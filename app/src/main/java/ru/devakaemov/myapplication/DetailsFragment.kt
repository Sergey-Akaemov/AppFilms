package ru.devakaemov.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.devakaemov.myapplication.databinding.ActivityDetailsBinding

class DetailsFragment : Fragment() {

    private var _binding: ActivityDetailsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityDetailsBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFilmsDetails()
    }

    private fun setFilmsDetails() {

        val film = arguments?.get("film") as Film

        binding!!.detailsToolbar.title = film.title
        binding!!.detailsPoster.setImageResource(film.poster)
        binding!!.detailsDescription.text = film.description
    }
}