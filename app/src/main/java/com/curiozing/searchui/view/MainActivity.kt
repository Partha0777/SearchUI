package com.curiozing.searchui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.curiozing.searchui.R
import com.curiozing.searchui.databinding.ActivityMainBinding
import com.curiozing.searchui.view.adapter.OrderListAdapter
import com.curiozing.searchui.viewModel.SearchViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private var orderAdapter = OrderListAdapter(orderList = listOf())

    private val searchViewModel:SearchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI(){
        searchViewModel.fetchAllGetOrders()
        searchViewModel.orderList.observe(this){
            orderAdapter.refreshList(it)
        }
        binding.rvOrderList.layoutManager = LinearLayoutManager(this)
        binding.rvOrderList.adapter = orderAdapter
    }
}