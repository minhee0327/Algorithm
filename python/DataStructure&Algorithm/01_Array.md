# 배열(Array)

- 데이터를 나열하고, 각 데이터를 인덱스에 대응하도록 구성한 데이터 구조
- 파이선에서는 리스트 타입이 배열 기능을 제공하고 있음

### 1. 배열이 왜 필요할까?

- 같은 종류의 데이터를 효율적으로 관리하기 위해 사용
- 같은 종류의 데이터를 순차적으로 저장

- 배열의 장점:
  - 빠른 접근 가능
- 배열의 단점:
  - 데이터가 가변적일 때 데이터 추가,삭제,수정이 어렵다.

### 2. 파이선과 배열

- 파이선 리스트 활용

In [2]:

```
# 1차원 배열: 리스트로 구현시
data = [1,2,3,4,5]
data
```

Out[2]:

```
[1, 2, 3, 4, 5]
```

In [9]:

```
# 2차원 배열: 리스트로 구현시
data = [[1,2,3],[4,5,6], [7,8,9]]
data
```

Out[9]:

```
[[1, 2, 3], [4, 5, 6], [7, 8, 9]]
```

In [4]:

```
print(data[0])
[1, 2, 3]
```

In [8]:

```
a = data[0][0]
print(data[0][0], type(a))
1 <class 'int'>
```

### 3. 프로그래밍 연습

#### 연습1: 위 2차원 배열에서 9, 8, 7 순서로 출력해보기

In [19]:

```
print(data[-1][-1],data[-1][-2],data[-1][-3] )
print(data[2][2],data[2][1],data[2][0])
9 8 7
9 8 7
```

#### 연습2: 다음 dataset 에서 전체 이름 안에 M이 몇번 나왔는지 빈도수 출력하기

In [20]:

```
dataset = ['Braund, Mr. Owen Harris',
'Cumings, Mrs. John Bradley (Florence Briggs Thayer)',
'Heikkinen, Miss. Laina',
'Futrelle, Mrs. Jacques Heath (Lily May Peel)',
'Allen, Mr. William Henry',
'Moran, Mr. James',
'McCarthy, Mr. Timothy J',
'Palsson, Master. Gosta Leonard',
'Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)',
'Nasser, Mrs. Nicholas (Adele Achem)',
'Sandstrom, Miss. Marguerite Rut',
'Bonnell, Miss. Elizabeth',
'Saundercock, Mr. William Henry',
'Andersson, Mr. Anders Johan',
'Vestrom, Miss. Hulda Amanda Adolfina',
'Hewlett, Mrs. (Mary D Kingcome) ',
'Rice, Master. Eugene',
'Williams, Mr. Charles Eugene',
'Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)',
'Masselmani, Mrs. Fatima',
'Fynney, Mr. Joseph J',
'Beesley, Mr. Lawrence',
'McGowan, Miss. Anna "Annie"',
'Sloper, Mr. William Thompson',
'Palsson, Miss. Torborg Danira',
'Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)',
'Emir, Mr. Farred Chehab',
'Fortune, Mr. Charles Alexander',
'Dwyer, Miss. Ellen "Nellie"',
'Todoroff, Mr. Lalio']
```

In [22]:

```
ans = 0
for data in dataset:
    for i in range(len(data)):
        if data[i]=='M':
            ans+=1
print(ans)
38
```

I