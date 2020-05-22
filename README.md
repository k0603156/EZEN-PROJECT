### Spring

#### contributer
[kimyongkuk]()
[leechangho]()
[hwanghyejin](https://github.com/hwanghyejin-1)
[leejichan]()

#### 실행환경

- Java-version: java version "1.8.0_241"
  - [다운로드링크](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
  - [환경변수설정](https://macchiato.tistory.com/9)
  - `````bash
        $java -version
        java version "1.8.0_241"
        Java(TM) SE Runtime Environment (build 1.8.0_241-b07)
        Java HotSpot(TM) 64-Bit Server VM (build 25.241-b07, mixed mode)
        ```
        ````
    `````
- IDE: Spring tool suite 3
  - [다운로드링크](https://github.com/spring-projects/toolsuite-distribution/wiki/Spring-Tool-Suite-3)
- WAS: Tomcat 8.5
  - [다운로드링크](http://mirror.apache-kr.org/tomcat/tomcat-8/v8.5.53/bin/apache-tomcat-8.5.53-windows-x64.zip)

#### 프로잭트 시작

- tomcat

  - **todo: 톰캣설치부터 세팅**

- new -> spring legacy project

  - spring mvc project 프로젝트 생성

    - [x] workingset

      `개발을 하다보면 workspace로 프로젝트들을 분류하여 관리할 수 있지만 하나의 workspace 안에서 여러가지 프로젝트들이 생성되어 프로젝트를 구분하기 어려워 질 수 있습니다. 이클립스에서는 프로젝트들을 하나로 묶을 수 있는 워킹셋(Working Set) 이라는 분류 단위를 제공합니다.`
      [#참조](https://dololak.tistory.com/451)

  - com.springsample.sampleapp
  - finish

- 기본적인 spring mvc 프로젝트가 생성된다.

- `ctrl+f11` 프로젝트를 등록하고 실행

- pom.xml을 분석하기 전 maven

  - maven?

    - maven은 자바 프로젝트의 빌드를 자동화 해주는 툴이다.
    - 자바 소스를 compile - packaging - deploy를 자동화.

  - maven이 참조하는 설정파일

    - settings.xml

      - settings.xml은 maven tool의 설정을 담당한다.
      - MAVEN_HOME/conf 아래에 있다.

    - pom.xml

      - 프로젝트에 빌드 툴로 maven을 설정 했다면 프로젝트 최상위에 `porm.xml`이 생성되었을 것이다.
      - pom.xml은 Project Object Model을 설정하는 부분으로 프로젝트 내 빌드 옵션을 설정하는 부분이다.

        ```
            <modelVersion>4.0.0</modelVersion>
            #maven pom.xml의 모델 버전

        ```

#### 참고

- spring tool suite4 의 경우 설치후 `new - spring legecy project` 메뉴가 없다.
  - `help- eclipse marketplace` 에서 `Spring Tools 3 Add-On for Spring Tools 4`를 찾아 인스톨 한다.
- spring starter project 는 spring boot 프로젝트.

```- simple java
    - 최상위 패키지 없이 기본 spring 구성 및 java 빌드를 사용해 간단한 spring 프로젝트를 생성
- simple spring maven
    - spring 라이브러리의 기본 세트를 포함하는 maven을 사용해 간단한 spring프로젝트를 생성
- simple spring web maven
    - spring 웹 라이브러리의 기본 세트를 포함, maven을 사용하여 간단한 spring 웹 프로젝트를 생성
- spring mvc project
    - 기본적인 mvc 형태로 maven까지 세팅이 되어 생성.
```
