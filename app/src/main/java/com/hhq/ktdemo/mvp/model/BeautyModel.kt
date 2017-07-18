package com.hhq.ktdemo.mvp.model

import android.content.Context
import com.hhq.ktdemo.mvp.contract.model.BeautyBean
import com.hhq.ktdemo.network.ApiService
import com.tt.lvruheng.eyepetizer.network.RetrofitClient
import io.reactivex.Observable

/**
 * Created by hhq on 2017/7/15 17:00
 */
class BeautyModel(){
    fun loadData(context: Context, pageSize: String, page: String): Observable<BeautyBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getBeautyImg(pageSize,page)
    }
}