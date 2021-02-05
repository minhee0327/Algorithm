# Basic Select 

### MySQL

* revising the select query 1

  ```sql
  select *
  from city
  where population > 100000 and countrycode = "USA";
  ```

* revising the select query 2

  ```sql
  select name
  from city
  where population > 120000 and countrycode = "USA";
  ```

* select all

  ```sql
  select *
  from city;
  ```

* select by id

  ```sql
  select *
  from city
  where id = 1661;
  ```

* select by id

  ```sql
  select *
  from city
  where id = 1661;
  ```

* Japanese Cities' Attributes

  ```sql
  select *
  from city
  where countrycode = "JPN";
  ```

* Japanese Cities' Names

  ```sql
  select name
  from city
  where countrycode = "JPN";
  ```

* Weather Observation Station 1

  ```sql
  select  city, state
  from station;
  ```

* Weather Observation Station 3

  ```sql
  select distinct city
  from station
  where id % 2 = 0;
  ```

* Weather Observation Station 4

  ```sql
  -- 문제 요약: 전체 city수 에서 중복되는 city수 제거하기
  -- sol1: city별로 group을 지어서 count한 후, sum에서 count 뺐음.
  select sum(a.distinctCnt) - count(a.distinctCnt)
  from  (
      select count(*) as distinctCnt
      from station
      group by city
  )a;
  -- sol2: 그런데 생각해보니 중복제거 distinct를 쓰면 더 짧게 짤 수 있었음;;
  select count(city) - count(distinct city)
  from station;
  ```

* Weather Observation Station 5

  ```sql
  -- city이름이 가장 짧은 city이름과 길이 + city이름이 가장 긴 city이름과 길이
  (select city, length(city) from station
  order by length(city),city asc
  limit 1)
  union
  (select city, length(city) from station
  order by length(city) desc
  limit 1);
  ```

* Weather Observation Station 6

  ```
  select distinct city 
  from station
  where city regexp '^[a|e|i|o|u]';
  ```

* Weather Observation Station 7

  ```
  select distinct city 
  from station
  where city regexp '[a|e|i|o|u]$';
  ```

* Weather Observation Station 8

  ```sql
  --sol1
  select distinct city 
  from station
  where city regexp '[a|e|i|o|u]$' and city regexp '^[a|e|i|o|u]';
  
  --sol2 RLIKE(=REGEXP)
  SELECT DISTINCT city 
  FROM station 
  WHERE city RLIKE '^[aeiou].*[aeiou]$'; 
  
  --sol3 문자열 잘라서 비교하기 
  select distinct city from station 
  where left(city,1) in ('a','e','i','o','u') 
  and right(city, 1) in ('a','e','i','o','u')
  ```

* Weather Observation Station 9

  ```
  -- regexp에서 [^문자]의 의미는 괄호 안의 문자를 포함하지 않는 이라는 의미
  select distinct city 
  from station
  where city regexp '^[^aeiou]'
  ```

* Weather Observation Station 10

  ```
  select distinct city 
  from station
  where city regexp '[^aeiou]$';
  ```

* Weather Observation Station 11

  ```
  select distinct city 
  from station
  where city regexp '[^aeiou]$' or city regexp '^[^aeiou]';
  
  select distinct city 
  from station
  where city regexp '[^aeiou]$|^[^aeiou]';
  ```

* Weather Observation Station 12

  ```sql
  select distinct city 
  from station
  where city regexp '[^aeiou]$' or city regexp '^[^aeiou]';
  
  SELECT DISTINCT city 
  FROM station 
  WHERE city RLIKE '^[^aeiou].*[^aeiou]$'; 
  ```

* Higher than 75 Marks

  ```
  select name
  from students
  where marks > 75
  order by right(name, 3), id ;
  ```

* Employee Names

  ```
  select name
  from employee
  order by name;
  ```

* Employee Salaries

  ```sql
  select name
  from employee
  where salary > 2000 and months < 10
  order by employee_id
  ```

  