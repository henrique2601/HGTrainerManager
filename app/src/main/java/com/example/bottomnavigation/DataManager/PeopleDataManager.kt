package com.example.bottomnavigation.DataManager

public class PeopleDataManager private constructor() {

    var peopleList = arrayListOf("Paulo", "Joao", "Maria")

    init {

    }

    private object Holder { val INSTANCE = PeopleDataManager() }

    companion object {
        val sharedInstance: PeopleDataManager by lazy { Holder.INSTANCE }
    }
}