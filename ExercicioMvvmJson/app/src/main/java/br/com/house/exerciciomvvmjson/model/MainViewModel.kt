package br.com.house.exerciciomvvmjson.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
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