package com.example.moneymanager.data.repository

import com.example.moneymanager.data.local.model.ExpenseEntity
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {
    suspend fun insertExpense(expense: ExpenseEntity)
    suspend fun updateExpense(expense: ExpenseEntity)
    suspend fun deleteExpense(expense: ExpenseEntity)
    fun getAllExpenses(userStartDate: Long? = null, userEndDate: Long? = null): Flow<List<ExpenseEntity>>
}