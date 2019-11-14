package com.suhocki.algorithms.codingInterviewToReddit


class Anagram {
    fun getMinimumDifference(a: List<String>, b: List<String>): Array<Int> {
        val answer = mutableListOf<Int>()

        for (i in a.indices) {
            val first = a[i]
            val second = b[i]

            if (first.length != second.length) {
                answer.add(-1)
                continue
            }

            val charsCount = IntArray(26)
            for (element in first) {
                ++charsCount[element - 'a']
            }

            var count = 0
            for (element in second) {
                if (--charsCount[element - 'a'] < 0) {
                    ++count
                }
            }
            answer.add(count)
        }

        return answer.toTypedArray()
    }
}