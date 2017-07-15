package com.hhq.ktdemo.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by hhq on 2017/7/15 18:08
 */
fun Context.showToast(message: String) : Toast {
    var toast : Toast = Toast.makeText(this,message,Toast.LENGTH_LONG)
    toast.setGravity(Gravity.CENTER,0,0)
    toast.show()
    return toast
}

fun <T> Observable<T>.applyschedulers(): Observable<T> {
    return subscribeOn(Schedulers.io()).
            unsubscribeOn(Schedulers.io()).
            observeOn(AndroidSchedulers.mainThread())

}