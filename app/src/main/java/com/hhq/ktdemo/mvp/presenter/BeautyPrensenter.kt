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
    val mModel :BeautyModel by lazy {
        BeautyModel()
    }

    init {
        mView = view
        mContext = context
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun requestData(pageSize: String, page: String) {
        val observable: Observable<MutableList<BeautyBean>>? = mContext?.let { mModel.loadData(mContext!!,pageSize,page) }
        observable?.applyschedulers()?.subscribe { beans : MutableList<BeautyBean> ->
            mView?.setData(beans)
        }
    }
}