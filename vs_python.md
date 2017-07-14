# [Syntax] Python vs Scala
- Python 3.4, Scala 2.11 기준
- 온라인 코드 실행 : https://scalafiddle.io

## Install
- Download : http://scala-lang.org/download/all.html
- set Environment Variable

  Environment | Variable | Value (example)
  ---|---|---
  Unix|$SCALA_HOME | /usr/local/share/scala
  | $PATH | $PATH:$SCALA_HOME/bin
  Windows | %SCALA_HOME% | c:\Progra~1\Scala
  | %PATH% | %PATH%;%SCALA_HOME%\bin

## REPL shell
### 실행
Python
```
python3
```
Scala
```
scala
```
### 종료
Python
```python
exit()
```
Scala
```scala
:q
```

## Filename Extension & Excute Program
Python
```bash
python3 {filename}.py
```
Scala
```bash
# 1. excute single file
scala {filename}.scala

# 2-1. compile : class file(java bytecode) 생성
scalac {filename}.scala
scalac -d {directory} {filename}.scala    # class file 저장 경로 지정

# 2-2-1. excute
scala {classname}
scala -cp {directory} {classname}         # class file 저장 경로 지정

# 2-2-2. excute with Java interpreter
java -cp $SCALA_HOME/lib/scala-library.jar:{directory} {classname}
```

## HelloWorld
Python
```python
class HelloWorld:
    def main(self):
        print("Hello, world!")

# 현재 파일 실행 시 아래 코드가 실행됨
if __name__ == "__main__":
    a = HelloWorld()
    a.main()

# 또는
print("Hello, world!")
```
Scala
```scala
object HelloWorld {
  // 객체 실행 시 프로그램 시작 함수
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
  }
}

// 또는
// App trait를 상속받으면 객체 내 모든 명령문이 실행됨
object HelloWorld extends App {
  println("Hello, world!")
}

// 또는(class로 컴파일은 불가)
println("Hello, world!")
```

## Comment
Python
```python
# single line

# multiple line : 없음
```
Scala
```scala
// single line

/*
multiple line
*/
```

## Block
Python
- block : 들여쓰기로 구분
- indentation : 보통 4 spaces, 필수

Scala
- block : {} 로 구분, 1줄인 경우 생략 가능
- indentation : 보통 2 spaces, 권장
- semicolon(;) : 문장의 끝, python처럼 scala도 일반적으로 생략함/ 한줄에 여러문장 쓰는 경우 사용함

## Print
Python
```python
# 줄바꿈 포함
print("abcd")

# 줄바꿈 미포함
print("abcd", end="")

# 문장 내 변수 출력
a = 1
b = 2
print("a: %d b: %d" % (a, b))
```
Scala
```scala
// 줄바꿈 포함
println("abcd")

// 줄바꿈 미포함
print("abcd")

// 문장 내 변수 출력
val a = 1
val b = 2
print(s"a: $a b: $b")
print(f"a: $a%d b: $b%d")   // format 지정
```

## Variables
Python
```python
# 변수 선언 시 타입 선언 안함
a = 1
s = "abcd"

a = "abcd"  # 가능, 값 할당 시 타입 결정

# 형변환
str(2)
float(2)
```
Scala
```scala
// 선언 시 타입 추론 가능
val a = 1
val s = "abcd"

// 타입 선언
val a1:Int = 1
val s1:String = "abcd"

a = "abcd"   // 오류, 같은 타입만 사용 가능
a = 2        // 오류, val은 수정 불가(constant), python에는 상수 키워드가 없고 대문자로 선언하도록 권장

var b = 1
b = 2        // 가능
b = 0.5       // 오류, 정수형의 경우 default Int로 추론됨

var c:Float = 1
c = 0.5      // 불가능, 부동소수점의 경우 default Double로 추론됨
c = 0.5f     // 가능, Long : l/L, Double : d/D, Float : f/F 를 같이 씀

var d:Any = 1
d = "abcd"   // 가능, scala의 모든 타입은 객체로 Any는 최상위 객체
             // 컴파일 시 오류 체크 불가, 각 타입에서 제공하는 연산자 등 사용 불가

// scala의 모든 데이터 타입은 클래스로 형변환 시 메소드 사용, 인자 값이 없는 경우 () 생략 가능
2.toString
2.toFloat
```

## 연산자
Python
```python
1 + 2
```
Scala
```scala
1 + 2
1.+(2)    // 산술 연산자들도 메소드
1.to(5)   // Range(1, 2, 3, 4, 5)
1 to 5    // method 호출 시 . () 생략 가능
```

## Function
Python
```python
def add(a, b): 
    return a + b
```
Scala
```scala
def add(a:Int, b:Int):Int = {
  return a + b
}

def add(a:Int, b:Int) = {     // 리턴 타입 생략 가능
  a + b                       // 보통 return 키워드 생략, 마지막 실행문이 리턴됨
}                             // 1줄인 경우 {}도 생략 가능

def subStr(str: String, len: Int = 10, tail: String = "...") = {
if (str.length > len)
    str.substring(0, len) + tail
else
    str
}

println(subStr("abcdefghijklmnopqrstuvwxyz", 5))                        // abcde...
println(subStr("abcdefghijklmnopqrstuvwxyz", tail = "-"))               // abcdefghij-
println(subStr("abcdefghijklmnopqrstuvwxyz", tail = "-", len = 5))      // abcde-
```

## Option, Some, None
- null 보다 Option 사용 권장
- Option[T] : 값이 있을 수도/ 없을 수도 있을 때, Some[T] : 값이 있는 경우, None : 값이 없다는 의미의 값

Scala
```scala
var name:Option[String] = None    // name: Option[String] = None
name.getOrElse("no name")         // no name
name = Some("sing")
```

## Anonymous Function
Python
```python
def exec(func):
    return func(1, 2)

exec(lambda a, b: a + b)      # 코드 조각 자체를 파라메터로 전달
```
Scala
```scala
def exec(func: (Int, Int) => Int) = {
  func(1, 2)
}

exec((a, b) => a + b)   // exec()에서 타입을 정의해서 생략 가능
exec(_ + _)             // 파라메터가 실행문 중 한번만 나오고, 순서대로 매핑되는 경우 _로 표시 가능
```

## If & Match
Python
```python
a = 1
if a == 1:
    print("first")
elif a  == 2:
    print("second")
else:
    print("other")
```
Scala
```scala
val a = 1
// if
if (a == 1) {
  println("first")
}
else if (a == 1) {
  println("second")
}
else
  println("other")

// pattern matching
a match {
  case 1 => println("first2")
  case 2 => println("second")
  // scala의 _(underscore)는 전체, default 값 등의 용도로 사용됨(참조 : https://www.slideshare.net/normation/scala-dreaded)
  case _ => println("other")
}
```

## Range & For
Python
```python
# 0 ~ 9
for a in range(10):
    print(a)
# 1 ~ 10
for a in range(1, 11):
    print(a)
# with filter
for a in [x for x in range(10) if x % 2 == 0]:
    print(a)
```
Scala
```scala
// 0 ~ 9
for (a <- 0 until 10) {
  println(a)
}
// 1 ~ 10
for (a <- 1 to 10) {
  println(a)
}
// with filter
for (a <- 0 to 9; if a % 2 == 0) {
  println(a)
}
```

## While & Do While
Python
```python
i = 0
while i < 10:
    i += 1
print(i)
```
Scala
```scala
// while
var i = 0
while (i < 10) {
    i += 1
}
println(i)

// do while, 1회는 반드시 실행됨
var i = 0
do {
    i += 1
} while (i < 10)
println(i)
```

## List
Python
```python
# declare
a = []
a = list()
a = [1, 2, 3, 4, 5]             # [1, 2, 3, 4, 5]

# get value
a[0]             # 1
# slice
a[0:2]           # [1, 2]
# update
a[1] = 0         # [1, 0, 3, 4, 5]
# delete
del a[2]         # [1, 0, 4, 5]
# append, 그 외에도 insert(), remove(), pop(), count() 등 함수 지원
a.append(6)      # [1, 0, 4, 5, 6]
# extend
a + [7, 8]       # [1, 2, 0, 4, 5, 6, 7, 8]
a.extend([7, 8])
```
Scala
```scala
val a = List()                          // 기본 Collection의 List는 변경 불가(immutable)
val a = List[Int]()
val var a:List[Int] = List()

val a = List(1, 2, 3, 4, 5)             // [1, 2, 3, 4, 5]
val a = List.range(1, 6)
val a = (1 to 5).toList
val a = 1 :: 2 :: 3 :: 4 :: 5 :: Nil    // Nil 빈 리스트, :: 뒤의 객체에 앞의 객체를 "앞에" 붙여 새 리스트로 반환함

// get value
a(0)
// slice
a.slice(0, 2)
// update
a(1) = 0      // 오류    
// extend, ++, :::, :+(append), +:(prepend) 등 연산자는 collection 공통 제공
a ++ List(7, 8)
a ::: List(7, 8)
```

## List Comprehension vs For Comprehension
Python
```python
a = [x + 1 for range(10)]
```
Scala
```scala
val a = for(x <- 1 to 9) yield x + 1    // Vector(2, 3, 4, 5, 6, 7, 8, 9, 10), loop가 실행되는 Collection에 따라 리턴 타입이 결정됨
val a = (for(x <- 1 to 9) yield x + 1).toList     // Collection 간 변환 가능
```

## Set
Python
```python
a = {}
a = set()
a = {1, 2, 3}
# exist
1 in a                  # True
# extend
a.union({3, 4, 5})      # {1, 2, 3, 4, 5}
```
Scala
```scala
val a = Set()
val a = Set(1, 2, 3)
// exist
a(1)                    // true
// extend
a ++ Set(3, 4, 5)       // Set(5, 1, 2, 3, 4), Set은 입력 순서 보장 안됨, ::: 연산자 없음
```

## Dict vs Map
Python
```python
d = {1: 'a', 2: 'b'}
# get value
d[1]                    # a
d.get(1)
d[3]                    # 오류
d.get(3)                # None
d.get(3, 'default')     # defaultE
# get keys
d.keys()
# get values
d.values()
# get tuple list
d.items()
# update
d[1] = 'c'
# exist
3 in d
```
Scala
```scala
val m = Map(1 -> "a", 2 -> "b")
// get value
m(1)
m.get(1)
m(3)                    // 오류
m.get(3)                // None
m.get(3, "default")     // default
// get keys, keysIterator도 있음 
m.keys
// get values
m.values
// exist
m contains 3
```

## Tuple
Python
```python
t1 = (1)
t2 = (1, "first")
t3 = (1, "coffee", 500)
# 불변, update/ delete 불가, 그외 list와 비슷
# get value
t3[1]       # coffee
```
Scala
- 왜 Array, List, Set, Map랑 다르게 Tuple만 new 키워드를 쓰나? -> Companion Object & apply() method 참조

```scala
val t1 = new Tuple1(1)
val t2 = new Tuple2(1, "first")
val t2 = (1, "coffee")                    // 생략 가능
val t2 = 1 -> "first"                     // 2개일 때만 가능
val t3 = new Tuple3(1, "coffee", 500)     // max 22개까지 사용 가능

// get value
t3._2     // coffee, tuple는 1부터 시작
```

## Array
Python
- array 없음

Scala
```scala
val a = Array(1, 2, 3)
// get value
a(0)
// update, 배열 크기는 불변/ 내용은 수정 가능
a(0) = 0
```

## Mutable Collections
- 꼭 필요하다면 scala mutable collection 이나 java collection을 사용 가능

Scala
```scala
import scala.collection.mutable._
import scala.collection.mutable.{Map => MMap}
import collection.JavaConverters._
import java.util.{List => JList, ArrayList => JArrayList}

// scala 가변 클래스들
val arr = ArrayBuffer(1, 2, 3)
val list = ListBuffer(1, 2, 3)
val set = Set(1, 2, 3)
val map = MMap(1 -> "a", 2 -> "b")

// 굳이 java class를 써보자면
val jList:JList[Int] = new JArrayList[Int]()
jList.add(1)
jList.add(2)
jList.add(3)

// scala to java
val javaListFromScala = list.asJava
// java to scala
val scalaListFromJava = jList.asScala
```

## Functional Combinators
Scala
```scala
scala> val numbers = List(1, 2, 3, 4)
numbers: List[Int] = List(1, 2, 3, 4)
// map
scala> numbers.map((i: Int) => i * 2)
res0: List[Int] = List(2, 4, 6, 8)
// foreach
scala> numbers.foreach((i: Int) => print(i * 2))
2468
// filter
scala> numbers.filter(_ > 2)
res2: List[Int] = List(3, 4)
// zip
scala> List(1, 2, 3).zip(List("a", "b", "c"))
res3: List[(Int, String)] = List((1,a), (2,b), (3,c))
// flatten
scala> List(List(1, 2), List(3, 4)).flatten
res4: List[Int] = List(1, 2, 3, 4)
// flatMap
scala> val nestedNumbers = List(List(1, 2), List(3, 4))
nestedNumbers: List[List[Int]] = List(List(1, 2), List(3, 4))
scala> nestedNumbers.flatMap(x => x.map(_ * 2))
res0: List[Int] = List(2, 4, 6, 8)
scala> nestedNumbers.map((x: List[Int]) => x.map(_ * 2)).flatten
res1: List[Int] = List(2, 4, 6, 8)
```

## Apply & Update methods
- apply(), update() method는 이름 생략 가능

```scala
val arr = Array(1, 2, 3, 4)
arr(1)
arr.apply(1)        // .apply 생략 가능

arr(1) = 0
arr.update(1, 0)    // = 중위 연산자로 치환 가능
```

## Companion Object & apply() method
- Companion Object : Class와 똑같은 이름의 Object, apply() method를 이용해서 factory를 만들 때 사용

```scala
class Hello(name: String) {
    def say() = {
        println("hello " + name)
    }
}
object Hello {
    def apply(name: String) = {
        new Hello(name)
    }
}
val h1 = new Hello("scala")
h1.say()
val h2 = Hello.apply("scala")
h2.say()
val h3 = Hello("scala")
h3.say()
```

## Class & Object
- object : 어플리케이션 안에서 한번만 생성할 객체, 상수와 util method 모아둠
- class : 반복 생성해서 사용할 객체

Scala
```scala
class Person1 {
  var name: String = ""   // 읽고 쓰기 가능(public), getter/setter
  val age: Int = 0    // 읽기만 가능, setter

  private val mind: String = "happy"  // 클래스 외부에서 접근 불가, private

  def feeling(): String = mind
}

class Person2(var name: String,   // getter/setter
              val age: Int,       // setter
              mind: String) {     // private
  def feeling(): String = mind
}

class Person3(var name: String,
              val varAge: Int = 0) {
  private var _age:Int = varAge

  def age: Int = _age

  def age_=(newAge: Int) = {
    if(newAge > _age)
      _age = newAge
  }
}

class Person4(var name: String,
              val age: Int) {
  def this(name: String) = this(name, 0)    // 생성자 추가
}

class Person5(var name: String,
              val age: Int)

object Person5 {
  def apply(name: String, age: Int): Person5 = new Person5(name, age)
}

case class Person6(var name: String,
                   age: Int)    // val로 간주

object demo extends App {
  val sing1 = new Person1()
  sing1.name = "sing"
  println(s"${sing1.name}, ${sing1.age}, ${sing1.feeling}")

  val sing2 = new Person2("sing", 10, "happy")
  println(s"${sing2.name}, ${sing2.age}, ${sing2.feeling}")

  val sing3 = new Person3("sing", 10)
  sing3.age = 7     // 무시됨
  println(s"${sing3.name}, ${sing3.age}")     // sing, 10

  val sing4 = new Person4("sing")
  println(s"${sing4.name}, ${sing4.age}")     // sing, 0

  val sing5 = Person5("sing", 10)
  println(s"${sing5.name}, ${sing5.age}")     // sing, 10

  val sing6 = Person6("sing", 10)
  println(s"${sing6.name}, ${sing6.age}")     // sing, 10
  sing6.name = "test"
  println(s"${sing6.name}")     // test
}
```

## Trait
Scala
```scala

```
