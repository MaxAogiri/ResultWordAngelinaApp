package com.example.resultwordapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var generateButton: Button
    private lateinit var phraseTextView: TextView

    private val negativePhrases: List<String> = listOf("Нет", "Никогда", "Не в этом году")
    private val neutralPhrases: List<String> = listOf("Может быть", "Возможно", "Не знаю")
    private val positivePhrases: List<String> = listOf("Да", "Конечно", "Определённо да")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateButton = findViewById(R.id.generate_button)
        phraseTextView = findViewById(R.id.phrase_textview)

        generateButton.setOnClickListener {
            val randomPhrase = generateRandomPhrase()
            phraseTextView.text = randomPhrase
        }
    }

    private fun generateRandomPhrase(): String {

        return when (Random.nextInt(3)) { // Генерируем случайное число от 0 до 2
            0 -> negativePhrases.random()
            1 -> neutralPhrases.random()
            else -> positivePhrases.random()
        }
    }
}