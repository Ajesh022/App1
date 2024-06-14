package com.example.myapp1

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imageButton1: ImageButton
    private lateinit var imageButton2: ImageButton
    private lateinit var imageButton3: ImageButton
    private lateinit var imageButton4: ImageButton
    private lateinit var newImageView: ImageView
    private lateinit var stepsButton: Button

    private var firstSelectedButton: Int? = null
    private var secondSelectedButton: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageButton1 = findViewById(R.id.imageButton1)
        imageButton2 = findViewById(R.id.imageButton2)
        imageButton3 = findViewById(R.id.imageButton3)
        imageButton4 = findViewById(R.id.imageButton4)
        newImageView = findViewById(R.id.newImageView)
        stepsButton = findViewById(R.id.Steps)

        imageButton1.setOnClickListener { handleButtonClick(1) }
        imageButton2.setOnClickListener { handleButtonClick(2) }
        imageButton3.setOnClickListener { handleButtonClick(3) }
        imageButton4.setOnClickListener { handleButtonClick(4) }

        stepsButton.setOnClickListener { showPopupMenu(it) }
    }

    private fun handleButtonClick(buttonId: Int) {
        if (firstSelectedButton == null) {
            firstSelectedButton = buttonId
        } else {
            secondSelectedButton = buttonId
            showCombinedImage(firstSelectedButton!!, secondSelectedButton!!)
            firstSelectedButton = null
            secondSelectedButton = null
        }
    }

    private fun showCombinedImage(button1: Int, button2: Int) {
        val drawableResId = when {
            button1 == 1 && button2 == 2 -> R.drawable.newimage1
            button1 == 1 && button2 == 3 -> R.drawable.newimage5
            button1 == 1 && button2 == 4 -> R.drawable.newimage2
            button1 == 2 && button2 == 3 -> R.drawable.newimage6
            button1 == 2 && button2 == 4 -> R.drawable.newimage4
            button1 == 3 && button2 == 4 -> R.drawable.newimage3
            else -> return
        }

        newImageView.setImageResource(drawableResId)
        newImageView.visibility = View.VISIBLE
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.items, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.btn1 -> {
                    Toast.makeText(this, "RED Selected", Toast.LENGTH_SHORT).show()
                    // Handle color change or other action
                    true
                }
                R.id.btn2 -> {
                    Toast.makeText(this, "GREY Selected", Toast.LENGTH_SHORT).show()
                    // Handle color change or other action
                    true
                }
                R.id.btn3 -> {
                    Toast.makeText(this, "CHERRY RED Selected", Toast.LENGTH_SHORT).show()
                    // Handle color change or other action
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}
