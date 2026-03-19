package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {

    private val _currentRoll = MutableLiveData(0)
    val currentRoll: LiveData<Int> = _currentRoll

    fun throwDie(dieSides: Int) {
        _currentRoll.value = Random.nextInt(1, dieSides + 1)
    }

    fun throw20Die() {
        _currentRoll.value = Random.nextInt(1, 20 + 1)
    }

}