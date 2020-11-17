package br.com.house.exerciciomvvmjson

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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