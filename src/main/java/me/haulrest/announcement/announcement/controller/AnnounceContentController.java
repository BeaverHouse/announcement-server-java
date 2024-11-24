package me.haulrest.announcement.announcement.controller;

import me.haulrest.announcement.announcement.dto.ContentDTO;
import me.haulrest.announcement.announcement.dto.ContentListItemDTO;
import me.haulrest.announcement.announcement.service.AnnounceContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/content")
@Tag(name = "Content", description = "공지사항 내용 관련 API")
public class AnnounceContentController {

    private final AnnounceContentService announceContentService;

    @Autowired
    public AnnounceContentController(AnnounceContentService announceContentService) {
        this.announceContentService = announceContentService;
    }

    @GetMapping
    @Operation(summary = "모든 공지사항 내용 조회", description = "페이지네이션을 적용하여 모든 공지사항 내용(코드 포함)을 코드 오름차순으로 조회합니다.")
    public ResponseEntity<Page<ContentListItemDTO>> getAllAnnounceContents(Pageable pageable) {
        return ResponseEntity.ok(announceContentService.getAllAnnounceContents(pageable));
    }

    @GetMapping("/{code}")
    @Operation(summary = "특정 공지사항 내용 조회", description = "코드를 이용하여 특정 공지사항 내용을 조회합니다.")
    public ResponseEntity<ContentDTO> getAnnounceContent(@PathVariable Long code) {
        return announceContentService.getAnnounceContent(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "공지사항 내용 생성", description = "새로운 공지사항 내용을 생성합니다.")
    public ResponseEntity<ContentDTO> createAnnounceContent(@RequestBody ContentDTO announceContentDTO) {
        return ResponseEntity.ok(announceContentService.createAnnounceContent(announceContentDTO));
    }

    @PutMapping("/{code}")
    @Operation(summary = "공지사항 내용 수정", description = "특정 공지사항의 내용을 수정합니다.")
    public ResponseEntity<ContentDTO> updateAnnounceContent(@PathVariable Long code, @RequestBody ContentDTO announceContentDetails) {
        return announceContentService.updateAnnounceContent(code, announceContentDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
