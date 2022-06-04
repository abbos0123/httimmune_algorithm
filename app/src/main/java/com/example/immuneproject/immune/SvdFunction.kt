package com.example.immuneproject.immune

class SvdFunction {

    private val U0 = doubleArrayOf(1.0, 1.0, 1.0)
    private val V0 = doubleArrayOf(1.0, 1.0, 1.0, 1.0)
    private var S0 = 0.0
    private val epsilon = 0.01

    fun SvdFunction() {}

    fun calculateSVD(massive: Array<IntArray>): SvdValues? {
        setS0(massive)
        return findSVU(massive)
    }

    private fun setS0(massive: Array<IntArray>) {
        val m: Int = massive[0].size
        for (ints in massive) {
            for (j in 0 until m) {
                S0 += ints[j]
            }
        }
    }

    private fun findSVU(massive: Array<IntArray>): SvdValues? {
        var Sn_1 = S0
        var Un_1 = U0
        var Un_1T: DoubleArray? = U0
        var Vn_1: DoubleArray? = V0
        var Vn_1T: DoubleArray? = V0

        var Sn = 0.0
        val Un = DoubleArray(3)
        val UnT = DoubleArray(3)
        val Vn = DoubleArray(4)
        val VnT = DoubleArray(4)
        var n = 0

        while (true) {
            VnT[0] = Un_1[0] * massive[0][0] + Un_1[1] * massive[1][0] + Un_1[2] * massive[2][0]
            VnT[1] = Un_1[0] * massive[0][1] + Un_1[1] * massive[1][1] + Un_1[2] * massive[2][1]
            VnT[2] = Un_1[0] * massive[0][2] + Un_1[1] * massive[1][2] + Un_1[2] * massive[2][2]
            VnT[3] = Un_1[0] * massive[0][3] + Un_1[1] * massive[1][3] + Un_1[2] * massive[2][3]
            val Vnorm = findNormalValue(VnT)

            for (i in 0..3) {
                Vn[i] = VnT[i] / Vnorm
            }

            Un[0] = massive[0][0] * Vn[0] + massive[0][1] * Vn[1] + massive[0][2] * Vn[2] + massive[0][3] * Vn[3]
            Un[1] = massive[1][0] * Vn[0] + massive[1][1] * Vn[1] + massive[1][2] * Vn[2] + massive[1][3] * Vn[3]
            Un[2] = massive[2][0] * Vn[0] + massive[2][1] * Vn[1] + massive[2][2] * Vn[2] + massive[2][3] * Vn[3]
            val Unorm = findNormalValue(Un)

            for (i in 0..2) {
                Un[i] = Un[i] / Unorm
            }

            val temp = DoubleArray(4)

            temp[0] = Un[0] * massive[0][0] + Un[1] * massive[1][0] + Un[2] * massive[2][0]
            temp[1] = Un[0] * massive[0][1] + Un[1] * massive[1][1] + Un[2] * massive[2][1]
            temp[2] = Un[0] * massive[0][2] + Un[1] * massive[1][2] + Un[2] * massive[2][2]
            temp[3] = Un[0] * massive[0][3] + Un[1] * massive[1][3] + Un[2] * massive[2][3]

            Sn = temp[0] * Vn[0] + temp[1] * Vn[1] + temp[2] * Vn[2] + temp[3] * Vn[3]

            if (Math.abs(Sn - Sn_1) >= epsilon) {
                Un_1 = Un
                Un_1T = UnT
                Vn_1 = Vn
                Vn_1T = VnT
                Sn_1 = Sn
                Sn = 0.0
            } else {
                break
            }

            if (++n > 100) break
        }

        return SvdValues(Un, Vn, Sn)
    }


    private fun findNormalValue(vector: DoubleArray): Double {
        var sum = 0

        for (v in vector) {
            sum += (v * v).toInt()
        }

        return Math.sqrt(sum.toDouble())
    }

}