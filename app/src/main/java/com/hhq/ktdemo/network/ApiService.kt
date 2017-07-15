package com.hhq.ktdemo.network

import com.hhq.ktdemo.mvp.contract.model.BeautyBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by hhq on 2017/7/15 17:15
 */
interface ApiService {
    companion object{
        val BASE_URL : String
            get() = "http://gank.io/api/data/"
    }

    //获取美女图片数据
    @GET("%E7%A6%8F%E5%88%A9/{pageSize}/{page}")
    fun getBeautyImg(@Path("pageSize") pageSize :String, @Path("page") page :String) : Observable<MutableList<BeautyBean>>
}