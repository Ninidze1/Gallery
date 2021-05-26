package com.example.tbviewpager.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tbviewpager.R
import com.example.tbviewpager.databinding.FragmentImageBinding

class ImageFragment : Fragment() {

    private lateinit var binding: FragmentImageBinding
    private val args: ImageFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {

        when (args.position) {
            0 -> binding.photoView.setImageResource(R.mipmap.lexus)
            1 -> binding.photoView.setImageResource(R.mipmap.br900)
            2 -> binding.photoView.setImageResource(R.mipmap.cadilac)
            3 -> binding.photoView.setImageResource(R.mipmap.giulia)
            4 -> binding.photoView.setImageResource(R.mipmap.hyndai)
        }

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_imageFragment_to_startFragment)
        }

    }

}