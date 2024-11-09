package taller

class ConjuntosDifusos() {
    type ConjDifuso = Int => Double
    def pertenece(elem: Int, s: ConjDifuso): Double = {
        s(elem)
    }

    def grande(d: Int, e: Int): ConjDifuso ={
        def gd(n: Int): Double = {
            if (n <= 0) 0.0 // Si el número es menor o igual a cero, no es grande
            else Math.pow(n.toDouble / (n + d).toDouble, e.toDouble)
        }
        gd
    }

    def complemento(c: ConjDifuso): ConjDifuso = {
        def comp(n: Int): Double = {
            1.0 - c(n)  // El complemento se calcula como 1 - fS(n)
        }
        comp
    }

    // Función que devuelve la unión de dos conjuntos difusos
    def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
        def un(n: Int): Double = {
            Math.max(cd1(n), cd2(n))  // La unión toma el máximo de los grados de pertenencia
        }
        un
    }

    // Función que devuelve la intersección de dos conjuntos difusos
    def interseccion(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
        def inter(n: Int): Double = {
            Math.min(cd1(n), cd2(n))  // La intersección toma el mínimo de los grados de pertenencia
        }
        inter
    }
    // Función que verifica si cd1 está incluido en cd2
    def inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
        @annotation.tailrec
        def aux(n: Int): Boolean = {
            if (n > 1000) true  // Si llegamos al final del rango, la inclusión es verdadera
            else if (cd1(n) > cd2(n)) false  // Si encontramos un caso donde cd1(n) > cd2(n), no hay inclusión
            else aux(n + 1)  // Seguimos recursivamente
        }
        aux(0)  // Empezamos desde 0
    }

    // Función que verifica si dos conjuntos difusos son iguales
    def igualdad(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
        inclusion(cd1, cd2) && inclusion(cd2, cd1)  // Son iguales si ambos están incluidos uno en el otro
    }


}
