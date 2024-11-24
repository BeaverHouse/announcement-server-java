package me.haulrest.announcement.announcement.dto;

import me.haulrest.announcement.announcement.entity.AnnounceHistory;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class HistoryDTO {
    private Long announceContentCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActivated;

    public static HistoryDTO fromEntity(AnnounceHistory entity) {
        HistoryDTO dto = new HistoryDTO();
        dto.setAnnounceContentCode(entity.getAnnounceContent().getCode());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setActivated(entity.isActivated());
        return dto;
    }

    public Long getAnnounceContentCode() {
        return this.announceContentCode;
    }
}
