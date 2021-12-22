# spring_cookie

## 고려할 점
- key 는 user_id + ip 이다.
  - 두 개를 하나의 문자열로 합쳐서 키 값 생성
- 캐시 용량을 최소화 할 수 있는 방안을 찾아야 함.
- 스케줄링 돌려서 캐시를 초기화해야할까?
- 최초 서버를 올렸을 때 DB를 읽어서 기본 캐싱 데이터들이 쌓여있어야 함
- 기본적으로 KEY 값으로 데이터를 조회하고 값이 없을 경우 캐시에 쌓는데, 이렇게 되면 안되거든
- 유효성 검사
  - 키값이 유효하지 않을 경우
- 관리자가 값을 추가했을 경우 캐시 데이터도 추가돼야 함.
- 관리자가 승인했을 경우 캐시 데이터도 추가돼야 함
- 모든 HTTP METHOD 에 적용이 되는지 확인해야 함 (POST, PUT, DELETE, PATCH 는 사용하는 것 같지 않지만 그래도 확인 필요함)
- DB 에서 조회하는 것 VS 캐싱된 데이터 조회하는 것 성능 차이 확실히 비교해야 함
  - 그러기 위해서는 DB 에서 조회하는 서비스도 만들어야 함
- 캐시 데이터의 MAX 값이 존재하는지 확인해야 함
  - 캐시 설정하는 게 있을 수 있음
- IP가 키값이면 아이피가 바뀐 경우는 어떻게 함?


## 매커니즘 정리
1. 사용자 ID + IP + URL 요청 받음
2. ID + IP 로 캐싱된 권한들 있는지 조회
  2-1. 권한이 있으면 리턴
  2-2. 없으면 DB에서 조회
  2-3. 결과 조회 캐싱
3. 결과값 리턴
  

### 수정
1. 수정의 경우 수정 전 데이터와 수정 후 데이터를 전송
2. 수정 전 키값으로 조회된 데이터를 삭제
3. 수정 후 데이터를 추가
4. 수정 후 데이터를 리턴

### 삭제
1. 그냥 삭제할 Entity 받아서 지움


### 기타
1. 하루에 한번 초기화
 -> 가끔 요청하는 사용자가 있을 수도 있음
 -> 캐시 데이터가 점점 커질 우려가 있음
ㅇ
