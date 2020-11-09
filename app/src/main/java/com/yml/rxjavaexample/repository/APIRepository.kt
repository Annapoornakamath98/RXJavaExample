package com.yml.rxjavaexample.repository

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APIRepository {
    fun getPosts(apiResponseInterface: APIResponseInterface){
        val retro = RetrofitInitializer.getRetrofitInstance()
        val apiInterface = retro.create(APIResponse::class.java)
        //val objects: Observable<List<APIResponseObjects>> = apiInterface.getPosts()
        var compositeDisposable: CompositeDisposable? = null
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(apiInterface.getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    apiResponseInterface.onResponse(it)
                }){
                    apiResponseInterface.onFailure(it)
                })
//        objects.enqueue(object : Callback<Data> {
//            override fun onResponse(call: Call<Data>, response: Response<Data>) {
//                response.body()?.let {
//                    apiResponseInterface.onResponse(it.data)
//                }
//            }
//
//            override fun onFailure(call: Call<Data>, t: Throwable) {
//                apiResponseInterface.onFailure(t)
//            }
//
//        })
    }
}