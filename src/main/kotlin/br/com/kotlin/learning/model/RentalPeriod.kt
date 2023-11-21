package br.com.kotlin.learning.model

import java.time.LocalDate
import java.time.Period
import javax.persistence.Embeddable

@Embeddable
data class RentalPeriod(
    val startDate: LocalDate = LocalDate.now(),
    val endDate: LocalDate = LocalDate.now().plusDays(7)
){
    val inDays = Period.between(startDate,endDate).days
}
