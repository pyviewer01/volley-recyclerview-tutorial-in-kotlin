package com.example.tutorial

/* Get/set methods removed from Article.kt:
*
* These are automatically created in Kotlin
* as a part of instantiating the class;
* from now on all we need is to access
* the attributes outright, seen below.*/

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import java.util.*


class MainActivity : AppCompatActivity() {
    var url = "https://api.myjson.com/bins/o4zlk"
    var recyclerView: RecyclerView? = null
    var adaptor: ArticlesAdaptor? = null
    lateinit var articles: ArrayList<Article>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView?.setLayoutManager(LinearLayoutManager(this))
        adaptor = ArticlesAdaptor()
        recyclerView?.setAdapter(adaptor)
        articles = ArrayList()
        data
    }

    private val data: Unit
        get() {
            val jsonArrayRequest =
                JsonArrayRequest(url,
                    Response.Listener { response ->
                        for (i in 0 until response.length()) {
                            try {
                                val jsonObject = response.getJSONObject(i)
                                val article = Article()
                                // Here we access /assign Article's attributes outright.
                                article.image = jsonObject.getString("image")
                                article.title = jsonObject.getString("title")
                                article.body = jsonObject.getString("body")
                                articles.add(article)
                            } catch (e: JSONException) {
                                e.printStackTrace()
                            }
                        }
                        adaptor!!.setData(articles)
                        adaptor!!.notifyDataSetChanged()
                    }, Response.ErrorListener { error ->
                        Log.e("Volley", error.toString())
                    })
            val requestQueue = Volley.newRequestQueue(this)
            requestQueue.add(jsonArrayRequest)
        }
}