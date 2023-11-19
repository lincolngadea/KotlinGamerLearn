package br.com.kotlin.learning.entities

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PlanType", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(
    val type: String = "Entity Plan",
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
)
@Entity
@DiscriminatorValue("Standard")
class PlanStandardEntity(
    type: String = "Standard Plan",
    id: Int = 0
): PlanEntity(type,id)
@Entity
@DiscriminatorValue("Assign")
class PlanAssignEntity(
    type: String = "Assign Plan",
    val monthPayment: Double = 0.0,
    val discountPercentage: BigDecimal = BigDecimal(0.0),
    val gameIncludes: Int = 0,
    id: Int = 0) : PlanEntity(type,id)