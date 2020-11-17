package br.com.house.exerciciomvvmjson.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.house.exerciciomvvmjson.model.Filme
import br.com.house.exerciciomvvmjson.R
import kotlinx.android.synthetic.main.item_filme.view.*

class AdapterFilmes(private val listaFilmes: List<Filme>) :
    RecyclerView.Adapter<AdapterFilmes.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(filme: Filme) {
            val textTitulo = itemView.textViewTitulo
            val textData = itemView.textViewData
            val textDescricao = itemView.textViewDescricao
            val textDirecao = itemView.textViewDirecao

            textTitulo.text = filme.titulo
            textData.text = filme.data
            textDescricao.text = filme.descricao
            textDirecao.text = filme.direcao
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return ViewHolder(view);
    }

    override fun getItemCount() = listaFilmes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = listaFilmes[position];
        holder.let { holder.bindView(dataItem) }
    }
}