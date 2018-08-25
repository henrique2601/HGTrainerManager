package com.example.bottomnavigation.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.bottomnavigation.DataManager.PeopleDataManager
import com.example.bottomnavigation.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_add.view.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    companion object {
        val TAG: String = ProfileFragment::class.java.simpleName
        fun newInstance() = ProfileFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.title = getString(R.string.title_profile)
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        return view
    }

    override fun onResume() {
        super.onResume()

        val adapter = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, PeopleDataManager.sharedInstance.peopleList)
        peopleListView.adapter = adapter

        fab.setOnClickListener { view ->
            showAddPeopleDialog(view.context)
        }
    }

    fun showAddPeopleDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Novo Participante")

        // https://stackoverflow.com/questions/10695103/creating-custom-alertdialog-what-is-the-root-view
        // Seems ok to inflate view with null rootView
        val view = layoutInflater.inflate(R.layout.dialog_add, null)

        val editText = view.editText

        builder.setView(view);

        // set up the ok button
        builder.setPositiveButton(android.R.string.ok) { dialog, p1 ->
            val newPeople = editText.text

            if (!newPeople.isBlank()) {
                PeopleDataManager.sharedInstance.peopleList.add(newPeople.toString())
                dialog.dismiss()
            }
        }

        builder.setNegativeButton(android.R.string.cancel) { dialog, p1 ->
            dialog.cancel()
        }

        builder.show();
    }

}