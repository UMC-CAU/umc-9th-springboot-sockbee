package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.mapping.UserTerm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTermRepository extends JpaRepository<UserTerm, Long> {
}
