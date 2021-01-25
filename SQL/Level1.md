# Level1

1. 최대값 구하기

```sql
SELECT max(datetime) as 시간
from animal_ins
```

2. 모든 레코드 조회

```sql
SELECT * 
from animal_ins
order by animal_id;
```

3. 역순 정렬

```sql
SELECT name, datetime
from animal_ins
order by animal_id desc
```

4. 아픈동물찾기

```sql
SELECT animal_id, name
from animal_ins
where intake_condition = 'Sick'
order by animal_id;
```

5. 어린동물찾기

```sql
SELECT animal_id, name
from animal_ins
where intake_condition != 'Aged'
order by animal_id;
```

6. 동물의 아이디와 이름

```sql
SELECT animal_id, name
from animal_ins
order by animal_id
```

7. 이름이 없는 동물의 아이디

```sql
SELECT animal_id
from animal_ins
where name is null
```

8. 여러 기준으로 정렬하기

```sql
SELECT animal_id, name, datetime
from animal_ins
order by name, datetime desc
```

9. 상위 n개 레코드

```sql
SELECT name
from animal_ins
order by datetime
limit 1
```

10.이름이 있는 동물의 아이디

```sql
SELECT animal_id
from animal_ins
where name is not null
order by animal_id
```