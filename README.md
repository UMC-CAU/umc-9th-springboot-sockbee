프로젝트 구조

├── domain
│   ├── common       # 공통 도메인 (Food_tag, region)
│   ├── member       # 사용자 관련 (User, User_food_tag, user_term, user_region_progress, user_mission)
│   ├── mission      # 미션 관련 (Mission)
│   ├── review       # 리뷰 관련 (Review)
│   ├── store        # 가게 관련 (Store)
│   └── terms        # 약관 관련 (Terms)
│
├── global           # 전역 설정
└── Umc9thApplication.java  # 메인 실행 클래스