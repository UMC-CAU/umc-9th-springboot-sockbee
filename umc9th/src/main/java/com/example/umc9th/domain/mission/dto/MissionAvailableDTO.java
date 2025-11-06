package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.entity.Mission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MissionAvailableDTO {

    private Long missionId;
    private Mission.Status status;
    private Integer rewardPoint;
    private LocalDateTime dueDate;
    private Long storeId;
    private String storeName;
    private String tagName;
}
