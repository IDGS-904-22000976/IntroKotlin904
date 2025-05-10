package temasKotlin

fun main() {
    var opcion: Int

    do {
        println("\nCALCULADORA SENCILLA")
        println("1. Sumar")
        println("2. Restar")
        println("3. Multiplicar")
        println("4. Dividir")
        println("5. Salir")
        print("Elige una opcion: ")

        opcion = readlnOrNull()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> sumar()
            2 -> restar()
            3 -> multiplicar()
            4 -> dividir()
            5 -> println("Cerrando aplicación")
            else -> println("Opción no válida")
        }
    } while (opcion != 5)
}

fun sumar() {
    println("\nSUMA")
    print("Ingrese el primer número: ")
    val a = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    print("Ingrese el segundo número: ")
    val b = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    println("Resultado: ${a + b}")
}

fun restar() {
    println("\nRESTA")
    print("Ingrese el primer número: ")
    val a = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    print("Ingrese el segundo número: ")
    val b = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    println("Resultado: ${a - b}")
}

fun multiplicar() {
    println("\nMULTIPLICACIÓN")
    print("Ingrese el primer número: ")
    val a = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    print("Ingrese el segundo número: ")
    val b = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    println("Resultado: ${a * b}")
}

fun dividir() {
    println("\nDIVISIÓN")
    print("Ingrese el primer número: ")
    val a = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    print("Ingrese el segundo número: ")
    val b = readlnOrNull()?.toDoubleOrNull() ?: 0.0

    if (b != 0.0) {
        println("Resultado: ${a / b}")
    } else {
        println("No se puede dividir entre cero")
    }
}