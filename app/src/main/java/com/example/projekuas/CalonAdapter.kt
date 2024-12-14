package com.example.projekuas

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projekuas.databinding.ItemCalonBinding
import kotlinx.coroutines.launch
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class CalonAdapter(
    private val calonList: List<CalonDPR>,
) : RecyclerView.Adapter<CalonAdapter.CalonViewHolder>() {

    inner class CalonViewHolder(private val binding: ItemCalonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        lateinit var calonDPRDao: CalonDPRDao
        lateinit var executor: Executor
        init {
            executor = Executors.newSingleThreadExecutor()
            val database = CalonDPRDatabase.getDatabase(binding.root.context)
            calonDPRDao = database!!.calonDPRDao()!!
        }
        fun bind(calon: CalonDPR) {
            executor.execute(){
                val Favorite = calonDPRDao.getCalonDPR(calon._id)
                with(binding){
                    if (Favorite == null){
                        btnFavorite.setBackgroundResource(R.drawable.ic_favorite)
                    }
                    else {
                        btnFavorite.setBackgroundResource(R.drawable.ic_favorited)

                    }
                }
            }
            binding.tvNama.text = calon.nama
            binding.tvPartai.text = calon.partai
            Glide.with(binding.root.context).load(calon.fotoUrl).into(binding.ivFoto)

            // Menambahkan listener untuk tombol favorit
            binding.btnFavorite.setOnClickListener {
                onFavoriteClick(Favorite(pid = calon._id, nama = calon.nama, partai = calon.partai, fotoUrl = calon.fotoUrl))
            }
        }
        fun onFavoriteClick(favorite: Favorite){
            executor.execute(){
                val Favorite = calonDPRDao.getCalonDPR(favorite.pid)
                if (Favorite == null){
                    calonDPRDao.insertFavorite(favorite = favorite)
                }
                else {
                    calonDPRDao.deleteFavorite(favorite = favorite)
                }
            }
        }
        fun refresh(_id : String){
            executor.execute() {
                val Favorite = calonDPRDao.getCalonDPR(_id)
                with(binding) {
                    if (Favorite == null) {
                        btnFavorite.setBackgroundResource(R.drawable.ic_favorite)
                    } else {
                        btnFavorite.setBackgroundResource(R.drawable.ic_favorited)

                    }
                }
            }
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
