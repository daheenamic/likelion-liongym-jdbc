# 🏋️ LionGym Management System

간단한 콘솔 UI로 회원(Member) / 트레이너(Trainer) 관리와 PT 등록/사용을 처리하는 JDBC 기반 학습용 프로젝트입니다.

---

## 📌 프로젝트 개요
- Language: Java 21
- Build: Gradle
- DB: MySQL 8.3
- JDBC Driver: mysql-connector-j:8.3.0
- 환경: macOS (로컬 개발 기준)

---

## 📌 주요 기능
1. 회원 목록, 등록, 수정, 삭제
    - 이름, 연락처 입력
    - 담당 트레이너, PT 수업횟수(선택)
    - PT 등록 및 PT 사용
2. 트레이너 목록, 등록, 수정, 삭제
    - 이름, 연락처, 기본급, 성과금 입력
      
---

## 📂 파일 구조
```text
src/
├── java/
│   ├── main/
│   │   └── Main.java
│   ├── member/
│   │   ├── controller/
│   │   │   └── MemberController.java
│   │   ├── dao/
│   │   │   ├── MemberDAO.java
│   │   │   └── MemberDAOImpl.java
│   │   └── dto/
│   │       └── MemberDTO.java
│   ├── trainer/
│   │   ├── controller/
│   │   │   └── TrainerController.java
│   │   ├── dao/
│   │   │   ├── TrainerDAO.java
│   │   │   └── TrainerDAOImpl.java
│   │   └── dto/
│   │       └── TrainerDTO.java
│   └── util/
│       ├── db/
│       │   └── DBUtil.java
│       └── io/
│           └── In.java
└── resources
```
---

## 📌 실행 방법
1. IntelliJ에서 `Main.java` 실행
2. 콘솔에서 메뉴 선택

```text
[1]회원관리 [2]트레이너관리 [0]종료
```

--- 

## 📌 커밋 메시지 컨벤션

```
feat: 새 기능 추가
fix: 버그 수정
refactor: 리팩토링 (기능 변화 없음)
docs: 문서 수정
chore: 설정/빌드 등 비즈니스 로직과 무관한 변경
```

--- 

## 📌 TODO

- [ ] DDL 및 DML 문서 업데이트
- [ ] 회원관리 > PT사용 로직에 TRAINER 테이블 LESSONS 컬럼 업데이트 로직 추가
- [ ] TRAINER CRUD
- [ ] 헬스 이용권 CRUD
- [ ] 회원관리 > 회원등록에 헬스 이용권 선택 로직 추가

---

## 📌 추가하면 좋을 기능들

- 트레이너 - 회원간의 운동일지 및 식단일지 기록
- 로그인 기능 추가(회원, 트레이너, 매니저별로 권한 설정)
- 트레이너의 PT 스케줄 관리
- 회원 및 트레이너의 PT History 관리









