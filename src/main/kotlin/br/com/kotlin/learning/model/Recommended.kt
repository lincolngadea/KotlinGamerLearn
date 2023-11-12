package br.com.kotlin.learning.model

interface Recommended {
    val gradeAverage: Double
    fun toRecommend(grade: Double)
}