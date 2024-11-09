package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosTest extends AnyFunSuite {
    val objConjuntoDifuso = new ConjuntosDifusos()


    //-----------------------------------------------------------------------
    //Función Pertecene
    test("1"){
        val c1: objConjuntoDifuso.ConjDifuso = (x: Int) => if (x > 5) 1.0 else 0.5
        assert(objConjuntoDifuso.pertenece(6, c1) == 1.0)
    }
    test("2"){
        val c1: objConjuntoDifuso.ConjDifuso = (x: Int) => if (x > 5) 1.0 else 0.5
        assert(objConjuntoDifuso.pertenece(4, c1) == 0.5)
    }
    test("3"){
        val c1: objConjuntoDifuso.ConjDifuso = (x: Int) => if (x > 5) 1.0 else 0.5
        assert(objConjuntoDifuso.pertenece(10, c1) == 1.0)
    }
    test("4"){
        val c1: objConjuntoDifuso.ConjDifuso = (x: Int) => if (x > 5) 1.0 else 0.5
        assert(objConjuntoDifuso.pertenece(0, c1) == 0.5)
    }
    test("5"){
        val c1: objConjuntoDifuso.ConjDifuso = (x: Int) => if (x > 5) 1.0 else 0.5
        assert(objConjuntoDifuso.pertenece(5, c1) == 0.5)
    }

    //-----------------------------------------------------------------------
    //Función Grande
    test("6"){
        val conjuntoGrande = objConjuntoDifuso.grande(2, 3)
        assert(conjuntoGrande(1) > 0.01)
    }
    test("7"){
        val conjuntoGrande = objConjuntoDifuso.grande(2, 3)
        assert(conjuntoGrande(10) > 0.5)
    }
    test("8"){
        val conjuntoGrande = objConjuntoDifuso.grande(2, 3)
        assert(conjuntoGrande(20) > 0.75)
    }
    test("9"){
        val conjuntoGrande = objConjuntoDifuso.grande(2, 3)
        assert(conjuntoGrande(0) == 0.0)
    }
    test("10"){
        val conjuntoGrande = objConjuntoDifuso.grande(2, 3)
        assert(conjuntoGrande(100) > 0.9)
    }
    //-----------------------------------------------------------------------
    //Función Complemento
    test("11"){
        val conjuntoGrande = objConjuntoDifuso.grande(2, 2)
        val complementoGrande = objConjuntoDifuso.complemento(conjuntoGrande)
        assert(complementoGrande(0) == 1.0)
    }
    test("12"){
        val conjuntoGrande = objConjuntoDifuso.grande(2, 2)
        val complementoGrande = objConjuntoDifuso.complemento(conjuntoGrande)
        assert(complementoGrande(5) > 0.4)
    }
    test("13"){
        val conjuntoGrande = objConjuntoDifuso.grande(2, 2)
        val complementoGrande = objConjuntoDifuso.complemento(conjuntoGrande)
        assert(complementoGrande(10) < 0.5)
    }
    test("14"){
        val conjuntoGrande = objConjuntoDifuso.grande(2, 2)
        val complementoGrande = objConjuntoDifuso.complemento(conjuntoGrande)
        assert(complementoGrande(100) < 0.1)
    }
    test("15"){
        val conjuntoGrande = objConjuntoDifuso.grande(2, 2)
        val complementoGrande = objConjuntoDifuso.complemento(conjuntoGrande)
        assert(complementoGrande(1000) < 0.01)
    }
    //-----------------------------------------------------------------------
    //Función Union
    test("16"){
        val conjunto1 = objConjuntoDifuso.grande(2, 2)
        val conjunto2 = objConjuntoDifuso.grande(3, 3)
        val unionConjuntos = objConjuntoDifuso.union(conjunto1, conjunto2)
        assert(unionConjuntos(5) == Math.max(conjunto1(5), conjunto2(5)))
    }
    test("17"){
        val conjunto1 = objConjuntoDifuso.grande(2, 2)
        val conjunto2 = objConjuntoDifuso.grande(3, 3)
        val unionConjuntos = objConjuntoDifuso.union(conjunto1, conjunto2)
        assert(unionConjuntos(10) == Math.max(conjunto1(10), conjunto2(10)))

    }
    test("18"){
        val conjunto1 = objConjuntoDifuso.grande(2, 2)
        val conjunto2 = objConjuntoDifuso.grande(3, 3)
        val unionConjuntos = objConjuntoDifuso.union(conjunto1, conjunto2)
        assert(unionConjuntos(50) == Math.max(conjunto1(50), conjunto2(50)))

    }
    test("19"){
        val conjunto1 = objConjuntoDifuso.grande(2, 2)
        val conjunto2 = objConjuntoDifuso.grande(3, 3)
        val unionConjuntos = objConjuntoDifuso.union(conjunto1, conjunto2)
        assert(unionConjuntos(100) == Math.max(conjunto1(100), conjunto2(100)))
    }
    test("20"){
        val conjunto1 = objConjuntoDifuso.grande(2, 2)
        val conjunto2 = objConjuntoDifuso.grande(3, 3)
        val unionConjuntos = objConjuntoDifuso.union(conjunto1, conjunto2)
        assert(unionConjuntos(1000) == Math.max(conjunto1(1000), conjunto2(1000)))

    }

    //-----------------------------------------------------------------------
    //Función Interseccion
    test("21"){
        val conjunto1 = objConjuntoDifuso.grande(2, 2)
        val conjunto2 = objConjuntoDifuso.grande(3, 3)
        val interseccionConjuntos = objConjuntoDifuso.interseccion(conjunto1, conjunto2)
        assert(interseccionConjuntos(5) == Math.min(conjunto1(5), conjunto2(5)))
    }
    test("22"){
        val conjunto1 = objConjuntoDifuso.grande(2, 2)
        val conjunto2 = objConjuntoDifuso.grande(3, 3)
        val interseccionConjuntos = objConjuntoDifuso.interseccion(conjunto1, conjunto2)
        assert(interseccionConjuntos(10) == Math.min(conjunto1(10), conjunto2(10)))
    }
    test("23"){
        val conjunto1 = objConjuntoDifuso.grande(2, 2)
        val conjunto2 = objConjuntoDifuso.grande(3, 3)
        val interseccionConjuntos = objConjuntoDifuso.interseccion(conjunto1, conjunto2)
        assert(interseccionConjuntos(50) == Math.min(conjunto1(50), conjunto2(50)))
    }
    test("24"){
        val conjunto1 = objConjuntoDifuso.grande(2, 2)
        val conjunto2 = objConjuntoDifuso.grande(3, 3)
        val interseccionConjuntos = objConjuntoDifuso.interseccion(conjunto1, conjunto2)
        assert(interseccionConjuntos(100) == Math.min(conjunto1(100), conjunto2(100)))
    }
    test("25"){
        val conjunto1 = objConjuntoDifuso.grande(2, 2)
        val conjunto2 = objConjuntoDifuso.grande(3, 3)
        val interseccionConjuntos = objConjuntoDifuso.interseccion(conjunto1, conjunto2)
        assert(interseccionConjuntos(1000) == Math.min(conjunto1(1000), conjunto2(1000)))
    }

    //-----------------------------------------------------------------------
    //Función Inclusion
    test("26"){
        val c1: objConjuntoDifuso.ConjDifuso = (x: Int) => if (x > 5) 1.0 else 0.5

        val c5: objConjuntoDifuso.ConjDifuso = (x: Int) => if (x > 5) 0.6 else 0.3
        assert(objConjuntoDifuso.inclusion(c5, c1))
    }
    test("27"){
        val c1: objConjuntoDifuso.ConjDifuso = (x: Int) => if (x > 5) 1.0 else 0.5
        val c2: objConjuntoDifuso.ConjDifuso = (x: Int) => if (x > 3) 0.9 else 0.1
        assert(!objConjuntoDifuso.inclusion(c2, c1))
    }
    test("28"){
        val c1: objConjuntoDifuso.ConjDifuso = (x: Int) => if (x > 5) 1.0 else 0.5
        val c3: objConjuntoDifuso.ConjDifuso = (x: Int) => 0.7
        assert(!objConjuntoDifuso.inclusion(c3, c1))
    }
    test("29"){
        val c1: objConjuntoDifuso.ConjDifuso = (x: Int) => if (x > 5) 1.0 else 0.5
        val c4: objConjuntoDifuso.ConjDifuso = (x: Int) => 1.0
        assert(objConjuntoDifuso.inclusion(c1, c4))
    }
    test("30"){
        val c4: objConjuntoDifuso.ConjDifuso = (x: Int) => 1.0
        assert(objConjuntoDifuso.inclusion(c4, c4))  // Un conjunto siempre está incluido en sí mismo
    }
    //-----------------------------------------------------------------------
    //Función Igualdad
    test("31"){
        val conjunto1 = objConjuntoDifuso.grande(2, 2)
        val conjunto2 = objConjuntoDifuso.grande(2, 2)
        assert(objConjuntoDifuso.igualdad(conjunto1, conjunto2))   // conjunto1 y conjunto2 son iguales
    }
    test("32"){
        val conjunto1 = objConjuntoDifuso.grande(2, 2)
        val conjunto3 = objConjuntoDifuso.grande(2, 3)
        assert(!objConjuntoDifuso.igualdad(conjunto1, conjunto3))  // conjunto1 y conjunto3 no son iguales
    }
    test("33"){
        val conjunto3 = objConjuntoDifuso.grande(2, 3)
        val conjunto4 = objConjuntoDifuso.grande(3, 4)
        assert(!objConjuntoDifuso.igualdad(conjunto4, conjunto3))  // conjunto4 y conjunto3 no son iguales
    }
    test("34"){
        val conjunto1 = objConjuntoDifuso.grande(2, 2)
        assert(objConjuntoDifuso.igualdad(conjunto1, conjunto1))   // Un conjunto es siempre igual a sí mismo
    }
    test("35"){
        val conjunto2 = objConjuntoDifuso.grande(2, 2)
        val conjunto4 = objConjuntoDifuso.grande(3, 4)
        assert(!objConjuntoDifuso.igualdad(conjunto2, conjunto4))  // conjunto2 y conjunto4 no son iguales
    }
}
