package br.com.kotlin.learning.entities

import br.com.kotlin.learning.model.RentalPeriod
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "aluguel")
data class RentEntity(
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    val player: PlayerEntity = PlayerEntity(),
    @ManyToOne
    val game: GameEntity = GameEntity(),
    @Embedded
    val period: RentalPeriod = RentalPeriod(),
) {
    var rentValue: BigDecimal = BigDecimal(0.0)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
}