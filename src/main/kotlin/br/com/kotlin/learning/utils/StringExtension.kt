package br.com.kotlin.learning.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformaData(): Int{
    val dateFormated = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val birthDay = LocalDate.parse(this,dateFormated)
    val today = LocalDate.now()

    return Period.between(birthDay,today).years
}