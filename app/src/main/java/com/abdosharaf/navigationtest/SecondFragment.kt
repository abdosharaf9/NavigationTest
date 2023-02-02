package com.abdosharaf.navigationtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.abdosharaf.navigationtest.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        setDummyData()

        binding.btnGoToNext2.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString()
            val gpa = binding.etGpa.text.toString()

            if(checkForm(name, age, gpa)){
                findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToThirdFragment(name, age, gpa))
            } else{
                Toast.makeText(activity, "Please enter a valid data", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun checkForm(name: String, age: String, gpa: String): Boolean{
        if (name.isEmpty() || age.isEmpty() || gpa.isEmpty()){
            return false
        }
        return true
    }

    private fun setDummyData(){
        binding.etName.setText("Abdo Sharaf")
        binding.etAge.setText("20")
        binding.etGpa.setText("3.5")
    }
}