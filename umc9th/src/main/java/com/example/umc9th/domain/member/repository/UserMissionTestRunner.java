package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.dto.UserMissionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
@Profile("local")
@RequiredArgsConstructor
public class UserMissionTestRunner implements CommandLineRunner {

    private final UserMissionRepository userMissionRepository;

    @Override
    public void run(String... args) {
        Long userId = 1L;
        LocalDateTime cursorUpdatedAt = LocalDateTime.now();
        Long cursorMissionId = Long.MAX_VALUE;

        List<UserMissionDTO> result = userMissionRepository.findUserMissionCursorBased(
                userId, cursorUpdatedAt, cursorMissionId
        );

        for (UserMissionDTO dto : result) {
            log.info("Mission ID: {}, Status: {}, Store: {} (ID={})",
                    dto.missionId(), dto.status(), dto.storeName(), dto.storeId());
        }
    }
}
