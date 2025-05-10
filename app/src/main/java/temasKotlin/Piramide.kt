package temasKotlin


fun main() {
    var valorM: Int
    do {
        print("Dame el numero de lineas: ")
        valorM = readlnOrNull()?.toIntOrNull() ?: 0

        if (valorM > 0) {
            var fila = 1
            do {
                var asterisco = 1
                do {
                    print("*")
                    asterisco++
                } while (asterisco <= fila)

                println()
                fila++
            } while (fila <= valorM)
        }
    } while (valorM != 0)
    println("Programa terminado.")
}