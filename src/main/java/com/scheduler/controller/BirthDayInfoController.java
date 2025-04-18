package com.scheduler.controller;

import brave.Span;
import brave.Tracer;
import com.scheduler.model.BirthDayInfo;
import com.scheduler.repository.BirthdayInfoRepository;
import com.scheduler.service.BirthDayInfoService;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/birthday")
@Slf4j
public class BirthDayInfoController {

     @Autowired
     private Tracer tracer;

     @Autowired
     private BirthDayInfoService service;

     @GetMapping("/{userId}")
     @Observed
     public ResponseEntity<List<BirthDayInfo>> getAllBirthDays(@PathVariable(name="userId") String userId) {
          Span currentSpan = tracer.currentSpan();
          Long correlationId = currentSpan.context().traceId();
          //log.info("Correlation ID: {}", correlationId);
          List<BirthDayInfo> birthdayInfos = service.getAllBirthDays(userId);
          if (birthdayInfos.isEmpty()) {
               return ResponseEntity.notFound().build();
          }
          return ResponseEntity.ok(birthdayInfos);

     }

     @PostMapping("/{userId}")
     public ResponseEntity<BirthDayInfo> createSchedule(@PathVariable(name="userId") String userId,@RequestBody BirthDayInfo scheduleInfo) {
          BirthDayInfo birthdayInfo = service.saveBirthDay(scheduleInfo,userId);
          return ResponseEntity.ok(birthdayInfo);
     }

}
