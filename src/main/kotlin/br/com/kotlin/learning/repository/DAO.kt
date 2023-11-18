package br.com.kotlin.learning.repository

import javax.persistence.EntityManager

abstract class DAO <TModel, TEntity>(protected val manager: EntityManager, protected  val entityType:Class<TEntity>) {
    abstract fun toEntity(model: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel
    open fun getModelList(): List<TModel> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        val objectEntity = query.resultList
        return objectEntity.map { entity -> toModel(entity) }
    }
    open fun addEntity(anyObject: TModel){
        val entity = toEntity(anyObject)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}