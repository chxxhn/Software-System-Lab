package com.example.myapplication7_2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication7_2.databinding.FragmentVolleyBinding
import com.example.myapplication7_2.model.ItemModel
import com.example.myapplication7_2.recycler.MyAdapter

import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


class VolleyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentVolleyBinding.inflate(inflater, container, false)

        val url =
            MyApplication.BASE_URL + "/v2/everything?q=${MyApplication.QUERY}&apiKey=${MyApplication.API_KEY}&page=1&pageSize=5"

        val queue = Volley.newRequestQueue(activity)
        val jsonRequest =
            object : JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                Response.Listener<JSONObject> { response ->
                    val items = mutableListOf<ItemModel>()
                    val jsonArray = response.getJSONArray("articles") // 'articles'는 응답 내의 JSON 배열 키를 가정합니다.

                    for (i in 0 until jsonArray.length()) {
                        ItemModel().run {
                            val article = jsonArray.getJSONObject(i)
                            author = article.getString("author")
                            title  = article.getString("title")
                            description = article.getString("description")
                            urlToImage = article.getString("urlToImage")
                            publishedAt = article.getString("publishedAt")
                            items.add(this)
                        }
                    }
                    binding.volleyRecyclerView.adapter = MyAdapter(activity as Context, items) // RecyclerView와 Adapter 초기화
                    binding.volleyRecyclerView.layoutManager = LinearLayoutManager(activity)
                },

                //Request 에러 처리
                Response.ErrorListener { error -> println("error............$error") }){
                override fun getHeaders(): MutableMap<String, String> {
                    val map = mutableMapOf<String, String>(
                        "User-agent" to MyApplication.USER_AGENT
                    )
                    return map
                }
            }

        //Request 전송
        queue.add(jsonRequest)
        return binding.root

    }

}
