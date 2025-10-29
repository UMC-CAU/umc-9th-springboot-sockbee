package com.example.umc9th.domain.term.entity;

import com.example.umc9th.global.BaseEntity;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "term",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title", "version"}) // 동일 제목이라도 버전별로 관리 가능
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Term extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 예: "서비스 이용약관", "개인정보 처리방침"
    @Column(length = 100, nullable = false)
    private String title;

    // 약관 버전 (예: v1.0, v2.0)
    @Column(length = 20, nullable = false)
    private String version;

    private LocalDateTime applyDate;

    @Lob
    private String terms;

    private Boolean essential;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Status status;

    public enum Status {
        ACTIVE, INACTIVE
    }
}
