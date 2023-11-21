import br.com.kotlin.learning.entities.GameEntity
import br.com.kotlin.learning.model.Game

fun Game.toEntity(): GameEntity{
    return GameEntity(this.id,this.thumb,this.description,this.price,this.title)
}

fun GameEntity.toModel(): Game{
    return Game(this.titulo,this.capa,this.preco,this.descricao,this.id)
}