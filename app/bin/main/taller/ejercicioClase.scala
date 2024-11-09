package taller

class ejercicioClase {
    /**
     * El problema de la subasta
     * El gobierno ofrece un número de acciones A
     * El gobierno las paga a un precio B
     * Existe una lista de oferentes que las quieren comprar, es representado como un conjunto de tripletas (m,M,x),
     m es el número minimo de acciones que el oferente puede comprar, M es el máximo y x es el precio.
     * Se desea conocer todas las combinaciones posibles de oferentes que pueden comprar todas las acciones
     * Retorna un conjunto de listas de 4 posiciones, donde la primera posiciones es el gobierno, la segunda es el primer oferente así sucesivamente
     */
    def ejercicioClase(A: Int, B:Int, oferentes:List[List[Int]]): Set[List[Int]] = {
        (for {
            gob <- 0 to A
            of1 <- oferentes.head.head to oferentes.head(1)
            of2 <- oferentes(1).head to oferentes (1)(1)
            of3 <- oferentes(2).head to oferentes (2)(1)
            if gob + of1 + of2 + of3 == A
        }yield List(gob,of1,of2,of3, gob*B + of1* oferentes.head(2) + of2*oferentes(1)(2) + of3*oferentes(2)(2))).toSet
    }

}
