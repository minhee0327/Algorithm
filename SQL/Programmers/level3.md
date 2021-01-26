# level3

1. **없어진 기록 찾기**

```sql
select ao.animal_id, ao.name
from animal_ins as ai 
right join animal_outs as ao
on ai.animal_id = ao.animal_id
where ai.animal_id is NULL
order by ao.animal_id;
```

- 보호소에 온 테이블(ai) 기준으로 right join을 했다.
- 기준이 ai이기 때문에, 만약 ai에 없는 ao의 경우 NULL로 나온다.
- 따라서, 보호소에 들어온 내역이 없는 경우에 (NULL)
- 입양간 동물의 id와 name을 뽑았다.

**2. 있었는데요 없었습니다.**

```sql
SELECT ai.animal_id, ai.name
from animal_ins as ai
join animal_outs as ao
on ai.animal_id = ao.animal_id
where ai.datetime > ao.datetime
order by ai.datetime;
```

- datetime끼리 비교 가능하다.(date_format을 사용했다가 수정)

**3. 오랜 기간 보호한 동물(1)**

```sql
SELECT ai.name, ai.datetime
from animal_ins as ai
left join animal_outs as ao
on ai.animal_id = ao.animal_id
where ao.animal_id is NULL
order by ai.datetime
LIMIT 3;
```

**4. 오랜기간 보호한 동물(2)**

```sql
SELECT ai.animal_id, ai.name
from animal_ins as ai
left join animal_outs as ao
on ai.animal_id = ao.animal_id
where ao.animal_id is NOT NULL
order by ai.datetime - ao.datetime
LIMIT 2;
```

- 나의 경우 생각을 보호소에 있는 애들중, 입양간 애들 기준(not null)로 풀었는데, inner join을 못생각 해낸거같다.;;
- 문제가 보호소에도 왔고, 입양을 간거기도 하니까 교집합을 생각했으면 좀더 간단히 짤 수 있었을 것 같다.
- 그래서 다시 푼거

```sql
SELECT ai.animal_id, ai.name
from animal_ins as ai
join animal_outs as ao
on ai.animal_id = ao.animal_id
order by ai.datetime - ao.datetime
LIMIT 2;
```