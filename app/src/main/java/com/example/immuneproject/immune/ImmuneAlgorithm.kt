package com.example.immuneproject.immune

class ImmuneAlgorithm {
    private val A = Array(8) {
        IntArray(
            12
        )
    }
    private val y = IntArray(8)
    private val A0 = Array(3) {
        IntArray(
            4
        )
    }
    private val A1 = Array(3) {
        IntArray(
            4
        )
    }
    private val A2 = Array(3) {
        IntArray(
            4
        )
    }
    private val A3 = Array(3) {
        IntArray(
            4
        )
    }
    private val A4 = Array(3) {
        IntArray(
            4
        )
    }
    private val A5 = Array(3) {
        IntArray(
            4
        )
    }
    private val A6 = Array(3) {
        IntArray(
            4
        )
    }
    private val A7 = Array(3) {
        IntArray(
            4
        )
    }
    private val M = Array(3) {
        IntArray(
            4
        )
    }

    private val function: SvdFunction = SvdFunction()

    private val immuneResult: ImmuneResult = ImmuneResult()

    fun ImmuneAlgorithm() {
        fillMassive()
        setDataToY()
        Display.showMassive(A)
        creatingChildMatrix()
    }


    private fun setDataToY() {
        for (i in 0..7) {
            y[i] = i + 1
        }
    }


    private fun fillMassive() {
        for (i in 0..7) {
            for (j in 0..11) {
                A[i][j] = (Math.random() * 10).toInt()
            }
        }
        Initialization.setInitialValues(A)
    }


    private fun creatingChildMatrix() {
        var pointer0 = 0
        var pointer1 = 0
        var pointer2 = 0
        var pointer3 = 0
        var pointer4 = 0
        var pointer5 = 0
        var pointer6 = 0
        var pointer7 = 0

        for (i in 0..2) {
            for (j in 0..3) {
                A0[i][j] = A[0][pointer0]
                pointer0++
            }
        }

        for (i in 0..2) {
            for (j in 0..3) {
                A1[i][j] = A[1][pointer1]
                pointer1++
            }
        }

        for (i in 0..2) {
            for (j in 0..3) {
                A2[i][j] = A[2][pointer2]
                pointer2++
            }
        }

        for (i in 0..2) {
            for (j in 0..3) {
                A3[i][j] = A[3][pointer3]
                pointer3++
            }
        }

        for (i in 0..2) {
            for (j in 0..3) {
                A4[i][j] = A[4][pointer4]
                pointer4++
            }
        }

        for (i in 0..2) {
            for (j in 0..3) {
                A5[i][j] = A[5][pointer5]
                pointer5++
            }
        }

        for (i in 0..2) {
            for (j in 0..3) {
                A6[i][j] = A[6][pointer6]
                pointer6++
            }
        }

        for (i in 0..2) {
            for (j in 0..3) {
                A7[i][j] = A[7][pointer7]
                pointer7++
            }
        }

        Initialization.setInitialValuesForMatrixM(M)
    }


    fun svdStart() {
        val svd: SvdValues? = function.calculateSVD(M)
        print("\n\nVn ->")
        val vn = svd?.getVn()
        vn?.forEach {
            print(" $it")
        }

        println()
        print("Un -> ")
        val un = svd?.getUn()
        un?.forEach {
            print(" $it")
        }

        println()
        System.out.println("Sn ->" + svd?.getSn())

    }

    fun getResultOfImmuneAlgorithm(): Int {
        return immuneResult.calculateOmega(this)
    }

    fun getA(): Array<IntArray>? {
        return A
    }

    fun getY(): IntArray? {
        return y
    }

    fun getA0(): Array<IntArray>? {
        return A0
    }

    fun getA1(): Array<IntArray>? {
        return A1
    }

    fun getA2(): Array<IntArray>? {
        return A2
    }

    fun getA3(): Array<IntArray>? {
        return A3
    }

    fun getA4(): Array<IntArray>? {
        return A4
    }

    fun getA5(): Array<IntArray>? {
        return A5
    }

    fun getA6(): Array<IntArray>? {
        return A6
    }

    fun getA7(): Array<IntArray>? {
        return A7
    }

    fun getM(): Array<IntArray>? {
        return M
    }

    fun getFunction(): SvdFunction? {
        return function
    }
}