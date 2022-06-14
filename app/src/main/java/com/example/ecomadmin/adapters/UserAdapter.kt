package com.example.ecomadmin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ecomadmin.databinding.UserRowBinding
import com.example.ecomadmin.models.EcomUser

class UserAdapter() : ListAdapter<EcomUser, UserAdapter.UserViewHolder>(UserDiffUtil()){
    class UserViewHolder(val binding: UserRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: EcomUser) {
            binding.user = user
        }
    }

    class UserDiffUtil : DiffUtil.ItemCallback<EcomUser>() {
        override fun areItemsTheSame(oldItem: EcomUser, newItem: EcomUser): Boolean {
            return oldItem.userId == newItem.userId
        }

        override fun areContentsTheSame(oldItem: EcomUser, newItem: EcomUser): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)

    }
}