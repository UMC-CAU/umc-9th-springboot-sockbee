package com.example.umc9th.domain.member.mapping;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.term.entity.Term;
import com.example.umc9th.global.BaseEntity;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "user_term",
        uniqueConstraints = {
                // 같은 유저라도 약관이 다르거나 버전이 다르면 여러 개 동의 가능
                @UniqueConstraint(columnNames = {"user_id", "term_id", "term_version"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTerm extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id", nullable = false)
    private Term term;

    // Term의 version 필드를 그대로 가져와 기록 (이 시점의 버전 보존)
    @Column(name = "term_version", length = 20, nullable = false)
    private String termVersion;

    private Boolean agreed;
    private LocalDateTime agreeDate;
}
