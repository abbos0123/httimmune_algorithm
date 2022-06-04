package com.example.immuneproject.immune

class Display {

   companion object{
       fun showMassive(massive: Array<IntArray>) {
           println("MAIN MATRIX: ")
           for (i in 0..7) {
               for (j in 0..11) {
                   System.out.printf("%4d ", massive[i][j])
               }
               println()
           }
       }

       fun showChildMassive(immuneAlgorithm: ImmuneAlgorithm) {
           println("\n\nA0 matrix")
           for (i in 0..2) {
               for (j in 0..3) {
                   System.out.printf("%4d ", immuneAlgorithm.getA0()?.get(i)?.get(j))
               }
               println()
           }

           println("\n\nA1 matrix")
           for (i in 0..2) {
               for (j in 0..3) {
                   System.out.printf("%4d ", immuneAlgorithm.getA1()?.get(i)?.get(j))
               }
               println()
           }

           println("\n\nA2 matrix")
           for (i in 0..2) {
               for (j in 0..3) {
                   System.out.printf("%4d ", immuneAlgorithm.getA2()?.get(i)?.get(j))
               }
               println()
           }

           println("\n\nA3 matrix")
           for (i in 0..2) {
               for (j in 0..3) {
                   System.out.printf("%4d ", immuneAlgorithm.getA3()?.get(i)?.get(j))
               }
               println()
           }

           println("\n\nA4 matrix")
           for (i in 0..2) {
               for (j in 0..3) {
                   System.out.printf("%4d ", immuneAlgorithm.getA4()?.get(i)?.get(j))
               }
               println()
           }

           println("\n\nA5 matrix")
           for (i in 0..2) {
               for (j in 0..3) {
                   System.out.printf("%4d ", immuneAlgorithm.getA5()?.get(i)?.get(j))
               }
               println()
           }

           println("\n\nA6 matrix")
           for (i in 0..2) {
               for (j in 0..3) {
                   System.out.printf("%4d ", immuneAlgorithm.getA6()?.get(i)?.get(j))
               }
               println()
           }

           println("\n\nA7 matrix")
           for (i in 0..2) {
               for (j in 0..3) {
                   System.out.printf("%4d ", immuneAlgorithm.getA7()?.get(i)?.get(j))
               }
               println()
           }

           println("\n\nM matrix")
           for (i in 0..2) {
               for (j in 0..3) {
                   System.out.printf("%4d ", immuneAlgorithm.getM()?.get(i)?.get(j))
               }
               println()
           }
       }
   }
}