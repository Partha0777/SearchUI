package com.curiozing.searchui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.curiozing.searchui.databinding.OrderItemLayoutBinding
import com.curiozing.searchui.model.OrderModel

class OrderListAdapter(var orderList: List<OrderModel>) : RecyclerView.Adapter<OrderListAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: OrderItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = OrderItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)

    }

    override fun getItemCount() = orderList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.productDetail.text = orderList[position].productModel.toString()
        holder.binding.userDetail.text = orderList[position].userModel.toString()
    }
}


