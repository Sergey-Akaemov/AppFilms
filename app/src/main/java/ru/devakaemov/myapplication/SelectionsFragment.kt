package ru.devakaemov.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.devakaemov.myapplication.databinding.FragmentSelectionsBinding

class SelectionsFragment : Fragment() {

    private var bindingSelectionsFragment: FragmentSelectionsBinding? = null
    private val binding get() = bindingSelectionsFragment!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingSelectionsFragment = FragmentSelectionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(binding.root, requireActivity(), 4)
    }
}