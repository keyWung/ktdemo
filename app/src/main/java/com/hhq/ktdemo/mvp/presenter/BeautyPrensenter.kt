package com.hhq.ktdemo.mvp.presenter

import android.content.Context
import com.hhq.ktdemo.mvp.contract.BeautyContract
import com.hhq.ktdemo.mvp.contract.model.BeautyBean
import com.hhq.ktdemo.mvp.model.BeautyModel
import com.hhq.ktdemo.utils.applyschedulers
import io.reactivex.Observable

/**
 * Created by hhq on 2017/7/15 16:50
 */
class BeautyPrensenter(context: Context, view: BeautyContract.View) : BeautyContract.Presenter {

    var mContext : Context? = null
    var mView : BeautyContract.View? = null
    var mList = ArrayList<BeautyBean.Item>()
    val mModel :BeautyModel by lazy {
        BeautyModel()
    }

    init {
        mView = view
        mContext = context
    }

    override fun start() {
    }

    override fun requestData(pageSize: String, page: String) {
        val observable: Observable<BeautyBean>? = mContext?.let { mModel.loadData(mContext!!,pageSize,page) }
        observable?.applyschedulers()?.subscribe { bean : BeautyBean ->
            bean.results?.forEach {
                mList.add(it)
            }
            mView?.setData(mList)
        }
    }

}