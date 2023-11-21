import br.com.kotlin.learning.entities.PlayerEntity
import br.com.kotlin.learning.model.Player

fun Player.toEntity(): PlayerEntity{
    return PlayerEntity(this.id,this.birthDay,this.email,this.name,this.user!!,this.plan.toEntity())
}

fun PlayerEntity.toModel(): Player{
    return Player(this.nome,this.email,this.aniversario,this.usuario)
}
