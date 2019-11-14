package com.suhocki.algorithms

import com.suhocki.algorithms.codingInterviewToReddit.Bits
import org.junit.Test

class BitsTest {
    private val bits = Bits()

    @Test
    fun getOneBits() {
        val actual = bits.getOneBits(161)
        assert(arrayOf(3, 1, 3, 8).contentEquals(actual)) { "${actual.toIntArray()}"}
    }
}