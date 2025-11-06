package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.CommandLineRunner;

import java.util.Optional;

@Slf4j
@Component
@Profile("local")              // ✅ local 프로필에서만 실행되도록 보호
@RequiredArgsConstructor
public class UserRepositoryTest implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) {
        // given
        Member member = Member.builder()
                .name("홍길동")
                .snsEmail("hong@test.com")
                .point(2500)
                .build();
        userRepository.save(member);

        // when
        Optional<Member> found = userRepository.findById(member.getUserId());

        // then
        if (found.isPresent()) {
            Member result = found.get();
            log.info("닉네임: {}", result.getName());
            log.info("이메일: {}", result.getSnsEmail());
            log.info("보유 포인트: {}", result.getPoint());
        } else {
            log.warn("사용자를 찾을 수 없습니다.");
        }
    }
}
