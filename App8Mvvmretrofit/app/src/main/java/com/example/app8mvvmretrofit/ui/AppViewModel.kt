package com.example.app8mvvmretrofit.ui

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app8mvvmretrofit.data.remote.RetrofitApi
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AppViewModel : ViewModel() {

//    var id=""
//    var title=""
//    var body=""

    var al = ArrayList<Model>()
    var alMutableLiveData = MutableLiveData<List<Model>>()

    fun getApiData() : MutableLiveData<List<Model>>{

        val apiinterface= RetrofitApi.create().getData()

        apiinterface.enqueue(object : Callback<List<Model>> {

            @RequiresApi(Build.VERSION_CODES.KITKAT)
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {


                if(response?.body() != null){

                    for(items in response?.body()!!){

                    //    Log.d("DATA","info>>>>>"+items.title)

                        val model=Model(items.id,items.title,items.body)

                        al.add(model)

                        Log.d("DATA","info>>>>>resp"+al)


                        alMutableLiveData.value = al

                        Log.d("DATA","info>>>>>"+alMutableLiveData)
                        Log.d("DATA","info>>>>>al"+al)

                    }
                }
            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                Log.d("DATA","failed")
            }
        })

        return alMutableLiveData
    }
}