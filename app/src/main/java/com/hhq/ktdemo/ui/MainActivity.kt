package com.hhq.ktdemo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hhq.ktdemo.R
import com.hhq.ktdemo.mvp.contract.BeautyContract
import com.hhq.ktdemo.mvp.contract.model.BeautyBean
import com.hhq.ktdemo.mvp.presenter.BeautyPrensenter

class MainActivity : AppCompatActivity(),BeautyContract.View {

    var mPresenter: BeautyPrensenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setData(beans: MutableList<BeautyBean>) {

    }
}
