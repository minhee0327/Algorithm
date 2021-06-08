## 대표적인 데이터구조 6: 해쉬테이블(Hash Table)

### 1. 해쉬구조

- Hash Table: 키에 데이터(value)를 저장하는 구조
  - 파이선에서는 해쉬 별도 구현 X => 딕셔너리타입 사용
  - key를 통해 데이터 받아오기때문에 **속도**가 매우빠름 => 검색에 자주 활용됨
  - 최근에는 Block Chain기술에 많이 활용되었음.
  - 보통 배열로 미리 Hash Table 사이즈만큼 생성 후 사용(공간과 탐색시간을 맞바꾸는 기법)

### 2. 알아둘 용어

- 해쉬(Hash): 임의 값을 고정길이로 변환하는 것
- 해쉬테이블(Hash Table): 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조
- 해싱함수(Hashing Function): Key에 대해 산술 연산을 이용해 데이터 위치를 찾을 수 있는 함수.
- 해쉬값 또는 해쉬 주소(Hash Value, Hash address):
  Key를 해싱함수로 연산해서, 해쉬값을 알아내고 이를 기반으로 해쉬테이블에서 Key에 대한 데이터 위치를 일관성 있게 찾을 수 있음
- 슬롯(Slot): 한개의 데이터를 저장할 수 있는 공간
- 저장할 데이터에 대해 Key를 추출할 수 있는 별도 함수 존재할 수 있음.

### 3. 간단하게 구현해보기

#### 3.3 hash table

In [1]:

```
hash_table = list([0 for i in range(10)])
hash_table
```

Out[1]:

```
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
```

#### 3.2 hash function

- 가장 간단한 방법: Division 법(나누기를 통한 나머지 값을 사용하는 기법)

In [8]:

```
def hash_func(key):
    return key % 5
```

#### 3.3 hash talbe에 저장

In [13]:

```
data1 = 'MinHee'
data2 = 'Jiyoung'
data3 = 'Amy'

#ord(): 문자의 ASCII 코드 리턴
print(ord(data1[0]), ord(data2[0]), ord(data3[0]))
print(ord(data1[0]), ord(data1[0])%5)
print(ord(data1[0]), hash_func(ord(data1[0]))) # key값: ord(data1[0])
77 74 65
77 2
77 2
```

#### 3.3.1 해쉬 테이블 값 저장 예시

In [14]:

```
def storage_data(data, value):
    key = ord(data[0])
    hash_address = hash_func(key)
    hash_table[hash_address] = value
```

#### 3.3.2 해쉬테이블에서 특정 주소 데이터를 가져오는 함수 만들어보기

In [15]:

```
storage_data('MinHee', '01066660000')
storage_data('Jiyoung', '01033337777')
storage_data('Amy', '01088881111')
```

#### 3.3.3 실제 데이터 저장하고 읽어보기

In [16]:

```
def get_data(data):
    key = ord(data[0])
    hash_address = hash_func(key)
    return hash_table[hash_address]
```

In [17]:

```
get_data('Amy')
```

Out[17]:

```
'01088881111'
```

### 4. 해쉬테이블 장단점 및 용도

- 장점
  - 데이터 저장/읽기 속도 빠름. **(검색속도 빠름!)**
  - 해쉬는 키에 대한 데이터 있는지 **(중복) 확인이 쉬움**
- 단점
  - 일반적으로 저장 공간 좀 더 많이 필요
  - **여러 키에 해당하는 주소 동일할 경우, 충돌을 해결하기 위한 별도 자료구조 필요!**
- 주요 용도
  - 검색 많이 필요할 때
  - 저장, 삭제, 읽기 빈번할 때
  - 캐쉬 구현시 ( 중복 확인 쉽기 때문에 )

### 5. 프로그래밍 연습

- 리스트 변수를 활용해서 해쉬 테이블 구현하기
  - 해쉬 함수: key %8
  - 해쉬 키 생성: hash(data) => 고정된 값을 리턴

In [21]:

```
hash_table = list([0 for i in range(8)])

def get_key(data):
    return hash(data)

def hash_function(key):
    return key % 8

def save_data(data, value):
    hash_address = hash_function(get_key(data))
    hash_table[hash_address] = value
    
def read_data(data):
    hash_address = hash_function(get_key(data))
    return hash_table[hash_address]
```

In [23]:

```
save_data('MinHee', '01066660000')
save_data('Jiyoung', '01033337777')
save_data('Amy', '01088881111')
```

In [24]:

```
read_data('MinHee')
```

Out[24]:

```
'01066660000'
```

### 6. 충돌(Collision) 해결 알고리즘(좋은 해쉬 함수 사용하기)

- 대표예
  - Chaining기법
  - Linear Probing 기법
  - 해쉬 함수를 재정의 및 해쉬 테이블 저장 공간 확대(2배)

#### 6.1 Chaining 기법

- Open Hashing(개방 해싱) 기법
- 해쉬 테이블 저장 공간 외의 공간 활용 기법
- 충돌이 일어나면, 링크드 리스트 자료구조를 사용해서, 데이터 추가로 뒤에 연결시켜 저장하는 기법

In [45]:

```
hash_table = list([0 for i in range(8)])

def get_key(data):
    return hash(data)

def hash_function(key):
    return key % 8

def save_data(data, value):
    index_key = get_key(data)
    hash_address = hash_function(index_key)
    if hash_table[hash_address] != 0: # 해쉬테이블의 해당 슬롯이 비워져 있지 않다면,
        for index in range(len(hash_table[hash_address])):
            if hash_table[hash_address][index][0] == index_key: # 새로들어올 key값이 만약 그 전에 들어와있었다면,
                hash_table[hash_address][index][1] = value #값을 덮어씌울 것.
                return
        hash_table[hash_address].append([index_key, value]) # 다 돌았는데, key값 중복이 없다면, 뒤에 append로 갱신해나갈것.
    else:
        hash_table[hash_address]= [[index_key, value]]
    
def read_data(data):
    index_key = get_key(data)
    hash_address = hash_function(get_key(data))
    if hash_table[hash_address] != 0:
        for index in range(len(hash_table[hash_address])):
            if hash_table[hash_address][index][0] == index_key:
                return hash_table[hash_address][index][1]
        return None
    else:
        return None

```

In [46]:

```
print(hash_function(get_key('MinHee')))
print(hash_function(get_key('Minhee')))
print(hash_function(get_key('MinJae')))
print(hash_function(get_key('MinJi')))
print(hash_function(get_key('MiMi')))
5
1
5
1
6
```

In [47]:

```
save_data('MinHee', '01011110000')
save_data('Minhee', '01022220000')
save_data('MinJae', '01033330000')
save_data('MinJi', '01044440000')
```

In [48]:

```
read_data('MinHee')
```

Out[48]:

```
'01011110000'
```

In [49]:

```
hash_table
```

Out[49]:

```
[0,
 [[3581682668247700977, '01022220000'], [8499967738134162953, '01044440000']],
 0,
 0,
 0,
 [[-1073313110567670403, '01011110000'],
  [-5229401617650671475, '01033330000']],
 0,
 0]
```

#### 6.2 Linear Proging 기법

- Close Hashing(폐쇄 해슁)기법 중하나: 해쉬 테이블 저장 공간 안에서 충돌 문제 해결
- 충돌이 일어나면, 해당 hash address 의 다음 address부터 맨 처음 나오는 빈 공간에 저장하는 기법
  - 저장공간을 활용하기 위한 기법

In [51]:

```
hash_table = list([0 for i in range(8)])

def get_key(data):
    return hash(data)

def hash_function(key):
    return key % 8

def save_data(data, value):
    index_key = get_key(data)
    hash_address = hash_function(index_key)
    if hash_table[hash_address] != 0: # 이미 hash_address에 차있다면, 
        for index in range(hash_address, len(hash_table)): # hash_address가 차있는 곳 다음부터 끝까지 반복하면서 확인
            if hash_table[index] == 0: # 만약 해당 index가 비어있다면(0)
                hash_table[index] = [index_key, value] #넣어주기!
                return
            elif hash_table[index][0] == index_key:# key가 동일하다면, 새로 value를 update
                hash_table[index][1] = value
                return
    else:
        hash_table[hash_address]= [index_key, value]
    
def read_data(data):
    index_key = get_key(data)
    hash_address = hash_function(get_key(data))
    if hash_table[hash_address] != 0:
        for index in range(hash_address, len(hash_table)):
            if hash_table[index] == 0:
                return None
            elif hash_table[index][0] == index_key:
                return hash_table[index][1]
    else:
        return None

```

In [52]:

```
save_data('MinHee', '01011110000')
save_data('Minhee', '01022220000')
save_data('MinJae', '01033330000')
save_data('MinJi', '01044440000')
```

In [54]:

```
read_data('MinJi')
```

Out[54]:

```
'01044440000'
```

In [53]:

```
hash_table
```

Out[53]:

```
[0,
 [3581682668247700977, '01022220000'],
 [8499967738134162953, '01044440000'],
 0,
 0,
 [-1073313110567670403, '01011110000'],
 [-5229401617650671475, '01033330000'],
 0]
```

#### 6.3 빈번한 충돌을 개선하는 기법

- 해쉬 함수를 재정의 및 해쉬 테이블 저장 공간 확대하기!

### 참고: 해시 함수와 키 생성함수

- 파이선의 hash()함수는 실행마다, 값이 달라질 수 있음
- 해쉬함수 2가지
  - SHA(Secure Hash Alogorithm,안전한 해시 알고리즘)
    - SHA-1
    - SHA-256
      - 어떤 데이터에도 유일한, 고정된 크기의 고정값을 리턴해주므로 해시함수로 유용하게 활용가능

In [55]:

```
#SHA-1
# 혹시 에러나면, pip install hashlib 으로 library 설치
import hashlib

data = 'test'.encode()
hash_object = hashlib.sha1()
hash_object.update(b'test') #b'test' => byte로 변환
hex_dig = hash_object.hexdigest() #16진수로 추출

print(hex_dig)
a94a8fe5ccb19ba61c4c0873d391e987982fbbd3
```

In [59]:

```
#SHA-256
# 혹시 에러나면, pip install hashlib 으로 library 설치
import hashlib

data = 'test'.encode()
hash_object = hashlib.sha256()
hash_object.update(b'test') #b'test' => byte로 변환
hex_dig = hash_object.hexdigest() #16진수로 추출

print(hex_dig, type(hex_dig))
print(int(hex_dig, 16), type(int(hex_dig, 16)))
9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08 <class 'str'>
72155939486846849509759369733266486982821795810448245423168957390607644363272 <class 'int'>
```

In [60]:

```
### Linear Chaining 기법 사용했던 부분, SHA로 hash 표현해보자!
import hashlib

hash_table = list([0 for i in range(8)])

def get_key(data):
    hash_object = hashlib.sha256()
    hash_object.update(data.encode())
    hex_dig = hash_object.hexdigest()
    return int(hex_dig,16) #16진수 문자열을 10진수 숫자열로 변환

def hash_function(key):
    return key % 8

def save_data(data, value):
    index_key = get_key(data)
    hash_address = hash_function(index_key)
    if hash_table[hash_address] != 0: 
        for index in range(hash_address, len(hash_table)): 
            if hash_table[index] == 0: 
                hash_table[index] = [index_key, value] 
                return
            elif hash_table[index][0] == index_key:
                hash_table[index][1] = value
                return
    else:
        hash_table[hash_address]= [index_key, value]
    
def read_data(data):
    index_key = get_key(data)
    hash_address = hash_function(get_key(data))
    if hash_table[hash_address] != 0:
        for index in range(hash_address, len(hash_table)):
            if hash_table[index] == 0:
                return None
            elif hash_table[index][0] == index_key:
                return hash_table[index][1]
    else:
        return None

```

In [64]:

```
print(get_key('MinHee')%8)
print(get_key('Minhee')%8)
print(get_key('MinJae')%8)
print(get_key('MinJi')%8)
3
1
3
3
```

In [61]:

```
save_data('MinHee', '01011110000')
save_data('Minhee', '01022220000')
save_data('MinJae', '01033330000')
save_data('MinJi', '01044440000')
```

In [62]:

```
hash_table
```

Out[62]:

```
[0,
 [95151058953297688801490983670223981708173521211243282372747593281218822559857,
  '01022220000'],
 0,
 [57074294736972814182231405250731525048968069818086329842541657300670696602931,
  '01011110000'],
 [35346450457171200099510866910500750872195032730351794231363716895012968310179,
  '01033330000'],
 [104935408917999936344823412221395089860526318901480398883333755526694617263171,
  '01044440000'],
 0,
 0]
```

### 7. 시간복잡도

- 일반적인 경우 (Collision이 없는 경우)는 O(1)

- 최악의 경우 (Collision이 모두 발생하는 경우)는 O(N)

  > 해쉬 테이블의 경우, 일반적인 경우를 기대하고 만들기 때문에, 시간복잡도는 O(1)이라고 할 수 있음!

### 검색에서 해쉬 테이블의 사용예

- 16개의 배열에 데이터를 저장하고, 검색할 때 O(N)
- 16개의 데이터 저장공간을 가진 위의 해쉬테이블에 데이터를 저장하고, 검색할 때 O(1)