package com.example.immuneproject.immune

import java.lang.reflect.Constructor

class SvdValues {

    private var Un = DoubleArray(8)
    private var Vn = DoubleArray(12)
    private var Sn = 0.0

    constructor(Un: DoubleArray, Vn: DoubleArray, Sn: Double) {
        this.Un = Un
        this.Vn = Vn
        this.Sn = Sn
    }


    fun setUn(un: DoubleArray) {
        Un = un
    }

    fun setVn(vn: DoubleArray) {
        Vn = vn
    }

    fun setSn(sn: Double) {
        Sn = sn
    }

    fun getUn(): DoubleArray? {
        return Un
    }

    fun getVn(): DoubleArray? {
        return Vn
    }

    fun getSn(): Double {
        return Sn
    }
}