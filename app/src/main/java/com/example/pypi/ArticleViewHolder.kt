package com.example.pypi

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticleViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    var image: ImageView
    var title: TextView
    var body: TextView

    init {
        image = itemView.findViewById(R.id.image)
        title = itemView.findViewById(R.id.title)
        body = itemView.findViewById(R.id.body)
    }
}