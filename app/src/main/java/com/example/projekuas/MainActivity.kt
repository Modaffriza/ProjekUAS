package com.example.projekuas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projekuas.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CalonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        fetchCalonDPR()
    }

    private fun setupRecyclerView() {
        binding.rvCalon.layoutManager = LinearLayoutManager(this)
    }

    private fun fetchCalonDPR() {
        lifecycleScope.launch {
            val response = RetrofitInstance.api.getAllCalon()
            if (response.isSuccessful) {
                response.body()?.let {
                    adapter = CalonAdapter(it)
                    binding.rvCalon.adapter = adapter
                }
            }
        }
    }
}
