# 영화관 콘솔 프로젝트
 본 프로젝트는 텍스트파일을 데이터베이스로 이용, 파일입출력 기능을 활용하여 구현한 영화관 콘솔 프로젝트입니다.
### 참여

조아라 장진영 윤지봉 임채원 정경화 조혜승

### 구현 목표 기능

#### 고객

1. 회원 : 회원가입, 회원탈퇴, 회원정보조회 및 수정, 아이디/비밀번호 찾기, 예매내역조회

2. 영화 : 현재 상영중인 영화의 상세정보조회, 관람한 영화의 별점/리뷰 작성 및 조회

3. 예매 : 영화관별/영화별 예매 가능, 좌석배치도를 통한 좌석 확인

4. 결제 : 쿠폰 사용, 포인트 사용, 핸드폰결제, 카드결제, 결제 카드 등록, 각종 할인

5. 매점 : 스낵 조회, 스낵교환권 구입

6. 추천 : 장르별 추천/인기영화 제공

7. 검색 : 가까운 영화 검색

8. 게시판 : 공지사항 조회, 컴플레인 작성, 이벤트 조회

9. 알림 : 관심있는 영화로 등록한 영화의 개봉 알림

#### 관리자

1. 매출조회 : 당월의 매출 조회

2. 이벤트 관리

3. 게시판 : 공지사항 작성 및 삭제, 컴플레인 조회 및 삭제, 이벤트 작성 및 삭제, 리뷰 삭제



### 개발환경

운영체제 : Windows10, MacOS   Catalina 10.15.7  

개발툴 : Eclipse  

개발언어 : JAVA(JDK 1.8)

### 데이터구조

#### 데이터모델링

기획 당시 작성한 다이어그램

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/date-modeling.png)

#### 데이터 구성
 본 프로젝트는 텍스트파일을 데이터베이스로 이용, 파일입출력 기능을 활용하여 구현한 영화관 콘솔 프로젝트입니다.
- Admin
  - 각 지점
    - 일별
      - 매출정보
  - AdminList(회원 아이디, 비밀번호, 관리지점) 테이블
- User
  - UserCard - 아이디별 카드정보 테이블
  - UserCoupon - 아이디별 쿠폰정보 테이블
  - UserInfo - 아이디별 회원등급, 포인트정보 테이블
  - UserList(회원 아이디, 비밀번호, 이름, 전화번호, 주소) 테이블
- Snack
  - 각 지점
    - 판매중인 스낵메뉴 테이블
- Movie
  - 영화정보 테이블
- Theater
  - 각 지점
    - 일별 상영내역 테이블
- Reservation
  - Member - 전화번호별 예약내역 테이블
  - Nonmeber - 전화번호별 예약내역 테이블

### 개발일정

총 16일 소요

|  아이템 선정   |        설계        |        구현        | 테스트 및 에러 수정, 디자인 수정, 더미데이터 제작 |
| :------------: | :----------------: | :----------------: | :-----------------------------------------------: |
| 11월 3일 ~ 4일 |  11월 5일 ~ 13일   |  11월 14일 ~ 18일  |                 11월 19일 ~ 20일                  |
|    2일 소요    | 7일 소요(주말제외) | 5일 소요(주말포함) |                     2일 소요                      |

### 담당업무

|            |                       조아라 담당업무                        |
| :--------: | :----------------------------------------------------------: |
|  기획단계  | - 담당업무 요구사항분석서 작성<br />- 화면 설계<br />-데이터구조 분석<br />- 순서도 작성<br />- 데이터 다이어그램 작성 |
|  구현단계  | - 영화별 상영내역조회 기능 및 상영정보 선택 기능, 영화정보상세조회 기능 구현<br />- 매점 조회 기능 구현 |
| 마무리단계 |         - 발표용 PPT 제작<br />- 프로그램 화면 캡처          |

#### 조아라 구현 코드

1. [회원 - 현재 상영중인 영화 목록 조회 기능 및 영화 선택 기능](https://github.com/arajo-hub/Java-Console-Project/blob/main/src/com/test/member/MovieList.java)

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/document/%5B08%5D모든%20화면%20스크린샷/영화별예매/영화별예매%20-%20영화별조회.png)

2. [회원 - 영화별 상영내역조회 기능 및 상영정보 선택 기능](https://github.com/arajo-hub/Java-Console-Project/blob/main/src/com/test/member/ChooseMovie.java)

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/document/%5B08%5D모든%20화면%20스크린샷/영화별예매/상영번호%20선택.png)

3. [비회원 - 현재 상영중인 영화 목록 조회 기능 및 영화 선택 기능](https://github.com/arajo-hub/Java-Console-Project/blob/main/src/com/test/nonmember/MovieList.java)

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/document/%5B08%5D모든%20화면%20스크린샷/영화별예매/영화별예매%20-%20영화별조회.png)

4. [비회원 - 영화별 상영내역조회 기능 및 상영정보 선택 기능](https://github.com/arajo-hub/Java-Console-Project/blob/main/src/com/test/nonmember/ChooseMovie.java)

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/document/%5B08%5D모든%20화면%20스크린샷/영화별예매/상영번호%20선택.png)

5. [현재 상영중인 영화 정보 상세 조회 기능 구현](https://github.com/arajo-hub/Java-Console-Project/blob/main/src/com/test/start/ViewMovieDetail.java)

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/document/%5B08%5D모든%20화면%20스크린샷/영화정보상세보기.png)

6. [매점 조회 기능](https://github.com/arajo-hub/Java-Console-Project/blob/main/src/com/test/snack/BuySnack.java)

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/document/%5B08%5D모든%20화면%20스크린샷/스낵/스낵메뉴%20조회.png)

7. [고객 공지사항 목록 조회 기능](https://github.com/arajo-hub/Java-Console-Project/blob/main/src/com/test/notice/showNoticeList.java)

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/document/%5B08%5D모든%20화면%20스크린샷/공지사항/공지사항목록.png)

8. [고객 공지사항 상세 조회 기능](https://github.com/arajo-hub/Java-Console-Project/blob/main/src/data/NoticeBoard.java)

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/document/%5B08%5D모든%20화면%20스크린샷/공지사항/공지사항%20상세(고객).png)

9. [관리자 공지사항 목록 조회 기능](https://github.com/arajo-hub/Java-Console-Project/blob/main/src/com/test/notice/showNoticeListAdmin.java)

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/document/%5B08%5D모든%20화면%20스크린샷/공지사항/공지사항목록.png)

10. [관리자 공지사항 상세 조회 기능](https://github.com/arajo-hub/Java-Console-Project/blob/main/src/data/NoticeBoard.java)

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/document/%5B08%5D모든%20화면%20스크린샷/공지사항/공지사항%20상세(관리자).png)

11. [관리자 공지사항 등록 기능](https://github.com/arajo-hub/Java-Console-Project/blob/main/src/data/Notice.java)

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/document/%5B08%5D모든%20화면%20스크린샷/공지사항/공지사항%20등록.png)

12. [관리자 공지사항 수정 기능](https://github.com/arajo-hub/Java-Console-Project/blob/main/src/data/NoticeBoard.java)

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/document/%5B08%5D모든%20화면%20스크린샷/공지사항/공지사항%20수정.png)

13. [관리자 공지사항 삭제 기능](https://github.com/arajo-hub/Java-Console-Project/blob/main/src/data/NoticeBoard.java)

![](https://github.com/arajo-hub/Java-Console-Project/blob/main/document/%5B08%5D모든%20화면%20스크린샷/공지사항/공지사항%20삭제.png)

### 소감

 처음으로 누군가와 팀을 이루어 작업한 첫 프로젝트였던만큼 완성 그 자체로 의의가 있지만, 개운함보다도 부족한 실력에 아쉬움이 많이 남습니다. 더 노력해야겠다고 다짐하는 계기가 되었습니다.

 그리고 팀단위로 프로젝트를 처음 진행하면서 설계를 어떻게 해야할지, 구현은 어떻게 해야할지 팀원들과 이야기를 나누며, 내가 말하고자 하는 바를 정확하게 팀원들에게 이해시키고 다른 사람의 이야기를 이해하는 커뮤니케이션능력이 중요하다는 것을 깨달았습니다.
