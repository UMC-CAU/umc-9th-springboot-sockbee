package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.global.BaseEntity;
import com.example.umc9th.domain.store.entity.Store;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mission")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    private LocalDateTime dueDate;

    private Integer rewardPoint;

    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY)
    private Set<com.example.umc9th.domain.member.mapping.UserMission> userMissions = new HashSet<>();
}
