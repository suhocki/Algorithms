package com.suhocki.algorithms

import com.suhocki.algorithms.codingInterviewToReddit.Anagram
import org.junit.Test

class AnagramTest {
    private val anagram = Anagram()

    @Test
    fun test() {
        val actual = anagram.getMinimumDifference(
            listOf("a", "jk", "abb", "mn", "abc"),
            listOf("bb", "kj", "bbc", "op", "def")
        )

        assert(arrayOf(-1, 0, 1, 2, 3).contentEquals(actual)) { "${actual.toIntArray()}" }
    }
}