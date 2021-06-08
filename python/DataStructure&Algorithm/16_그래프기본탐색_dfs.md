## 1. DFS 알고리즘 구현

```python
- 자료구조 stack, queue 활용
    - need_visit: 방문이 필요한 스택
    - visited: 방문을 한 큐
```

> BFS: 두개의 큐 활용 / DFS: 스택, 큐를 활용

In [1]:

```python
# 그래프 BFS와 동일
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

```python
def dfs(graph, start_node):
    visited, need_visit = list(), list()
    need_visit.append(start_node)
    
    while need_visit:
        node = need_visit.pop()
        if node not in visited:
            visited.append(node)
            need_visit.extend(graph[node])
            
    return visited
```

In [3]:

```
dfs(graph, 'A')
```

Out[3]:

```
['A', 'C', 'I', 'J', 'H', 'G', 'B', 'D', 'F', 'E']
```

## 2. 시간복잡도

- 노드: V, 간선: E

  ```
    - O(V+E)
  ```