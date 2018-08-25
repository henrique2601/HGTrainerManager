package com.example.bottomnavigation.helper

import android.support.v4.app.Fragment
import com.example.bottomnavigation.R
import com.example.bottomnavigation.ui.DashboardFragment
import com.example.bottomnavigation.ui.NotificationsFragment
import com.example.bottomnavigation.ui.ProfileFragment

enum class BottomNavigationPosition(val position: Int, val id: Int) {
    DASHBOARD(1, R.id.dashboard),
    NOTIFICATIONS(2, R.id.notifications),
    PROFILE(0, R.id.profile);
}

fun findNavigationPositionById(id: Int): BottomNavigationPosition = when (id) {
    BottomNavigationPosition.DASHBOARD.id -> BottomNavigationPosition.DASHBOARD
    BottomNavigationPosition.NOTIFICATIONS.id -> BottomNavigationPosition.NOTIFICATIONS
    BottomNavigationPosition.PROFILE.id -> BottomNavigationPosition.PROFILE
    else -> BottomNavigationPosition.PROFILE
}

fun BottomNavigationPosition.createFragment(): Fragment = when (this) {
    BottomNavigationPosition.DASHBOARD -> DashboardFragment.newInstance()
    BottomNavigationPosition.NOTIFICATIONS -> NotificationsFragment.newInstance()
    BottomNavigationPosition.PROFILE -> ProfileFragment.newInstance()
}

fun BottomNavigationPosition.getTag(): String = when (this) {
    BottomNavigationPosition.DASHBOARD -> DashboardFragment.TAG
    BottomNavigationPosition.NOTIFICATIONS -> NotificationsFragment.TAG
    BottomNavigationPosition.PROFILE -> ProfileFragment.TAG
}

