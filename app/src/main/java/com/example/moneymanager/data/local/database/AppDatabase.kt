package com.example.moneymanager.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moneymanager.data.local.database.dao.BudgetDao
import com.example.moneymanager.data.local.database.dao.CategoryDao
import com.example.moneymanager.data.local.database.dao.ExpenseDao
import com.example.moneymanager.data.local.model.BudgetEntity
import com.example.moneymanager.data.local.model.ExpenseEntity

@Database(entities = [ExpenseEntity::class, BudgetEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
    abstract fun budgetDao(): BudgetDao
    abstract fun categoryDao(): CategoryDao
}