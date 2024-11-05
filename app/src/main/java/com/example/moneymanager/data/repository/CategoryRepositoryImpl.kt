package com.example.moneymanager.data.repository

import com.example.moneymanager.data.local.database.dao.CategoryDao
import com.example.moneymanager.data.local.model.CategoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val categoryDao: CategoryDao) :
    CategoryRepository {
    override suspend fun insertCategory(category: CategoryEntity) {
        categoryDao.insertCategory(category)
    }

    override suspend fun updateCategory(category: CategoryEntity) {
        categoryDao.updateCategory(category)
    }

    override suspend fun deleteCategory(category: CategoryEntity) {
        categoryDao.deleteCategory(category)
    }

    override fun getAllCategories(): Flow<List<CategoryEntity>> {
        return categoryDao.getAllCategories()
    }

    /**
    val defaultCategories = listOf(
        CategoryEntity(name = "Food", isDefault = true),
        CategoryEntity(name = "Transport", isDefault = true),
        CategoryEntity(name = "Shopping", isDefault = true)
    )

    suspend fun initializeDefaultCategories() {
        if (categoryDao.getAllCategories().isEmpty()) {
            defaultCategories.forEach { categoryDao.insertCategory(it) }
        }
    }
    */
}