# SWEA D3 요약

### * 시험 전에 읽고 들어가자 *

* **1209 SUM**:  대각선 합 (ul :왼쪽위, dr: 오른쪽 아래)

  * ```java
    	private static void diagonally(int[][] arr) {
    		int ul =0, dr= 0;
    		for(int i = 0; i < arr.length; i++) {
    			ul += arr[arr.length-i-1][i];
    			dr += arr[i][i];
    		}
    		max = Math.max(max, Math.max(ul, dr));
    	}
    ```



* **1215, 1216 회문 시리즈**: 나의 경우 오른쪽 방향 90도 회전 + 회문검사로 구현

  * roatate

    * ```java
      private static char[][] rotate(char[][] arr) {
      		char ret[][] = new char[arr.length][arr.length];
      		
      		for(int i = 0; i < arr.length; i++) {
      			for(int j = 0; j< arr.length; j++) {
      				ret[j][arr.length-i-1] = arr[i][j];
      			}
      		}
      		return ret;
      	}
      ```

  * palindrome

    * ```java
      private static int palindrom(char[] a, int n) {
          int ret = 0;
          for(int i = 0; i < a.length - n + 1; i++) {
              boolean flag = true;
              for(int j = 0; j < n/2; j++) {
                  if(a[i+j] != a[(i+n-1)-j]) {
                      flag = false;
                      break;
                  }
              }
              if(flag) ret++;
          }
          return ret;
      }
      ```





* **1221 GNS:** 배열에서 원하는 index를 찾을 때.

  * ```java
    int idx = Arrays.asList(strArr).indexOf(num);
    ```

* **1493 수의 새로운 연산**: 좌표에서 규칙찾기 [참조](https://github.com/minhee0327/Algorithm/blob/master/JAVA/SWEA/level3/Main1493_%EC%88%98%EC%9D%98%EC%83%88%EB%A1%9C%EC%9A%B4%EC%97%B0%EC%82%B0.java)
* **1873 상호의배틀필드**: 구현 시간이 오래 걸림 [참조](https://github.com/minhee0327/Algorithm/blob/master/JAVA/SWEA/level3/Main1873_%EC%83%81%ED%98%B8%EC%9D%98%EB%B0%B0%ED%8B%80%ED%95%84%EB%93%9C.java)

* **2805 농작물 수확하기**: 2차원 배열 다이아몬드(diamond) 모양으로 합산.  [참조](https://github.com/minhee0327/Algorithm/blob/master/JAVA/SWEA/level3/Main2805_%EB%86%8D%EC%9E%91%EB%AC%BC%EC%88%98%ED%99%95%ED%95%98%EA%B8%B0.java)

* **2930 힙**: 

  * Priority Queue (최대힙의 경우 Collections.reverseOrder()로.)
  * 문자열 연결에 연산자 대신 StringBuilder, StringBuffer 사용하기. (속도)

* **2948 문자열교집합**: JAVA에서 집합 HashSet

  * ```java
    HashSet<String> firstSet = new HashSet<String>();
    for (int i = 0; i < n; i++) {
        firstSet.add(sc.next());
    }
    
    for (int i = 0; i < m; i++) {
        if (firstSet.contains(sc.next())) {
            cnt++;
        }
    }
    ```

* **3032 홍준이의 숫자놀이** : 유클리드 확장 알고리즘 (최소공배수, 최대공약수) 문제

  * ```java
    private static int[] EE(int a, int b) {
    		int s0 = 1, s1 = 0;
    		int t0 = 0, t1 = 1;
    		int q = 0;
    		while(true) {
    			q = a/b;
    			a = a%b;
    			s0 = s0 - s1 * q;
    			t0 = t0 - t1 * q;
    			
    			if(a == 0) {
    				int gcd = b;
    				int[] xy = {gcd, s1, t1};
    				return xy;
    			}
    			
    			q = b/a;
    			b = b%a;
    			s1 = s1 - s0 * q;
    			t1 = t1 - t0 * q;
    			
    			if(b == 0) {
    				int gcd = a;
    				int[] xy = {gcd, s0, t0};
    				return xy;
    			}
    		}
    	}
    ```





* **3233 정사각형 분할 놀이, 3408 세가지합** : 수열 간단 정리.

  * ```
    * 수열
      * 등차수열 : A + (n-1) * D (A:초기값, n차수, D:증감수)
      	* (1,2,3,4,5,...): n*(n+1)/2
      	* (2,4,6,8,10,..): n² + n
      	* (1,3,5,7,9,...): n²
      	* (3,5,7,9,11,..): n² + 2n
      * 등비수열: 2ⁿ-¹
      * 계차수열
        * 두 항의 사이가 2k-1 =>  n² - 2n + 2
        * 두 항의 사이가 2k +1 => n²
    ```



* **3260 두수의 덧셈:** long타입보다 큰 정수 입력받을 때, BigInteger 타입.
* **[3282 knapsack]()**

* **3131 100만이하의 모든 소수**: 소수 관련 알고리즘: 에라토스테네스의 체

  * 해당 값이 소수인지 확인할 때, 앞에서부터 Math.sqrt(해당값)까지 나눠떨어지지 않는다면, 소수.
  (등호 반드시 넣어야한다!! 
    **4698번(테네스의 특별한 소수) 문제**에서 Math.sqrt 미만으로 구했다가 푸는데 한참 걸림..;;)
  
  * ```java
    int N = 1000000;
    		
    for(int i = 2; i <= N; i++) {
        boolean ck = true;
        for(int j = 2 ; j<= Math.sqrt(i); j++) {
            if(i % j == 0) {
                ck = false;
                break;
            }
        }
        if(ck) {
            System.out.printf(i + " ");
        }
    }
    ```
    
  * **5986 새샘이와 세 소수**





* **4371 항구에 들어오는 배**: LinkedList와 ArrayList의 성능에 대해 고려해보게 되었던 문제.
  * remove()의 필요성을 줄여서 푸는 방법을 생각하는게 좋겠다고 생각했고
  * ArrayList가 탐색에는 더 효율적이니까 시간초과 나면 한번 고려해봐야한다.



* **5549 홀수일까 짝수일까**

  * 홀짝을 구할때 고려할게 맨마지막 자리 수만 고려하면 된다는거!! 기억!

* **5688 세제곱근 찾기**

  ```java
  //double to int
  Double cbrt = Math.cbrt(N);
  int intCbrt = cbrt.intValue();		
  ```

* **5948 새샘이의 735게임**

  ```java
  //combination (backtrack구현)으로 풀이 중 일부
  private static void combination(int[] arr, boolean[] visited, int dept, int r) {
  		if(r == 0) {
  			int sumVal = sum(arr, visited);
  			ans.add(sumVal);
  			return;
  		}
  		if(dept == arr.length) {
  			return;
  		}else {
  			for(int i = dept; i<arr.length; i++) {
  				visited[i] = true;
  				combination(arr, visited, i+1, r-1);
  				visited[i] = false;
  			}
  		}
  		
  	}
  ```

* [**5607 조합 문제**](https://github.com/minhee0327/Algorithm/blob/master/JAVA/SWEA/level3/Main5607_%EC%A1%B0%ED%95%A9.java) : [참조자료](https://minkwon4.tistory.com/25)

  * nCr = n!/(n-r)!(r)!
  * 모듈러 연산 (+, -, *만) 
    * (a mod n + b mod n) mod n = (a + b) mod n
    * (a mod n - b mod n) mod n = (a - b) mod n
    * (a mod n * b mod n) mod n = (a * b) mod n
  * 합동
    * 두 숫자 a, b 가 n으로 mod 한 결과 값이 같을 때, 모듈러 합동 관계라고 한다.
    *  a mod n = b mod n 를 a ≡ b (mod n) 로 표현 할 수 있다.
  * 페르마 소정리
    * p가 소수이고 가 p로 나누어 떨어지지 않는 정수일 경우
      * a^p ≡ a (mod p) 성립
      * a^p-1 ≡ 1 (mod p) (위 식에서 양 항을 a로 나눈 결과)
      * a^p-2 ≡ a^-1 (mod p) (위 식에서 양 항을 a로 나눈 결과)
  * 거듭제곱 분할 정복
    * a^n을 구할 때
      * 짝수인 경우: a^n = a^(n/2) * a^(n/2) = ...
      * 홀수인 경우: a^n = a * a^(n/2) * a^(n/2) = ...

  





## Search 문제 유형

- [1244 최대상금](https://github.com/minhee0327/Algorithm/blob/master/JAVA/SWEA/level3/Main1244_%EC%B5%9C%EB%8C%80%EC%83%81%EA%B8%88.java): 완전탐색
- [2814 최장경로](https://github.com/minhee0327/Algorithm/blob/master/JAVA/SWEA/level3/Main2814_%EC%B5%9C%EC%9E%A5%EA%B2%BD%EB%A1%9C.java): DFS 

* [5215 햄버거다이어트: ](https://github.com/minhee0327/Algorithm/blob/master/JAVA/SWEA/level3/Main5215_%ED%96%84%EB%B2%84%EA%B1%B0%EB%8B%A4%EC%9D%B4%EC%96%B4%ED%8A%B8.java)
  * DFS, 완전탐색 
  * DP knapsack 알고리즘

* [5293 이진문자열 복원](https://github.com/minhee0327/Algorithm/blob/master/JAVA/SWEA/level3/Main5293_%EC%9D%B4%EC%A7%84%EB%AC%B8%EC%9E%90%EC%97%B4%EB%B3%B5%EC%9B%902.java)

* [6507 그래프의 삼각형](https://github.com/minhee0327/Algorithm/blob/master/JAVA/SWEA/level3/Main6057_%EA%B7%B8%EB%9E%98%ED%94%84%EC%9D%98%EC%82%BC%EA%B0%81%ED%98%95.java) : 탐색으로 풀어도 괜찮을 것 같은데, 반복문으로 구현했음;



