package br.com.house.exerciciomvvmjson.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.house.exerciciomvvmjson.view.adapter.AdapterFilmes
import br.com.house.exerciciomvvmjson.viewModel.MainViewModel
import br.com.house.exerciciomvvmjson.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listafilmes = viewModel.getListFilmes()
        val recycler = recyclerViewRestaurantList
        recycler.adapter = AdapterFilmes(listafilmes.filmes)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
    }
}