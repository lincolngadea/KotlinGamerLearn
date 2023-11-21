package br.com.kotlin.learning.repository

import javax.persistence.EntityManager

abstract class DAO <TModel, TEntity>(protected val manager: EntityManager, protected  val entityType:Class<TEntity>) {
    abstract fun toEntity(model: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel
    open fun getModelList(): List<TModel> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        val objectEntity = query.resultList
        return objectEntity.map { entity ->
            toModel(entity)
        }
    }
    open fun addEntity(anyObject: TModel){
        val entity = toEntity(anyObject)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun getModelFromId(id: Int): TModel{
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id",entityType)
        query.setParameter("id",id)
        val entity = query.singleResult
        return toModel(entity)
    }

    open fun deleteModel(id:Int){
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id",entityType)
        query.setParameter("id",id)
        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }
}