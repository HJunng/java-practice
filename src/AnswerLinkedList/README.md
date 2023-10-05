# LinkedList란?

-----
- LinkedList란?
  - LinkedList는 연속적인 메모리 공간에 저장되지 않으며, element들이 포인터(주소값)로 연결되어 있는 자료구조이다.
  - java의 Collection 프레임워크의 일부
   

- 자료 구조
  - Node
    - data
    - next
  - Head
  - 맨 마지막 Node의 next는 NULL
  ![스크린샷 2023-10-05 오전 11.13.36.png](..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fb8%2Fw6xh9vts089683nl6prvt8nm0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_ambe9e%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-10-05%20%EC%98%A4%EC%A0%84%2011.13.36.png)
  - https://www.geeksforgeeks.org/data-structures/linked-list/
   
    
- 시간 복잡도
  - 탐색
    - Head 노드부터 쭉 보면서 내가 원하는 데이터가 나올 때까지 찾는다.
    - O(n)
  - 추가/삭제
    - 추가, 삭제할 노드 주변 노드의 Link만 수정해주면 된다.
    - O(1)
    - 다만 삽입, 삭제할 노드를 탐색하는 과정이 필요한 경우에는 최악의 경우 O(n)의 시간복잡도를 갖는다.
      - cf. ArrayList는 무조건 O(n)이다.
   

- ArrayList vs LinkedList
  - LinkedList와 ArrayList의 가장 큰 차이점은 '메모리의 연속성'
    - ArrayList는 연속된 메모리 공간에 저장되어 있는 배열, LinkedList는 주소값으로 서로 연결되어 있는 구조
    - https://www.nextree.co.kr/p6506/
    - https://opentutorials.org/module/1335/8821
    - https://webprogramcustom.tistory.com/47
        
  - LinkedList의 장점
    - 추가/삭제 연산의 최악의 경우 시간 복잡도 O(1)
      - cf. ArrayList는 O(n)
    - 크기의 제약이 없음
      - 물론, 일반 배열과 달리 ArrayList는 크기를 가변적으로 늘릴 수 있지만, 내부적으로 capacity(default 10)이상의 데이터가 들어오면 재조정하는 연산을 수행해야 하고, 이 연산의 비용이 비싸다.
    - LinkedList의 단점
      - 탐색 연산의 시간 복잡도 O(n)
        - cf. ArrayList는 O(1). x번째 index에 바로 접근 가능
      - 언제, 어떤 걸 사용하면 좋은가?
        - LinkedList: 추가, 삭제가 많은 경우
        - ArrayList: 탐색, 정렬이 많이 발생하는 경우


# Generic이란?

---
- 정의
  - 데이터의 타입(data type)을 일반화(generalize) 하는 것
  - 여러가지 타입을 가능하게 함
  - 타입을 파라미터로 가지는 클래스 또는 인터페이스: <>
  - 클래스 내부에서 사용할 타입을 외부에서 지정 가능
   

- 장점
  - 컴파일 시에 타입 검사 수행
    - 런타임에 발생하는 오류로부터 안전함
  - 타입 안정성 및 타입 변환 불필요해서 편함
   
   

# 기본 과제 구현

---
- data의 타입은 LinkedList를 생성할 때 정할 수 있도록 제네릭으로 구현
- 단순 연결 리스트(single linked list)로 구현
- 구현에 정답 x. 자료구조의 정의만 잘 따라갈 수 있도록 자유롭게 구현하면 된다.

### 순서
1. Node.java 작성
   - 멤버: data, next
   

2. Node를 사용하는 MyLinkedList.java 작성
![스크린샷 2023-10-05 오전 11.24.50.png](..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fb8%2Fw6xh9vts089683nl6prvt8nm0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_m92Gcc%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-10-05%20%EC%98%A4%EC%A0%84%2011.24.50.png)

- 멤버: Head, size(optional)
- add(): MyLinkedList의 **마지막 노드**에 data를 추가할 수 있습니다.
  1. LinkedList가 비어있는 경우: head에 넣어준다.
  2. 그 외 모든 경우
    a. 마지막 노드를 찾는다. (loop)
    b. 마지막 노드의 next에 새로운 노드를 추가한다.
- get(index i): MyLinkedList의 **i번째 노드**의 data를 return 합니다.
  1. i번째 노드를 찾는다. (loop)
  2. 그 노드의 data를 리턴한다.
- delete(index i): MyLinkedList의 **i번째 노드**의 데이터를 삭제합니다.
  1. head 노드 (index==0)를 삭제하는 경우: head를 그 다음껄로 바꿔준다.
  2. 그 외의 노드를 삭제하는 경우
![스크린샷 2023-10-05 오후 6.53.15.png](..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fb8%2Fw6xh9vts089683nl6prvt8nm0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_cxiRab%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-10-05%20%EC%98%A4%ED%9B%84%206.53.15.png)
   

3. MyLinkedList를 확인하기 위한 Main.java 작성


## 하위 과제 1

---
- Iterator interface 를 implements 한 후에 구현하여 for-each로 순회 가능하도록 하자.
- java의 for-each문
  ```java
  for(type 변수명 : iterate){
    // body-of-loop
  }
  ```
  - iterate 부분에 들어가는 타입은 Iterable<E>를 상속받은 객체면 다 가능하다.
   
   
- 구현
  1. `implements Iterable<T>` 추가
  2. `iterator()` 를 override 한다.
  3. 리턴 타입인 Iterator<T>를 만들어서 리턴해줘야 한다.
  4. Iterator에서 필수적으로 구현해야 하는 hasNext(), next()를 override 한다.
  5. hasNext()를 먼저 구현: 내 다음이 있는지? true/false 리턴
  6. next() 구현: 현재 원소를 반환하고, 다음 요소로 넘겨주는 메서드

## 하위 과제 2

---
- MyLinkedList를 이용해서 Queue와 Stack을 구현
- Stack과 Queue의 기본 정의에 맞게, 간단하게 구현한다.
- **Stack**
  - Last In First Out, 나중에 들어온 놈이 먼저 나간다.
  ![스크린샷 2023-10-05 오후 7.00.20.png](..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fb8%2Fw6xh9vts089683nl6prvt8nm0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_zuzb9H%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-10-05%20%EC%98%A4%ED%9B%84%207.00.20.png)
  - LinkedList의 맨 킅을 top이라고 하자.
    - 왜? 우리가 구현한 add()가 맨 끝에 추가하는 메서드이기 때문
  - push(): top에 원소를 추가한다.
  - pop(): top의 원소를 제거하고 반환한다.
  - peek(): top의 원소를 반환한다. (제거 x)
  - 각 operation에 예외처리 추가
   

- Queue
  - First In First Out, 먼저 온 놈이 먼저 나간다.
  - enqueue(): 가장 뒤에 원소를 추가한다.
  - dequeue(): 가장 앞에 있는 원소를 제거하고 반환한다.
  - peek(): 가장 앞에 있는 원소를 반환한다. (제거 x)
  - 각 operation에 예외처리 추가