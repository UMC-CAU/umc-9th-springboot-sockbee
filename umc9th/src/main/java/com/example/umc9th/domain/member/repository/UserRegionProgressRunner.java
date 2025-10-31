package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.dto.UserRegionProgressDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@Profile("local") // 로컬 환경일 때만 자동 실행
@RequiredArgsConstructor
public class UserRegionProgressRunner implements CommandLineRunner {

    private final UserRegionProgressRepository repository;

    @Override
    public void run(String... args) {
        Long userId = 1L;
        Long regionId = 3L;

        List<UserRegionProgressDTO> results = repository.findRegionProgress(userId, regionId);

        for (UserRegionProgressDTO dto : results) {
            log.info("Region: {} (ID={}), Cleared: {}, Total: {}",
                    dto.regionName(), dto.regionId(), dto.clearedCount(), dto.totalCount());
        }
    }
}
