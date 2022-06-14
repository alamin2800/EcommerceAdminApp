package com.example.ecomadmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecomadmin.adapters.UserAdapter
import com.example.ecomadmin.databinding.FragmentUserListBinding
import com.example.ecomadmin.viewmodels.UserViewModel

class UserListFragment : Fragment() {
    private val userViewModel: UserViewModel by activityViewModels()
    private lateinit var binding: FragmentUserListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        val adapter = UserAdapter()
        binding.userRV.layoutManager = LinearLayoutManager(requireActivity())
        binding.userRV.adapter = adapter
        userViewModel.getAllUser().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        return binding.root
    }

}