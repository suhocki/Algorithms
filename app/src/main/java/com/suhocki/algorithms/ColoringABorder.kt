package com.suhocki.algorithms

import java.util.*

/**
 * https://leetcode.com/problems/coloring-a-border/
 */
class ColoringABorder {
    fun colorBorder(grid: Array<IntArray>, r0: Int, c0: Int, color: Int): Array<IntArray> {
        val ourColor = grid[r0][c0]
        val xMax = grid.first().lastIndex
        val yMax = grid.lastIndex
        val isBorder = Array(grid.size) { BooleanArray(grid.first().size) }
        val traversedRight = Array(grid.size) { BooleanArray(grid.first().size) }
        val traversedBottom = Array(grid.size) { BooleanArray(grid.first().size) }
        val traversedLeft = Array(grid.size) { BooleanArray(grid.first().size) }
        val traversedTop = Array(grid.size) { BooleanArray(grid.first().size) }
        val notTraversedPoints = LinkedList<Pair<Int, Int>>().apply { add(r0 to c0) }

        while (notTraversedPoints.isNotEmpty()) {
            var (i, j) = notTraversedPoints.pop()

            // region Traverse to top
            /**
             * Traverse to top
             */
            var wasInTraverseToTopLoop = false
            while (i in 0..yMax && j in 0..xMax && grid[i][j] == ourColor && !traversedTop[i][j]) {
                wasInTraverseToTopLoop = true
                // region Traverse to left
                /**
                 * Traverse to left
                 */
                var wasInTraverseToLeftLoop = false
                while (i in 0..yMax && j in 0..xMax && grid[i][j] == ourColor && !traversedLeft[i][j]) {
                    wasInTraverseToLeftLoop = true
                    // region Traverse to bottom
                    /**
                     * Traverse to bottom
                     */
                    var wasInTraverseToBottomLoop = false
                    while (i in 0..yMax && j in 0..xMax && grid[i][j] == ourColor && !traversedBottom[i][j]) {
                        wasInTraverseToBottomLoop = true
                        // region Traverse to right
                        /**
                         * Traverse to right
                         */
                        var wasInTraverseToRightLoop = false
                        while (i in 0..yMax && j in 0..xMax && grid[i][j] == ourColor && !traversedRight[i][j]) {
                            wasInTraverseToRightLoop = true
                            traversedRight[i][j] = true
                            if (!traversedBottom[i][j] || !traversedLeft[i][j] || !traversedTop[i][j]) {

                            }
                            j++
                        }
                        if (wasInTraverseToRightLoop) {
                            j--
                        }
                        isBorder[i][j] = true
                        // endregion

                        traversedBottom[i][j] = true
                        i++
                    }
                    if (wasInTraverseToBottomLoop) {
                        i--
                    }
                    isBorder[i][j] = true
                    // endregion

                    traversedLeft[i][j] = true
                    j--
                }
                if (wasInTraverseToLeftLoop) {
                    j++
                }
                isBorder[i][j] = true
                // endregion

                traversedTop[i][j] = true
                i--
            }
            if (wasInTraverseToTopLoop) {
                i++
            }
            isBorder[i][j] = true
            // endregion

            if (notTraversedPoints.isEmpty()) {
                addNotTraversedPoints(
                    notTraversedPoints,
                    traversedRight,
                    traversedBottom,
                    traversedLeft,
                    traversedTop
                )
            }
        }


        /**
         * Color border
         */
        for (i in 0..yMax) {
            for (j in 0..xMax) {
                if (isBorder[i][j] && !isSurroundedByTrue(isBorder, i, j)) {
                    grid[i][j] = color
                }
            }
        }

        return grid
    }

    private fun addNotTraversedPoints(
        notTraversedPoints: Queue<Pair<Int, Int>>,
        traversedRight: Array<BooleanArray>,
        traversedBottom: Array<BooleanArray>,
        traversedLeft: Array<BooleanArray>,
        traversedTop: Array<BooleanArray>
    ) {
        for (i in 0..traversedRight.lastIndex) {
            for (j in 0..traversedRight.first().lastIndex) {
                if ((traversedBottom[i][j] || traversedLeft[i][j] || traversedTop[i][j] || traversedRight[i][j]) &&
                    (!traversedBottom[i][j] || !traversedLeft[i][j] || !traversedTop[i][j] || !traversedRight[i][j])
                ) {
                    notTraversedPoints.add(i to j)
                }
            }
        }
    }

    private fun isSurroundedByTrue(booleanGrid: Array<BooleanArray>, i: Int, j: Int): Boolean {
        val iMax = booleanGrid.lastIndex
        val jMax = booleanGrid.first().lastIndex
        return if (i in 1 until iMax && j in 1 until jMax) {
            booleanGrid[i - 1][j] &&
                    booleanGrid[i][j - 1] &&
                    booleanGrid[i + 1][j] &&
                    booleanGrid[i][j + 1]
        } else {
            false
        }
    }
}