package com.hhq.ktdemo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.hhq.ktdemo.mvp.contract.model.BeautyBean
import com.hhq.ktdemo.utils.ImageLoadUtils

/**
 * Created by hhq on 2017/7/15 18:28
 */
class BeautyAdapter(context: Context, beans: List<BeautyBean.Item>?) : RecyclerView.Adapter<BeautyAdapter.BeautyHolder>(){

    var mContext:Context? = null
    var mList: List<BeautyBean.Item>? = null
    var mInflater: LayoutInflater? = null

    init {
        mContext = context
        mList = beans
        mInflater = LayoutInflater.from(mContext)
    }

    override fun getItemCount(): Int {
       return mList?.size?:0
    }

    override fun onBindViewHolder(holder: BeautyHolder?, position: Int) {
        ImageLoadUtils.display(mContext!!,holder?.iv_beauty,mList?.get(position)?.url!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BeautyHolder {
        return BeautyHolder(mInflater!!.inflate(R.layout.item_beauty,parent,false))
    }

    class BeautyHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var iv_beauty : ImageView? = null
        init {
            iv_beauty = itemView.findViewById(R.id.iv_beauty) as ImageView?
        }
    }
}
