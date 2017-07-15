package com.hhq.ktdemo.mvp.contract

import com.hhq.ktdemo.base.BasePresenter
import com.hhq.ktdemo.base.BaseView
import com.hhq.ktdemo.mvp.contract.model.BeautyBean

/**
 * Created by hhq on 2017/7/15 16:35
 */
interface BeautyContract {
    interface View : BaseView<MutableList<BeautyBean>> {
        fun setData(beans : MutableList<BeautyBean>)
    }
    interface Presenter : BasePresenter {
        fun requestData(pageSize: String, page: String)
    }
}