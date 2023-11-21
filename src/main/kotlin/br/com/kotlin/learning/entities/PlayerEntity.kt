package br.com.kotlin.learning.entities

import org.hibernate.engine.internal.Cascade
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
    var plano: PlanEntity = PlanStandardEntity()
)