package com.example.atorapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.atorapp.databinding.AtorLayoutBinding
import com.example.atorapp.model.Ator


class AtorAdapter: ListAdapter<Ator,AtorAdapter.AtorViewHolder>(AtorDiffcallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtorViewHolder {
        return  AtorViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: AtorViewHolder, position: Int) {
        val ator = currentList[position]
        holder.bind(ator)

    }

    class AtorViewHolder private constructor(var binding: AtorLayoutBinding) :RecyclerView.ViewHolder(binding.root){


        fun bind(ator: Ator) {
            binding.ator = ator

        }

        companion object {
             fun from(parent: ViewGroup): AtorViewHolder {

                 val binding:AtorLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.ator_layout, parent, false)


                 return AtorViewHolder(binding)



            }
        }
    }
}
class AtorDiffcallBack : DiffUtil.ItemCallback<Ator>(){
    override fun areItemsTheSame(oldItem: Ator, newItem: Ator): Boolean {
        return oldItem.id == newItem.id
    }


    override fun areContentsTheSame(oldItem: Ator, newItem: Ator): Boolean {
        return oldItem == newItem
    }

}
