package ru.devakaemov.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.devakaemov.myapplication.databinding.ActivityDetailsBinding

class DetailsFragment : Fragment() {

    private var _binding: ActivityDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var film: Film

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailsFabFavorites.setOnClickListener {
            film.isInFavorites = !film.isInFavorites
            binding.detailsFabFavorites.setImageResource(
                if (film.isInFavorites) R.drawable.round_favorite_border_24
                else R.drawable.round_favorite_border_24
            )
        }

        binding.detailsFabShare.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Посмотрите этот фильм: ${film.title} \n\n ${film.description}"
                )
                type = "text/plain"
            }
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
        setFilmsDetails()
    }

    private fun setFilmsDetails() {
        film = arguments?.getParcelable("film")
            ?: throw IllegalArgumentException("Film not found in arguments")

        binding.detailsToolbar.title = film.title
        binding.detailsPoster.setImageResource(film.poster)
        binding.detailsDescription.text = film.description

        binding.detailsFabFavorites.setImageResource(
            if (film.isInFavorites) R.drawable.round_favorite_border_24
            else R.drawable.round_favorite_border_24
        )
    }
}