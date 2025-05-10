package temasKotlin

import kotlin.math.sqrt

fun main() {
    println("CALCULADORA DE FÓRMULA GENERAL")
    println("(Soluciones para ax² + bx + c = 0)\n")

    val a = pedirNumero("a", true)
    val b = pedirNumero("b", false)
    val c = pedirNumero("c", false)

    val operacionraiz = b * b - 4 * a * c

    if (operacionraiz < 0) {
        println("\nNo hay soluciones reales")
    } else {
        val raiz = sqrt(operacionraiz)
        val x1 = (-b + raiz) / (2 * a)
        val x2 = (-b - raiz) / (2 * a)

        println("\nSoluciones:")
        println("x1 = $x1")
        println("x2 = $x2")
    }
}

fun pedirNumero(coef: String, evitarCero: Boolean): Double {
    while (true) {
        print("Ingresa el valor de $coef: ")
        val num = readLine()?.toDoubleOrNull()

        when {
            num == null -> println("Ingresa un número válido")
            evitarCero && num == 0.0 -> println("'a' no puede ser cero")
            else -> return num
        }
    }
}