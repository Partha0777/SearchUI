package com.curiozing.searchui.viewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curiozing.searchui.model.OrderModel
import com.curiozing.searchui.model.SearchDataProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    var searchInterval= 500L

    var orderList : MediatorLiveData<List<OrderModel>> = MediatorLiveData()
    private var searchList = MutableLiveData<List<OrderModel>>()
    private var _orderListData =  MutableLiveData<List<OrderModel>>()
    var job: Job? = null

    init {
       orderList.addSource(_orderListData){
           orderList.value = it
       }

        orderList.addSource(searchList){
            orderList.value = it
        }
    }

    fun fetchAllGetOrders(){
        viewModelScope.launch {
            _orderListData.value = SearchDataProvider.getOrderList()
        }
    }

    fun searchOrder(query:String){
        job?.cancel()
        job = CoroutineScope(Dispatchers.IO).launch {
            delay(searchInterval)
            searchList.postValue(SearchDataProvider.searchData(query))
        }
    }

}