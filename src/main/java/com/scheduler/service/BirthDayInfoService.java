package com.scheduler.service;

import com.scheduler.model.BirthDayInfo;
import com.scheduler.repository.BirthdayInfoRepository;
import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Observed
public class BirthDayInfoService {
    @Autowired
    private  BirthdayInfoRepository birthdayInfoRepository;

    public List<BirthDayInfo> getAllBirthDays(String userId) {

        // Fetch all birthday information for the given userId
        List<BirthDayInfo> birthdayInfos = birthdayInfoRepository.findByCreatedBy(userId);
        return birthdayInfos;
    }

    public BirthDayInfo saveBirthDay(BirthDayInfo birthDayInfo,String userId) {
       // birthDayInfo.setUserId(userId);
        return birthdayInfoRepository.save(birthDayInfo);
    }
}
