package com.ponto_360.core.timeclock.infra.db.entity;

import com.ponto_360.core.timeclock.enums.RecordType;
import com.ponto_360.core.user.infra.db.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "time_clock_records")
public class TimeClockRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private RecordType type;

    private LocalDateTime timestamp;
    private String location;
    private String latitude;
    private String longitude;
}
