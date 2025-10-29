package com.example.umc9th.domain.store.entity;

import com.example.umc9th.global.BaseEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "region")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Region extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionId;

    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private Set<Store> stores = new HashSet<>();

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private Set<com.example.umc9th.domain.member.mapping.UserRegionProgress> userRegionProgresses = new HashSet<>();
}
