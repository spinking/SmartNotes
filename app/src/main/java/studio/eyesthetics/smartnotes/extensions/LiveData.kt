package studio.eyesthetics.smartnotes.extensions

import androidx.lifecycle.MutableLiveData

/**
 * Created by BashkatovSM on 23.09.2019
 */

 fun <T>mutableLiveData(defaultValue: T? = null): MutableLiveData<T> {
    val data = MutableLiveData<T>()

    if(defaultValue != null) {
        data.value = defaultValue
    }

    return data
 }