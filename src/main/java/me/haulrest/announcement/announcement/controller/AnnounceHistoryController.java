package me.haulrest.announcement.announcement.controller;

import me.haulrest.announcement.announcement.dto.HistoryDTO;
import me.haulrest.announcement.announcement.dto.LatestAnnouncementDTO;
import me.haulrest.announcement.announcement.service.AnnounceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/history")
@Tag(name = "History", description = "공지사항 히스토리 관련 API")
public class AnnounceHistoryController {

    private final AnnounceHistoryService announceHistoryService;

    @Autowired
    public AnnounceHistoryController(AnnounceHistoryService announceHistoryService) {
        this.announceHistoryService = announceHistoryService;
    }
    
    @GetMapping("/latest/{category}")
    @Operation(summary = "최신 카테고리별 공지사항 조회", description = "활성화된 최신 카테고리별 공지사항을 조회합니다.")
    public ResponseEntity<LatestAnnouncementDTO> getLatestAnnouncementByCategory(@PathVariable String category) {
        return announceHistoryService.getLatestActivatedAnnouncementByCategory(category)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "공지사항 히스토리 생성", description = "새로운 공지사항 히스토리를 생성합니다.")
    public ResponseEntity<HistoryDTO> createAnnounceHistory(@RequestBody HistoryDTO historyDTO) {
        try {
            HistoryDTO createdHistory = announceHistoryService.createAnnounceHistory(historyDTO);
            return ResponseEntity.ok(createdHistory);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "공지사항 히스토리 비활성화", description = "특정 공지사항 히스토리를 비활성화합니다.")
    public ResponseEntity<Void> deactivateAnnounceHistory(@PathVariable Long id) {
        boolean deactivated = announceHistoryService.deactivateAnnounceHistory(id);
        if (deactivated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
