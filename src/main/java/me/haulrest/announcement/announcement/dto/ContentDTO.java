package me.haulrest.announcement.announcement.dto;

import me.haulrest.announcement.announcement.entity.AnnounceContent;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ContentDTO {
    private String category;
    private String title;
    private String koreanDescription;
    private String englishDescription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ContentDTO fromEntity(AnnounceContent entity) {
        ContentDTO dto = new ContentDTO();
        dto.setCategory(entity.getCategory());
        dto.setTitle(entity.getTitle());
        dto.setKoreanDescription(entity.getKoreanDescription());
        dto.setEnglishDescription(entity.getEnglishDescription());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public AnnounceContent toEntity() {
        AnnounceContent entity = new AnnounceContent();
        entity.setCategory(this.category);
        entity.setTitle(this.title);
        entity.setKoreanDescription(this.koreanDescription);
        entity.setEnglishDescription(this.englishDescription);
        entity.setCreatedAt(this.createdAt);
        entity.setUpdatedAt(this.updatedAt);
        return entity;
    }
}
