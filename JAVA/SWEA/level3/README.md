# SWEA D3 요약

### 요약

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

* **1493 수의 새로운 연산**: 좌표에서 규칙찾기 [참조](https://zzang9ha.tistory.com/262)
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



* 3260 두수의 덧셈: long타입보다 큰 정수 입력받을 때, BigInteger 타입.
* [3282 knapsack]()

* 3131 100만이하의 모든 소수: 소수 관련 알고리즘: 에라토스테네스의 체

  * 해당 값이 소수인지 확인할 때, 앞에서부터 Math.sqrt(해당값)까지 나눠떨어지지 않는다면, 소수.

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









## Search 문제 유형

- [1244 최대상금](https://github.com/minhee0327/Algorithm/blob/master/JAVA/SWEA/level3/Main1244_%EC%B5%9C%EB%8C%80%EC%83%81%EA%B8%88.java): 완전탐색
- [2814 최장경로](https://github.com/minhee0327/Algorithm/blob/master/JAVA/SWEA/level3/Main2814_%EC%B5%9C%EC%9E%A5%EA%B2%BD%EB%A1%9C.java): DFS 
- 









