package com.example.bottomnavigation.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bottomnavigation.DataManager.HGTestType
import com.example.bottomnavigation.R
import kotlinx.android.synthetic.main.dialog_add.*

class AddHGTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_hgtest)
    }

    fun confirm() {
        val testName = editText.text


        if (!testName.isBlank()) {

        }
    }

    fun cancel() {
        this.finish()
    }
}
