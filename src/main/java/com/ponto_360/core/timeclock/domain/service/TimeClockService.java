package com.ponto_360.core.timeclock.domain.service;

import com.ponto_360.core.timeclock.app.DTO.request.TimeClockRequestDTO;

public interface TimeClockService {
    void saveRecord(TimeClockRequestDTO timeClockRequestDTO);
}
