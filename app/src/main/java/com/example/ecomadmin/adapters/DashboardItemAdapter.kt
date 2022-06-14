package com.example.ecomadmin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecomadmin.databinding.DashboardItemBinding
import com.example.ecomadmin.models.DashboardItem
import com.example.ecomadmin.models.DashboardItemType
import com.example.ecomadmin.models.dashboardItemList

class DashboardItemAdapter(val callback: (DashboardItemType) -> Unit) : RecyclerView.Adapter<DashboardItemAdapter.DashboardViewHolder>(){

    class DashboardViewHolder(val binding: DashboardItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: DashboardItem) {
                binding.item = item
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val binding = DashboardItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return DashboardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.bind(dashboardItemList.get(position))
        holder.itemView.setOnClickListener {
            callback(dashboardItemList.get(position).type)
        }
    }

    override fun getItemCount() = dashboardItemList.size
}