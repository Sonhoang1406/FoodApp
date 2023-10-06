package com.example.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainDishesFragment : Fragment() {
  private lateinit var foodViewModel: FoodViewModel
  private lateinit var adapter: FoodAdapter
  private var foodList = ArrayList<ItemFood>()
    lateinit var imgFood: Array<Int>
    lateinit var nameFood: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_main_dishes,container,false)
        // khoi tao viewModel
        foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
        // khoi tao recycleView va adapter
        val recyclerView: RecyclerView = view?.findViewById(R.id.rcvMainFood) ?: return null
        // data cua cac phan tu trong List
        imgFood = arrayOf(
            R.drawable.beef_steak,
            R.drawable.fries,
            R.drawable.grilled_meat,
            R.drawable.hamberger,
            R.drawable.rice_chicken
        )
        nameFood = arrayOf(
            "Bo",
            "Khoai tay chien",
            "thit nuong",
            "hamberger",
            "com ga"
        )
        // gan du lieu cho adapter
        adapter = FoodAdapter(foodList,foodViewModel)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        // khoi tao List va gan du lieu cho List
        foodList = arrayListOf<ItemFood>()
        getFoodData()
        // quan sat livedata
        foodViewModel.getSelectedFoodList().observe(viewLifecycleOwner, Observer { selectedFoodList ->
            if(selectedFoodList != null){
                adapter.updateData(selectedFoodList)
            }

        })

        return view
    }
    // add du lieu cho ListFood
    private fun getFoodData() {
        for(i in imgFood.indices){
            val food = ItemFood(imgFood[i], nameFood[i],false)
            foodList.add(food)
        }
    }


    interface onClickCheckBox{

    }



}