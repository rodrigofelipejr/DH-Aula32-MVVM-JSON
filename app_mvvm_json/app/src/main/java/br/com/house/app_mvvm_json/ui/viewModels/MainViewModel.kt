package br.com.house.app_mvvm_json.ui.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import br.com.house.app_mvvm_json.models.Expense
import org.json.JSONArray
import java.io.IOException

class MainViewModel(application: Application) : AndroidViewModel(application) {
    // contexto
    private val context = getApplication<Application>().applicationContext

    fun getListExpenses(): ArrayList<Expense> {
        val listExpenses: ArrayList<Expense> = arrayListOf()

        try {
            // realizando a leitura do arquivo .json
            val jsonString = context.assets.open("expenses.json")
                .bufferedReader()
                .use { it.readText() }

            val jsonArray = JSONArray(jsonString)

            for (i in 0..jsonArray.length() - 1) {
                val jsonObj = jsonArray.getJSONObject(i)

                var expense = Expense(
                    jsonObj.getInt("id"),
                    jsonObj.getString("description"),
                    jsonObj.getDouble("value"),
                )

                listExpenses.add(expense)
            }
        } catch (ioException: IOException) {
            Log.e("ERROR", ioException.toString())
        } finally {
            return listExpenses
        }
    }
}