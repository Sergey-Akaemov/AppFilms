package ru.devakaemov.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.devakaemov.myapplication.databinding.FragmentWatchLaterBinding

class WatchLaterFragment : Fragment() {

    private var bindingWatchLaterBinding: FragmentWatchLaterBinding? = null
    private val binding get() = bindingWatchLaterBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingWatchLaterBinding = FragmentWatchLaterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(binding.root, requireActivity(), 3)
    }
}