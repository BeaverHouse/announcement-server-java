package me.haulrest.announcement.announcement.repository;

import me.haulrest.announcement.announcement.entity.AnnounceContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnounceContentRepository extends JpaRepository<AnnounceContent, Long> {
}
