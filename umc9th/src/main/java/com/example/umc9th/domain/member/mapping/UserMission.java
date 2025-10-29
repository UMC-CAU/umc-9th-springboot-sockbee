package com.example.umc9th.domain.member.mapping;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.global.BaseEntity;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_mission",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","mission_id"})})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Status status;

    private LocalDate joinedAt;
    private LocalDate completedAt;

    public enum Status {
        JOINED, COMPLETED, CANCELLED
    }
}
