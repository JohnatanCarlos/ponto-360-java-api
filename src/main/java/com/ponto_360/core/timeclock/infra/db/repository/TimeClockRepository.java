package com.ponto_360.core.timeclock.infra.db.repository;

import com.ponto_360.core.timeclock.infra.db.entity.TimeClockRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimeClockRepository extends JpaRepository<TimeClockRecord, UUID> {
}
