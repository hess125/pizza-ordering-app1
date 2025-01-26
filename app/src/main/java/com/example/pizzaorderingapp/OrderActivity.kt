package com.example.pizzaorderingapp

import android.os.Bundle
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

    }

    fun onIngredientSelected(view: View) {
        val checkBox = view as CheckBox
        val price = (checkBox.tag as String).toDouble()

        if (checkBox.isChecked) {
            selectedIngredients.add(checkBox.text.toString())
            totalPrice += price
        } else {
            selectedIngredients.remove(checkBox.text.toString())
            totalPrice -= price
        }

        updateSelectedIngredients()
        updateTotalPrice()
    }

    // Handles size selection
    fun onSizeSelected(view: View) {
        val selectedSize = view as RadioButton
        val sizePrice = (selectedSize.tag as String).toDouble()
        totalPrice = sizePrice + getIngredientsPrice()
        updateTotalPrice()
    }

    private fun getIngredientsPrice(): Double {
        return selectedIngredients.sumOf { ingredient ->
            when (ingredient) {
                "Cheese - $2" -> 2.0
                "Pepperoni - $3" -> 3.0
                "Mushrooms - $1.5" -> 1.5
                else -> 0.0
            }
        }
    }

    private fun updateSelectedIngredients() {
        ingredientsContainer.removeAllViews()
        for (ingredient in selectedIngredients) {
            val ingredientView = TextView(this)
            ingredientView.text = ingredient
            ingredientsContainer.addView(ingredientView)
        }
    }

    private fun updateTotalPrice() {
        txtTotalPrice.text = "Total: $$totalPrice"
    }

}

    private lateinit var txtTotalPrice: TextView
    private lateinit var ingredientsContainer: LinearLayout
    private var totalPrice = 0.0
    private val selectedIngredients = mutableListOf<String>()
