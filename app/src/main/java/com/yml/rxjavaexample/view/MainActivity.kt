package com.yml.rxjavaexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yml.rxjavaexample.*
import com.yml.rxjavaexample.repository.APIResponse
import com.yml.rxjavaexample.repository.APIResponseObjects
import com.yml.rxjavaexample.repository.RetrofitInitializer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var recycler: RecyclerView
class MainActivity : AppCompatActivity() {
    private var compositeDisposable: CompositeDisposable? = null
    private var responseObjectsList: ArrayList<APIResponseObjects>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(this)
        compositeDisposable = CompositeDisposable()
        btnPost.setOnClickListener {
            loadPosts()
        }
        btnComments.setOnClickListener {
            loadComments()
        }
    }
    private fun loadPosts(){
        val retrofit = RetrofitInitializer.getRetrofitInstance()
        val requestInterface = retrofit.create(APIResponse::class.java)
        compositeDisposable?.add(requestInterface.getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handlePosts))
    }
    private fun handlePosts(responseList: List<APIResponseObjects>) {
        responseObjectsList = ArrayList(responseList)
        recycler.adapter = AdapterClass(responseObjectsList!!)
    }
    private fun loadComments(){
        val retrofit = RetrofitInitializer.getRetrofitInstance()
        val requestInterface = retrofit.create(APIResponse::class.java)
        compositeDisposable?.add(requestInterface.getComments()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleComments))
    }
    private fun handleComments(responseList: List<APIResponseObjects>) {
        responseObjectsList = ArrayList(responseList)
        recycler.adapter = AdapterClass(responseObjectsList!!)
    }
    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }
}
