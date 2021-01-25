# level2

1. **최솟값 구하기**

```sql
SELECT min(datetime) as 시간 
from animal_ins
```

**2. 동물 수 구하기**

```sql
SELECT count(animal_id) as count
from animal_ins;
```

**3. 중복 제거하기**

```sql
SELECT count(distinct(name)) as count
from animal_ins
where name is not null;
```

**4. 고양이와 개는 몇마리 있을까?**

- 내풀이

```sql
SELECT animal_type, count(animal_type) as count
from animal_ins
where animal_type = 'Cat'
group by animal_type
union all
SELECT animal_type, count(animal_type) as count
from animal_ins
where animal_type = 'Dog'
group by animal_type;
```

- 다시 풀기

```sql
select animal_type, count(animal_type)
from animal_ins
group by animal_type
order by animal_type;
```

**5. 동명 동물 수 찾기**

- 집계함수는 where절에서 사용할 수 없다!
- having 혹은 서브쿼리를 떠올리자.

```sql
SELECT name, count(name) as count
from animal_ins
group by name
having count >=2
order by name;
```

**6. NULL 처리하기**

```sql
SELECT animal_type, IFNULL(name, 'No name')as name, sex_upon_intake
from animal_ins
order by animal_id
```

**7. 입양시각구하기(1)**

```sql
SELECT HOUR(datetime) as HOUR, count(datetime) as COUNT
from animal_outs
group by HOUR(datetime)
having HOUR >= 9 and HOUR <=19
order by HOUR;
```

**8. 루시와 엘라 찾기**

```sql
SELECT animal_id, name, sex_upon_intake
from animal_ins
where name in ("Lucy", "Ella", "Pickle", "Rogan", "Sabrina", "Mitty")
order by animal_id;
```

**9. 이름에 el이 들어가는 동물찾기**

```sql
SELECT animal_id, name
from animal_ins
where lower(name) like "%el%" and animal_type = 'Dog'
order by name;
```

**10. 중성화 여부 파악하기**

```sql
SELECT animal_id, name,(
    CASE 
    WHEN sex_upon_intake like "%Neutered%" then "O"
    WHEN sex_upon_intake like "%Spayed%" then "O"
    ELSE "X"
    END) as 중성화
from animal_ins
order by animal_id;
```

**11. DATETIME에서 DATE로 형변환**

```sql
SELECT animal_id, name, date_format(datetime, "%Y-%m-%d") as 날짜
from animal_ins
order by animal_id;
```