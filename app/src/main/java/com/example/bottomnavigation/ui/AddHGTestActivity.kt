package com.example.bottomnavigation.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bottomnavigation.DataManager.HGTest
import com.example.bottomnavigation.DataManager.HGTestType
import com.example.bottomnavigation.DataManager.TestDataManager
import com.example.bottomnavigation.R
import kotlinx.android.synthetic.main.activity_add_hgtest.*
import kotlinx.android.synthetic.main.dialog_add.*

class AddHGTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_hgtest)

        confirmarAdd.setOnClickListener { view ->
            confirm(view = view)
        }

        cancel2.setOnClickListener {
            cancel()
        }
    }

    fun confirm(view: View) {
        val testName = nameText.text

        if (!testName.isBlank()) {
            var type = HGTestType.DISTANCE

            if (radioTempo.isChecked) {
                type = HGTestType.TIME
            } else if (radioRepeticoes.isChecked) {
                type = HGTestType.COUNT
            }

            TestDataManager.sharedInstance.testList.add(HGTest(name = testName.toString(), type = type))
            finish()
        }
    }

    fun cancel() {
        finish()
    }
}
