package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.member.mapping.UserMission;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.global.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mission")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    private LocalDateTime dueDate;

    private Integer rewardPoint;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Status status;

    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY)
    private List<UserMission> userMissions = new ArrayList<>();

}
