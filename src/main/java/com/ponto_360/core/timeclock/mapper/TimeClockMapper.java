package com.ponto_360.core.timeclock.mapper;

import com.ponto_360.core.timeclock.app.DTO.request.TimeClockRequestDTO;
import com.ponto_360.core.timeclock.infra.db.entity.TimeClockRecord;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TimeClockMapper {
    public TimeClockRecord toEntity(TimeClockRequestDTO timeClockRequestDTO, UUID userId) {
        return TimeClockRecord.builder()
                .timestamp(timeClockRequestDTO.getTimestamp())
                .type(timeClockRequestDTO.getType())
                .location(timeClockRequestDTO.getLocation())
                .latitude(timeClockRequestDTO.getLatitude())
                .longitude(timeClockRequestDTO.getLongitude())
                .build();
    }
}
