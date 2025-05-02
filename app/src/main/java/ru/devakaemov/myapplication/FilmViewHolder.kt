package ru.devakaemov.myapplication

import androidx.recyclerview.widget.RecyclerView
import ru.devakaemov.myapplication.databinding.FilmItemBinding

class FilmViewHolder(private val bindingItem: FilmItemBinding) :
    RecyclerView.ViewHolder(bindingItem.root) {

    fun bind(film: Film, clickListener: FilmListRecyclerAdapter.OnItemClickListener) {

        bindingItem.itemContainer.setOnClickListener { clickListener.click(film) }
        bindingItem.title.text = film.title
        bindingItem.poster.setImageResource(film.poster)
        bindingItem.description.text = film.description
    }

}