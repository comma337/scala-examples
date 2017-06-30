### CASE 1 : REPL
case1.scala
```scala
def test() {
    println("test")
}
println("Hello, world!")
test()
```

```scala
scala> scala -print case1.scala
[[syntax trees at end of                   cleanup]] // case1.scala
package <empty> {
  object Main extends Object {
    def main(args: Array[String]): Unit = {
      new <$anon: Object>();
      ()
    };
    def <init>(): Main.type = {
      Main.super.<init>();
      ()
    }
  };
  final class anon$1 extends Object {
    private def test(): Unit = scala.this.Predef.println("test");
    def <init>(): <$anon: Object> = {
      anon$1.super.<init>();
      scala.this.Predef.println("Hello, world!");
      anon$1.this.test();
      ()
    }
  }
}

Hello, world!
test
```

### CASE 2 : extends App
case2.scala
```scala
object HelloWorld extends App {
    def test() {
        println("test")
    }

    test()
}
```

```scala
scala> scala -print case2.scala
[[syntax trees at end of                   cleanup]] // case2.scala
package <empty> {
  object Main extends Object with App {
    <stable> <accessor> def executionStart(): Long = Main.this.executionStart;
    @deprecatedOverriding("executionStart should not be overridden", "2.11.0") private[this] val executionStart: Long = _;
    final <accessor> def _args(): Array[String] = Main.this._args;
    private[this] var _args: Array[String] = _;
    final <accessor> def _args_=(x$1: Array[String]): Unit = {
      Main.this._args = x$1;
      ()
    };
    final <stable> <accessor> def initCode(): scala.collection.mutable.ListBuffer = Main.this.initCode;
    private[this] val initCode: scala.collection.mutable.ListBuffer = _;
    <accessor> def scala$App$_setter_$executionStart_=(x$1: Long): Unit = {
      Main.this.executionStart = x$1;
      ()
    };
    <accessor> def initCode_=(x$1: scala.collection.mutable.ListBuffer): Unit = {
      Main.this.initCode = x$1;
      ()
    };
    @deprecatedOverriding("args should not be overridden", "2.11.0") def args(): Array[String] = scala.App$class.args(Main.this);
    @deprecated("The delayedInit mechanism will disappear.", "2.11.0") override def delayedInit(body: Function0): Unit = scala.App$class.delayedInit(Main.this, body);
    @deprecatedOverriding("main should not be overridden", "2.11.0") def main(args: Array[String]): Unit = scala.App$class.main(Main.this, args);
    def test(): Unit = scala.this.Predef.println("test");
    final <synthetic> def delayedEndpoint$Main$1: Unit = {
      Main.this.test();
      ()
    };
    def <init>(): Main.type = {
      Main.super.<init>();
      scala.App$class./*App$class*/$init$(Main.this);
      Main.this.delayedInit(new Main$delayedInit$body(Main.this));
      ()
    }
  };
  final <synthetic> class Main$delayedInit$body extends runtime.AbstractFunction0 {
    <paramaccessor> private[this] val $outer: Main.type = _;
    final def apply(): Object = {
      Main$delayedInit$body.this.$outer.delayedEndpoint$Main$1();
      scala.runtime.BoxedUnit.UNIT
    };
    def <init>($outer: Main.type): Main$delayedInit$body = {
      if ($outer.eq(null))
        throw null
      else
        Main$delayedInit$body.this.$outer = $outer;
      Main$delayedInit$body.super.<init>();
      ()
    }
  }
}

test
```

### CASE 3 : define main()
case3.scala
```scala
object HelloWorld {
    def test() {
        println("test")
    }

    def main(args: Array[String]) {
        test()
    }
}
```

```scala
scala> scala -print case3.scala
[[syntax trees at end of                   cleanup]] // case3.scala
package <empty> {
  object Main extends Object {
    def test(): Unit = scala.this.Predef.println("test");
    def main(args: Array[String]): Unit = Main.this.test();
    def <init>(): Main.type = {
      Main.super.<init>();
      ()
    }
  }
}

test
```

### CASE 4 : function vs method
case4.scala
```scala
object HelloWorld {
    val test1 = () => println("test")
    def test2() = println("test")

    def main(args: Array[String]) {
        test1()
        test2()
    }
}
```

```scala
scala> scala -print case4.scala
[[syntax trees at end of                   cleanup]] // case4.scala
package <empty> {
  object Main extends Object {
    private[this] val test1: Function0 = _;
    <stable> <accessor> def test1(): Function0 = Main.this.test1;
    def test2(): Unit = scala.this.Predef.println("test");
    def main(args: Array[String]): Unit = {
      Main.this.test1().apply$mcV$sp();
      Main.this.test2();
      scala.this.Predef.println(Main.this.test1());
      scala.this.Predef.println({
        Main.this.test2();
        scala.runtime.BoxedUnit.UNIT
      })
    };
    def <init>(): Main.type = {
      Main.super.<init>();
      Main.this.test1 = {
        (new <$anon: Function0>(): Function0)
      };
      ()
    }
  };
  @SerialVersionUID(value = 0) final <synthetic> class anonfun$1 extends scala.runtime.AbstractFunction0$mcV$sp with Serializable {
    final def apply(): Unit = anonfun$1.this.apply$mcV$sp();
    <specialized> def apply$mcV$sp(): Unit = scala.this.Predef.println("test");
    final <bridge> <artifact> def apply(): Object = {
      anonfun$1.this.apply();
      scala.runtime.BoxedUnit.UNIT
    };
    def <init>(): <$anon: Function0> = {
      anonfun$1.super.<init>();
      ()
    }
  }
}

test
test
<function0>
test
()

```

### CASE 5
```scala
scala> scala -Xprint:typer -e "for (i <- 0 to 10) yield i"
package <empty> {
  object Main extends scala.AnyRef {
    def <init>(): Main.type = {
      Main.super.<init>();
      ()
    };
    def main(args: Array[String]): Unit = {
      final class $anon extends scala.AnyRef {
        def <init>(): <$anon: AnyRef> = {
          $anon.super.<init>();
          ()
        };
        scala.this.Predef.intWrapper(0).to(10).map[Int, scala.collection.immutable.IndexedSeq[Int]](((i: Int) => i))(immutable.this.IndexedSeq.canBuildFrom[Int])
      };
      {
        new $anon();
        ()
      }
    }
  }
}
```