# 2.3 설계 단계

(분석 단계에서 표현한 다이어그램을 통해 코딩할 수 있는 수준으로 구체화함)

<details>
<summary>소프트웨어 개발 생명주기에서 설계 단계에 대해 설명하세요.</summary>
<br>
<div markdown="1">

설계 단계에서는 분석 단계에서 개념적이고 추상적인 내용을 구체화하여, 고려하지 않았던 상세 내용을 충분히 반영하여 구현할 수 있는 수준으로 준비합니다. <br>
사용자의 요구를 what(무엇)의 관점이 아닌 how(어떻게) 관점에서 생각해야 합니다. <br>
소프트웨어 설계는 요구 분석 명세서와 설계 원리, 제약조건에 따라 상위 설계와 하위 설계로 나눌 수 있습니다. <br>
<br>

</div>
</details>

<details>
<summary>소프트웨어 설계에서 상위 설계에 대해 설명하세요.</summary>
<br>
<div markdown="1">

예비 설계(preliminary design)라고도 하며, 집 짓기에서 전체 골조, 뼈대를 세우는 것과 유사합니다. <br>

1. 아키텍처/구조 설계: 시스템의 전체적인 구조를 표현합니다. <br>
2. 데이터 설계: 시스템에 필요한 정보를 자료구조와 데이터데이스 설계에 반영합니다. <br>
3. 시스템 분할: 전체 시스템을 여러 개의 서브 시스템으로 분리합니다. <br>
4. 인터페이스 정의: 시스템의 구조와 서브 시스템들 사이의 인터페이스를 명확히 정의합니다. <br>
5. 사용자 인터페이스(UI: User Interface) 설계: 사용자가 익숙하고 편리하게 사용할 수 있도록 사용자 인터페이스를 설계합니다. <br>
   <br>

</div>
</details>

<details>
<summary>소프트웨어 설계에서 하위 설계에 대해 설명하세요.</summary>
<br>
<div markdown="1">

내부 구조를 상세히 나타내는 것과 유사합니다. <br>
각 모듈의 실제적인 내부를 알고리즘 형태로 표현하고 인터페이스에 대한 설명, 자료구조, 변수 등에 대한 상세한 정보를 작성합니다.<br>
<br>

</div>
</details>

<details>
<summary>설계의 원리 5가지에 대해 설명하세요.</summary>
<br>
<div markdown="1">

1. 분할과 정복: 가장 세분화된 작은 시스템을 개발하고 하나씩 위로 올라가면서 완성시키는 방법으로 개발하는 것입니다. 하나의 일을 수행할 때 작은 단위로 나누고 각 작은 단위를 하나씩 처리하여 전체 일을 끝낸다는 의미입니다.<br>
2. 모듈화(Modularity): 소프트웨어의 성능 향상, 시스템의 수정 및 재사용, 유지 관리 등이 용리하도록 시스템의 기능들을 모듈 단위로 나누는 것입니다.<br>
3. 추상화(Abstraction): 문제의 전체적이고 포과적인 개념을 설계한 후 차례로 세분화하여 구체화시켜 나가는 것으로, 과정, 데이터, 제어 추상화가 있습니다. <br>
4. 단계적 분해(Stepwise Refinement): 문제를 상위의 중요 개념으로부터 하위의 개념으로 구체화시키는 분할 기법입니다. Niklaus Wirth에 의해 제안된 하향식 설계 전략입니다. <br>
5. 정보 은닉(Information Hiding): 모듈 내부에 포함된 절차와 자료들의 정보가 감추어져 다른 모듈이 접근하거나 변경하지 못하도록 하는 기법입니다. <br>
<br>
</div>
</details>

<details>
<summary>소프트웨어 아키텍처란 무엇인가요?</summary>
<br>
<div markdown="1">

소프트웨어를 구성하는 요소들 간의 관계를 표현하는 시스템 구조 또는 구조체로, 소프트웨어의 뼈대를 만드는 것을 의미합니다.<br>
복잡하고 규모가 큰 소프트웨어를 개발하려면 전체적인 구조가 유기적으로 잘 구성되어야 하기 때문에 필요합니다. <br>
사용자가 만족할만한 품질 좋은 소프트웨어를 개발하려면 요구 분석, 설계 단계에서부터 품질 특성을 고려하여 개발해야 합니다. <br>
잘 정의된 전체적인 구조와 품질 좋은 소프트웨어를 만들려면 소프트웨어 아키텍처가 필요합니다. <br>
<br>

</div>
</details>

---

## 아키텍처 패턴

<details>
<summary>아키텍처 패턴이란?</summary>
<br>
<div markdown="1">

아키텍처를 설계할 때 참조할 수 있는 전형적인 해결방식 또는 예제로, 레이어 패턴, 클라이언트-서버 패턴, 파이프-필터 패턴, 모델-뷰-컨트롤러 패턴 등이 있습니다. <br>
<br>

</div>
</details>

<details>
<summary>레이어 패턴(Layer parttern)이란?</summary>
<br>
<div markdown="1">

시스템을 계층으로 구분하여 구성하는 고전적인 방법의 패턴입니다.
<br>

</div>
</details>

<details>
<summary>클라이언트-서버 패턴(Client-Server pattern)이란?</summary>
<br>
<div markdown="1">

하나의 서버 컴포넌트와 다수의 클라이언트 컴포넌트로 구성되는 패턴으로, OSI 참조 모델이 있습니다. <br>
<br>

</div>
</details>

<details>
<summary>파이프-필터 패턴(Pipe-Filter pattern)이란?</summary>
<br>
<div markdown="1">

데이터 스트림 절차의 각 단계를 필터로 캡슐화하여 파이프를 통해 전송하는 패턴으로, UNIX의 쉘(Shell)이 있습니다. <br>
<br>

</div>
</details>

<details>
<summary>모델-뷰-컨트롤러 패턴(MVC: Model-View-Controller pattern)이란?</summary>
<br>
<div markdown="1">

서브 시스템을 모델, 뷰, 컨트롤러로 구조화하는 패턴입니다. <br>
<br>

</div>
</details>

<details>
<summary>마스터-슬레이브 패턴(Master-Slave pattern)이란?</summary>
<br>
<div markdown="1">

슬레이브 컴포넌트에서 처리된 결과물을 다시 돌려받는 방식으로 작업을 수행하는 패턴입니다. <br>
<br>

</div>
</details>

<details>
<summary>브로커 패턴(Broker pattern)이란?</summary>
<br>
<div markdown="1">

사용자가 원하는 서비스와 특성을 브로커 컴포넌트에 요청하면 브로커 컴포넌트가 요청에 맞는 컴포넌트와 사용자를 연결해주는 패턴입니다.
<br>

</div>
</details>

<details>
<summary>피어-투-피어 패턴(Peer-To-Peer pattern)이란?</summary>
<br>
<div markdown="1">

피어(Peer)라 불리는 하나의 컴포넌트가 클라이언트가 될 수도 서버가 될 수도 있는 패턴입니다. <br>
<br>

</div>
</details>

<details>
<summary>이벤트-버스 패턴(Event-Bus pattern)이란?</summary>
<br>
<div markdown="1">

소스가 특정 채널에 이벤트 메시지를 발행(Publish)하면 해당 채널을 구독한 리스너들이 메시지를 받아 이벤트를 처리하는 패턴입니다. <br>
<br>

</div>
</details>

<details>
<summary>블랙보드 패턴(Blakcboard pattern)이란?</summary>
<br>
<div markdown="1">

모든 컴포넌트들이 공유 데이터 저장소와 블랙보드 컴포넌트에 접근이 가능한 패턴입니다. <br>
<br>

</div>
</details>

<details>
<summary>인터프리터 패턴(Interpreter pattern)이란?</summary>
<br>
<div markdown="1">

프로그램 코드의 각 라인을 수행하는 방법을 지정하고, 기호마다 클래스를 갖도록 구성된 패턴입니다. <br>
<br>

</div>
</details>

---

### 디자인 패턴

<details>
<summary>디자인 패턴이란 무엇인지 설명하세요.</summary>
<br>
<div markdown="1">

모듈 간의 관계 및 인터페이스를 설계할 때, 참조할 수 있는 설계 과정에서 자주 발생하는 문제들에 대한 전형적인 해결방식 또는 예제를 의미합니다. <br>
자주 사용하는 설계 형태를 정형화해서 이를 유형별로 설계 템플릿을 만들어둔 것으로,<br>
한 번 만들어 놓으면 계속 재사용할 수 있고, 이를 변경하여 새로운 디자인 패턴을 만들수도 있습니다. <br>
많은 개발자들이 수많은 시행착오를 겪으며 만들어 놓은 좋은 설계 자료를 모아두고 새 프로젝트에 활용할 수 있게 됩니다. <br>
이를 통해 개발 기간을 줄일 수 있고 유지보수가 쉬워집니다. ex. 불고거 버거, 치즈 버거 등 버거의 패턴을 정해서 미리 만들어 놓는 것<br>
<br>

</div>
</details>

<details>
<summary>아키텍처 패턴과 디자인 패턴의 차이점은?</summary>
<br>
<div markdown="1">

아키텍처 패턴은 건물의 윤곽을 잡는 가이드라인을 제시하는 것이고, <br>
디자인 패턴은 그보다 더 세밀한 부분의 건물의 각 방들을 인테리어하는 과정이라고 할 수 있습니다. <br>
<br>

</div>
</details>

<details>
<summary>Gof 디자인 패턴이란?</summary>
<br>
<div markdown="1">

디자인 패턴은 여러 가지 문제에 대한 설계 사례로 분석하여, 서로 비슷한 문제를 해결하기 위한 설계들을 분류하고<br>
각 문제 유형별로 가장 적합한 설계를 일반화해 패턴으로 정립한 것을 말합니다. <br>
에릭 감마, 리처드 헬름, 랄프 존슨, 존 블리시데스가 제안한 Gof(Gang of Four)의 디자인 패턴으로, <br>
쉽게 재사용할 수 있도록 객체지향 개념에 따른 설계만을 패턴으로 지정했습니다. <br>
<br>

</div>
</details>

### 생성 패턴

### 구조 패턴

### 행위 패턴

---

## 객체 지향

<details>
<summary>절차지향 언어(Prodedural Programming)이란?</summary>
<br>
<div markdown="1">

순차적으로 처리되고 프로그램 전체가 유기적으로 연결되도록 만드는 방법으로, 대표적인 예로 C언어가 있습니다. <br>
컴퓨터의 처리 구조와 유사해 실행 속도가 빠른 장점이 있지만, <br>
실행 순서가 정해져 있으므로 코드의 순서가 바뀌면 동일한 결과를 보장하기 어려워 유지보수가 어렵다는 단점이 있습니다. ex. 자동차 제조<br>
<br>

</div>
</details>

<details>
<summary>객체지향 언어(Object-oriented Programming)란?</summary>
<br>
<div markdown="1">

객체란 구제적인 사물, 사람 등 추상적인 개념이 될 수도 있는 무언가로, 소프트웨어의 각 요소를 객체(Object)로 만든 후 객체들을 조립해서 소프트웨어를 개발하는 기법입니다. <br>
컴퓨터의 모든 부품을 적절히 연결하고 조립해서 컴퓨터가 제대로 작동하도록 만드는 것으로, 대표적으로 자바가 있습니다. <br>
객체지향의 구성 요소에는 객체, 클래스, 메시지가 있습니다. <br>
<br>

</div>
</details>

<details>
<summary>객체 지향의 구성 요소 중 객체란?</summary>
<br>
<div markdown="1">

데이터와 이를 처리하기 위한 함수를 묶어 놓은 소프트웨어 모듈입니다. <br>
데이터는 객체가 가지고 있는 정보로, 속성이나 상태 분류 등을 말합니다. <br>
함수는 객체가 수행하는 기능으로 객체가 갖는 데이터를 처리하는 알고리즘으로, <br>
프로그래밍에서 하나의 특정 작업을 수행하기 위해 독립적으로 설계된 프로그램 코드의 집합을 통해 중복적인 코드의 작성을 최소화할 수 있습니다. <br>
<br>

</div>
</details>

<details>
<summary>객체 지향의 구성 요소 중 클래스란?</summary>
<br>
<div markdown="1">

공통된 속성과 연산을 갖는 객체의 집합으로, 객체를 찍어내는 공장이라고 말할 수 있습니다. <br>
클래스에서 생성된 객체를 인스턴스라고 부르며, 클래스에서 객체를 만드는 과정을 인스턴스화라고 합니다. <br>
클래스를 쓰는 이유는 함수와 데이터가 저장되는 변수까지 함께 묶어서 관리하기 위해서입니다. <br>
클래스에서 포함되는 변수를 속성이라고 하며, 클래스에 포함되는 함수를 메서드라고 합니다. <br>
<br>

</div>
</details>

<details>
<summary>객체 지향의 구성 요소 중 메시지란?</summary>
<br>
<div markdown="1">

객체들 간의 상호작용에 사용되는 수단으로, 객체의 동작이나 연산을 일으키는 외부의 요구사항을 말합니다. <br>
<br>

</div>
</details>

<details>
<summary>객체 지향의 특징 중 캡슐화(Encapulation)란?</summary>
<br>
<div markdown="1">

외부에서 접근을 제한하기 위해 인터페이스를 제외한 세부 내용을 은닉하는 것을 말합니다. <br>
캡슐로된 알약처럼 캡슐 속 알갱이 하나하나가 어떤 기능을 하는지 외부에 비공개를 하고 알약을 사용하게 하는 것과 같습니다. <br>
<br>

</div>
</details>

<details>
<summary>객체 지향의 특징 중 상속(Inheritance)이란?</summary>
<br>
<div markdown="1">

상위 클래스의 모든 속성과 연산을 하위 클래스가 물려받는 것을 말합니다. <br>
물려주는 클래스를 상위 클래스 또는 부모 클래스라고 하고, 물려받는 클래스를 하위 클래스 또는 자식 클래스라고 합니다.<br>
<br>

</div>
</details>

<details>
<summary>객체 지향의 특징 중 추상화(Abstration)란?</summary>
<br>
<div markdown="1">

객체의 공통적인 속성과 기능을 추출하여 정의하는 것으로, 바나나, 사과, 포도를 추성화하여 과일이 되는 특성을 말합니다. <br>
<br>

</div>
</details>

<details>
<summary>객체 지향의 특징 중 다형성(Polymorphism)이란?</summary>
<br>
<div markdown="1">

하나의 메세지에 대한 각각의 객체가 가지고 있는 고유한 방법으로 응답할 수 있는 능력을 의미합니다. <br>
객체의 속성이나 기능이 그 맥락에 따라 다른 역할을 수행할 수 있는 것을 말합니다. <br>
동물과 과일 클래스가 있을 때 상황, 맥락에 따라 동물은 코뿔소, 사자, 호랑이 등이 될 수 있고, 과일은 바나나, 사과, 포토 등으로 바뀔 수 있는 것을 의미합니다. <br>
<br>

</div>
</details>

<details>
<summary>오버로딩(Overloading)이란?</summary>
<br>
<div markdown="1">

한 클래스에 이름이 동일한 메서드가 중복 정의되어 있는 경우를 의미합니다. <br>
자바에서 한 클래스 내에 이미 사용하려는 이름과 같은 이름을 가진 메서드가 있더라도, <br>
매개변수의 개수 또는 타입이 다르면 같은 이름을 사용해서 메서드를 정의할 수 있습니다. <br>
<br>

</div>
</details>

<details>
<summary>오버라이딩(Overriding)이란?</summary>
<br>
<div markdown="1">

부모 클래스로부터 상속받은 메서드를 자식 클래스에서 재정의하는 것을 말합니다. <br>
상속받은 메서드를 그대로 사용할 수도 있지만, 자식 클래스에서 상황에 맞게 변경해야 하는 경우 오버라이딩 할 필요가 생깁니다. <br>
<br>

</div>
</details>

<details>
<summary>객체 지향의 특징 중 연관성(Relationship)이란?</summary>
<br>
<div markdown="1">

두 개 이상의 객체들이 상호 참조하는 관계를 말합니다. <br>
클래스들이 서로 관계를 맺고 이 고나계를 통해 메시지를 주고 받으며 기능을 제공합니다. <br>

1. 연관화(Association): is a member of, 2개 이상의 객체가 상호 관련되어 있음을 의미합니다. <br>
2. 분류화(Classification): is intance of, 동일한 형의 특성을 갖는 객체들을 모아 구성하는 것을 말합니다. <br>
3. 집단화(Aggregation): is part of, 관련 있는 객체들을 묶어 하나의 상위 객체를 구성하는 것을 말합니다. <br>
4. 일반화(Generalization): is a, 공통적인 성질들로 추상화한 상위 객체를 구성하는 것을 의미합니다. <br>
5. 특수화/상세화(Specialization): is a, 상위 객체를 구체화하여 하위 객체를 구성하는 것을 말합니다. <br>
   <br>

</div>
</details>

<details>
<summary>객체지향 설계 원칙 SOLID에 대해 설명하세요.</summary>
<br>
<div markdown="1">

변경이나 확장에 유연한 시스템을 설계하기 위해 지켜져야 할 원칙으로, 이 원칙을 따르면 시간은 더 소요될 수 있지만 유지보수하기 용이합니다. <br>

1. 단일 책임 원칙(SRP: Single Responsibility Principle): 한 클래스에 단 하나의 책임, 기능만 가져야 한다는 원칙입니다. <br>
2. 개방-폐쇄 원칙(OCP: Open Closed Principle): 기존의 코드를 변경하지 않으면서 기능을 추가할 수 있도록 설계해야 한다는 원칙입니다. 확장에 대해서는 개방적(open)이고, 수정에 대해서는 폐쇄적(closed)이어야 한다는 의미를 가집니다. <br>
3. 리스코스 치환 원칙(LSP: Liskov Subtitution Principle): 자식 클래스는 최소한 부모 클래스의 기능은 수행할 수 있어야 한다는 원칙으로, 프로그램의 최신 버전에서도 구버전에서 작성한 프로그램을 열 수 있도록 해야한다는 의미를 가집니다. <br>
4. 의존 역전의 원칙(DIP: Dependency Inversion Principle): 의존 관계 성립 시 추상성이 높은 클래스와 의존 관계를 맺어야 한다는 원칙으로, 사자가 아닌 동물과 의존 관계를 맺어야 한다는 의미를 가집니다. <br>
   <br>

</div>
</details>

---

## 모듈화
