package com.example.bottomnavigation.DataManager

public class TestDataManager private constructor() {

    var testList = arrayListOf(HGTest(name = "Arremesso de peso", type = HGTestType.DISTANCE))

    init {

    }

    private object Holder { val INSTANCE = TestDataManager() }

    companion object {
        val sharedInstance: TestDataManager by lazy { Holder.INSTANCE }
    }
}

data class HGTest(val name: String, val type:HGTestType)


enum class HGTestType {
    DISTANCE, TIME, COUNT
}