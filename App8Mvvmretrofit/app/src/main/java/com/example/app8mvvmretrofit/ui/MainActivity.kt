package com.example.app8mvvmretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app8mvvmretrofit.R
import com.example.app8mvvmretrofit.data.remote.RetrofitApi
import com.example.app8mvvmretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding?=null
    var rvAdapter:RcAdapter?=null
    var rcViewModel:AppViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding!!.lifecycleOwner

        rcViewModel=ViewModelProvider(this@MainActivity).get(AppViewModel::class.java)

        var a=rcViewModel?.al
        //Log.d("DATA","info>>>>>"+a)
        rcViewModel?.apply {

            getApiData()

            alMutableLiveData.observe(this@MainActivity,androidx.lifecycle.Observer {list ->

                //Log.d("DATA","info>>>>>"+list)

                if(list!==null){
                    rvAdapter= RcAdapter(this@MainActivity,list,rcViewModel!!)
                    binding!!.rv.layoutManager=LinearLayoutManager(this@MainActivity)
                    binding!!.rv.adapter=rvAdapter
                }
            })
        }

    }
}
