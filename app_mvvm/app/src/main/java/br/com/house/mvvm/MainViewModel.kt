package br.com.house.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    val total = MutableLiveData<Int>().apply {
        value = 0
    }

    fun increment(num: Int) {
        total.value.let { total.value = it!! + num }
    }

    fun refresh() {
        total.value = 0
    }
}