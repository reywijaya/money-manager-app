package com.example.moneymanager.data.repository

import com.example.moneymanager.data.local.model.BudgetEntity
import kotlinx.coroutines.flow.Flow

interface BudgetRepository {
    suspend fun insertBudget(budget: BudgetEntity)
    suspend fun updateBudget(budget: BudgetEntity)
    suspend fun deleteBudget(budget: BudgetEntity)
    fun getAllBudgetPerMonth(startDate: Long? = null, endDate: Long? = null): Flow<List<BudgetEntity>>
}