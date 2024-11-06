package com.example.moneymanager.ui.screens.navigation.bottom

import androidx.annotation.DrawableRes
import com.example.moneymanager.R

sealed class BottomNavItem(
    val route: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val label: String
) {
    object Transactions :
        BottomNavItem(
            route = "transactions",
            selectedIcon = R.drawable.paid_24px_filled,
            unselectedIcon = R.drawable.paid_24px,
            label = "Transactions"
        )

    object Statistics : BottomNavItem(
        route = "statistics",
        selectedIcon = R.drawable.insert_chart_24px,
        unselectedIcon = R.drawable.insert_chart_24px_outlined,
        label = "Statistics"
    )

    object Accounts : BottomNavItem(
        route = "accounts",
        selectedIcon = R.drawable.account_balance_wallet_24px_filled,
        unselectedIcon = R.drawable.account_balance_wallet_24px,
        label = "Accounts"
    )

    object Settings : BottomNavItem(
        route = "settings",
        selectedIcon = R.drawable.widgets_24px_setting,
        unselectedIcon = R.drawable.widgets_24px,
        label = "Settings"
    )
}