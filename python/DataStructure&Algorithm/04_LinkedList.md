## 링크드 리스트(Linked List)

### 1. 링크드 리스트(Linked List) 구조

- 연결리스트 라고도 함
- 배열은 순차적으로 연결된 공간에 데이터를 나열하는 데이터 구조
- 링크드 리스트는 떨어진 곳에 존재하는 데이터를 화살표로 연결해서 관리하는 데이터 구조
- 본래 C언어에서는 주요한 데이터 구조이지만, 파이선은 리스트 타입이 링크드 리스트의 기능을 모두 지원한다

- 링크드 리스트 기본 구조와 용오
  - 노드(Node): 데이터 저장 단위 **(데이터 값, 포인터(주소값))** 로 구성
  - 포인터(pointer): 각 노드 안에서, 다음이나 이전의 노드와의 연결정보를 가지고 있는 공간

### 참고1: 객체지향(OOP), Class 예제

In [19]:

```python
class rect:
    width = 0
    height = 0
    color = ''
    
    def getArea(self):
        return self.width * self.height
    
    def setArea(self, data1, data2, data3):
        self.width = data1
        self.height = data2
        self.color = data3
    
rect1 = rect()
rect2 = rect()

rect1.setArea(10,5, 'red')

rect2.width = 7
rect2.height = 7
rect2.color = 'blue'

print(rect1.width, rect1.height, rect1.getArea(), rect1.color)
print(rect2.width, rect2.height, rect2.getArea(), rect2.color)


10 5 50 red
7 7 49 blue
```

### 참고2: 생성자와 소멸자

In [22]:

```python
import math

class Triangle:
    def __init__(self, w, n):
        self.width = w
        self.name = n
        
    def __del__(self):
        print('object is deleted')
        
    def getName(self):
        return self.name
    
    def getArea(self):
        return (math.sqrt(3)/2) * self.width**2
        
```

In [23]:

```python
triangle = Triangle(10, 'minhee')
print(triangle.getName())
print(triangle.getArea())

# 위 print 결과
minhee
86.60254037844386
```

### 2. 구현

#### Node 구현

- 보통 파이선에서 링크드 리스트 구현시, 파이선 클래스를 활용함
  - 파이선 객체지향 문법 이해 필요

In [24]:

```python
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
```

In [26]:

```python
class Node:
    def __init__(self, data, next = None):
        self.data = data
        self.next = next
```

#### Node와 Node 연결하기 (포인터 활용)

In [28]:

```python
node1 = Node(1)
node2 = Node(2)
# print(node1)
node1.next = node2 # node1 => node2를 가리킴
head = node1 # 가장 앞에 있는 주소
```

#### 링크드 리스트로 데이터 추가하기

In [32]:

```python
class Node:
    def __init__(self, data, next = None):
        self.data = data
        self.next = next
        
def add(data):
    node = head
    while node.next:
        node = node.next
    node.next = Node(data)
```

In [33]:

```python
node1 = Node(1)
head = node1 

for index in range(2,10):
    add(index)
```

#### 링크드 리스트 데이터 출력하기(검색하기)

In [35]:

```python
node = head

while node.next:
    print(node.data)
    node = node.next
   
print(node.data)
# 출력 결과 
1
2
3
4
5
6
7
8
9
```

### 3.링크드 리스트의 장단점(전통정인 C언어에서의 배열과 링크드 리스트)

- 장점
  - 미리 데이터 공간을 미리 할당하지 않아도 됨
    - 배열은 미리 데이터 공간을 할당해야 함.
- 단점
  - 데이터 이외에 포인터를 저장해야하는 공간이 별도로 필요하므로, 저장효율은 높지 않음
  - 연결 정보를 찾는 시간이 필요하므로 접근 속도가 느림
  - 중간 데이터 삭제시, 앞 뒤 데이터의 연결을 재구성해야하는 부가적인 작업 필요

### 4. 링크드 리스트의 복잡한 기능1 ( 링크드 리스트 데이터 사이에 데이터를 추가)

- 링크드 리스트는 유지 관리에 부가적인 구현이 필요함

In [39]:

```python
# 현재 데이터 상태 출력
node = head

while node.next:
    print(node.data)
    node = node.next
print(node.data)

# 출력 결과 
1
2
3
4
5
6
7
8
9
```

In [40]:

```python
node3 = Node(1.5)
```

In [41]:

```python
node = head
search = True

while search:
    if node.data ==1:
        search = False
    else:
        node = node.next
        
node_next = node.next  # 기존 연결리스트의 다음에 올 node
node.next = node3      # node를 3에 연결
node3.next = node_next # node3을 다음 노드에 연결
```

In [42]:

```python
node = head

while node.next:
    print(node.data)
    node = node.next
print(node.data)

## 1.5 삽입 후 결과 출력
1
1.5
2
3
4
5
6
7
8
9
```

### 5. 파이선 객체지향 프로그래밍으로 링크드 리스트 구현하기

In [5]:

```python
## Linked List 구현 예 (삽입, 출력 함수까지 구현.)
class Node:
    def __init__(self, data, next = None):
        self.data = data
        self.next = next
    
class NodeMgmt:
    # head : 맨 앞의 노드 주소 값
    def __init__(self, data):
        self.head = Node(data)
    
    #새로운 노드를 추가하는 함수
    def add(self, data):
        #만약, head값이 없다면, linked list가 없다면, 새로 추가
        if self.head == '':
            self.head = Node(data)
        else:
            node = self.head
            while node.next:
                node = node.next
            node.next = Node(data)
    
    # 노드 출력하는 함수
    def desc(self):
        node = self.head
        while node:
            print(node.data)
            node = node.next
```

In [6]:

```python
linkedlist1 = NodeMgmt(0)
linkedlist1.desc()
# 출력 (desc()수행 결과)
0
```

In [48]:

```python
for data in range(1,10):
    linkedlist1.add(data)
linkedlist1.desc()

# 출력 (desc()수행 결과)
0
1
2
3
4
5
6
7
8
9
```

### 6. 특정노드를 삭제

- case
  1. head값을 삭제할 때 => head의 다음 노드가 head가 된다. (기존 head는 제거, null로 처리)
  2. tail값을 삭제할 때 => 앞의 노드가 가리키는 주소값을 null또는 None으로 바꾸어주어야 한다.
  3. 중간 노드 삭제 => 이전 노드가 가리키는 주소를 변경(이전노드가, 현재노드 다음 노드를 가리키게 하고) + 해당 노드 삭제
- 결과적으로는 2,3 삭제 구현은 같다

In [54]:

```python
class Node:
    def __init__(self, data, next = None):
        self.data = data
        self.next = next
    
class NodeMgmt:
    # head : 맨 앞의 노드 주소 값
    def __init__(self, data):
        self.head = Node(data)
    
    #새로운 노드를 추가하는 함수
    def add(self, data):
        #만약, head값이 없다면, linked list가 없다면, 새로 추가
        if self.head == '':
            self.head = Node(data)
        else:
            node = self.head
            while node.next:
                node = node.next
            node.next = Node(data)
    
    # 노드 출력하는 함수
    def desc(self):
        node = self.head
        while node:
            print(node.data)
            node = node.next
            
    def delete(self, data):
        if self.head == '':
            print('해당 값을 가진 노드가 없습니다.')
            return
        if self.head.data == data:
            temp = self.head
            self.head = self.head.next
            del temp
            
        else:
            node = self.head
            while node.next:
                if node.next.data == data:
                    temp = node.next # 다음 노드
                    node.next = node.next.next #다음 노드를 다다음 노드로 변경
                    del temp
                    return
                else:
                    node = node.next
```

#### 테스트를 위해 1개 노드 만들어봄

In [60]:

```python
linkedlist2 = NodeMgmt(0)
linkedlist2.desc()
0
```

#### head가 살아있음을 확인

In [56]:

```python
linkedlist2.head
```

Out[56]:

```bash
<__main__.Node at 0x22d3a3a2508>
```

#### head를 지워봄(head 지우는 경우): 아무것도 출력이 안된다면, 정삭 삭제 되었음 의미

In [57]:

```python
linkedlist2.delete(0)
linkedlist2.desc()
```

#### 새로 노드 만들기

In [62]:

```python
linkedlist2 = NodeMgmt(0)
linkedlist2.desc()
0
```

#### 여러 노드 추가하기

In [64]:

```python
for data in range(1,10):
    linkedlist2.add(data)

linkedlist2.desc()
# linkedlist에 1~10까지 담고 출력 (기존에 0은 위에서 추가했었음.)
0
1
2
3
4
5
6
7
8
9
```

#### 노드 삭제하기 4, 9, 2

In [65]:

```python
linkedlist2.delete(4)
linkedlist2.desc()
# 4삭제후 출력한 결과
0
1
2
3
5
6
7
8
9
```

In [67]:

```python
linkedlist2.delete(9)
linkedlist2.desc()
# 9 삭제후 출력결과
0
1
2
3
5
6
7
8
```

In [68]:

```python
linkedlist2.delete(2)
linkedlist2.desc()
# 2 삭제 후 출력결과
0
1
3
5
6
7
8
```

### 7. 다양한 링크드 리스트 구조

1. 양방향 연결 리스트 (더블 링크드 리스트)
   - 앞의 주소, 뒤의 주소를 모두 저장해서 검색 속도를 증가시킨다.
   - 단방향 연결리스트의 단점인 검색속도를 증가시킬 수 있다.

In [11]:

```python
class Node:
    def __init__(self, data,prev=None, next=None):
        self.data = data
        self.prev = prev
        self.next = next
        
class NodeMgmt:
    def __init__(self,data):
        self.head = Node(data)
        self.tail = self.head
    
    def insert(self,data):
        if self.head == None:
            self.head = Node(data)
            self.tail = self.head
        else:
            node = self.head
            # node.next가 None일 경우 맨 끝을 뜻함.
            while node.next:
                node = node.next
            new = Node(data)
            node.next = new
            new.prev = node
            self.tail = new
            
    def desc(self):
        node = self.head
        while node:
            print(node.data)
            node = node.next
                
```

In [12]:

```python
double_linked_list = NodeMgmt(0)
```

In [13]:

```python
for data in range(1,10):
    double_linked_list.insert(data)
```

In [14]:

```python
double_linked_list.desc()
0
1
2
3
4
5
6
7
8
9
```

1. 연습문제: 노드 데이터가 특정 숫자인 노드 앞에 데이터를 추가하는 함수를 만들고, 테스트하기
   - tail부터 이동하며 특정 숫자인 노드를 찾는 방식으로 구현할 것.
   - 테스트: 데이터 값이 2인 노드 앞에 1.5 데이터 값을 가진 노드 추가해보기

In [36]:

```python
class Node:
    def __init__(self, data,prev=None, next=None):
        self.data = data
        self.prev = prev
        self.next = next
        
class NodeMgmt:
    def __init__(self,data):
        self.head = Node(data)
        self.tail = self.head
    
    def insert(self,data):
        if self.head == None:
            self.head = Node(data)
            self.tail = self.head
        else:
            node = self.head
            # node.next가 None일 경우 맨 끝을 뜻함.
            while node.next:
                node = node.next
            new = Node(data)
            node.next = new
            new.prev = node
            self.tail = new
            
    def desc(self):
        node = self.head
        while node:
            print(node.data)
            node = node.next
                
    def search_from_head(self, data):
        if self.head == None:
            return False
        
        node = self.head
        while node:
            if node.data == data:
                return node
            else:
                node = node.next
        return False
    
    def search_from_tail(self, data):
        if self.head == None:
            return False
        
        node = self.tail
        while node:
            if node.data == data:
                return node
            else:
                node = node.prev
        return False
    
    def insert_before(self, data, before_data):
        if self.head == None:
            self.head = Node(data)
            self.tail = self.head
            return True
        else:
            node = self.tail
            while node.data != before_data:
                node = node.prev
                if node == None:
                    return False
            #반복문을 무사히 통과했다면, 현재 node는 앞의 데이터
            new = Node(data)
            before_new = node.prev
            before_new.next = new
            new_prev = before_new
            new.next = node
            node.prev = new
            return True
        
```

In [37]:

```python
double_linked_list = NodeMgmt(0)
for data in range(1,10):
    double_linked_list.insert(data)

# 양방향 연결리스트에 0~10까지 추가하고 출력
double_linked_list.desc()
0
1
2
3
4
5
6
7
8
9
```

In [33]:

```python
node_3 = double_linked_list.search_from_head(10)
if node_3:
    print(node_3.data)
else:
    print('No data!')
    
# 출력: 10을 head부터 차례로 검색해봤으나 없음 (9까지만 삽입했기때문)
No data!
```

In [35]:

```python
node_3 = double_linked_list.search_from_tail(3)
if node_3:
    print(node_3.data)
else:
    print('No data!')
    
# 출력: 3은 삽입 정상적으로 됨
3
```

In [38]:

```python
# 2 가 담긴 값 앞에 1.5 삽입
double_linked_list.insert_before(1.5,2)
```

Out[38]:

```python
# 삽입 정상 처리
True
```

In [39]:

```python
# 전체 링크드 리스트 출력
double_linked_list.desc()
0
1
1.5
2
3
4
5
6
7
8
9
```

1. 연습문제 4: 앞에서부터 차례대로 찾음서, 데이터 추가하기!!

In [45]:

```python
# 양방향 링크드 리스트 최종
class Node:
    def __init__(self, data,prev=None, next=None):
        self.data = data
        self.prev = prev
        self.next = next
        
class NodeMgmt:
    def __init__(self,data):
        self.head = Node(data)
        self.tail = self.head
    
    def insert(self,data):
        if self.head == None:
            self.head = Node(data)
            self.tail = self.head
        else:
            node = self.head
            # node.next가 None일 경우 맨 끝을 뜻함.
            while node.next:
                node = node.next
            new = Node(data)
            node.next = new
            new.prev = node
            self.tail = new
            
    def desc(self):
        node = self.head
        while node:
            print(node.data)
            node = node.next
                
    def search_from_head(self, data):
        if self.head == None:
            return False
        
        node = self.head
        while node:
            if node.data == data:
                return node
            else:
                node = node.next
        return False
    
    def search_from_tail(self, data):
        if self.head == None:
            return False
        
        node = self.tail
        while node:
            if node.data == data:
                return node
            else:
                node = node.prev
        return False
    
    def insert_before(self, data, before_data):
        if self.head == None:
            self.head = Node(data)
            self.tail = self.head
            return True
        else:
            node = self.tail
            while node.data != before_data:
                node = node.prev
                if node == None:
                    return False
            #반복문을 무사히 통과했다면, 현재 node는 앞의 데이터
            new = Node(data)
            before_new = node.prev
            before_new.next = new
            new_prev = before_new
            new.next = node
            node.prev = new
            return True
        
    def insert_after(self, data, after_data):
        if self.head == None:
            self.head = Node(data)
            self.tail = self.head
            return True
        else:
            node = self.head
            while node.data != after_data:
                node = node.next
                if node == None:
                    return False
            new = Node(data)
            after_new = node.next
            node.next = new
            new.prev = node
            new.next = after_new
            after_new.prev = new
            return True
```

In [46]:

```python
double_linked_list = NodeMgmt(0)
for data in range(1,10):
    double_linked_list.insert(data)
    
double_linked_list.desc()
0
1
2
3
4
5
6
7
8
9
```

In [47]:

```python
# data가 1인 값 뒤에 1.5추가하기
double_linked_list.insert_after(1.5,1)
```

Out[47]:

```python
# 성공적으로 추가
True
```

In [48]:

```python
# 결과 확인
double_linked_list.desc()
0
1
1.5
2
3
4
5
6
7
8
9
```

