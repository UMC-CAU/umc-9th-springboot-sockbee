package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.MemberMissionPageResponse;
import com.example.umc9th.domain.mission.dto.MissionListResponse;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.global.apiPayload.code.error.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionQueryService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public MissionListResponse getStoreMissions(Long storeId, Pageable pageable) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.STORE_NOT_FOUND));

        var page = missionRepository.findMissionsByStore(storeId, pageable);
        return MissionConverter.toListResponse(store.getId(), store.getName(), page);
    }

    @Transactional(readOnly = true)
    public MemberMissionPageResponse getOngoingMissions(Long memberId, Pageable pageable) {
        var missionPage = missionRepository.findOngoingMissionsByMember(memberId, pageable);
        return MissionConverter.toMemberMissionPageResponse(memberId, missionPage);
    }
}
