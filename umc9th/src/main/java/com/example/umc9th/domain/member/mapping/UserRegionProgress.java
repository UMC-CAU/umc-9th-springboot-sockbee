package com.example.umc9th.domain.member.mapping;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.store.entity.Region;
import com.example.umc9th.global.BaseEntity;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "user_region_progress",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","region_id"})})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserRegionProgress extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    private Integer pointCount;
}
