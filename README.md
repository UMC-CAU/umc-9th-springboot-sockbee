프로젝트 구조
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