package com.example.moneymanager.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.moneymanager.data.local.model.ExpenseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertExpense(expense: ExpenseEntity)

    @Update
    suspend fun updateExpense(expense: ExpenseEntity)

    @Delete
    suspend fun deleteExpense(expense: ExpenseEntity)

    // get all expenses base on current month and calculate [sum] the amount
    @Query("SELECT * FROM expenses WHERE date BETWEEN :startDate AND :endDate")
    fun getAllExpenses(startDate: Long, endDate: Long): Flow<List<ExpenseEntity>>
}