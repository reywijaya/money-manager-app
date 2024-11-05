package com.example.moneymanager.data.repository

import com.example.moneymanager.data.local.database.dao.BudgetDao
import com.example.moneymanager.data.local.model.BudgetEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BudgetRepositoryImpl @Inject constructor(private val budgetDao: BudgetDao) : BudgetRepository {
    override suspend fun insertBudget(budget: BudgetEntity) {
        budgetDao.setMonthlyBudget(budget)
    }

    override suspend fun updateBudget(budget: BudgetEntity) {
        budgetDao.updateMonthlyBudget(budget)
    }

    override suspend fun deleteBudget(budget: BudgetEntity) {
        budgetDao.deleteMonthlyBudget(budget)
    }

    override fun getAllBudgetPerMonth(
        startDate: Long,
        endDate: Long
    ): Flow<List<BudgetEntity>> {
        return budgetDao.getAllMonthlyBudget()
    }
}