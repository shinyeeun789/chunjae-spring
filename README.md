# Spring Framework 학습하기
Spring Framework 학습을 위한 Repository 입니다.
<br><br><br>

## 1. Spring Framework란?
- 자바, 엔터프라이즈 개발, 오픈소스, `light-weight` 애플리케이션 프레임워크
- 특정 계층이나 기술, 업무 분야에 국한되지 않고 애플리케이션의 전 영역을 포괄하는 범용적인 프레임워크
- 굉장히 범용적이고 다양한 분야에서 활용하고 있지만, 모두 다 알아야 활용할 수 있는 것은 아닌 만큼 기본에 충실해서 학습해야 함
    
    ### 🍑 경량급 프레임워크
    - 단순한 웹 컨테이너에서도 엔터프라이즈 개발의 고급 기술을 대부분 사용 가능
    - `EJB(Enterprise Java Bean)`에 비해 경량급이며, 일반 자바 객체만을 사용하여 엔터프라이즈 급의 고급 기술을 구현할 수 있음
  
    ### 🍑 엔터프라이즈 개발 용이 
    - 개발자가 복잡하고 실수하기 쉬운 `Low Level`에 많이 신경 쓰지 않으면서 `Business Logic` 개발에 전념할 수 있도록 해줌
    
    ### 🍑 오픈소스
    - `Spring`은 `OpenSource`로서 누구나 사용할 수 있음
    - 무료 프레임워크의 단점을 극복하고, 장점을 극대화하여 사용하여야 함
<br><br><br>

## 2. Spring Framework 특징
### 🥭 컨테이너 제공
- `Spring Container`는 `Java` 객체의 `Life Cycle`을 관리하며, `Spring Container`로부터 필요한 객체를 가져와 사용할 수 있음

### 🥭 `DI(Dependency Injection)` 지원
- `Spring`은 설정 파일이나 `Annotation`을 통해서 객체 간의 의존 관계를 설정 가능

### 🥭 `AOP(Aspect Oriented Programming)` 지원
- Spring은 `Transaction`이나 `Logging`, 보안(`Security`)과 같이 공통적으로 필요로 하는 모듈들을 실제 핵심 모듈에서 분리해서 적용 가능

### 🥭 `POJO(Plain Old Java Object)` 지원
- `Spring Container`에 저장되는 `Java` 객체는 특정한 인터페이스(`Interface`)를 구현하거나, 특정 `Class`를 상속받지 않아도 됨

### 🥭 트랜잭션(`Transaction`) 처리를 위한 일관된 방법 지원
- `JDBC(Java DataBase Connectivity)`, `JTA(Java Transaction API)` 등 어떤 트랜잭션을 사용하더라도 설정(`Configuration`)을 통해 정보를 관리하므로 트랜잭션 구현에 상관없이 동일한 코드 사용 가능

### 🥭 영속성(`Persistence`)과 관련된 다양한 `API` 지원
- `Spring`은 `Mybatis`, `Hibernate` 등 데이터베이스 처리를 위한 `ORM(Object Relational Mapping)` 프레임워크들과 연동 지원
<br><br><br>

## 3. Spring Framework 주요 모듈 구성
<img src="https://github.com/shinyeeun789/chunjae-spring/assets/70800414/c141384a-1241-410b-96d2-e5693e1eca4c" width="1300">

### 🥝 Data Access/Integration (데이터 접근 및 통합)
- `JDBC (Java DataBase Connectivity)` : Java 기반 애플리케이션의 데이터를 데이터베이스에 저장 및 업데이트하거나, 데이터베이스에 저장된 데이터를 Java에서 사용할 수 있도록 하는 자바 API
- `ORM (Object Relational Mapping)` : 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑(연결)해주는 것
- `OXM (Object-XML Mapping)` : XML과 자바(Java) 오브젝트를 매핑해서 상호 변환해주는 기술
- `JMS (Java Message Service)` : 사람이 아닌 애플리케이션의 구성 요소가 소비하는 요청, 보고서, 이벤트로 메시지를 작성, 전송 수신 및 읽을 수 있는 메시징 서비스를 제공하는 것
- `Transactions` : 데이터베이스에서 여러 요청이 한꺼번에 처리가 되어야 하는 트랜잭션(Transaction)이 정의되고, 구현될 수 있도록 어노테이션으로 제공

### 🥝 Web
- `Websocket` : HTTP 통신의 단점인 단방향 통신을 개선하기 위하여 웹 소켓을 활용하여 반 영구적인 양방향 통신 제공
- `Servlet` : MVC 처리 패턴에서 Controller에 해당하는 요청에 대한 처리 작업이 진행되도록 함
- `Web` : `JSP(Java Server Page)`에 속하는 `Expression, Directive, Declaration, Expression Language, Java Standard Tag Library` 등을 활용할 수 있는 웹 모듈 제공
- `Portlet` : 포털 페이지를 구성하는 웹 컴포넌트(`Web Component`)를 제공하며, `MVC` 처리 패턴에서 `View`에 속하는 곳에 데이터를 처리하여 보내질 수 있는 역할 수행

### 🥝 Core Container
- 주요한 객체들(Bean)을 관리해주는 아주 중요한 모듈
    
    #### 🧆 Beans
    - 스프링 컨테이너에 의해 관리되는 재사용 가능한 소프트웨어 컴포넌트로서 하나의 클래스로부터 얻어진 객체
    - 주입(Inject)의 대상
    - XML의 bean 태그나 `@Configuration` 어노테이션으로 설정되는 주입 설정 클래스에서 `@Bean` 어노테이션으로 설정됨
    
    #### 🥜 Core
    - 스프링 프레임워크의 근간이 되는 요소
    - `IoC(Invert Of Control)` 또는 `DI(Dependency Injection)` 기능을 지원하는 요소
    
    #### 🪘 Context
    - 여러 Bean을 관련 있는 요소로 각각 분리하여 하나의 XMl 파일로 구성될 수 있도록 하는 요소
    
    #### 🥔 SpEL
    - `Spring Expression Language`의 약자
    - 런타임(실행) 시 객체 그래프 쿼리 및 조작을 지원하는 표현 언어
    - `#{표현식}` 이나 `${표현식}` 으로 된 파라미터나 연산식, 비교식 등을 구현할 수 있도록 도움

### 🥝 Test
- JUnit 및 Spring Test를 지원
- `JUnit`은 `@Test, @Ignore, @Before, @After, @BeforeClass, @AfterClass` 등의 어노테이션을 활용한 assert 메서드로 단위 테스트를 지원
- `Spring Test`는 `@RunWith, @ContextConfiguration, @Autowired` 어노테이션을 활용하여 별도의 컨텍스트 없이도 테스트 케이스를 작성할 수 있도록 지원

### 🥝 Spring Object
- `AOP(Aspect-Oriented Programming)` : 공통적으로 적용이 되어야 하는 부분이 여러 군데에 흩어져 있을 경우 사용 시기(`Jointpoint`)가 되었을 경우를 대비해 여러 사용 시기(`Jointpoint`)를 정규 표현식인 포인트컷(`Pointcut`)으로 만들어 각각의 대상 클래스에 있는 코드를 연결하여 하나의 객체로 만드는데 이를 위빙(`Weaving`)이라 하고, 위빙(`Weaving`) 된 것을 동작하도록 함. 이때, 위빙(`Weaving`)된 동작을 어드바이스(`Advice`)라고 함
- `Aspects` : 보통 `AspectJ`에 의한 관점 지향 프로그래밍을 의미하며, `Spring AOP`는 공통적인 문제를 해결하기 위해 간단히 구현하고, `Spring Container`에 의해 관리되는 `Bean`에만 적용하지만, `Aspects`는 `Spring AOP`보다 강력하고, 완전체를 별도로 구성하여 진행하기 때문에 많이 복잡해짐
- `Instrumentation` : `Bean`의 생명 주기와 설정 그리고 처리 방법을 관리하는 스프링 컨테이너
- `Messaging` : 시스템의 구성 요소 간에 메시징을 지원하고 관리하는 요소
<br><br><br>

## 4. IoC와 DI
<aside> 💡 IoC (자동이체) / DI (자동이체 계좌 등록) → 정보 제공 </aside>

### 🥑 DI (Dependency Injection)
![Untitled](https://github.com/shinyeeun789/chunjae-spring/assets/70800414/66dfacd2-71e9-4a5e-9c94-d3e499cf6066)
- 스프링이 다른 프레임워크와 차별화되어 제공하는 의존 관계 주입 기능
- 객체를 직접 생성하는 게 아니라 외부에서 생성한 후 주입 시켜주는 방식
- `DI`(의존성 주입)를 통해 모듈 간의 결합도가 낮아지고 유연성이 높아짐

![image](https://github.com/shinyeeun789/chunjae-spring/assets/70800414/85ce1e3f-cdb6-4b52-9ea4-8163ef892b8e)

![image](https://github.com/shinyeeun789/chunjae-spring/assets/70800414/cc1ae61c-4e07-4735-9157-95f2078642c6)
- `Bean` : 스프링에서 객체를 의미
- `Bean Container` : 프로젝트가 실행될 때 사용자가 `Bean`으로 관리하는 객체들의 생성과 소멸에 관련된 작업을 자동적으로 수행해주는데, 이때 객체가 생성되는 곳을 의미
- ❗ 의존성 주입 어노테이션 결정 방법
    - `**@Inject**` : Java와의 호환성을 생각할 경우
    - `**@Autowired**` : Spring에서 사용하며 타이머가 있음

### 🥑 IoC(Inversion of Control)
- **제어의 역전**이라고 말하며, **제어의 흐름을 바꾼다** 라고도 함
- **IoC는 pre loading 방식**
    - `lazy loading` ⇒ 그때 그때 개발자의 작업이 필요함
    - `pre loading` ⇒ xml 파일로 미리 만들어두기만 하면 스프링이 필요할 때 로딩할 수 있도록 `bean`을 사전 로딩해줌
- `method`나 객체의 호출 작업을 개발자가 결정하는 것이 아니라, 외부에서 결정되는 것을 의미
- 객체의 의존성을 역전시켜 객체 간의 결합도를 줄이고 유연한 코드를 작성할 수 있게 하여 가독성 및 코드 중복, 유지 보수를 편하게 할 수 있도록 함
- 스프링이 모든 의존성 객체를 스프링이 실행될 때 다 만들어주고 필요한 곳에 주입시켜줌으로써 `Bean`들은 `Singleton` 패턴의 특징을 가짐
- 제어의 흐름을 사용자가 컨트롤 하는 것이 아니라 스프링에게 맡겨 작업을 처리하게 됨
- `IoC`를 하기 위해 `DI` (Bean을 만들어 주입하는 것)를 만듦
    ```xml
    <bean id="sample" Class="kr.co.pro03.controller.Sample">
    </bean>
    ```
    ```java
    Sample sample = new Sample(); // 과 같음
    ```
