package com.curiozing.searchui.model

sealed class UIState {
    class Loading : UIState()
    class Success(list: List<OrderModel>) : UIState()
    class Failure : UIState()
}