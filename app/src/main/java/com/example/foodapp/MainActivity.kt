package com.example.foodapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity() {
    private var foodList = ArrayList<ItemFood>()

    private lateinit var foodAdapter: FoodAdapter
    private lateinit var foodRecyclerView: RecyclerView
    private val fragMain = MainDishesFragment()
    private val fragSide = SideDishesFragment()
    private val fragFruit = FruitFragment()
    private val fragDrink = DrinkFragment()
    private val fragCart = CartFragment()
    private lateinit var bottomNavView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().apply {
            this.replace(R.id.frameLayout, fragMain)
            commit()
            true

        }
        bottomNavView = findViewById(R.id.bottomNav)
        bottomNavView.setOnItemReselectedListener {
                menuItem ->
                when(menuItem.itemId) {
                    R.id.mainDishes -> {
                        supportFragmentManager.beginTransaction().apply {
                            this.replace(R.id.frameLayout, fragMain)
                            commit()
                            true

                        }
                    }

                    R.id.sideDishes -> {
                        supportFragmentManager.beginTransaction().apply {
                            this.replace(R.id.frameLayout, fragSide)
                            commit()
                            true
                        }
                    }

                    R.id.fruit -> {
                        supportFragmentManager.beginTransaction().apply {
                            this.replace(R.id.frameLayout, fragFruit)
                            commit()
                            true
                        }
                    }

                    R.id.drink -> {
                        supportFragmentManager.beginTransaction().apply {
                            this.replace(R.id.frameLayout, fragDrink)
                            commit()
                            true
                        }
                    }

                    R.id.cart -> {
                        supportFragmentManager.beginTransaction().apply {
                            this.replace(R.id.frameLayout, fragCart)
                            commit()
                            true
                        }
                    }
                }

        }
    }


}
