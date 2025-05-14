# Kotlin 특징 요약
- 보일러 플레이트 코드 최소화 
- 세미콜론 안씀, 더 깔끔
- Null safety : String vs String? 으로 null 허용여부 명시
- Java 100% 호환 : Java 라이브러리 사용가능
- 참고문서
  - [Kotlin 공식 docs](https://kotlinlang.org/docs/home.html)
  - [playground](https://play.kotlinlang.org/?_gl=1*px89te*_gcl_au*NDE4NzMzMzY3LjE3NDcyMTM3NDk.*_ga*MjEyMjcwNTcyOS4xNzQ3MjEzNzQ5*_ga_9J976DJZ68*czE3NDcyMTkxMDIkbzIkZzEkdDE3NDcyMTkzNTMkajM3JGwwJGgw#eyJ2ZXJzaW9uIjoiMi4xLjIxIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiZnVuIG1haW4oKSB7XG5cbiAgICB2YXIgbmV2ZXJOdWxsOiBTdHJpbmcgPSBcIlRoaXMgY2FuJ3QgYmUgbnVsbFwiICAgICAgICAgICAgLy8gMVxuICAgIFxuICAgIG5ldmVyTnVsbCA9IG51bGwgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgLy8gMlxuICAgIFxuICAgIHZhciBudWxsYWJsZTogU3RyaW5nPyA9IFwiWW91IGNhbiBrZWVwIGEgbnVsbCBoZXJlXCIgICAgICAvLyAzXG4gICAgXG4gICAgbnVsbGFibGUgPSBudWxsICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAvLyA0XG4gICAgXG4gICAgdmFyIGluZmVycmVkTm9uTnVsbCA9IFwiVGhlIGNvbXBpbGVyIGFzc3VtZXMgbm9uLW51bGxcIiAgIC8vIDVcbiAgICBcbiAgICBpbmZlcnJlZE5vbk51bGwgPSBudWxsICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIC8vIDZcbiAgICBcbiAgICBmdW4gc3RyTGVuZ3RoKG5vdE51bGw6IFN0cmluZyk6IEludCB7ICAgICAgICAgICAgICAgICAgIC8vIDdcbiAgICAgICAgcmV0dXJuIG5vdE51bGwubGVuZ3RoXG4gICAgfVxuICAgIFxuICAgIHN0ckxlbmd0aChuZXZlck51bGwpICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgLy8gOFxuICAgIHN0ckxlbmd0aChudWxsYWJsZSkgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgLy8gOVxuXG59In0=)
  - 

# Kotlin vs Java: 핵심 문법,특징 비교
## 1. 변수 선언 & 타입 시스템, Null

### 1.1. 변수선언 [🔗](https://www.notion.so/yina-note/Kotlin-vs-Java-1f36b67830f4803988cfd46cc102c10b?pvs=4)

- ✅ Kotlin - **`val` vs `var`**
  - `val`(읽기 전용) : Java `final`변수 
  - `var`(가변) : 일반 변수
  ```kotlin
  val name = "Yina"     // String
  var age = 30          // Int
  
- ✔️ Java - **모두 가변변수, 명시적 final**
  ```java
  final String name = "Alice";
  int age = 25;
  ```

### 1.2. 타입
- ✅ Kotlin - 타입추론
  ```kotlin
  val name = "Yina"     // String
  var age = 30          // Int

- ✔️ Java - **타입 선언 필수**
  ```java
  String name = "Alice";
  Integer age = 25;  // null 허용
  ```

### 1.3.[Null Safety](https://kotlinlang.org/docs/null-safety.html?_gl=1*b6f3cz*_gcl_au*NDE4NzMzMzY3LjE3NDcyMTM3NDk.*_ga*MjEyMjcwNTcyOS4xNzQ3MjEzNzQ5*_ga_9J976DJZ68*czE3NDcyMTkxMDIkbzIkZzEkdDE3NDcyMTk0NjUkajMzJGwwJGgw&_cl=MTsxOzE7blNxdEp3cWxRTmhRMjJ0NlF0MG9Ld0JTWW9RNENiTlRFY01WNXBsdFlLaU1pb0VSQ2ZqUEZ4dXhRTmp5cUdEdDs=#nullable-types-and-non-nullable-types)
**✅ Kotlin - 안전한 null체크 + 기본값 처리**
  - 타입시스템 차원에서 null 허용 여부를 명시함, null 체크를 강제하기 때문에 NPE 방지
    - null 가능성 자체를 코드에 명시적으로 표현, 컴파일 타임에 강제 체크
      ```kotlin
      val a: String = "hi"      // null 불가
      val b: String? = null     // null 허용
      ```
  - null safe 문법을 기본적으로 제공, null 허용타입을 안전하게 처리하기 위한 전용 연산자
    - `!!` 는 정말 예외상황에만 사용 
    - 대부분의 경우 `?.` , `?:`, `let` 조합으로 null-safe하게 처리하는 것이 Kotlin의 권장 방식

| 연산자   | 설명                                  | 예시                               | 결과                             |
| ----- | ----------------------------------- | -------------------------------- |--------------------------------|
| `?.`  | **Safe-call 연산자**                   | `email?.length`  | null이면 null 반환                 |
| `?:`  | **Elvis 연산자** (기본값 제공)              | `email?.length ?: 0`| null이면 0반환                     |
| `!!`  | **Not-null 단언 연산자** (null이면 NPE 발생) | `email!!.length`  | null이면 예외발생 (진짜 예외 상황에만 사용할 것) |
| `let` | null-safe 블록 실행                     | `email?.let { println(it) }`| null이 아닐 때만 실행                 |

**✔️ Java - 모든 참조형은 null 허용( @Nullable/@NotNull 은 문서화용)**

| Java                         | Kotlin                            |
  |------------------------------|-----------------------------------|
| 모든 참조형이 기본적으로 null 허용  | `?` 를 붙이지 않으면 null 불가 (강제)   |
| 런타임에만 NPE 발생, 컴파일 타임에 그냥 넘어감 | 컴파일 타임에 null 체크 강제 |
| `NullPointerException` 자주 발생 | Safe call/Elvis 연산자로 **미리 차단** 가능 |

## 2. 클래스 & 객체 
### 2.1. 클래스 선언
- ✅ Kotlin - 기본 생성자 + 프로퍼티 선언 동시에, 한줄로 끝
  ```kotlin
  class User(val name: String, var age: Int)
  ```
- ✔️ Java - 필드 + 생성자 + getter/sertter 분리

### 2.2. Data 클래스
- ✅ Kotlin - data 클래스
  ```kotlin
  data class User(val name: String, val age: Int)
  // equals, hashCode, toString, copy 자동생성
  ```

- ✔️ Java - 롬복 @Data 사용
  ```java
  import lombok.Data;

  @Data
  public class User {
    private String name;
    private int age;
  }
  // 생성자, getter, setter, equals, hashCode, toString 자동생성 
  ```

### 2.3. 정적멤버 선언 - Kotlin의 companion object vs Java의 static
- ✅ Kotlin - companion object
  - const val 선언
  - val, var, const val 뿐 아니라
  - 함수 선언 가능 
  - 호출시 클래스명으로 바로 호출 가능
    ```kotlin
    class Util {
      companion object {
          const val VERSION = "1.0"
          fun hello() = println("Hi") // 함수선언 
      }
    }
    
    // const val, 함수 호출
    println(Util.VERSION)  // "1.0"
    Util.hello()        // "Hi"
    ```
  

- ✔️ Java - static 
  - static 변수, 메서드 선언해서 사용 
    ```java
    public class Util {
      public static final String VERSION = "1.0";
    
      public static void printHello() {
          System.out.println("Hello static method");
      }
    }
  
    // 변수, 메서드 호출
    System.out.println(Util.VERSION);  // "1.0"
    Util.printHello();  // "Hello static method"
    ```


## 3. 함수
### 3.1. Top-level 함수
- ✅ Kotlin -

  ```kotlin
  ```

- ✔️ Java -

  ```java
  ```

### 3.2. 기본인자(default) / 이름인자(named)
- ✅ Kotlin -

  ```kotlin
  ```

- ✔️ Java -

  ```java
  ```

### 3.3. single-expression 함수 
```kotlin
fun 함수이름(파라미터: 타입): 반환타입 = 표현식
```
- ✅ Kotlin - 함수 본문이 한줄이면, 중활호나 return 키워드 없이 `=` 기호만 사용해서 표현식함수 선언가능
  - 코드 간결해짐
  - 한줄짜리 로직 표현 편함
    ```kotlin
    fun sum(a: Int, b: Int): Int = a + b
  
    // 풀어쓰면
    fun sum(a: Int, b: Int): Int {
      return a + b
    }
    ```
  - if, when, try 등 표현식도 반환가능
    - ⚠️ Kotlin에서는 Java의 삼항연산자가 없음   
    - when, try의 경우 : 단일 표현식으로 작성되었다면 single-expression 함수로 간주됨
    - 본문이 한 줄(`=` 사용)이고 값이 하나로 평가되면, 그게 when, try, if 상관없이 single-expression 함수
    ```kotlin
    // if : 삼항연산자 "처럼" 동작함
    fun max(a: Int, b: Int) = if (a > b) a else b
    
    // when : switch + 패턴매칭 확장형
    fun grade(score: Int) = when {
      score >= 90 -> "A"
      score >= 80 -> "B"
      else        -> "F"
    }
  
    // try : 예외처리 후 값 반환 가능
    fun parseIntOrZero(input: String) = try {
      input.toInt()
    } catch (e: NumberFormatException) {
      0
    }
    ```
  - 반환 타입 생략 가능 (컴파일러가 추론) : ⚠️ single-expression 함수인 경우에만 가능함 주의
    ```kotlin
    fun square(x: Int) = x*x // Int로 추론됨
    fun greet(name: String) = "Hello, $name" // String으로 추론됨
    
    // 단일 표현식이 명확한 타입을 반환한다면, 인자 2개이고 각 타입이 달라도 가능
    fun repeatText(text: String, times: Int) = text.repeat(times) // String으로 추론
    fun isAdult(name: String, age: Int) = age >= 20 // boolean으로 추론
    ```

- ✔️ Java - 메서드 정의할 때는 반드시 중괄호, return 사용
  - 기본 메서드 정의
    ```java
    public int square(int x) {
      return x * x;
    }
    ```
  - if, when, try 등 표현식 : return 키워드를 반드시 사용, return 문으로 반환
  - ⚠️ 반환 타입 생략 불가능 : 컴파일오류

### 3.4. extension 함수
- ✅ Kotlin -

  ```kotlin
  ```

- ✔️ Java -

  ```java
  ```

