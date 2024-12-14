package com.example.projekuas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projekuas.databinding.FragmentFavoriteBinding
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var adapter: CalonAdapter
    private lateinit var executor: Executor
    private lateinit var db:CalonDPRDatabase
    private lateinit var calonViewModel:CalonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiService = RetrofitInstance.api
        apiService.getAllCalon().enqueue(object : Callback<List<CalonDPR>>{
            override fun onResponse(
                call: Call<List<CalonDPR>>,
                response: Response<List<CalonDPR>>
            ) {
                val data =response.body()!!
                val calonAdapter = CalonAdapter(data)
                binding.recyclerViewFavorites.apply {
                  adapter = calonAdapter
                    layoutManager = LinearLayoutManager(binding.root.context)
                }
                Toast.makeText(binding.root.context, data.toString(), Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<List<CalonDPR>>, t: Throwable) {
            }

        })

        // Setup RecyclerView

    }



}
