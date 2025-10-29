package com.example.umc9th.domain.member.mapping;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.store.entity.FoodTag;
import com.example.umc9th.global.BaseEntity;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "user_food_tag",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","tag_id"})})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserFoodTag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // owning side
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    // owning side
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private FoodTag tag;
}
