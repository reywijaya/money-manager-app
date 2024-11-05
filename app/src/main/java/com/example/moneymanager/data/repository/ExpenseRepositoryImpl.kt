package com.example.moneymanager.data.repository

import com.example.moneymanager.data.local.database.dao.ExpenseDao
import com.example.moneymanager.data.local.model.ExpenseEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor(private val expenseDao: ExpenseDao) : ExpenseRepository {
    override suspend fun insertExpense(expense: ExpenseEntity) {
        expenseDao.insertExpense(expense)
    }

    override suspend fun updateExpense(expense: ExpenseEntity) {
        expenseDao.updateExpense(expense)
    }

    override suspend fun deleteExpense(expense: ExpenseEntity) {
        expenseDao.deleteExpense(expense)
    }

    override fun getAllExpenses(
        startDate: Long,
        endDate: Long
    ): Flow<List<ExpenseEntity>> {
        return expenseDao.getAllExpenses(startDate, endDate)
    }
}