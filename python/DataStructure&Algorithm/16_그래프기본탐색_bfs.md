## 1. BFS와 DFS란?

- 너비우선탐색(Breadth First Search): 정점들과 같은 레벨에 있는 노드들(형제 노드)을 먼저 탐색하는 방식
- 깊이우선탐색(Depth First Search): 정점의 자식들을 먼저 탐색하는 방식

## 2. 기본 그래프 파이선으로 구현하는 방법

- dict() 의 k,v 로 표현 => k: 각노드들, v: k노드에 인접한 노드들
- list로 value를 표현 => 각 인접한 노드들을 리스트로 표현

In [1]:

```
graph = dict()

graph['A'] = ['B','C']
graph['B'] = ['A','D']
graph['C'] = ['A','G','H','I']
graph['D'] = ['B','E','F']
graph['E'] = ['D']
graph['F'] = ['D']
graph['G'] = ['C']
graph['H'] = ['C']
graph['I'] = ['C','J']
graph['J'] = ['I']
```

In [2]:

```
graph
```

Out[2]:

```
{'A': ['B', 'C'],
 'B': ['A', 'D'],
 'C': ['A', 'G', 'H', 'I'],
 'D': ['B', 'E', 'F'],
 'E': ['D'],
 'F': ['D'],
 'G': ['C'],
 'H': ['C'],
 'I': ['C', 'J'],
 'J': ['I']}
```

## 3. BFS 알고리즘 구현

- 자료구조 queue 활용
  - need_visit: 방문이 필요한 큐
  - visited: 방문을 한 큐
  - queue 라이브러리 대신, list를 사용함

In [3]:

```
def bfs(graph, start_node):
    visited = list()
    need_visit = list()
    
    need_visit.append(start_node)
    
    while need_visit:
        node = need_visit.pop(0)
        if node not in visited:
            visited.append(node)
            need_visit.extend(graph[node])
            
    return visited   
```

In [4]:

```
bfs(graph, 'A')
```

Out[4]:

```
['A', 'B', 'C', 'D', 'G', 'H', 'I', 'E', 'F', 'J']
```

## 4. 시간복잡도

- 일반적인 BFS 시간복잡도
  - 노드 수: V
  - 간선 수: E
    - 위 코드에서 while need_visit은 V + E 번만큼 수행함.
  - O(V+E)