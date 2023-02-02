package com.abdosharaf.navigationtest

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.abdosharaf.navigationtest.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding
    private val args: ThirdFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)

        binding.name = args.name
        binding.age = args.age
        binding.gpa = args.gpa

        binding.btnStartOver.setOnClickListener {
            findNavController().navigate(ThirdFragmentDirections.actionThirdFragmentToFirstFragment())
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.app_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miShare -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "Name: ${args.name}, Age: ${args.age}, GPA: ${args.gpa}")
                startActivity(intent)
            }
            R.id.miExit -> {
                activity?.finish()
            }
            else -> Toast.makeText(activity, "You selected ${item.title}", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}