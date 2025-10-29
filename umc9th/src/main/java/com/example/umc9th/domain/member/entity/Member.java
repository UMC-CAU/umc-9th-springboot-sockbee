package com.example.umc9th.domain.member.entity;

import com.example.umc9th.global.BaseEntity;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Gender gender;

    private LocalDate birthDate;

    @Column(length = 255)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private SnsType snsType;

    @Column(length = 50)
    private String snsEmail;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private MemberStatus status; // UserStatus → MemberStatus

    private LocalDate inactiveDate;

    private Integer point;

    @Column(length = 255)
    private String detailAddress;

    // mappings
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<com.example.umc9th.domain.member.mapping.UserFoodTag> userFoodTags = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<com.example.umc9th.domain.member.mapping.UserTerm> userTerms = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<com.example.umc9th.domain.member.mapping.UserRegionProgress> userRegionProgresses = new ArrayList<>();

    public enum Gender {
        M, F, OTHER
    }

    public enum SnsType {
        KAKAO, NAVER, APPLE, GOOGLE, NONE
    }

    public enum MemberStatus {
        ACTIVE, INACTIVE, BANNED
    }
}