package com.example.job1_class.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.job1_class.ApiInstance.apiService
import com.example.job1_class.Product
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {

    private val _product = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _product


    init {
        viewModelScope.launch {
            fetchroducts()
        }
    }

    private suspend fun fetchroducts() {
        try {
            val response =  apiService.getProducts()
            _product.postValue(response)
        }catch (e:Exception){

        }
    }


}