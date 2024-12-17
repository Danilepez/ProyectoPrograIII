package com.example.aaa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.RecyclerVencenProntoAdapter
import com.example.aaa.adapters.RecyclerVencidosAdapter
import com.example.aaa.databinding.ActivityVencenProntoBinding

class VencenProntoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVencenProntoBinding
    private lateinit var vencenProntoAdapter: RecyclerVencenProntoAdapter
    private lateinit var vencidosAdapter: RecyclerVencidosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVencenProntoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vencenProntoAdapter = RecyclerVencenProntoAdapter()
        binding.recyclerViewVencenPronto.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewVencenPronto.adapter = vencenProntoAdapter

        vencidosAdapter = RecyclerVencidosAdapter()
        binding.recyclerViewVencidos.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewVencidos.adapter = vencidosAdapter
    }
}
