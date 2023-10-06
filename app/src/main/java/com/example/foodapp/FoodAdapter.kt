package com.example.foodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val foodList: ArrayList<ItemFood>,
                  private val foodViewModel: FoodViewModel)
    : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val imgFood: ImageView = itemview.findViewById(R.id.imgFood)
        val nameFood: TextView = itemview.findViewById(R.id.tvNameFood)
        val checkBox: CheckBox = itemview.findViewById(R.id.check)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.food_item,parent,false)
            return FoodViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val currentFood = foodList[position]
        // gán dữ liêu vào check box và textview
        holder.imgFood.setImageResource(R.drawable.salad)
        holder.nameFood.text = currentFood.nameFood
        holder.checkBox.isChecked = currentFood.isChecked

        // xử lý sự kiện khi thay đổi trạng thái check box
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            currentFood.isChecked = isChecked
            if(isChecked){
                foodViewModel.addSelectedFood(currentFood)
            }
            else{
                foodViewModel.removeSelectedFood(currentFood)
            }
        }
        }


    fun updateData(newData: List<ItemFood>?) {
        foodList.clear()
        newData?.let { foodList.addAll(it) }
        notifyDataSetChanged()
    }

    interface onClickCheckBox{
        fun onItemClick()


    }

}