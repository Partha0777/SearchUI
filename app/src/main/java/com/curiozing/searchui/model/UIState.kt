package com.curiozing.searchui.model

sealed class UIState {
    class Loading : UIState()
    class Success : UIState()
    class Failure : UIState()
}