package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.MissionAvailableDTO;
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
public class MissionAvailableRunner implements CommandLineRunner {

    private final MissionRepository missionRepository;

    @Override
    public void run(String... args) {
        Long userId = 1L;
        Long regionId = 2L; // 조회할 지역
        LocalDateTime cursorUpdatedAt = LocalDateTime.now();
        Long cursorMissionId = Long.MAX_VALUE;

        List<MissionAvailableDTO> result = missionRepository.findAvailableMissionsByRegionWithCursor(
                userId, regionId, cursorUpdatedAt, cursorMissionId
        );

        for (MissionAvailableDTO dto : result) {
            log.info("Mission ID: {}, Status: {}, Store: {} ({}), Tag: {}, Reward: {}, Due: {}",
                    dto.getMissionId(),
                    dto.getStatus(),
                    dto.getStoreName(), dto.getStoreId(),
                    dto.getTagName(),
                    dto.getRewardPoint(),
                    dto.getDueDate());

        }
    }
}
