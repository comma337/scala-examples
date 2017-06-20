# [Syntax] Python vs Scala
- Python 3.4, Scala 2.11 기준
- 온라인 코드 실행 : https://scalafiddle.io

## Install
- Download : http://scala-lang.org/download/all.html
- set Environment Variable
  |Environment | Variable | Value (example) |
  |--|--|--|
  |Unix|$SCALA_HOME|/usr/local/share/scala|
  ||$PATH|$PATH:$SCALA_HOME/bin|
  |Windows|%SCALA_HOME%|c:\Progra~1\Scala|
  ||%PATH%|%PATH%;%SCALA_HOME%\bin|

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
# REPL
scala {filename}.scala

# compile : class file(java bytecode) 생성
scalac {filename}.scala
scalac -d {directory} {filename}.scala    # class file 저장 경로 지정

# excute
scala {classname}
scala -cp {directory} {classname}         # class file 저장 경로 지정

# excute with Java
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
```

## Comment
Python
```python
# single line

"""
multiple line
"""
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
// extend
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

```
Scala
```scala

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
```scala
val t1 = new Tuple1(1)
val t2 = new Tuple2(1, "first")
val t3 = new Tuple3(1, "coffee", 500)     // max 22개까지 사용 가능
val t3 = (1, "coffee", 500)               // 생략 가능
// get value
t3._2     // coffee, tuple는 1부터 시작
```

## Array
Scala
```scala

```

## Mutable Collections
Python
```python

```
Scala
```scala

```

## Functional Combinator
Python
```python

```
Scala
```scala

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
<!--
## Class & Object
Python
```python
class HelloWorld():
    def __init__(self, name):
        self.name = name

    def main(self):
        print("Hello, %s" % self.name)

if __name__ == "__main__":
    a = HelloWorld("world")
    a.main()
```
Scala
```scala
// singleton object
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
  }
}

// class

```

## Import
Python
```python

```
Scala
```scala

```

## Exception
Python
```python

```
Scala
```scala

```

## 추가
파일 읽고 쓰기



## 참조
- https://twitter.github.io/scala_school/ko/
-->