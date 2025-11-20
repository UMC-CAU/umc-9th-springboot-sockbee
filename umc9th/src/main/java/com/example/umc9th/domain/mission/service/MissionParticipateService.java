package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.mapping.UserMission;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.member.repository.UserMissionRepository;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MissionParticipateService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final UserMissionRepository userMissionRepository;

    @Transactional
    public Long participate(Long memberId, Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("미션을 찾을 수 없습니다. id=" + missionId));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. id=" + memberId));

        // 이미 참여 중인지 체크
        if (userMissionRepository.existsByMember_UserIdAndMission_MissionId(memberId, missionId)) {
            throw new IllegalStateException("이미 도전 중이거나 완료한 미션입니다.");
        }

        UserMission userMission = UserMission.builder()
                .member(member)
                .mission(mission)
                .status(UserMission.Status.JOINED)
                .joinedAt(LocalDate.now())
                .build();

        return userMissionRepository.save(userMission).getId();
    }
}
