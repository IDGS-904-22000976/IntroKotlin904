package temasKotlin

fun main(){
    // variables solo lectura val
    // variables mutables var

    val a=1
    val b=8
    var c=10

    println(a)
    println("El valor de b es $b")
    println("El valor de c + 2 es ${c+2}")
    c= a+2
    c+=8
    c-+5
    c*8
    c/=2
    println("El valor de b es $c")

    val num1:Int=23
    var num2:Int?

    num2=6

    var nombre:String="Carlos"
    var caracter:Char='a'
    var num4:Float=12.5f
}
