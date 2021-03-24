package com.lexueoude.guessmynum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lexueoude.guessmynum.databinding.ActivityMainBinding

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var number: Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        question_text_view.text = resources.getString(R.string.str_question) + number.toString()
//        question_text_view.text = String.format(resources.getString(R.string.str_question), number)
        binding.questionTextView.text = String.format(resources.getString(R.string.str_question), number)

    }

    fun clickUpwardArrow(view: View) {
        if (number == 3) {
            guessTheNumber(4)
        } else if (number == 5) {
            guessTheNumber(8)
        } else if (number == 8) {
            guessTheNumber(9)
        } else if (number == 9) {
            guessTheNumber(10)
        }
    }

    fun clickDownwardArrow(view: View) {
        if (number == 5) {
            guessTheNumber(3)
        } else if (number == 3) {
            guessTheNumber(2)
        } else if (number == 2) {
            guessTheNumber(1)
        } else if (number == 8) {
            guessTheNumber(7)
        } else if (number == 7) {
            guessTheNumber(6)
        }
    }

    fun clickCheckIcon(view: View) {
        binding.questionTextView.visibility = View.INVISIBLE
        binding.ansTextView.visibility = View.VISIBLE
        binding.ansTextView.text = String.format(resources.getString(R.string.str_success), number)
    }

    fun clickResetIcon(view: View) {
        binding.questionTextView.visibility = View.VISIBLE
        binding.ansTextView.visibility = View.INVISIBLE
        number = 5
        printTheQuestion()
    }

    private fun printTheQuestion() {
        binding.questionTextView.text = String.format(resources.getString(R.string.str_question), number)
    }

    private fun guessTheNumber(newGuessNum: Int) {
        number = newGuessNum
        printTheQuestion()
    }


}


//               1-10
//                5
//            3       8
//          2   4   7   9
//        1       6       10