package com.valery.myapplication.repository


interface Repository<Model> {

    fun insert(model: Model): Model

    fun insert(models: List<Model>): List<Model>

    fun replace(model: Model): Model

    fun replace(models: List<Model>): List<Model>

    fun get(limit: Int = 20, offset: Int = 0): List<Model>

    fun getById(id: String): Model?

    fun get(): Model?

    fun getAll(): List<Model>

    fun removeAll(): Int

    fun count(): Int
}

/**
 * This implementation will be changed later. For now this is just a mockup.
 */
abstract class BaseRepositoryImpl<Model> : Repository<Model> {
    override fun insert(model: Model): Model {
        return model
    }

    override fun insert(models: List<Model>): List<Model> {
        return models
    }

    override fun replace(model: Model): Model {
        return model
    }

    override fun replace(models: List<Model>): List<Model> {
        return models
    }

    override fun get(limit: Int, offset: Int): List<Model> {
        return emptyList()
    }

    override fun getById(id: String): Model? {
        return null
    }

    override fun get(): Model? {
        return null
    }

    override fun getAll(): List<Model> {
        return emptyList()
    }

    override fun removeAll(): Int {
        return 0
    }

    override fun count(): Int {
        return 0
    }

}