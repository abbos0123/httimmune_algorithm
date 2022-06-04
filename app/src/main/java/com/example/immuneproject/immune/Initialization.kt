package com.example.immuneproject.immune

class Initialization {
   companion object{
       fun setInitialValues(massive: Array<IntArray>) {
           var n = -1
           for (i in massive.indices) {
               for (j in 0 until massive[0].size) {
                   massive[i][j] = ++n
               }
           }
       }

       fun setInitialValuesForMatrixM(massive: Array<IntArray>) {
           var n = 11
           for (i in massive.indices) {
               for (j in 0 until massive[0].size) {
                   massive[i][j] = ++n
               }
           }
       }

   }
}