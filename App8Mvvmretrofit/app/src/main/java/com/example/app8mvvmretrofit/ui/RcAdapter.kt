package com.example.app8mvvmretrofit.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.app8mvvmretrofit.R
import com.example.app8mvvmretrofit.databinding.RcLayoutBinding

class RcAdapter(var context:Context,var userList:List<Model>,var viewModel:AppViewModel) : RecyclerView.Adapter<RcAdapter.VHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v =LayoutInflater.from(parent.context).inflate(R.layout.rc_layout,parent,false)
        return VHolder(v,viewModel)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        val user:Model=userList[position]
        holder.bindView(user)
    }

    inner class VHolder(itemView:View,var viewModel:AppViewModel):RecyclerView.ViewHolder(itemView) {

        var lbinding:RcLayoutBinding?=null
        init{
            lbinding=DataBindingUtil.bind(itemView)
        }
        fun bindView(model:Model){
            this.lbinding!!.model=model
            lbinding!!.executePendingBindings()
        }
    }
}

