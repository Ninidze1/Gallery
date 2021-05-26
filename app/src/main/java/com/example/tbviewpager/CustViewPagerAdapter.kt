package com.example.tbviewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class CustViewPagerAdapter(private val context: Context, private var click: onImageClick) : PagerAdapter() {


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val modelObject = ViewModel.values()[position]
        val layout = LayoutInflater.from(context).inflate(modelObject.layoutId, container, false) as ViewGroup

        container.addView(layout)
        layout.setOnClickListener {
            click.imageClick(position)
        }

        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return ViewModel.values().size
    }

    override fun isViewFromObject(view: View, it: Any): Boolean {
        return view === it
    }

}