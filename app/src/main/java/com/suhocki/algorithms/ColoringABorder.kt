package com.suhocki.algorithms

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
        var i = r0
        var j = c0

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

        /**
         * Color border
         */
        for (i in 0..yMax) {
            for (j in 0..xMax) {
                if (isBorder[i][j] && !isRoundedByTrue(isBorder, i, j)) {
                    grid[i][j] = color
                }
            }
        }

        return grid
    }

    private fun isRoundedByTrue(booleanGrid: Array<BooleanArray>, i: Int, j: Int): Boolean {
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