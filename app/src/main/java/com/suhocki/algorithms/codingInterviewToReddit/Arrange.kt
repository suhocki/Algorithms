package com.suhocki.algorithms.codingInterviewToReddit

class Arrange {
    fun arrange(sentence: String): String {
        return sentence.replace(".", " ")
            .split(' ')
            .filter { it.isNotBlank() }
            .sortedWith(compareBy { it.length })
            .mapIndexed { index, s -> if (index == 0) s.capitalize() else s.decapitalize() }
            .joinToString(" ") + '.'
    }
}