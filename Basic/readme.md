# 내용 정리

## 좋은 객체 지향 설계의 5가지 원칙의 적용

### SRP 단일 책임 원칙
**한 클래스는 하나의 책임만 거져야 한다.**
- SRP 단일 책임 원칙을 따르면서 관심사를 분리
- 구현 객체를 생성하고 연결하는 책임은 AppConfig가 담당
- 클라이언트 객체는 실행하는 책임만 담당

### DIP 의존관계 역전 원치
**프로그래머는 "추상화에 의존해야지, 구체화에 의존하면 안된다." 의존성 주입은 이 원칙을 따르는 방법 중 하나다.**

### OCP 의존관계 역전 원칙
**소프트웨어 요소는 확장에는 열러 있으나 변경에는 닫혀 있어야 한다.**
- 다형성 활용

### LIP 리스코프 치환 원칙
**프로그램 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.**

### ISP 인터페이스 분리 원칙
**특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.**


## IoC, DI 그리고 컨테이너

### 제어의 역전 IoC(Inversion of Control)
**프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것(AppConfig)**


### 의존관계 주입 DI(Dependency Injection)
**의존관계는 정적인 클래스 의존관계와, 실행 시점에서 결정되는 동적인 객체(인스턴스) 의존 관계 둘을 분리해서 생각**

- AppConfig처럼 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것을 IoC 컨테이너 또는 DI 컨테이너 라고 한다.
- 의존관계 주입에 초점을 맞추어 최근에는 주로 **DI 컨테이너**라고 한다.
- 또는 어샘블러, 오브젝트 팩토리 등으로 불리기도 함










