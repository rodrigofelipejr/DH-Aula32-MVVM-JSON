package br.com.house.app_mvvm_json.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import br.com.house.app_mvvm_json.R
import br.com.house.app_mvvm_json.ui.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        val listExpensesA = viewModel.getListExpenses()
        listExpensesA.forEach {
            Log.i("MainActivity A", it.toString())
        }

        val listExpensesB = viewModel.getListExpensesGson()
        listExpensesB.forEach {
            Log.i("MainActivity B", it.toString())
        }
    }
}