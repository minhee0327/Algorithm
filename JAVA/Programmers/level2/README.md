## Programmers Level2

> 맨 뒤에 있는 문제부터 앞으로 가면서 풀기

#### 1. N 개의 최소 공배수

* 유클리드호제법으로 최대공약수, 최소공배수를 구한다.
* 선형시간에서 O(logN)까지 시간 복잡도를 줄일 수 있다.
* A = {a1, a2, a3, a4, ..., an} 의 배열이 있을 때, 모든 요소들의 최소공배수를 구하려면
  * a1 a2의 최소공배수를 구한다음, 이 최소공배수와 a3 의 최소공배수를 구하고, 또 그 최소공배수와 a4의 최소 공배수를 구해가는 방식을 쓴다.
  * an까지 위 방법을 반복하면 모든 요소들의 최소공배수를 구할 수 있다.



#### 2. JadenCase 문자열 만들기

* solution2 메서드에 구현한걸 참조하는게 좋을 듯하다. [프로그래머스 최다 좋아요 눌린 풀이!! 다음엔 나도 이런 사고를..!]
* 문장에서, 각 단어의 맨 첫번째 문자만 대문자로 바꾸고 싶다. 라는 것은
  * 맨 처음 혹은, 공백(" ") 다음 문자열만 바꾸는 것과 동일한 의미.
  * 따라서 체크를 할 flag를 두고, 이전 문자열이 시작지점이었거나, 공백일 경우만 true로 두어 해당 문자열을 대문자로 바꿔주기.



#### 3. 행렬의 곱셈

* 행렬 A(i,j), 행렬 B(j,k) 이 있을 때 행렬의 곱이 성립하고, 곱한 크기는 temp(i,k) 이 된다. 
* temp행렬을 i,k 로 체워주면서, 각 곱을 할 때 j 씩 이동해야하므로 3중 반복문의 순서가 i,k,j가 된다.



#### 7. 숫자의 표현

1. **Two pointer algorithm**	
2. **정수론** 이용
3. 일반 반복문 이용

* 각각 solution1, solution2, solution3 method 로 구현해 둠



#### 8. 땅따먹기

* 처음에 탐색으로 접근을 했는데, 행의 개수가 1000000 이하임을 놓친 탓에 돌아왔다. O(N) 안으로 탐색을 마무리 지어야한다.
* 이전 행에 있는 값들 중, 현재 위치한 열과 같지 않은 값들을 비교해서 그 중, 가장 큰 값을 현재 값에 합해가는 방식으로 구현했다.



#### 9. 다음 큰 숫자

* 기존에 알던 `Integer.toBinaryString()` 로 10진수 -> 2진수 변환한 다음, 1을 전부 count해서 비교하여 구현했었다.

* 그런데 `Integer.bitCount()` 라는 아주 유용한 메서드 발견 !! ㅠㅠ 내가 직접 1 count하지 않아도 1을 count해서 바로 반환해준다.






#### 11. 파일명 정렬

* **`Unstable sort` vs `Stable sort`** 의 차이의 이해와 **자바의 내부 정렬**을 이해가 선행되면 좋았을 문제였다.

  * `Unstable sort` vs `Stable sort` 

    * `Unstable sort`: 동일한 정렬 기준을 가진 것의 순서가 다를 수 있다.
    * `Stable sort`: 동일한 정렬 기준을 가진 것은 정렬하기 전의 순서와 정렬한 후의 순서가 동일하다.

  * Java의 정렬 방법

    *  `Arrays.sort()` 의 내부 정렬 알고리즘

      * `Dual-Pivot Quick Sort` :  `Primitive Type`  https://javanitto.tistory.com/6
      * `Tim Sort=Insertion + Merge` : `Object Type` - `Stable sort`: https://javanitto.tistory.com/7?category=923427

      * 기존 quick sort 는 하나의 pivot 을 기준으로 하지만, dual-pivot quick sort는 pivot 2개를 사용한다.
      * Daul-privot quick sort 도 quick sort 의 일종이기 때문에 unstable sort 라고 생각이 들기는하지만, 문제가 String type 기반이기 때문에, 내부적으로 Tim Sort 가 사용되었기 때문에 `Stable Sort` 가 적용될 수 있었다고 생각한다.

    * `Collections.sort()` 의 내부정렬 알고리즘

      * `merge sort` - `stable sort`

* 문제 자체도 꽤나 복잡한 정렬로 나왔는데 `Stable Sort` 를 사용했다면, 마지막 조건을 별도로 구현하지 않아도 되었다.
* 처음 혼자 구현할 때는 이부분까지 고려해서 입력된 순서를 idx로 받아서 idx 별로도 정렬을 했었다.
* `Tim Sort` 관련 추가자료: https://d2.naver.com/helloworld/0315536



#### 12. 올바른 괄호

* Stack 을 바로 떠올렸다. 다만 String type 으로 해결을 하려고 했었다. (-> 효율성 2개 통과 X)
* 기본 데이터 타입 char로 접근시도 + 마지막에 stack size 랑 남은 문자열 길이를 비교해서 stack size가 더 큰 경우에는 검사를 하지 않게 구현.(통과)
* 다만 다른 풀이를 보니까 괄호 종류가 소괄호("()") 뿐이라서 굳이 `stack` 을 사용하지 않고 stack size 를 세어 풀이한 것이 많았다. 







