package com.suhocki.algorithms

import com.suhocki.algorithms.codingInterviewToReddit.Arrange
import org.junit.Test

class ArrangeTest {

    private val arrange= Arrange()

    @Test
    fun test1() {
        val expected = "I here come."
        val actual = arrange.arrange("Here i come.")
        assert(expected == actual) { "Expected: $expected != $actual"}
    }
}