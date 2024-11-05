package com.example.moneymanager.ui.screens.expense

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moneymanager.data.local.model.ExpenseEntity
import com.example.moneymanager.data.repository.ExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseScreenViewModel @Inject constructor(private val expenseRepository: ExpenseRepository) :
    ViewModel() {

    private val _expenses = MutableStateFlow<List<ExpenseEntity>>(emptyList())
    val expenses: StateFlow<List<ExpenseEntity>> = _expenses.asStateFlow()

    init {
        fetchExpenses()
    }

    private fun fetchExpenses() {
        viewModelScope.launch {
            expenseRepository.getAllExpenses().map { expenses ->
                _expenses.value = expenses
            }
        }
    }

    fun insertExpense(expense: ExpenseEntity) {
        viewModelScope.launch {
            expenseRepository.insertExpense(expense)
            fetchExpenses()
        }
    }

    fun deleteExpense(expense: ExpenseEntity) {
        viewModelScope.launch {
            expenseRepository.deleteExpense(expense)
            fetchExpenses()
        }
    }

    fun updateExpense(expense: ExpenseEntity) {
        viewModelScope.launch {
            expenseRepository.updateExpense(expense)
            fetchExpenses()
        }
    }
}