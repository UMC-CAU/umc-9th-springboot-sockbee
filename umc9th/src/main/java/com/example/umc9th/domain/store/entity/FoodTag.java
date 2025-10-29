package com.example.umc9th.domain.store.entity;

import com.example.umc9th.global.BaseEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food_tag")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class FoodTag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    private Set<com.example.umc9th.domain.store.entity.Store> stores = new HashSet<>();

    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    private Set<com.example.umc9th.domain.member.mapping.UserFoodTag> userFoodTags = new HashSet<>();
}
