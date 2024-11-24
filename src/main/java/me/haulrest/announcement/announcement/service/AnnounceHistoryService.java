package me.haulrest.announcement.announcement.service;

import me.haulrest.announcement.announcement.entity.AnnounceHistory;
import me.haulrest.announcement.announcement.entity.AnnounceContent;
import me.haulrest.announcement.announcement.dto.HistoryDTO;
import me.haulrest.announcement.announcement.dto.LatestAnnouncementDTO;
import me.haulrest.announcement.announcement.repository.AnnounceHistoryRepository;
import me.haulrest.announcement.announcement.repository.AnnounceContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AnnounceHistoryService {

    private final AnnounceHistoryRepository announceHistoryRepository;
    private final AnnounceContentRepository announceContentRepository;

    @Autowired
    public AnnounceHistoryService(AnnounceHistoryRepository announceHistoryRepository,
                                  AnnounceContentRepository announceContentRepository) {
        this.announceHistoryRepository = announceHistoryRepository;
        this.announceContentRepository = announceContentRepository;
    }

    public Optional<LatestAnnouncementDTO> getLatestActivatedAnnouncementByCategory(String category) {
        return announceHistoryRepository.findTopByIsActivatedTrueAndAnnounceContent_CategoryOrderByCreatedAtDesc(category)
                .map(LatestAnnouncementDTO::fromEntity);
    }

    @Transactional
    public HistoryDTO createAnnounceHistory(HistoryDTO historyDTO) {
        Optional<AnnounceContent> announceContent = announceContentRepository.findById(historyDTO.getAnnounceContentCode());
        
        if (announceContent.isEmpty()) {
            throw new IllegalArgumentException("Invalid AnnounceContent code");
        }

        AnnounceHistory announceHistory = new AnnounceHistory();
        announceHistory.setAnnounceContent(announceContent.get());
        announceHistory.setActivated(historyDTO.isActivated());

        AnnounceHistory savedEntity = announceHistoryRepository.save(announceHistory);
        return HistoryDTO.fromEntity(savedEntity);
    }

    @Transactional
    public boolean deactivateAnnounceHistory(Long id) {
        Optional<AnnounceHistory> history = announceHistoryRepository.findById(id);
        if (history.isPresent()) {
            AnnounceHistory announceHistory = history.get();
            announceHistory.setActivated(false);
            announceHistoryRepository.save(announceHistory);
            return true;
        }
        return false;
    }
}
