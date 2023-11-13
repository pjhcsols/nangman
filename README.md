# 낭만코더 '우리도 한 때는 어린 아이였다.'
<br>

## S타입 : 주제
아동의 발달권 보장을 위한 “YES 키즈존" 정보 제공 웹 서비스 : “얼라 IT(얼라잇)"
<br>
<br>
<br>

## 프로젝트 설명
맵API를 이용해 아동들을 위한 정보를 제공하는 웹 

<br>
<br>
<br>

## 시연영상 Youtube
https://www.youtube.com/watch?v=azKnLuOpeVQ
<br>
<br>
<br>
<br>

## 팀원 👨‍👨‍👧‍👧

|                                       Backend                                        |                                       Backend                                        |                                                                               |
|:-------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------:|
| <img src="https://avatars.githubusercontent.com/u/110244523?s=400" width=130px alt="한솔"> | <img src="https://avatars.githubusercontent.com/u/110244523?s=400" width=130px alt="진노"> 
|                          [한솔](https://github.com/pjhcsols)                           |                            [진노](https://github.com/)                            

|                                        Frontend                                         |                                        Frontend                                         |                                                               |                                           |
|:--------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------:|
| <img src="https://avatars.githubusercontent.com/u/110244523?s=400" width=130px alt="현수"/> | <img src="https://avatars.githubusercontent.com/u/110244523?s=400" width=130px alt="민수"/> | 
|                             [현수](https://github.com/)                             |                          [민수](https://github.com/)                          |

<br><br><br>


# 핵심기술 3가지
<br>

## 1. JWT 인증인가 token을 통한 로그인 기능 구현
![image](https://github.com/pjhcsols/nangman/assets/110244523/8e8a025f-110f-4e4e-ac65-7848d80e23cd)
<img width="1257" alt="인증인가" src="https://github.com/pjhcsols/nangman/assets/110244523/81a7d9b2-0638-4d0e-99d3-88162c3b4b17">

JWT (JSON Web Token)
인증에 필요한 정보들을 암호화시킨 토큰을 뜻한다.

<br>

JWT 기반 인증 방식이란 Client가 Server에게 요청을 보낼 때 HTTP의 Header에 
이전에 Server로부터 발급받은 JWT를 담아 보내고, 이를 기반으로 Server가 Client를 식별하는 방식을 뜻한다.<br>
클라이언트에서 패스워드를 통하지 않고 암호화된 token기반으로 로그인 성공여부를 파악하기때문에 보안성이 높다.

<br>

## 1-1. Signature 구현
header의 인코딩 값 + payload의 인코딩 값 + 서버의 key값 을 header에서 정의한 알고리즘으로 암호화한 것.<br>
이 때 서버의 key값이 유출되지 않는 이상 복호화할 수 없다.

<br>

## 1-2. Access token
Client는 JWT를 저장하고, 이후 인증이 필요한 요청마다 Authorization Header에 Access token을 담아 보냄

[' . '로 구분된 세 문자열인 Header, Payload, Signature로 이루어져있다.]
Server는 발행했던 token과 Client로부터 받은 token의 일치여부를 확인한다 (인증).

<br>

## 2. 카테고리ID(1.노키즈존, 2.키즈존, 3.아동복합문화공간) 별로 DB를 통한 필터링 기능
<br>

클라이언트 측에서 요청한 노키즈존, 키즈존, 아동복합문화공간을 카테고리ID 별로 필터링을 통해 원하는 정보를 전송해준다.
<img width="1257" alt="스크린샷 2023-11-12 오후 11 44 52" src="https://github.com/pjhcsols/nangman/assets/110244523/1094f64c-7bf6-457a-9972-365dbc2a21df">

### 카테고리 단일 선택
<img width="1462" alt="마커-노키즈존 카테고리" src="https://github.com/pjhcsols/nangman/assets/112597910/8dee9eb8-201c-4490-b438-012bfcef398e">

### 카테고리 다중 선택
<img width="1470" alt="스크린샷 2023-11-13 오후 3 48 33" src="https://github.com/pjhcsols/nangman/assets/112597910/c95089c8-3e7a-4ab0-869f-f51e6107418a">

### 카테고리 모두 가져오기
<img width="1470" alt="스크린샷 2023-11-13 오후 3 48 43" src="https://github.com/pjhcsols/nangman/assets/112597910/0b22f5c4-b1ff-4b5b-9996-8c808a9262f3">

<br>

## 3. 카카오 지도 API 사용

<br>

import {useMap,Map,MapMarker} from 'react-kakao-maps-sdk' 문을 추가하여 카카오 지도 API를 사용한다.<br>
지도를 디스플레이 크기에 맞춰 출력하기 위해 Map 컴포넌트를 아래와 같은 코드로 사용한다.

<img width="721" alt="스크린샷 2023-11-13 오후 3 26 11" src="https://github.com/pjhcsols/nangman/assets/112597910/6e212fa4-7124-47d1-893c-9ac659141ef1">


직접 구현한 함수 EventMarkerContainer 내에서 마커를 표시하기 위해 MapMarker 컴포넌트를 사용한다.


<img width="891" alt="스크린샷 2023-11-13 오후 3 28 22" src="https://github.com/pjhcsols/nangman/assets/112597910/2df7053e-e916-48e0-9969-414f7c688fda">

마커에 인포 윈도우 띄우기 <br>
마커를 클릭하였을 때, 인포 윈도우에 위치 정보를 담아 띄우고 exit 버튼을 누르면 창이 닫히는 기능을 구현하기 위한 컴포넌트를 생성하여 사용한다.
<img width="1020" alt="스크린샷 2023-11-13 오후 3 53 25" src="https://github.com/pjhcsols/nangman/assets/112597910/3cf4bccf-c233-4323-a493-e0dc69118562">

<br>
<br>
<br>
<br>
<br>
<br>

## 시스템 아키텍처
![해커톤시스템architecture](https://github.com/pjhcsols/nangman/assets/97275777/934e6ed9-e65b-49af-8a08-c220802bfe07)

<br>
<br>
<br>
<br>
<br>

## 번외
# 프로젝트 nangman

## git commit message head
Feat : 새로운 기능 추가, 기존의 기능을 요구 사항에 맞추어 수정  
Fix : 기능에 대한 버그 수정  
Build : 빌드 관련 수정  
Chore : 패키지 매니저 수정, 그 외 기타 수정 ex) .gitignore  
Docs : 문서(주석) 수정  
Refactor : 기능의 변화가 아닌 코드 리팩터링 ex) 변수 이름 변경  
Test : 테스트 코드 추가/수정  




# 제안 배경
최근 신조어 중 “노키즈 존”이라는 단어가 있다. 이는 카페, 식당 등 특정 자영업자들이 자신의 사업장에 아이들을 받지 않겠다고 해서 붙혀진 신조어이다. 물론 아이들을 차별하려는 것이 아닌 사업장 컨셉과의 불일치 또는 일부 고객으로 인한 피해로 생겨난 것이지만 UN 에서 선언한 UN 아동인권협약에 따르면, 아이들은 차별받지 않고 교육받고, 놀 권리인 ‘발달권'이 있다고 명시되어 있다. 우리는 이 ‘발달권’ 보장에 초점을 두기로 하였다. 아이들을 차별하는 현 세태를 재고하며 아이들이 언제 어디서든 정당한 ‘발달권'을 보장받을 수 있도록하는 웹 서비스를 구현하고자 한다.




# 개요
핵심 내용
1. 지도 API 를 활용하여 실시간으로 ‘내 위치' 주변 탐색이 가능하도록 구현
2. 해당 지도에서 대구시 내의 “YES키즈존" 공간 및 이벤트 등의 정보 제공
3. “NO키즈존” 필터링 할 수 있는 알고리즘 구현 예정 - 지도 내에서는 “NO 키즈존" 정보는 제외시킬 것
4. “YES 키즈존”의 공간과 이벤트는 고유의 색으로 구분하여 표시 예정 (Ex. 식당/카페 :파란색, 활동/행사 : 초록색)
5. 식당과 카페의 경우, 등록된 메뉴 정보로부터 ‘주니어’ ,’어린이’,’키즈'’등 아동 관련 특정 단어에 대한 필터링을 실시하여 해당 메뉴가 우선적으로 노출되게끔 구현 예정
- 이 기능을 통해 주 타겟 사용자(부모)는 해당 식당/카페에 아이들을 위한 메뉴가 있는 지 쉽게 확인 가능



<br>

# 백엔드

## 1. JWT 인증인가 token을 통한 로그인 기능 구현
![image](https://github.com/pjhcsols/nangman/assets/110244523/8e8a025f-110f-4e4e-ac65-7848d80e23cd)
<img width="1257" alt="인증인가" src="https://github.com/pjhcsols/nangman/assets/110244523/81a7d9b2-0638-4d0e-99d3-88162c3b4b17">

JWT (JSON Web Token)
인증에 필요한 정보들을 암호화시킨 토큰을 뜻한다.

<br>

JWT 기반 인증 방식이란 Client가 Server에게 요청을 보낼 때 HTTP의 Header에 
이전에 Server로부터 발급받은 JWT를 담아 보내고, 이를 기반으로 Server가 Client를 식별하는 방식을 뜻한다.<br>
클라이언트에서 패스워드를 통하지 않고 암호화된 token기반으로 로그인 성공여부를 파악하기때문에 보안성이 높다.

<br>

## 1-1. Signature 구현
header의 인코딩 값 + payload의 인코딩 값 + 서버의 key값 을 header에서 정의한 알고리즘으로 암호화한 것.<br>
이 때 서버의 key값이 유출되지 않는 이상 복호화할 수 없다.

<br>

## 1-2. Access token
Client는 JWT를 저장하고, 이후 인증이 필요한 요청마다 Authorization Header에 Access token을 담아 보냄

[' . '로 구분된 세 문자열인 Header, Payload, Signature로 이루어져있다.]
Server는 발행했던 token과 Client로부터 받은 token의 일치여부를 확인한다 (인증).



## 2. 카테고리ID(1.노키즈존, 2.키즈존, 3.아동복합문화공간) 별로 DB를 통한 필터링 기능
<br>

클라이언트 측에서 요청한 노키즈존, 키즈존, 아동복합문화공간을 카테고리ID 별로 필터링을 통해 원하는 정보를 전송해준다.
<img width="1257" alt="스크린샷 2023-11-12 오후 11 44 52" src="https://github.com/pjhcsols/nangman/assets/110244523/1094f64c-7bf6-457a-9972-365dbc2a21df">

### 카테고리 단일 선택
<img width="1462" alt="마커-노키즈존 카테고리" src="https://github.com/pjhcsols/nangman/assets/112597910/8dee9eb8-201c-4490-b438-012bfcef398e">

### 카테고리 다중 선택
<img width="1470" alt="스크린샷 2023-11-13 오후 3 48 33" src="https://github.com/pjhcsols/nangman/assets/112597910/c95089c8-3e7a-4ab0-869f-f51e6107418a">

### 카테고리 모두 가져오기
<img width="1470" alt="스크린샷 2023-11-13 오후 3 48 43" src="https://github.com/pjhcsols/nangman/assets/112597910/0b22f5c4-b1ff-4b5b-9996-8c808a9262f3">

<br>

## 3. Store Service를 통한 DB에 저장된 스토어 보기
클라이언트 측에서 요청한 모든 상점에 대한 정보를 json 형식으로 파싱하여 전송해준다.
<img width="872" alt="image" src="https://github.com/pjhcsols/nangman/assets/97275777/1d6cbe59-dbe9-407e-8fca-7a81c4e46d62">


# 프론트엔드

## 1. UI 피그마 디자인
<img width="948" alt="KakaoTalk_Photo_2023-11-13-15-51-42" src="https://github.com/pjhcsols/nangman/assets/112597910/4c3b6686-2da8-4a54-adb7-088152a5e7a9">


## 2. 카카오 지도 API 사용
import {useMap,Map,MapMarker} from 'react-kakao-maps-sdk' 문을 추가하여 카카오 지도 API를 사용한다.<br>
지도를 디스플레이 크기에 맞춰 출력하기 위해 Map 컴포넌트를 아래와 같은 코드로 사용한다.

<img width="721" alt="스크린샷 2023-11-13 오후 3 26 11" src="https://github.com/pjhcsols/nangman/assets/112597910/6e212fa4-7124-47d1-893c-9ac659141ef1">


직접 구현한 함수 EventMarkerContainer 내에서 마커를 표시하기 위해 MapMarker 컴포넌트를 사용한다.


<img width="891" alt="스크린샷 2023-11-13 오후 3 28 22" src="https://github.com/pjhcsols/nangman/assets/112597910/2df7053e-e916-48e0-9969-414f7c688fda">

마커에 인포 윈도우 띄우기 <br>
마커를 클릭하였을 때, 인포 윈도우에 위치 정보를 담아 띄우고 exit 버튼을 누르면 창이 닫히는 기능을 구현하기 위한 컴포넌트를 생성하여 사용한다.
<img width="1020" alt="스크린샷 2023-11-13 오후 3 53 25" src="https://github.com/pjhcsols/nangman/assets/112597910/3cf4bccf-c233-4323-a493-e0dc69118562">




## 3. UI 실제 화면
### 홈 페이지
<img width="1462" alt="홈화면-기본" src="https://github.com/pjhcsols/nangman/assets/112597910/c97c1610-69dd-4219-9b81-dbe2ad3af0ee">

### 회원가입 관련 페이지
<img width="1462" alt="회원가입 모드 선택" src="https://github.com/pjhcsols/nangman/assets/112597910/d1a107ed-c028-49df-9fb7-1bc7bc762a85">

<img width="1462" alt="회원가입-일반 유저" src="https://github.com/pjhcsols/nangman/assets/112597910/43e25a3b-1bf5-44fa-b14d-e0728e94fb66">

### 로그인 관련 페이지
<img width="1462" alt="로그인 모드 선택" src="https://github.com/pjhcsols/nangman/assets/112597910/09efa285-01a9-4c1c-a639-76dcce33b988">
<img width="1470" alt="스크린샷 2023-11-13 오후 3 43 46" src="https://github.com/pjhcsols/nangman/assets/112597910/2fa9f60e-5e13-437e-b9bd-17fccb3b5e7a">


### 일반 유저 메인 페이지
<img width="1462" alt="일반 유저-메인" src="https://github.com/pjhcsols/nangman/assets/112597910/f9e77679-4cf3-4558-86a9-e8d241b6fe98">

### 호스트 유저 페이지
#### 호스트 유저 메인 페이지
<img width="1462" alt="호스트-메인" src="https://github.com/pjhcsols/nangman/assets/112597910/065526e7-daec-4e42-9087-28a5b651938b">

#### 호스트 유저 키즈존 등록 페이지
<img width="1462" alt="호스트-키즈존 등록" src="https://github.com/pjhcsols/nangman/assets/112597910/d147a030-97d1-44c4-a9b1-90cac9775775">

## 4. Custom hooks 활용
'react-kakao-maps-sdk'패키지 내의 Map 컴포넌트를 사용할 때, 지도의 너비와 높이에 대한 style을 지정해주어야한다. </br>
현재 브라우저 창의 너비와 높이에 따라 지도의 크기를 세팅하기 위해 Custom hooks를 활용한다.</br>(window.innerWidth,window.innerHeight 속성 사용)
<img width="1020" alt="스크린샷 2023-11-13 오후 3 53 25" src="https://github.com/pjhcsols/nangman/assets/112597910/3f2ed90d-67e0-4b47-8c9b-f8e19bf88393">

## 5. Geolocation 이용하여 현 위치 찾기
navigator.geolocation을 이용하여 접속 위치를 찾아, 현 위치 마커를 사용하여 표시한다.
<img width="1020" alt="스크린샷 2023-11-13 오후 4 10 29" src="https://github.com/pjhcsols/nangman/assets/112597910/64e1f607-310d-4900-bed9-39dc712f9aa1">





