# Queue

### 1. 큐 구조

- 줄을 서는 행위와 유사
- 가장 먼저 넣은 데이터를 가장 먼저 꺼낼 수 있는 구조
  - 음식점에서 가장 먼저 줄을 선 사람이 제일 먼저 음식점에 입장하는 것과 동일
  - FIFO, LILO방식, 스택과 순서 반대

### 2. 알아둘 용어

- Enqueue: 큐에 데이터를 넣는 기능
- Dequeue: 큐에서 데이터를 꺼내는 기능

### 3. 파이선 queue 라이브러리 활용해서 큐 자료구조 사용하기

- queue 라이브러리에는 다양한 큐 구조로 Queue(), LifoQueue(), PriorityQueue()

  - Queue(): 가장 일반적인 큐 자료구조

  - LifoQueue(): 나중에 입력된 데이터가 먼저 출력되는 구조(스택 구조라고 보면됨)

  - PriorityQueue(): 데이터마다 우선순위를 넣어서, 우선순위가 높은 순으로 데이터 출력

    > 일반적인 큐 외에 다양한 정첵이 적용된 큐들이 있음

#### 3.1 Queue()로 큐 만들기(가장 일반적인 큐, FIFO(First In First Out))

In [2]:

```
import queue #queue: 라이브러리 명

data_queue = queue.Queue() # Queue():클래스 명
```

In [3]:

```
data_queue.put('minimi') # 데이터 삽입
data_queue.put(1)
```

In [5]:

```
data_queue.qsize()
```

Out[5]:

```
2
```

In [6]:

```
data_queue.get() # 데이터 꺼내오기(먼저 넣은 것 순으로 )
```

Out[6]:

```
'minimi'
```

In [7]:

```
data_queue.qsize() #따라서 queue사이즈 감소
```

Out[7]:

```
1
```

#### 3.2 LifoQueue()로 큐 만들기(Last in First out)

In [8]:

```
import queue # queue 라이브러리에 있음

data_queue = queue.LifoQueue()
```

In [9]:

```
data_queue.put("minimi")
data_queue.put(1)
```

In [10]:

```
data_queue.qsize()
```

Out[10]:

```
2
```

In [11]:

```
data_queue.get() # 마지막에 넣었던 값이 나오게 된다.
```

Out[11]:

```
1
```

#### 3.3 PriorityQueue()로 만들기

- 각 데이터를 넣을 때마다, 우선순위 번호가 같이 들어가고, 우선순위에 따라 나오는 순서 결정
- 우선순위가 높은(번호가 낮은) 순으로 추출됨

In [12]:

```
import queue

data_queue = queue.PriorityQueue()
```

In [13]:

```
data_queue.put((10, "Korea")) # (우선순위, 데이터) tuple형태로 넣는다.
data_queue.put((5,1))
data_queue.put((15, 'china'))
```

In [14]:

```
data_queue.qsize()
```

Out[14]:

```
3
```

In [15]:

```
data_queue.get()
```

Out[15]:

```
(5, 1)
```

In [16]:

```
data_queue.get()
```

Out[16]:

```
(10, 'Korea')
```

### 참고: 어디에 큐가 많이 쓰일까?

- 멀티 태스킹을 위한 프로세스 스케쥴링 방식을 구현

  하기 위해 사용됨(OS 참조)

  > 큐의 경우에는 장단점 보다는 큐의 활용 예로 프로세스 스케쥴링 방식을 함께 이해해 두는 것이 좋음

#### 연습1. 리스트 변수로 큐를 다루는 enqueue, dequeue 기능 구현해보기

In [18]:

```
queue_list = list()

def enqueue(data):
    queue_list.append(data)
def dequeue():
    data = queue_list[0]
    del queue_list[0]
    return data
```

In [19]:

```
for index in range(10):
    enqueue(index)
```

In [20]:

```
len(queue_list)
```

Out[20]:

```
10
```

In [21]:

```
dequeue()
```

Out[21]:

```
0
```

In [22]:

```
dequeue()
```

Out[22]:

```
1
```