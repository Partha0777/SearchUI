package com.curiozing.searchui.viewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curiozing.searchui.model.OrderModel
import com.curiozing.searchui.model.SearchDataProvider
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    var orderList : MediatorLiveData<List<OrderModel>> = MediatorLiveData()
    private var _orderListData =  MutableLiveData<List<OrderModel>>()

    init {
       orderList.addSource(_orderListData){
           orderList.value = it
       }
    }

    fun fetchAllGetOrders(){
        viewModelScope.launch {
            _orderListData.value = SearchDataProvider.getOrderList()
        }
    }

}