package com.curiozing.searchui.viewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curiozing.searchui.model.OrderModel
import com.curiozing.searchui.model.SearchDataProvider

class SearchViewModel : ViewModel() {

    var orderList : MediatorLiveData<List<OrderModel>> = MediatorLiveData()
    var _orderListData =  MutableLiveData<List<OrderModel>>()

    init {
       orderList.addSource(_orderListData){
           orderList.value = it
       }
    }

    fun fetchAllGetOrders(){
        _orderListData.value = SearchDataProvider.orderList
    }


}