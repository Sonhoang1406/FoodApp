package com.example.foodapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoodViewModel: ViewModel() {
    private val selectedFoodList = MutableLiveData<List<ItemFood>>()

    fun getSelectedFoodList(): LiveData<List<ItemFood>>{
        return selectedFoodList
    }
    fun addSelectedFood(food: ItemFood){
        val currentList = selectedFoodList.value?.toMutableList() ?: mutableListOf()
        currentList.add(food)
        selectedFoodList.value = currentList
    }

    fun removeSelectedFood(food: ItemFood){
        val currentList = selectedFoodList.value?.toMutableList() ?: mutableListOf()
        currentList.remove(food)
        selectedFoodList.value = currentList
    }
}