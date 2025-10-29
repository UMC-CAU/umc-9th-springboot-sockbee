package com.example.umc9th.domain.store.entity;

import com.example.umc9th.global.BaseEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "store",
        indexes = {
                @Index(name = "idx_store_region", columnList = "region_id"),
                @Index(name = "idx_store_tag", columnList = "tag_id")
        })
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 255)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private FoodTag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private Set<com.example.umc9th.domain.store.entity.Review> reviews = new HashSet<>();

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private Set<com.example.umc9th.domain.mission.entity.Mission> missions = new HashSet<>();
}
