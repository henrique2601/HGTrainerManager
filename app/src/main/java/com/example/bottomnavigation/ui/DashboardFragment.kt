package com.example.bottomnavigation.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.bottomnavigation.DataManager.PeopleDataManager
import com.example.bottomnavigation.DataManager.TestDataManager
import com.example.bottomnavigation.R
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_profile.*


class DashboardFragment : Fragment() {

    companion object {
        val TAG: String = DashboardFragment::class.java.simpleName
        fun newInstance() = DashboardFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.title = getString(R.string.title_dashboard)
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return view
    }

    override fun onResume() {
        super.onResume()

        val adapter = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, TestDataManager.sharedInstance.testList.map { it.name })
        listView.adapter = adapter

        fabDash.setOnClickListener { view ->
            val intent = Intent(view.context, AddHGTestActivity::class.java)
            startActivity(intent)
        }
    }

}