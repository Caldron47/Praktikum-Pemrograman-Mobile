package com.andra.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * Activity ini memungkinkan user untuk melempar dadu dan melihat hasilnya
 * di layar.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Lempar dadu ketika aplikasi dimulai
        rollDice()
    }

    /**
     * Melemparkan dadu dan mengupdate layar dengan hasilnya.
     */
    private fun rollDice() {
        // Membuat object dadu baru dengan 6 sisi dan melemparnya
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Membuat object dadu kedua dengan 6 sisi dan melemparnya
        val dice2 = Dice(6)
        val diceRoll2 = dice.roll()

        // Menemukan ImageView di tata letak
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Menemukan ImageView kedua di tata letak
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Menentukan ID resource mana yang akan digunakan berdasarkan lemparan dadu
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Menentukan ID resource mana yang akan digunakan berdasarkan lemparan dadu kedua
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Mengupdate ImageView dengan ID resource drawable yang benar
        diceImage.setImageResource(drawableResource)

        // Mengupdate deskripsi konten
        diceImage.contentDescription = diceRoll.toString()

        // Mengupdate ImageView kedua dengan ID resource drawable yang benar
        diceImage2.setImageResource(drawableResource2)

        // Mengupdate deskripsi konten kedua
        diceImage2.contentDescription = diceRoll2.toString()
    }
}

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}