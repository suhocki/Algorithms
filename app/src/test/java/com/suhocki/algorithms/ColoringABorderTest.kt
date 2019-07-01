package com.suhocki.algorithms

import org.junit.Test

import org.junit.Assert.*

class ColoringABorderTest {
    private val pen = ColoringABorder()

    @Test
    fun test1() {
        // Given
        val grid = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 2)
        )
        val r0 = 0
        val c0 = 0
        val color = 3

        // When
        val answer = pen.colorBorder(grid, r0, c0, color)

        // Then
        assert(
            answer.contentDeepEquals(
                arrayOf(
                    intArrayOf(3, 3),
                    intArrayOf(3, 2)
                )
            )
        )
    }

    @Test
    fun test2() {
        // Given
        val grid = arrayOf(
            intArrayOf(1, 2, 2),
            intArrayOf(2, 3, 2)
        )
        val r0 = 0
        val c0 = 1
        val color = 3

        // When
        val answer = pen.colorBorder(grid, r0, c0, color)

        // Then
        assert(
            answer.contentDeepEquals(
                arrayOf(
                    intArrayOf(1, 3, 3),
                    intArrayOf(2, 3, 3)
                )
            )
        )
    }

    @Test
    fun test3() {
        // Given
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        val r0 = 1
        val c0 = 1
        val color = 2

        // When
        val answer = pen.colorBorder(grid, r0, c0, color)

        // Then
        assert(
            answer.contentDeepEquals(
                arrayOf(
                    intArrayOf(2, 2, 2),
                    intArrayOf(2, 1, 2),
                    intArrayOf(2, 2, 2)
                )
            )
        )
    }

    @Test
    fun test4() {
        // Given
        val grid = arrayOf(
            intArrayOf(1,2,1,2,2,2),
            intArrayOf(2,2,1,1,1,1),
            intArrayOf(2,1,2,1,2,1),
            intArrayOf(2,1,2,1,2,1),
            intArrayOf(1,1,1,2,1,2),
            intArrayOf(2,1,2,2,1,2)
        )
        val r0 = 3
        val c0 = 3
        val color = 1

        // When
        val answer = pen.colorBorder(grid, r0, c0, color)

        // Then
        assert(
            answer.contentDeepEquals(
                arrayOf(
                    intArrayOf(1,2,1,2,2,2),
                    intArrayOf(2,2,1,1,1,1),
                    intArrayOf(2,1,2,1,2,1),
                    intArrayOf(2,1,2,1,2,1),
                    intArrayOf(1,1,1,2,1,2),
                    intArrayOf(2,1,2,2,1,2)
                )
            )
        )
    }
}
