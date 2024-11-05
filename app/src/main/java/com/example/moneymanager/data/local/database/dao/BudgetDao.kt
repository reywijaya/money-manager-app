package com.example.moneymanager.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.moneymanager.data.local.model.BudgetEntity
import kotlinx.coroutines.flow.Flow

/**
 * CRUD Budget operations only works with the corresponding category
 * */

@Dao
interface BudgetDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun setMonthlyBudget(budget: BudgetEntity)

    @Update
    suspend fun updateMonthlyBudget(budget: BudgetEntity)

    @Delete
    suspend fun deleteMonthlyBudget(budget: BudgetEntity)

    @Query("SELECT * FROM budgets WHERE budget_date BETWEEN :startDate AND :endDate")
    fun getAllMonthlyBudget(startDate: Long, endDate: Long): Flow<List<BudgetEntity>>
}