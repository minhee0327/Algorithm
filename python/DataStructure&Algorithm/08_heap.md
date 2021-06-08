## 대표적인 데이터 구조 : 힙

### 1. 힙(Heap)이란

- 힙: 데이터에서 최대값과 최소값을 빠르게 찾기 위해 고안된 완전 이진트리(Complete Binary Tree)
  - 완전 이진 트리: 노드를 삽입할 때, 최하단 왼쪽 노드부터 차례대로 삽입하는 트리
- 힙을 사용하는 이유
  - 배열에 데이터를 넣고, 최대값과 최소값을 찾으려면 O(N) 이 걸림
  - 이에 반해, 힙에 데이터를 넣고, 최대값과 최소값을 찾으면, O(logN)이 걸림
  - 우선순위 큐와 같이 최대값 또는 최소값을 빠르게 찾아야 하는 자료구조 및 알고리즘 구현 등에 활용됨

### 2. 힙(Heap) 구조

- 힙은 최대값을 구하기 위한 구조(최대 힙, Max Heap)와, 최소값을 구하기 위한 구조(최소힙, Min Heap)으로 분류할 수 있음.
- 힙은 다음과 같이 두 가지 조건을 가지고 있는 자료구조임
  1. 각 노드의 값은 해당 노드의 자식 노드가 가진 값보다 크거나 같다.(최대 힙의 경우)
     - 최소 힙의 경우는 각 노드의 값은 해당 노드의 자식 노드가 가진 값보다 작거나 같음
  2. 완전 이진트리 형태를 가짐
     - 삽입할 노드가 기본적으로 왼쪽 최하단부 노드부터 채워지는 형태로 삽입

### 힙과 이진탐색트리의 공통점과 차이점

- 공통점: 힙과 이진탐색트리는 모두 이진트리임.
- 차이점:
  - 힙은 각 노드의 값이 자식 노드 보다 크거나 같음(Max Heap의 경우)
  - 이진 탐색트리는 왼쪽 자식 노드의 값이 가장 작고, 그 다음 부모노드, 그다음 오른쪽 자식 노드 값이 가장 큼.
  - 힙은 이진 탐색 트리의 조건인 자식 노드에서 작은 값은 왼쪽, 큰 값은 오른쪽이라는 조건은 없음
    - 힙의 왼쪽 및 오른쪽 자식 노드의 값은 오른쪽이 클수도 있고, 왼쪽이 클 수도 있음.
- 이진탐색트리는 탐색을 위한 구조, 힙은 최대/최소값 검색을 위한 구조 중 하나로 이해하면 됨.

### 3. 힙 동작

### 힙에 데이터 삽입하기 - 기본 동작

```
- 힙은 완전 이진 트리이므로, 삽입할 노드는 기본적으로 왼쪽 최하단부 노드부터 채워지는 형태로 삽입
```

### 힙에 데이터 삽입하기 - 삽입할 데이터가 힙의 데이터보다 클 경우(Max Heap의 예)

- 먼저 삽입된 데이터는 완전 이진 트리 구조에 맞추어, 최하단부 왼쪽 노드부터 채워짐
- 채워진 노드위치에서, 부모노드보다 값이 클 경우, 부모 노드와 위치를 바꿔주는 작업을 반복함(SWAP)

### 힙에 데이터 삭제하기 (Max Heap의 예)

- 보통 삭제는 최상단 노드(root 노드)를 삭제하는 것이 일반적임
  - 힙의 용도는 최대값 또는 최소값을 root노드에 놓아서, 최대값과 최소값을 바로 꺼내 쓸 수 있도록 하는 것임.
- 상단의 데이터 삭제시, 가장 최하단부 왼쪽에 위치한 노드(일반적으로 가장 마지막에 추가한 노드)를 root노드로 이동
- root노드의 값이 child node보다 작을 경우, root노드의 child node중 가장 큰 값을 가진 노드와 root노드 위치를 바꿔주는 작업을 반복함(SWAP)

### 4. 힙 구현

### 힙과 배열

- (완전 이진 트리의 형태를 띄기 때문에)
- 일반적으로 힙 구현시 배열 자료구조를 활용함
- 배열은 인덱스가 0번부터 시작하지만 힙구현의 편의를 위해 root 노드 인덱스 번호를 1로 지정하면, 구현이 좀 더 수월함
  - 부모 노드 인덱스 번호(parent node's index) = 자식 노드 인덱스 번호 //2
  - 왼쪽 자식 노드 인덱스 번호(left child node's index) = 부모 노드 인덱스 번호(parent node's index) * 2
  - 오른쪽 자식 노드 인덱스 번호(right child node's index) = 부모 노드 인덱스 번호(parent node's index) * 2 + 1

### 힙에 데이터 삽입 구현(Max Heap 의 예)

- 힙 클래스 구현1

In [1]:

```python
class Heap:
    def __init__(self, data):
        self.heap_array = list()
        self.heap_array.append(None)
        self.heap_array.append(data)
```

In [2]:

```python
heap = Heap(1)
heap.heap_array
```

Out[2]:

```python
[None, 1]
```

- 힙 클래스 구현2 - insert1
  - 인덱스 번호는 1번 부터 시작하도록 변경

In [ ]:

```python
class Heap:
    def __init__(self, data):
        self.heap_array = list()
        self.heap_array.append(None)
        self.heap_array.append(data)
        
    def insert(self, data):
        if len(self.hea_array) == 0:
            self.heap_array.append(None)
            self.heap_array.append(data)
            return True
        
        self.heap_array.append(data)
        return True
```

- 힙 클래스 구현3 - insert2
  - 삽입한 노드가 부모 노드의 값보다 클 경우, 부모노드와 삽입한 노드의 위치를 바꿈(SWAP)
  - 삽입한 노드가 루트 노드가 되거나, 부모노드보다 값이 작거나 같은 경우까지 반복

In [3]:

```python
class Heap:
    def __init__(self, data):
        self.heap_array = list()
        self.heap_array.append(None)
        self.heap_array.append(data)
    
    # 상위 노드와 바꿔야하는지를 확인하는 method
    def move_up(self, inserted_idx):
        # root 노드일 경우
        if inserted_idx <=1:
            return False
        
        parent_idx = inserted_idx //2
        if self.heap_array[inserted_idx] > self.heap_array[parent_idx]:
            return True
        else:
            return False
            
    def insert(self, data):
        #heap_array가 비워져있을 경우 초기화하고 종료
        if len(self.heap_array) == 0:
            self.heap_array.append(None)
            self.heap_array.append(data)
            return True
        
        # 그게 아니라면, 기존 heap_array에 data를 이진트리 형태로 붙여나감.
        self.heap_array.append(data)
        
        # 넣고자 하는 위치는 총 길이 - 1
        #index가 1부터 시작하도록 하도록,  0에 None을 넣었기 때문에  -1을 함.
        inserted_idx = len(self.heap_array) - 1 
        
        while self.move_up(inserted_idx):
            # true라면 (부모와 넣고자하던 데이터 위치) SWAP (파이선 tuple이용하여 아래와 같이 구현 가능!)
            parent_idx = inserted_idx // 2 
            self.heap_array[inserted_idx] , self.heap_array[parent_idx] =  self.heap_array[parent_idx] , self.heap_array[inserted_idx] 
            inserted_idx = parent_idx
            
        return True
```

In [4]:

```python
heap  = Heap(15)
heap.insert(10)
heap.insert(8)
heap.insert(5)
heap.insert(4)
heap.insert(20)
heap.heap_array
```

Out[4]:

```python
[None, 20, 10, 15, 5, 4, 8]
```

### 힙 데이터 삭제 구현(Max Heap 예)

- 힙 클래스 구현 4 - delete1
- 보통 삭제는 최상단 노드 (root 노드)를 삭제하는 것이 일반적임
  - 힙의 용도는 최대값 또는 최소값을 root 노드에 놓아서, 최대값과 최소값을 꺼내 쓸 수 있도록 하는 것임.

In [5]:

```python
class Heap:
    def __init__(self, data):
        self.heap_array = list()
        self.heap_array.append(None)
        self.heap_array.append(data)
        
    def pop(self, data):
        if len(self.heap_array) <=1:
            return None
        
        # root data 는 index 가 1
        returned_data = self.heap_array[1]
        return returned_data
```

- 힙 클래스 구현 4 - delete2
  - 상단의 데이터 삭제시, 가장 최하단부 왼쪽에 위치한 노드(일반적으로 가장 마지막에 추가한 노드)를 root 노드로 이동
  - root 노드의 값이 child node보다 작을 경우, root 노드의 child node중 가장 큰 값을 가진 노드와 root 노드 위치를 바꿔주는 작업을 반복함.

In [32]:

```python
class Heap:
    def __init__(self, data):
        self.heap_array = list()
        self.heap_array.append(None)
        self.heap_array.append(data)
    
    def move_down(self, poped_idx):
        left_child_poped_idx = poped_idx * 2
        right_child_poped_idx = poped_idx *2 +1
        # case1 왼쪽 자식 노드가 없을 경우 SWAP 필요 없음
        if left_child_poped_idx >= len(self.heap_array):
            return False
        # case2 왼쪽 자식은 있고, 오른쪽 자식은 없을 경우 
        # 현재 값과, 왼쪽 자식값을 비교해서 왼쪽 자식 값이 클 경우에 True를 반환해서, SWAP해줄 것 
        elif  right_child_poped_idx >= len(self.heap_array):
            if self.heap_array[poped_idx] < self.heap_array[left_child_poped_idx]:
                return True
            else:
                return False
        # case3-1 왼쪽, 오른쪽 자식  모두 있을 경우, 두 자식 노드 중 큰 값을 찾고
        # case3-2 그 큰 값을 부모와 비교해서 변화 할지 여부 결정
        else:
            if self.heap_array[left_child_poped_idx] > self.heap_array[right_child_poped_idx]:
                if self.heap_array[poped_idx] < self.heap_array[left_child_poped_idx]:
                    return True
                else:
                    return False
            else:
                if self.heap_array[poped_idx] < self.heap_array[right_child_poped_idx]:
                    return True
                else:
                    return False

                
    def pop(self):
        if len(self.heap_array) <=1:
            return None
        
        # root data 는 index 가 1
        returned_data = self.heap_array[1]
        # 맨마지막 데이터를 root로 이동
        self.heap_array[1] = self.heap_array[-1]
        del self.heap_array[-1]
        
        poped_idx = 1
        while self.move_down(poped_idx):
            left_child_poped_idx = poped_idx * 2
            right_child_poped_idx = poped_idx *2 +1
            
            #case2
            if  right_child_poped_idx >= len(self.heap_array):
                if self.heap_array[poped_idx] < self.heap_array[left_child_poped_idx]:
                    self.heap_array[poped_idx] , self.heap_array[left_child_poped_idx] = self.heap_array[left_child_poped_idx], self.heap_array[poped_idx]
                    poped_idx = left_child_poped_idx
            
            #case3
            else:
                if self.heap_array[left_child_poped_idx] > self.heap_array[right_child_poped_idx]:
                    if self.heap_array[poped_idx] < self.heap_array[left_child_poped_idx]:
                        self.heap_array[poped_idx], self.heap_array[left_child_poped_idx] = self.heap_array[left_child_poped_idx],self.heap_array[poped_idx]
                        poped_idx = left_child_poped_idx
                 
                else:
                     if self.heap_array[poped_idx] < self.heap_array[right_child_poped_idx]:
                            self.heap_array[poped_idx] , self.heap_array[right_child_poped_idx] = self.heap_array[right_child_poped_idx], self.heap_array[poped_idx]
                            poped_idx = right_child_poped_idx
                            
        return returned_data
    
    def move_up(self, inserted_idx):
        if inserted_idx <=1:
            return False
        
        parent_idx = inserted_idx //2
        if self.heap_array[inserted_idx] > self.heap_array[parent_idx]:
            return True
        else:
            return False
            
    def insert(self, data):
        if len(self.heap_array) == 0:
            self.heap_array.append(None)
            self.heap_array.append(data)
            return True
        
        self.heap_array.append(data)
        
        inserted_idx = len(self.heap_array) - 1 
        
        while self.move_up(inserted_idx):
            parent_idx = inserted_idx // 2 
            self.heap_array[inserted_idx] , self.heap_array[parent_idx] =  self.heap_array[parent_idx] , self.heap_array[inserted_idx] 
            inserted_idx = parent_idx
            
        return True
```

In [33]:

```python
heap = Heap(15)
heap.insert(10)
heap.insert(8)
heap.insert(5)
heap.insert(4)
heap.insert(20)
heap.heap_array
```

Out[33]:

```python
[None, 20, 10, 15, 5, 4, 8]
```

In [34]:

```python
heap.pop()
```

Out[34]:

```python
20
```

In [36]:

```python
heap.heap_array
```

Out[36]:

```python
[None, 15, 10, 8, 5, 4]
```

In [38]:

```python
heap.pop()
```

Out[38]:

```python
15
```

In [39]:

```python
heap.heap_array
```

Out[39]:

```python
[None, 10, 5, 8, 4]
```

### 5. 힙(Heap)의 시간 복잡도

- depth(트리의 높이)를 h라고 표기한다면,
- n개의 노드를 가진 heap에 데이터 삽입 또는 삭제시, 최악의 경우 root 노드에서 elaf 노드까지 비교해야 하므로 h = log₂n에 가까우므로, 시간 복잡도는 O(logn)
  - 참고: 빅오 표기법에서 logn에서의 log의 밑은 10이아니라, 2dlqslek.
  - 한번 실행시마다, 50%의 실행할 수도 있는 명령을 제거한다는 의미. 즉, 50% 의 실행시간을 단축시킬 수 있다는 것을 의미함.