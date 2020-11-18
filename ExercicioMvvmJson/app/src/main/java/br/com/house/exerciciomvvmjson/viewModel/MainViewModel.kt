package br.com.house.exerciciomvvmjson.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.house.exerciciomvvmjson.model.Filmes
import com.google.gson.Gson

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext

    fun getListFilmes(): Filmes {
        val jsonString = context.assets.open("filmes.json")
            .bufferedReader()
            .use { it.readText() }

        val temp = Gson().fromJson(jsonString, Filmes::class.java)

        return temp
    }
}