package com.example.moneymanager.ui.screens.budget

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moneymanager.data.local.model.BudgetEntity
import com.example.moneymanager.data.repository.BudgetRepository
import com.example.moneymanager.data.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BudgetScreenViewModel @Inject constructor(private val budgetRepository: BudgetRepository, private val categoryRepository: CategoryRepository) :
    ViewModel() {

    private val _budget = MutableStateFlow<List<BudgetEntity>>(emptyList())
    val budget = _budget.asStateFlow() // wrong

    init {
        fetchBudget()
    }

    private fun fetchBudget() {
        viewModelScope.launch {
            budgetRepository.getAllBudgetPerMonth().collect {
                _budget.value = it
            }
        }
    }

    fun addBudget(budgetEntity: BudgetEntity) {
        viewModelScope.launch {
            budgetRepository.insertBudget(budgetEntity)
            fetchBudget()
        }
    }

    fun deleteBudget(budgetEntity: BudgetEntity) {
        viewModelScope.launch {
            budgetRepository.deleteBudget(budgetEntity)
            fetchBudget()
        }
    }

    fun updateBudget(budgetEntity: BudgetEntity) {
        viewModelScope.launch {
            budgetRepository.updateBudget(budgetEntity)
            fetchBudget()
        }
    }
}