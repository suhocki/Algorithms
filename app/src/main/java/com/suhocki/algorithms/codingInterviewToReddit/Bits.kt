package com.suhocki.algorithms.codingInterviewToReddit

class Bits {
    fun getOneBits(n: Int): Array<Int> {
        var n = n
        var counter = 0
        var currentPosition = 0
        val l = mutableListOf<Int>()
        while (n > 0) {
            if (n and 1 == 1) {
                counter += 1
                l.add(currentPosition)
            }
            n = n shr 1
            ++currentPosition
        }

        val allPos = currentPosition

        val res = mutableListOf<Int>(counter)
        for (i in l.indices.reversed()) {
            res.add(allPos - l[i])
        }

        return res.toTypedArray()
    }
}