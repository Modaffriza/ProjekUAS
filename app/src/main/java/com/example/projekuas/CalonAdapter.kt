package com.example.projekuas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projekuas.databinding.ItemCalonBinding

class CalonAdapter(private val calonList: List<CalonDPR>) :
    RecyclerView.Adapter<CalonAdapter.CalonViewHolder>() {

    inner class CalonViewHolder(private val binding: ItemCalonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(calon: CalonDPR) {
            binding.tvNama.text = calon.nama
            binding.tvPartai.text = calon.partai
            Glide.with(binding.root.context).load(calon.fotoUrl).into(binding.ivFoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalonViewHolder {
        val binding = ItemCalonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CalonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalonViewHolder, position: Int) {
        holder.bind(calonList[position])
    }

    override fun getItemCount(): Int = calonList.size
}
