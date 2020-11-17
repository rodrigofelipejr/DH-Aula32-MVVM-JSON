package br.com.house.exerciciomvvmjson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_filme.view.*

class AdapterFilmes(private val listaFilmes: List<Filme>) :
    RecyclerView.Adapter<AdapterFilmes.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(dd: Filme) {
            val titulo = itemView.textViewTitulo
            val data = itemView.textViewData
            val descricao = itemView.textViewDescricao
            val direcao = itemView.textViewDirecao

            titulo.text = dd.titulo
            data.text = dd.data
            descricao.text = dd.descricao
            direcao.text = dd.direcao
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return ViewHolder(view);
    }

    override fun getItemCount() = listaFilmes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var dataItem = listaFilmes[position];
        holder.let { holder.bindView(dataItem) }
    }
}