package com.scheduler.repository;

import com.scheduler.model.BirthDayInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BirthdayInfoRepository extends MongoRepository<BirthDayInfo, String> {
    List<BirthDayInfo> findByCreatedBy(String createdBy);
    List<BirthDayInfo> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
    List<BirthDayInfo> findByStatus(String status);
    List<BirthDayInfo> findByTitleContainingIgnoreCase(String titleKeyword);
}
