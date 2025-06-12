package com.nutriflex.app.ui.kcal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.nutriflex.app.network.KcalApi
import com.nutriflex.app.network.KcalRequest
import com.nutriflex.app.network.KcalRecord
import com.nutriflex.app.network.RetrofitInstance
import kotlinx.coroutines.launch

class KcalViewModel : ViewModel() {
    private val _history = MutableLiveData<List<KcalRecord>>()
    val history: LiveData<List<KcalRecord>> = _history

    private val _measureResult = MutableLiveData<KcalRecord?>()
    val measureResult: LiveData<KcalRecord?> = _measureResult

    fun getHistory(userId: Long) {
        viewModelScope.launch {
            try {
                val result = RetrofitInstance.api.getHistory(userId)
                _history.postValue(result)
            } catch (e: Exception) {
                _history.postValue(emptyList())
            }
        }
    }

    fun measureAndSave(request: KcalRequest) {
        viewModelScope.launch {
            try {
                val result = RetrofitInstance.api.measureAndSave(request)
                _measureResult.postValue(result)
                getHistory(request.userId) // refresh history
            } catch (e: Exception) {
                _measureResult.postValue(null)
            }
        }
    }
} 