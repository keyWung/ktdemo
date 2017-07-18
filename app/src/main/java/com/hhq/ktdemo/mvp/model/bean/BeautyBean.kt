package com.hhq.ktdemo.mvp.contract.model

/**
 * Created by hhq on 2017/7/15 16:38
 */
data class BeautyBean(var error: Boolean?, var results: List<Item>?) {

    data class Item(var _id: String?, var url: String?)

}