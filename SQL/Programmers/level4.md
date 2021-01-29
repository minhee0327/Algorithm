# level4

### 1. **우유와 요거트가 담긴 장바구니**

- **self join** (카디션 곱을 활용. 성능은 조금 더 느릴 가능성 있음.) - 가장 먼저 생각났던 방법

    ```sql
    //self join
    select distinct(a.cart_id)
    from cart_products as a, cart_products as b
    where a.cart_id = b.cart_id and a.name = "MILK" and b.name="Yogurt"
    order by a.cart_id;
    ```

- **sub query 활용**: name이 요거트인 cart_id가 name이 우유인 cart_id에 포함이 되어있을 경우

    ```sql
    //sub query를 사용하는 방법
    SELECT distinct(cart_id)
    from cart_products
    where name = "Yogurt" 
        and cart_id in (
            select distinct cart_id 
            from cart_products 
            where name = 'Milk'
        )
    ```

- **group , having** 활용하기:
    - cart_products 테이블에서, 이름이 mik, yogurt인 것들만 가져와서, cart_id별로 그룹핑한 후,  
    name의 중복을 제거한 후 count한 갯수가 2개라면 cart_id로 정렬해서 출력.

    ```sql
    select cart_id
    from cart_products
    where name in ("MILK", "Yogurt")
    group by cart_id
    having count(distinct(name)) = 2
    order by cart_id;
    ```

- **group_concat() 함수**

    ```sql
    select cart_id 
    from (
    	select cart_id, group_concat(name) as name
    	from cart_products
    	group by cart_id
    ) A
    where A.name like '%MILK%' and A.name like '%Yogurt%'
    order by A.cart_id;
    ```

    - group_concat()함수 정리
        - 기본형: group_concat(필드명) [기본 구분자 쉼표]
        - 구분자 변경: group_concat(필드명 seperator '구분자')
        - 중복제거: group_concat(distinct 필드명)
        - 문자열 정렬: group_concat(필드명 order by 필드명)
    - 추가: from절에 사용한 서브 쿼리를 인라인-뷰라고도 하고, 동적으로 조인방식 사용한 것.
- **WITH문**
    - 이름을 가진 SubQuery를 정의한 후 사용하는 구문
    - 서브쿼리가 많아질 때, 유용한 구문이나, 현재는 하나의 서브쿼리로도 해결이 가능해서 가독성이 조금 떨어졌던 것 같다.

    ```sql
    with A as(
        SELECT cart_id, name
        from cart_products
        where name in ('Milk', 'Yogurt')
        group by cart_id, name
    )

    select cart_id
    from A
    group by cart_id
    having count(*) = 2
    order by cart_id;
    ```

- **RANK()함수**
    - rank()함수는 떠올랐으나.. 활용을 잘 못하겠다;
    - postgreSQL로 잠깐씩 써봤었는데, MySQL에는 버전 8 부터 사용가능해졌다고 해서 연습.

    ```sql
    SELECT B.CART_ID 
    FROM (
        SELECT A.CART_ID, RANK() OVER (PARTITION BY A.CART_ID ORDER BY A.NAME) AS RN 
        FROM (
            SELECT CART_ID, NAME  
    				FROM CART_PRODUCTS
            WHERE NAME IN ('Milk','Yogurt')
            GROUP BY CART_ID, NAME
            ORDER BY CART_ID ASC
            ) A
        ) B
    WHERE B.RN = 2
    ```

    - 여기서 첫번 째 해석은 별칭이 A 인 서브 쿼리, 이름이 우유거나 요거트인 자료들을 cart_id, name,에 따라 그룹핑을 해둠.
    - 이 서브 쿼리중에서 cart_id를 기준으로 ranking을 매기는 건데 정렬을 name을 기준으로 함.
    여기서 나온 랭킹이 2이라는 의미는, 우유, 요거트가 두개 다 있어서 rank가 2가 된 애들의 cart_id를 가져온다는 의미.
    - 내가 생각할때는 불필요하게 rank를 하면서 1, 2, 3,....다 랭킹을 매겨서 두개 있는 값을 가져오니까.. 좋은 쿼리인지는 조금 모호했지만.. rank라는 함수를 연습하기 좋은 쿼리였다.







## 2. 입양시각 구하기 (2)

- count가 없는 hour에도 hour를 넣기 위해서 고민을 해야했다.

- 2가지 방법을 많이 사용했는데, 첫번째는 SQL에 @hour로 변수를 두고, 0~23까지 일치하는 때에만 count를 구했고, 2번째는 recursive를 이용해서 풀었다.
    - 1st sol: 변수 지정해서 풀기

    ```sql
    //변수를 지정해서 푸는 방법
    set @hour := -1;

    select @hour := @hour + 1 as hour, (
        select count(*)
        from animal_outs
        where @hour = HOUR(datetime)
    ) as count
    from animal_outs
    where @hour < 23
    order by hour;
    ```

    - recursive 로 hour 0~23을 구하는 쿼리를 만든 다음, 재귀로 만들어진 N값과 animal_outs테이블의 시간이 일치하는 경우에 count를 구하는 방식.

    ```sql
    with recursive func as (
    	select 0 as N
    	union
    	select N+1 from func where N<23)

    select func.N as hour, count(ao.datetime) as count
    from func
    left join ANIMAL_OUTS  as ao
    on func.N = hour(ao.datetime)
    group by hour;
    ```

    

    

    

## 3. 보호소에서 중성화 한 동물

- 내가 생각을 복잡하게 해서 푼거같다.

    ```sql
    select animal_id, animal_type, name
    from animal_ins
    where SEX_UPON_INTAKE like '%Intact%' and animal_id in (
        select animal_id 
        from ANIMAL_OUTS 
        where (SEX_UPON_OUTCOME like '%Spayed%' or  SEX_UPON_OUTCOME like '%Neutered%')
        )
    order by animal_id, animal_type, name;
    ```

- Like in (%~~)사용하고싶을때  RegExp 정규표현식으로 도 사용 가능

    ```sql
    select animal_id, animal_type, name
    from animal_ins
    where SEX_UPON_INTAKE like '%Intact%' and animal_id in (
        select animal_id 
        from ANIMAL_OUTS 
        where (SEX_UPON_OUTCOME REGEXP 'Spayed|Neutered')
        )
    order by animal_id, animal_type, name;
    ```

- join을 걸어서 겹치는 경우 중, 중성화 수술 여부가 다른 경우만 추출해도 됬었던 문제..

    ```sql
    select ai.animal_id, ai.animal_type, ai.name
    from animal_ins ai
    join animal_outs ao
    where ai.animal_id = ao.animal_id and ai.SEX_UPON_INTAKE != ao.SEX_UPON_OUTCOME;
    ```

    ```sql
    select O.ANIMAL_ID,O.ANIMAL_TYPE,O.NAME 
    from ANIMAL_OUTS as O 
    left join ANIMAL_INS as I 
    on O.ANIMAL_ID = I.ANIMAL_ID 
    where I.SEX_UPON_INTAKE like "Intact %" 
        and O.SEX_UPON_OUTCOME REGEXP 'Spayed|Neutered' 
    order by O.ANIMAL_ID;
    ```