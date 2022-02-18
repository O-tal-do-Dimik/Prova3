package com.example.atorapp.ui.home

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.atorapp.AtorAdapter
import com.example.atorapp.AtorappApplication
import com.example.atorapp.R
import com.example.atorapp.util.RecyclerViewClickListener
import com.example.atorapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
    lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val factory = HomeViewModel.Factory((requireActivity().application as AtorappApplication).atorRepository)
        viewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)


        val adapter = AtorAdapter()

        binding.recyclerView.adapter = adapter

        viewModel.list.observe(viewLifecycleOwner,  { list ->
            adapter.submitList(list)
        })

        binding.recyclerView.addOnItemTouchListener(RecyclerViewClickListener(binding.recyclerView, object : RecyclerViewClickListener.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                Navigation.findNavController(binding.recyclerView).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(adapter.currentList[position].id))
            }

            override fun onItemLongClick(view: View, position: Int) {
                Navigation.findNavController(binding.recyclerView).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(adapter.currentList[position].id))
            }
        }))


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.ajuda_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.opcao_menu_ajuda){
            Toast.makeText(context, "Ajuda da tela de Home", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)

    }


}