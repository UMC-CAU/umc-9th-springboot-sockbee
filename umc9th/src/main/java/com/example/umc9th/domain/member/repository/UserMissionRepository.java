package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.mapping.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
}
