package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;

public interface MemberCommandService {
    MemberResDTO.JoinDTO signup(MemberReqDTO.JoinDTO dto);
}

