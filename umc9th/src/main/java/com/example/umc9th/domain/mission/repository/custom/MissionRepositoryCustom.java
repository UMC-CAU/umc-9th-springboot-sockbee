package com.example.umc9th.domain.mission.repository.custom;

import com.example.umc9th.domain.mission.dto.MissionSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MissionRepositoryCustom {

    Page<MissionSummaryDTO> findMissionsByStore(Long storeId, Pageable pageable);

    Page<MissionSummaryDTO> findOngoingMissionsByMember(Long memberId, Pageable pageable);
}
