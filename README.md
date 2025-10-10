## 📝 작업 내용
스프링 JPA를 이용하여 로컬 DB에 테이블을 만들었습니다

## 🔍 관련 이슈
- Close #이슈번호

## 🖼️ 스크린샷 
![member](https://github.com/user-attachments/assets/27af70ed-e5bd-4f87-a7eb-e9dd74581289)
![member](https://github.com/user-attachments/assets/f14739cf-0122-4cdd-96dc-d93b5f4b9446)
![region](https://github.com/user-attachments/assets/e4ec0595-542b-4b94-8a2a-f24806bf063b)
![review](https://github.com/user-attachments/assets/c42ae32a-3e6f-4acb-a529-08123e9abfdd)
![store](https://github.com/user-attachments/assets/209de8de-e317-4127-a6dd-5361f8ae98a4)
![term](https://github.com/user-attachments/assets/c41ac79a-81fc-4d33-993d-d1f0d726617b)
![user_food_tag](https://github.com/user-attachments/assets/0a708c03-313b-4059-9820-cb69de5d3195)
![user_mission](https://github.com/user-attachments/assets/271c8922-837d-4b21-9fed-eb20496295dd)
![user_region_progress](https://github.com/user-attachments/assets/6e376a04-4858-4a1e-8b40-d2afbfc93b86)
![user_term](https://github.com/user-attachments/assets/96bfc587-6ba0-461d-a602-ea73aa7deeb2)


## 🧪 테스트 결과
- [✅] 정상 작동 확인
![고생한 나](https://github.com/user-attachments/assets/3ba33aa2-285f-4abe-9be9-c79f502399f5)

- [✅] 테스트 코드 포함 (있다면)

## 💬 기타 참고 사항
- 리뷰 시 유의사항, 질문, 고민한 점 등을 자유롭게 작성해주세요.

<프로젝트 구조>
├─ domain
│   ├─ user
│   │   ├─ entity
│   │   │   └─ User.java
│   │   ├─ mapping
│   │   │   ├─ UserTerm.java
│   │   │   ├─ UserFoodTag.java
│   │   │   ├─ UserMission.java
│   │   │   └─ UserRegionProgress.java
│   │   ├─ repository
│   │   │   ├─ UserRepository.java
│   │   │   ├─ UserTermRepository.java
│   │   │   ├─ UserFoodTagRepository.java
│   │   │   ├─ UserMissionRepository.java
│   │   │   └─ UserRegionProgressRepository.java
│   ├─ store
│   │   ├─ entity
│   │   │   ├─ Store.java
│   │   │   ├─ Region.java
│   │   │   ├─ FoodTag.java
│   │   │   └─ Review.java
│   │   ├─ repository
│   │   │   ├─ StoreRepository.java
│   │   │   ├─ RegionRepository.java
│   │   │   ├─ FoodTagRepository.java
│   │   │   └─ ReviewRepository.java
│   ├─ mission
│   │   ├─ entity
│   │   │   └─ Mission.java
│   │   ├─ repository
│   │   │   └─ MissionRepository.java
│   └─ term
│       ├─ entity
│       │   └─ Term.java
│       ├─ repository
│       │   └─ TermRepository.java
├─ global
│   ├─ BaseEntity.java


# 🧠 개발 회고 - YYYY.MM.DD

## 🔧 작업한 내용
0주차에 만들었던 ERD를 피드백을 받아 수정하고, 직접 DDL을 설정하는 대신에 JPA를 이용해 Local DB에 TABLE을 만들었습니다.

## 😕 어려웠던 점
인텔리제이와 JPA 세팅이 어려웠습니다..
단계 단계 어디서부터 해야할지 전체 순서를 모르니 할 일을 찾는 과정이 어려웠습니다.

## 💡 배운 점 / 개선할 점
- 새로 알게 된 개념
  JPA의 패키지 구조와 REPOSITORY 등을 설정하는 법을 배웠습니다.
- 다음에 더 잘하기 위해 개선할 부분
  JPA로 DDL의 세부 제약 조건 등을 설정하는 것을 더 연습해야겠습니다.
  
## 🙌 느낀 점
- 소감, 팀워크, 개발 프로세스에 대한 피드백 등
- 이제 세팅 끝났으니 다음은 쉬울 거 같습니다.
