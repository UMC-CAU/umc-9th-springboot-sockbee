package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.mapping.UserFoodTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFoodTagRepository extends JpaRepository<UserFoodTag, Long> {
}
