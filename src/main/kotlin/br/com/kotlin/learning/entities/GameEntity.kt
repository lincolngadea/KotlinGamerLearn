package br.com.kotlin.learning.entities

import javax.persistence.*

@Entity
@Table(name = "jogos")
data class GameEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val capa: String = "capa",
    val descricao: String = "descrição",
    val preco: Double = 0.0,
    val titulo: String = "titulo"
)
