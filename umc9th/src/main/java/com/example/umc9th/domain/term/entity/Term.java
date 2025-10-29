package com.example.umc9th.domain.term.entity;

import com.example.umc9th.global.BaseEntity;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "term")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Term extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private java.time.LocalDateTime applyDate;

    @Lob
    private String terms;

    private Boolean essential;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE, INACTIVE
    }
}
