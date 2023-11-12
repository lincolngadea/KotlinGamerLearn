package br.com.kotlin.learning.model

import java.time.LocalDate
import java.time.Period

data class RentalPeriod(
    val startDate: LocalDate,
    val endDate: LocalDate
){
    val inDays = Period.between(startDate,endDate).days
}
