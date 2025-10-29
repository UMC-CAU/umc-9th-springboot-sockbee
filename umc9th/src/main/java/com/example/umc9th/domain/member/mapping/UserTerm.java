package com.example.umc9th.domain.member.mapping;

import com.example.umc9th.domain.term.entity.Term;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.global.BaseEntity;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_term",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","term_id"})})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserTerm extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id")
    private Term term;

    private Boolean agreed;
    private LocalDateTime agreeDate;
}
