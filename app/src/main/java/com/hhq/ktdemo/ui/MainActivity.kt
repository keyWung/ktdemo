package com.hhq.ktdemo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.hhq.ktdemo.BeautyAdapter
import com.hhq.ktdemo.R
import com.hhq.ktdemo.mvp.contract.BeautyContract
import com.hhq.ktdemo.mvp.contract.model.BeautyBean
import com.hhq.ktdemo.mvp.presenter.BeautyPrensenter
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity(),BeautyContract.View {

    var mPresenter: BeautyPrensenter? = null
    var mAdapter: BeautyAdapter? = null
    var mList: List<BeautyBean.Item>? = null
    val pageSize = "10"
    var page: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    override fun setData(beans: List<BeautyBean.Item>) {
        mAdapter?.mList = beans
        mList = beans
        mAdapter?.notifyDataSetChanged()
    }

    fun initView() {
        mPresenter = BeautyPrensenter(this,this)
        mPresenter?.requestData(pageSize!!,page.toString())
        mAdapter = BeautyAdapter(this,mList)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = mAdapter
        recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                var layoutManager : LinearLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
                var lastPos = layoutManager.findLastVisibleItemPosition()
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastPos == mList?.size!! - 1) {
                    page = page.plus(1)
                    mPresenter?.requestData(pageSize,page.toString())
                }
            }
        })

    }
}
