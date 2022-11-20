package com.example.revchap5

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.revchap5.databinding.FragmentProfileBinding
import com.example.revchap5.model.User


class ProfileFragment : Fragment() {
    lateinit var  sharedPref : SharedPreferences
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireActivity().getSharedPreferences("registerData", Context.MODE_PRIVATE)
        var username = sharedPref.getString("username", null).toString()
        var name = sharedPref.getString("name", null).toString()
        var email = sharedPref.getString("email", null).toString()
        var password = sharedPref.getString("password", null).toString()

        binding.apply {
            dataEdit = User(username, name, email, password)
            binding.btnEdit.setOnClickListener(){
                username = binding.edtUsername.text.toString()
                name = binding.edtName.text.toString()
                email = binding.edtEmail.text.toString()

                var addData = sharedPref.edit()
                addData.putString("username", username)
                addData.putString("name", name)
                addData.putString("email", email)
                addData.apply()
                Toast.makeText(requireContext(), "Data Save", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_profileFragment_to_accountFragment)
            }

        }
    }
}