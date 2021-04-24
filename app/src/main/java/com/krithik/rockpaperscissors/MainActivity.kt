package com.krithik.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.krithik.rockpaperscissors.databinding.ActivityMainBinding
import com.krithik.rockpaperscissors.databinding.ActivityMainBinding.inflate
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    enum class Option(selector :Int){
        ROCK(1),
        PAPER(2),
        SCISSOR(3)
    }
     var  computerImageSelection = Option.ROCK
     var  yourImageSelection = Option.ROCK

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //1.Button Impelementation
        //2.randamozie Image
        //3.Set our Image
        //4.compare
        binding.rockButton.setOnClickListener {
            randomizer()
            yourImageSelection = Option.ROCK
            binding.ourImageView.setImageResource(R.drawable.sheriffrock)
            compare()

        }
        binding.paperButton.setOnClickListener {
            randomizer()
            yourImageSelection = Option.PAPER
            binding.ourImageView.setImageResource(R.drawable.sheriffpaper)
            compare()

        }
        binding.scissorButton.setOnClickListener {
            randomizer()
            yourImageSelection = Option.SCISSOR
            binding.ourImageView.setImageResource(R.drawable.sheriffscissors)
            compare()

        }

    }

    private fun compare() {

        //win logic
        //Change Text
        if(yourImageSelection == computerImageSelection){
            binding.resultText.text = "Draw"
        }else{
        when(yourImageSelection ) {
            Option.ROCK -> {

                if (computerImageSelection == Option.PAPER) binding.resultText.text = "Computer Wins"
                else binding.resultText.text = "You Wins"
            }
            Option.PAPER -> {

                if (computerImageSelection == Option.SCISSOR) binding.resultText.text =
                    "Computer Wins"
                else binding.resultText.text = "You Wins"
            }
            Option.SCISSOR -> {

                if (computerImageSelection == Option.ROCK) binding.resultText.text = "Computer Wins"
                else binding.resultText.text = "You Wins"
            }
        }


        }

    }

    private fun randomizer(){
        when((1..3).shuffled().last()){
            1 -> {
                computerImageSelection = Option.ROCK
                binding.computerImageView.setImageResource(R.drawable.outlawrock)

            }
            2 -> {
                computerImageSelection = Option.PAPER
                binding.computerImageView.setImageResource(R.drawable.outlawpaper)

            }
            3 -> {
                computerImageSelection = Option.SCISSOR
                binding.computerImageView.setImageResource(R.drawable.outlawscissors)

            }
        }
    }
}