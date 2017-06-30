object HelloWorld {
    val test1 = () => println("test")
    def test2() = println("test")

    def main(args: Array[String]) {
        test1()
        test2()

        println(test1)
        println(test2)
    }
}