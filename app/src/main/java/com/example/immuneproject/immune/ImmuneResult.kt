package com.example.immuneproject.immune

class ImmuneResult {
    private var U0: DoubleArray? = DoubleArray(3)
    private var U1: DoubleArray? = DoubleArray(3)
    private var U2: DoubleArray? = DoubleArray(3)
    private var U3: DoubleArray? = DoubleArray(3)
    private var U4: DoubleArray? = DoubleArray(3)
    private var U5: DoubleArray? = DoubleArray(3)
    private var U6: DoubleArray? = DoubleArray(3)
    private var U7: DoubleArray? = DoubleArray(3)

    private var V0: DoubleArray? = DoubleArray(4)
    private var V1: DoubleArray? = DoubleArray(4)
    private var V2: DoubleArray? = DoubleArray(4)
    private var V3: DoubleArray? = DoubleArray(4)
    private var V4: DoubleArray? = DoubleArray(4)
    private var V5: DoubleArray? = DoubleArray(4)
    private var V6: DoubleArray? = DoubleArray(4)
    private var V7: DoubleArray? = DoubleArray(4)


    private var omega0 = 0.0
    private var omega1 = 0.0
    private var omega2 = 0.0
    private var omega3 = 0.0
    private var omega4 = 0.0
    private var omega5 = 0.0
    private var omega6 = 0.0
    private var omega7 = 0.0


    fun calculateOmega(immuneAlgorithm: ImmuneAlgorithm): Int {
        setValues(immuneAlgorithm)
        setOmegaValues(immuneAlgorithm.getM())
        return getOmegaResult()
    }

    private fun setValues(immuneAlgorithm: ImmuneAlgorithm) {

        val svd0 = immuneAlgorithm.getFunction()!!.calculateSVD(immuneAlgorithm.getA0()!!)
        U0 = svd0!!.getUn()
        V0 = svd0.getVn()

        val svd1 = immuneAlgorithm.getFunction()!!.calculateSVD(immuneAlgorithm.getA1()!!)
        U1 = svd1!!.getUn()
        V1 = svd1.getVn()

        val svd2 = immuneAlgorithm.getFunction()!!.calculateSVD(immuneAlgorithm.getA2()!!)
        U2 = svd2!!.getUn()
        V2 = svd2.getVn()

        val svd3 = immuneAlgorithm.getFunction()!!.calculateSVD(immuneAlgorithm.getA3()!!)
        U3 = svd3!!.getUn()
        V3 = svd3.getVn()

        val svd4 = immuneAlgorithm.getFunction()!!.calculateSVD(immuneAlgorithm.getA4()!!)
        U4 = svd4!!.getUn()
        V4 = svd4.getVn()

        val svd5 = immuneAlgorithm.getFunction()!!.calculateSVD(immuneAlgorithm.getA5()!!)
        U5 = svd5!!.getUn()
        V5 = svd5.getVn()

        val svd6 = immuneAlgorithm.getFunction()!!.calculateSVD(immuneAlgorithm.getA6()!!)
        U6 = svd6!!.getUn()
        V6 = svd6.getVn()

        val svd7 = immuneAlgorithm.getFunction()!!.calculateSVD(immuneAlgorithm.getA7()!!)
        U7 = svd7!!.getUn()
        V7 = svd7.getVn()
    }

    private fun setOmegaValues(massiveM: Array<IntArray>?) {

        var temp = DoubleArray(4)
        temp[0] = U0!![0] * massiveM!![0][0] + U0!![1] * massiveM[1][0] + U0!![2] * massiveM[2][0]
        temp[1] = U0!![0] * massiveM[0][1] + U0!![1] * massiveM[1][1] + U0!![2] * massiveM[2][1]
        temp[2] = U0!![0] * massiveM[0][2] + U0!![1] * massiveM[1][2] + U0!![2] * massiveM[2][2]
        temp[3] = U0!![0] * massiveM[0][3] + U0!![1] * massiveM[1][3] + U0!![2] * massiveM[2][3]
        omega0 = -(temp[0] * V0!![0] + temp[1] * V0!![1] + temp[2] * V0!![2] + temp[3] * V0!![3])

        temp = DoubleArray(4)
        temp[0] = U1!![0] * massiveM[0][0] + U1!![1] * massiveM[1][0] + U1!![2] * massiveM[2][0]
        temp[1] = U1!![0] * massiveM[0][1] + U1!![1] * massiveM[1][1] + U1!![2] * massiveM[2][1]
        temp[2] = U1!![0] * massiveM[0][2] + U1!![1] * massiveM[1][2] + U1!![2] * massiveM[2][2]
        temp[3] = U1!![0] * massiveM[0][3] + U1!![1] * massiveM[1][3] + U1!![2] * massiveM[2][3]
        omega1 = -(temp[0] * V1!![0] + temp[1] * V1!![1] + temp[2] * V1!![2] + temp[3] * V1!![3])

        temp = DoubleArray(4)
        temp[0] = U2!![0] * massiveM[0][0] + U2!![1] * massiveM[1][0] + U2!![2] * massiveM[2][0]
        temp[1] = U2!![0] * massiveM[0][1] + U2!![1] * massiveM[1][1] + U2!![2] * massiveM[2][1]
        temp[2] = U2!![0] * massiveM[0][2] + U2!![1] * massiveM[1][2] + U2!![2] * massiveM[2][2]
        temp[3] = U2!![0] * massiveM[0][3] + U2!![1] * massiveM[1][3] + U2!![2] * massiveM[2][3]
        omega2 = -(temp[0] * V2!![0] + temp[1] * V2!![1] + temp[2] * V2!![2] + temp[3] * V2!![3])

        temp = DoubleArray(4)
        temp[0] = U3!![0] * massiveM[0][0] + U3!![1] * massiveM[1][0] + U3!![2] * massiveM[2][0]
        temp[1] = U3!![0] * massiveM[0][1] + U3!![1] * massiveM[1][1] + U3!![2] * massiveM[2][1]
        temp[2] = U3!![0] * massiveM[0][2] + U3!![1] * massiveM[1][2] + U3!![2] * massiveM[2][2]
        temp[3] = U3!![0] * massiveM[0][3] + U3!![1] * massiveM[1][3] + U3!![2] * massiveM[2][3]
        omega3 = -(temp[0] * V3!![0] + temp[1] * V3!![1] + temp[2] * V3!![2] + temp[3] * V3!![3])

        temp = DoubleArray(4)
        temp[0] = U4!![0] * massiveM[0][0] + U4!![1] * massiveM[1][0] + U4!![2] * massiveM[2][0]
        temp[1] = U4!![0] * massiveM[0][1] + U4!![1] * massiveM[1][1] + U4!![2] * massiveM[2][1]
        temp[2] = U4!![0] * massiveM[0][2] + U4!![1] * massiveM[1][2] + U4!![2] * massiveM[2][2]
        temp[3] = U4!![0] * massiveM[0][3] + U4!![1] * massiveM[1][3] + U4!![2] * massiveM[2][3]
        omega4 = -(temp[0] * V4!![0] + temp[1] * V4!![1] + temp[2] * V4!![2] + temp[3] * V4!![3])

        temp = DoubleArray(4)
        temp[0] = U5!![0] * massiveM[0][0] + U5!![1] * massiveM[1][0] + U5!![2] * massiveM[2][0]
        temp[1] = U5!![0] * massiveM[0][1] + U5!![1] * massiveM[1][1] + U5!![2] * massiveM[2][1]
        temp[2] = U5!![0] * massiveM[0][2] + U5!![1] * massiveM[1][2] + U5!![2] * massiveM[2][2]
        temp[3] = U5!![0] * massiveM[0][3] + U5!![1] * massiveM[1][3] + U5!![2] * massiveM[2][3]
        omega5 = -(temp[0] * V5!![0] + temp[1] * V5!![1] + temp[2] * V5!![2] + temp[3] * V5!![3])

        temp = DoubleArray(4)
        temp[0] = U6!![0] * massiveM[0][0] + U6!![1] * massiveM[1][0] + U6!![2] * massiveM[2][0]
        temp[1] = U6!![0] * massiveM[0][1] + U6!![1] * massiveM[1][1] + U6!![2] * massiveM[2][1]
        temp[2] = U6!![0] * massiveM[0][2] + U6!![1] * massiveM[1][2] + U6!![2] * massiveM[2][2]
        temp[3] = U6!![0] * massiveM[0][3] + U6!![1] * massiveM[1][3] + U6!![2] * massiveM[2][3]
        omega6 = -(temp[0] * V6!![0] + temp[1] * V6!![1] + temp[2] * V6!![2] + temp[3] * V6!![3])

        temp = DoubleArray(4)
        temp[0] = U7!![0] * massiveM[0][0] + U7!![1] * massiveM[1][0] + U7!![2] * massiveM[2][0]
        temp[1] = U7!![0] * massiveM[0][1] + U7!![1] * massiveM[1][1] + U7!![2] * massiveM[2][1]
        temp[2] = U7!![0] * massiveM[0][2] + U7!![1] * massiveM[1][2] + U7!![2] * massiveM[2][2]
        temp[3] = U7!![0] * massiveM[0][3] + U7!![1] * massiveM[1][3] + U7!![2] * massiveM[2][3]
        omega7 = -(temp[0] * V7!![0] + temp[1] * V7!![1] + temp[2] * V7!![2] + temp[3] * V7!![3])
    }

    private fun getOmegaResult(): Int {
        if (omega0 < omega1 && omega0 < omega2 && omega0 < omega3 && omega0 < omega4 && omega0 < omega5 && omega0 < omega6 && omega0 < omega7) return 0
        else if (omega1 < omega0 && omega1 < omega2 && omega1 < omega3 && omega1 < omega4 && omega1 < omega5 && omega1 < omega6 && omega1 < omega7) return 1
        else if (omega2 < omega0 && omega2 < omega1 && omega2 < omega3 && omega2 < omega4 && omega2 < omega5 && omega2 < omega6 && omega2 < omega7) return 2
        else if (omega3 < omega0 && omega3 < omega1 && omega3 < omega2 && omega3 < omega4 && omega3 < omega5 && omega3 < omega6 && omega3 < omega7) return 3
        else if (omega4 < omega0 && omega4 < omega1 && omega4 < omega2 && omega4 < omega3 && omega4 < omega5 && omega4 < omega6 && omega4 < omega7) return 4
        else if (omega5 < omega0 && omega5 < omega1 && omega5 < omega2 && omega5 < omega3 && omega5 < omega4 && omega5 < omega6 && omega5 < omega7) return 5
        else if (omega6 < omega0 && omega6 < omega1 && omega6 < omega2 && omega6 < omega3 && omega6 < omega4 && omega6 < omega5 && omega6 < omega7) return 6
        return if (omega7 < omega0 && omega7 < omega1 && omega7 < omega2 && omega7 < omega3 && omega7 < omega4 && omega7 < omega5 && omega7 < omega6) 7 else -1
    }

}