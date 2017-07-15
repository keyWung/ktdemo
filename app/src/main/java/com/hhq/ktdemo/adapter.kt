package com.hhq.ktdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.hhq.ktdemo.mvp.contract.model.BeautyBean

/**
 * Created by hhq on 2017/7/15 18:28
 */
class BeautyAdapter(context: Context, beans: MutableList<BeautyBean>) : BaseAdapter(){

    var mContext:Context? = null
    var mList: MutableList<BeautyBean>? = null
    var mInflater: LayoutInflater? = null

    init {
        mContext = context
        mList = beans
        mInflater = LayoutInflater.from(mContext)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("not implemented")
    }

    override fun getItem(position: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class BeautyHolder(itemView : View) {
        var iv_beauty : ImageView? = null
        init {
            iv_beauty = itemView.findViewById(R.id.iv_beauty) as ImageView?
        }
    }
}
