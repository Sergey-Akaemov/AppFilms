package ru.devakaemov.myapplication

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.devakaemov.myapplication.databinding.FilmItemBinding

class FilmViewHolder(private val bindingItem: FilmItemBinding) :
    RecyclerView.ViewHolder(bindingItem.root) {

    fun bind(film: Film, clickListener: FilmListRecyclerAdapter.OnItemClickListener) {

        bindingItem.itemContainer.setOnClickListener { clickListener.click(film) }
        bindingItem.title.text = film.title
        Glide.with(itemView)
            .load(film.poster)
            .centerCrop()
            .into(bindingItem.poster)
        bindingItem.description.text = film.description
    }
}