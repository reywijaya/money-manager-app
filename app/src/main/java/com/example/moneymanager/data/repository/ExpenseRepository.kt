package com.example.moneymanager.data.repository

import com.example.moneymanager.data.local.model.ExpenseEntity
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {
    suspend fun insertExpense(expense: ExpenseEntity)
    suspend fun updateExpense(expense: ExpenseEntity)
    suspend fun deleteExpense(expense: ExpenseEntity)
    fun getAllExpenses(startDate: Long, endDate: Long): Flow<List<ExpenseEntity>>
}