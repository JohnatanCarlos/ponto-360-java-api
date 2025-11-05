package com.ponto_360.core.timeclock.domain.service.impl;

import com.ponto_360.core.timeclock.app.DTO.request.TimeClockRequestDTO;
import com.ponto_360.core.timeclock.domain.service.TimeClockService;
import com.ponto_360.core.timeclock.infra.db.entity.TimeClockRecord;
import com.ponto_360.core.timeclock.infra.db.repository.TimeClockRepository;
import com.ponto_360.core.timeclock.mapper.TimeClockMapper;
import com.ponto_360.core.user.infra.db.entity.User;
import com.ponto_360.core.user.infra.db.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TimeClockServiceImpl implements TimeClockService {

    @Inject
    TimeClockMapper timeClockMapper;

    @Inject
    TimeClockRepository timeClockRepository;

    @Inject
    UserRepository userRepository;

    @Transactional
    public void saveRecord(TimeClockRequestDTO timeClockRequestDTO) {
        User user = userRepository.findByCpf(timeClockRequestDTO.getCpf());
        if(user == null){
            throw new RuntimeException("User not found");
        }

        TimeClockRecord timeClockRecord = timeClockMapper.toEntity(timeClockRequestDTO, user.getId());
        timeClockRecord.setUser(user);
        timeClockRepository.save(timeClockRecord);
    }
}
