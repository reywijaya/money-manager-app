package com.example.moneymanager.data.repository

import com.example.moneymanager.data.local.database.dao.ExpenseDao
import com.example.moneymanager.data.local.model.ExpenseEntity
import com.example.moneymanager.utils.getDefaultEndDate
import com.example.moneymanager.utils.getDefaultStartDate
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
        userStartDate: Long?,
        userEndDate: Long?
    ): Flow<List<ExpenseEntity>> {
        val startDate = userStartDate ?: getDefaultStartDate()
        val endDate = userEndDate ?: getDefaultEndDate()
        return expenseDao.getAllExpenses(startDate, endDate)
    }
}