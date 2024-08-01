package com.curiozing.searchui.model

data class OrderModel(val userModel: UserModel, val productModel: ProductModel)


data class UserModel(
    val name: String,
    val email: String
) {
    override fun toString(): String {
        return "$name ($name.gmail.com)"
    }
}

data class ProductModel(
    val name: String,
    val price: Double,
    val brand: String
) {
    override fun toString(): String {
        return "$name - $brand ($$price)"
    }
}