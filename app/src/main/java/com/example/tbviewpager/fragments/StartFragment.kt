package com.example.tbviewpager.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tbviewpager.CustViewPagerAdapter
import com.example.tbviewpager.databinding.FragmentStartBinding
import com.example.tbviewpager.onImageClick

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var adapter: CustViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)

        init()
        return binding.root
    }

    private fun init() {

        activity?.let {
            adapter = CustViewPagerAdapter(it, object: onImageClick{
                override fun imageClick(count: Int) {

                    val action = StartFragmentDirections.actionStartFragmentToImageFragment(count)
                    findNavController().navigate(action)

                }

            })
        }

        binding.viewpager.adapter = adapter
    }


}