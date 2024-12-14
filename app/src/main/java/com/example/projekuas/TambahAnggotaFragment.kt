package com.example.projekuas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class TambahAnggotaFragment : Fragment() {

    private lateinit var etNama: EditText
    private lateinit var etPartai: EditText
    private lateinit var etDapil: EditText
    private lateinit var btnSubmit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tambah_anggota, container, false)

        etNama = view.findViewById(R.id.etNama)
        etPartai = view.findViewById(R.id.etPartai)
        etDapil = view.findViewById(R.id.etDapil)
        btnSubmit = view.findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val nama = etNama.text.toString()
            val partai = etPartai.text.toString()
            val dapil = etDapil.text.toString()

            if (nama.isNotEmpty() && partai.isNotEmpty() && dapil.isNotEmpty()) {
                // Simpan data ke SharedViewModel atau database
                Toast.makeText(requireContext(), "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
                // Navigasi kembali ke daftar anggota (implementasi tergantung navigation yang digunakan)
            } else {
                Toast.makeText(requireContext(), "Harap isi semua field", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
