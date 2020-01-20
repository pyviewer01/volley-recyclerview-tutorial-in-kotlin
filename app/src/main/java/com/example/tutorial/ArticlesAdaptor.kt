package com.example.tutorial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.*

class ArticlesAdaptor : RecyclerView.Adapter<ArticleViewHolder>() {
    var articles: ArrayList<Article>
    fun setData(articles: ArrayList<Article>) {
        this.articles = articles
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val articleView = inflater.inflate(R.layout.recycler_row, parent, false)
        return ArticleViewHolder(articleView)
    }

    override fun onBindViewHolder(
        holder: ArticleViewHolder,
        position: Int
    ) {
        val article = articles[position]
        Picasso.get()
            .load(article.image)
            .into(holder.image)
        holder.title.text = article.title
        holder.body.text = article.body
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    init {
        articles = ArrayList()
    }
}