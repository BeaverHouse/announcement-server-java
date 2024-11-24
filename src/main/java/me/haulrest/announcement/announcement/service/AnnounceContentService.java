package me.haulrest.announcement.announcement.service;

import me.haulrest.announcement.announcement.entity.AnnounceContent;
import me.haulrest.announcement.announcement.dto.ContentDTO;
import me.haulrest.announcement.announcement.dto.ContentListItemDTO;
import me.haulrest.announcement.announcement.repository.AnnounceContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@Service
public class AnnounceContentService {

    private final AnnounceContentRepository announceContentRepository;

    @Autowired
    public AnnounceContentService(AnnounceContentRepository announceContentRepository) {
        this.announceContentRepository = announceContentRepository;
    }

    public Page<ContentListItemDTO> getAllAnnounceContents(Pageable pageable) {
        // code 오름차순으로 정렬
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), 
                                                 Sort.by(Sort.Direction.ASC, "code"));
        return announceContentRepository.findAll(sortedPageable)
            .map(ContentListItemDTO::fromEntity);
    }

    public Optional<ContentDTO> getAnnounceContent(Long code) {
        return announceContentRepository.findById(code)
            .map(ContentDTO::fromEntity);
    }

    public ContentDTO createAnnounceContent(ContentDTO announceContentDTO) {
        AnnounceContent savedEntity = announceContentRepository.save(announceContentDTO.toEntity());
        return ContentDTO.fromEntity(savedEntity);
    }

    public Optional<ContentDTO> updateAnnounceContent(Long code, ContentDTO announceContentDetails) {
        return announceContentRepository.findById(code)
            .map(announceContent -> {
                announceContent.setCategory(announceContentDetails.getCategory());
                announceContent.setTitle(announceContentDetails.getTitle());
                announceContent.setKoreanDescription(announceContentDetails.getKoreanDescription());
                announceContent.setEnglishDescription(announceContentDetails.getEnglishDescription());
                
                AnnounceContent updatedEntity = announceContentRepository.save(announceContent);
                return ContentDTO.fromEntity(updatedEntity);
            });
    }
}
