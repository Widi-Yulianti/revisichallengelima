package com.example.revchap5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.revchap5.databinding.FragmentLoginBinding
import java.util.*

class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    lateinit var  sharedPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cekLogin()

        sharedPref = requireActivity().getSharedPreferences("registerData", Context.MODE_PRIVATE)
        var username = sharedPref.getString("username", null)
        var password = sharedPref.getString("password", null)

        binding.login.setOnClickListener{
            var _username = binding.username.text.toString()
            var _password = binding.password.text.toString()
            if(username == _username && password == _password){
                var addData = sharedPref.edit()
                addData.putString("_username", _username)
                addData.putString("_password", _password)
                addData.apply()
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
            }
            else {
                Toast.makeText(
                    requireContext(),
                    "The username or password is incorrect!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.register.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnIndo.setOnClickListener {
            setLocale("in")
        }

        binding.btnUsa.setOnClickListener {
            setLocale("en")
        }
    }

    private fun cekLogin() {
        var data = requireActivity().getSharedPreferences("registerData", Context.MODE_PRIVATE)
        var username = data.getString("_username", null)

        Handler(Looper.myLooper()!!).postDelayed({
            if(username != null)
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
        },1000)
    }


    fun setLocale(lang: String?) {
        val myLocale = Locale(lang)
        val res = resources
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, res.displayMetrics)
        findNavController().navigate(R.id.loginFragment)
    }
}