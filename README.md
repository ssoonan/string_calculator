## 문자열 계산기

### 간단한 소개

```
null or "" -> 0
"1,2" -> 3
"1,2:3" -> 6  // , :으로 분리해서 합
"//;\n1;2;3" -> 6 // //와 \n 사이에는 사용자가 원하는 딜리미터 사용 가능
"-1,2,3" -> RuntimeException
```

이런 기능을 구현하는 문자열 계산기 구현하기

---

### 실습을 통해 느낀점 

1. private 메서드의 사용

코딩 테스트를 포함, 우리가 실제로 개발을 하며 구현 해야 할 문제들은 덩어리로, 크게 이루어져있음.  
이를 작게 나눠서 하나씩 구현하는 과정이 개발.

이 때 이런 작은, 밖으로 공개될 필요가 없는 메서드는 private으로 선언하는 점은 이해. 하지만 private 메서드는 테스트가 불가능함.  
그렇기에 처음엔 public으로, 기능이 되는 지 테스트 & 디버깅으로 확인하고 구현 이후 private으로 만들자.  
`ex 정규식 패턴 테스트, 알고리즘 테스트` 

이후 private으로 선언된 하나의 메서드는 public 메서드 내에서 간접적으로 다시 테스트 하기

2. 가능한 결과를 다 생각하기

문제를 작게 나누는 과정은 필요하다. 그에 못지 않게 **가능한 결과의 경우를 생각**하는 것도 필요하다.   
나는 처음 이 실습을 할 때 split -> parsing -> sum의 분해는 생각했지만 `: ,`이 2가지로 같이 split이 되는 건 생각하지 못 했음.  
그러다 보니 불필요하게 코드가 늘어졌음.  

3. 기능별 분리

객체 지향 설계 원칙 SRP는
`하나의 모듈은, 오직 하나의 액터(행위자, 부서, 역할)에 의해서만 책임져야 한다.` 라고 한다.  
당장은 각 기능의 구현이 간단해서 하나의 메서드로 합친다면 나중에 어떻게 복잡해질지 모른다.  
그렇기에 설령 한 줄, 두 줄이어도 기능이 다르다면 다르게 분리하자.
```java
public class StringCalculator {
    private int sum(String[] splitedString) {
        int sum = 0;
        for (String str : splitedString) {
            sum += Integer.parseInt(str);
        }
        return sum;
    }

// -> sum에서 더하는 과정과 int로의 파싱이 합쳐져있음. 거창해도 이를 분리하기
    private int[] stringToInts(String[] splitedString) {
        int[] numbers = new int[splitedString.length];
        for (int i = 0; i < splitedString.length; i++) {
            numbers[i] = Integer.parseInt(splitedString[i]);
        }
        return numbers;
    }

    private int intSum(int[] numbers) {
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }
}
```
이렇게 분리를 해야 이후 각 정수의 제약 조건 `ex 음수는 더할 수 없다` 나와도 변경하기 쉽다.

4. 리팩토링, TDD의 효과

기능을 구현한 이후엔 리팩토링까지 하고 다음으로 가야 한다. 이 때 테스트 코드가 있으면 부담없이 코드를 고치는 게 가능.  
단 이때, 버전 관리를 잘 해야 한다. 기껏 구현하고 전체를 리팩토링 한다고 지우다 보면 각 커밋에서 변경 과정을 알아보기가 어려움.  
급하게 하지 말고 하나씩 커밋하며 리팩토링 하자.