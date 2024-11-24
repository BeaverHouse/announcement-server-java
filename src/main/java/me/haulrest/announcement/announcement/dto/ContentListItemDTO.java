package me.haulrest.announcement.announcement.dto;

import me.haulrest.announcement.announcement.entity.AnnounceContent;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ContentListItemDTO {
    private Long code;
    private String category;
    private String title;
    private String koreanDescription;
    private String englishDescription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ContentListItemDTO fromEntity(AnnounceContent entity) {
        ContentListItemDTO dto = new ContentListItemDTO();
        dto.setCode(entity.getCode());
        dto.setCategory(entity.getCategory());
        dto.setTitle(entity.getTitle());
        dto.setKoreanDescription(entity.getKoreanDescription());
        dto.setEnglishDescription(entity.getEnglishDescription());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
