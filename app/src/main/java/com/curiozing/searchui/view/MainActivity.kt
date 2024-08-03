package com.curiozing.searchui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
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

        binding.etSearch.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.isNotEmpty() == true){
                    searchViewModel.searchOrder(s.toString())
                }else{
                    searchViewModel.fetchAllGetOrders()
                }

            }


        })

    }


}

fun <T,R> calculate(data:List<T>,func: (T) -> R) : List<R>{
    return  data.map { e -> func(e) }
}