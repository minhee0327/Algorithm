# Advanced Select

* Type of Triangle

  ```sql
  SELECT CASE
      WHEN A+B<=C OR A+C<=B OR B+C<=A THEN "Not A Triangle"
      WHEN A = B AND B = C THEN "Equilateral"
      WHEN A = B OR B = C OR C =A THEN "Isosceles"
      ELSE "Scalene"
      END
  FROM TRIANGLES;
  ```

  

* The PADS

  ```sql
  select concat(name, "(", LEFT(OCCUPATION, 1), ")")
  from OCCUPATIONS
  order by name;
  
  select concat("There are a total of ", count(*)," ", LOWER(OCCUPATION),"s.")
  from OCCUPATIONS
  group by OCCUPATION
  order by count(*);
  ```



* Occupations

