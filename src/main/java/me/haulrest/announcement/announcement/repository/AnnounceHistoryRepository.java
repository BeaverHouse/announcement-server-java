package me.haulrest.announcement.announcement.repository;

import me.haulrest.announcement.announcement.entity.AnnounceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnnounceHistoryRepository extends JpaRepository<AnnounceHistory, Long> {
    
    @Query("SELECT ah FROM AnnounceHistory ah " +
           "WHERE ah.isActivated = true " +
           "AND ah.announceContent.category = 'emergency' " +
           "ORDER BY ah.createdAt DESC")
    Optional<AnnounceHistory> findLatestActivatedEmergencyAnnouncement();

    Optional<AnnounceHistory> findTopByIsActivatedTrueAndAnnounceContent_CategoryOrderByCreatedAtDesc(String category);

    @Modifying
    @Query("UPDATE AnnounceHistory ah SET ah.isActivated = false WHERE ah.id = :id")
    int deactivateAnnounceHistory(Long id);
}
