package me.haulrest.announcement.announcement.dto;

import me.haulrest.announcement.announcement.entity.AnnounceHistory;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LatestAnnouncementDTO {
    private Long announceContentCode;
    private String title;
    private String koreanDescription;
    private String englishDescription;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActivated;

    public static LatestAnnouncementDTO fromEntity(AnnounceHistory entity) {
        LatestAnnouncementDTO dto = new LatestAnnouncementDTO();
        dto.setAnnounceContentCode(entity.getAnnounceContent().getCode());
        dto.setTitle(entity.getAnnounceContent().getTitle());
        dto.setKoreanDescription(entity.getAnnounceContent().getKoreanDescription());
        dto.setEnglishDescription(entity.getAnnounceContent().getEnglishDescription());
        dto.setCategory(entity.getAnnounceContent().getCategory());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setActivated(entity.isActivated());
        return dto;
    }
}
