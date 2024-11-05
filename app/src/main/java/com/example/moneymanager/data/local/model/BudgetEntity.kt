package com.example.moneymanager.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


/**
 * Relationship between budgets and categories -> 1 to M
 * */
@Entity(
    tableName = "budgets",
    foreignKeys = [ForeignKey(
        entity = CategoryEntity::class,
        parentColumns = ["id"],
        childColumns = ["category_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class BudgetEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    // foreign key for category entity
    @ColumnInfo(name = "category_id")
    val categoryId: Int,
    @ColumnInfo(name = "budget_amount")
    val budgetAmount: Double,
    @ColumnInfo(name = "budget_date")
    val budgetDate: Long
)