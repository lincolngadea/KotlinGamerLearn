package br.com.kotlin.learning.entities

import javax.persistence.*

@Entity
@Table(name = "players")
data class PlayerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val aniversario: String? = null,
    val email: String = "email@email",
    val nome: String = "Nome",
    val usuario: String = "Usuario",
    @ManyToOne
    val plano: PlanEntity = PlanStandardEntity()
)