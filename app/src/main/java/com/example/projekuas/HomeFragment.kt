package com.example.projekuas

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projekuas.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CalonAdapter
    private lateinit var prefManager: PrefManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        prefManager = PrefManager(requireContext())
        // Set up the logout button click listener using binding
        binding.btnLogout.setOnClickListener {
            val editor = prefManager.clearPreferences()

            // Use an Intent to start MainActivity and clear the fragment stack
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            activity?.finish()
        }
    }
    private fun setupRecyclerView() {
        binding.rvCalon.layoutManager = LinearLayoutManager(context)
        val apiService = RetrofitInstance.api
        apiService.getAllCalon().enqueue(object : Callback<List<CalonDPR>> {
            override fun onResponse(
                call: Call<List<CalonDPR>>,
                response: Response<List<CalonDPR>>
            ) {
                Toast.makeText(binding.root.context, "a", Toast.LENGTH_SHORT).show()

                val data =response.body()!!
                val calonAdapter = CalonAdapter(data)
                binding.rvCalon.apply {
                  adapter =   calonAdapter
                    layoutManager = LinearLayoutManager(binding.root.context)
                }
            }

            override fun onFailure(call: Call<List<CalonDPR>>, t: Throwable) {
            }

        })
    }



    private fun toggleFavorite(calon: CalonDPR) {
        lifecycleScope.launch {
            Toast.makeText(context, "${calon.nama} ditekan tombol favorit", Toast.LENGTH_SHORT).show()

            // Get the CalonViewModel instance
            val calonViewModel = ViewModelProvider(requireActivity()).get(CalonViewModel::class.java)

            // Check if the candidate is already a favorite

        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}