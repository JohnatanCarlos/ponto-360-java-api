package com.ponto_360.core.timeclock.controller;

import com.ponto_360.core.timeclock.app.DTO.request.TimeClockRequestDTO;
import com.ponto_360.core.timeclock.domain.service.TimeClockService;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/timeclocks")
@RequiredArgsConstructor
public class TimeClockController {
    @Inject
    TimeClockService timeClockService;

    @PostMapping
    public void saveRecord(@RequestBody TimeClockRequestDTO timeClockRequestDTO) {
        timeClockService.saveRecord(timeClockRequestDTO);
    }
}
