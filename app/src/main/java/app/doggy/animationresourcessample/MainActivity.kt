package app.doggy.animationresourcessample

import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.doggy.animationresourcessample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        binding.diceImageView.setBackgroundResource(R.drawable.dice_animation)

        val diceAnimation = binding.diceImageView.background
        binding.diceImageView.setOnClickListener {
            if (diceAnimation is Animatable) {
                diceAnimation.start()
            }
        }
    }
}