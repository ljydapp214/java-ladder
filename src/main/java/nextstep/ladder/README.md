# 사다리타기

---


## 기능 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
  - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

## 프로그래밍 요구사항
- 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
- 규칙 6: 모든 엔티티를 작게 유지한다.

### 실행결과
- 위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
```text
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
꽝,5000,꽝,3000

최대 사다리 높이는 몇 개인가요?
5

사다리 결과

pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
꽝    5000  꽝    3000

결과를 보고 싶은 사람은?
pobi

실행 결과
꽝

결과를 보고 싶은 사람은?
all

실행 결과
pobi : 꽝
honux : 3000
crong : 꽝
jk : 5000
```

---


## 구현할 기능 목록
### 사용자명 (UserName)
- [x] 사용자 이름은 1~5자이다.
- [x] 사용자 이름을 형식에 맞게 반환한다.

### 참여자 (Participants)
- [x] InputView 로 부터 받은 입력값을 정제하여 초기화한다.
- [x] 사용자 이름 리스트를 갖는다.
- [x] 사용자 수를 반환한다.
- [x] 사용자 이름을 반환한다.
- [x] 사용자 이름을 입력하면 참여순서를 반환한다.

### 실행결과 (ExecuteResults)
- [x] 실행결과를 갖는다.
  - NOTE: InputView 로 부터 받은 입력값을 정제하여 초기화한다.
- [x] 위치를 입력하면 실행결과를 반환한다.

### 사다리 높이 (LadderHeight)
- [x] 사다리 높이 값을 갖는다.
- [x] 사다리 높이 값은 0보다 커야한다.
- [x] 사다리 높이 값을 반환한다.

### 사다리 (Ladder)
- [x] 높이만큼 rows을 생성한다.
- [x] rows 리스트를 갖는다.
  - NOTE: 사용자 수만큼 연결여부 리스트를 생성해야한다.
- [x] rows를 반환한다.
- [x] 참여자 위치를 입력하면 실행결과를 반환한다.

### 사다리 가로행 (Row)
- [x] 연결유형 리스트를 갖는다.
  - [x] 연결유형은 우측연결을 기준으로 랜덤하게 결정된다.
  - [x] 연속해서 연결된 값을 가질 수 없다.
  - [x] 이전 연결여부를 확인하여 좌측 연결여부를 결정한다.
- [x] 연결유형 리스트를 반환한다.
- [x] 최근 위치를 입력하면 해당 위치의 움직임 포인트를 반환한다.

### 연결유형 (ConnectionType)
- [x] 연결유형을 나타낸다.
  - LEFT, RIGHT, NONE
- [x] move point를 반환한다.

### 위치 (Position)
- [x] 현재 위치를 갖는다.
- [x] 현재 위치를 반환한다.
- [x] movePoint를 받아 새로운 위치를 반환한다.

### 입력 (InputView)
- [x] 사용자로부터 사다리 게임에 참여하는 사람의 이름을 입력받아 반환한다.
- [x] 사용자로부터 최대 사다리 높이를 입력받아 반환한다. 
- [x] 사용자로부터 실행 결과를 입력받아 반환한다.
- [x] 사용자로부어 실행 결과를 보고 싶은 이름을 입력받아 반환한다.

### 출력 (ResultView)
- [x] 사용자 이름을 형식에 맞게 출력한다.
- [x] 사다리를 출력한다.
- [x] 사다리 실행결과를 출력한다.
- [x] 사용자의 실행결과를 출력한다.
- [x] 사용자들의 실행결과를 출력한다.