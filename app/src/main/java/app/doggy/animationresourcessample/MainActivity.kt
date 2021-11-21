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

        // dice_image_viewの背景にdice_animationを設定
        binding.diceImageView.setBackgroundResource(R.drawable.dice_animation)

        // dice_image_viewの背景に設定したdice_animationを取得
        val diceAnimation = binding.diceImageView.background

        // dice_image_viewをクリックした時の処理
        binding.diceImageView.setOnClickListener {
            // diceAnimationがAnimatableの場合
            if (diceAnimation is Animatable) {
                if (diceAnimation.isRunning) {
                    // diceAnimationが再生している場合，停止する．
                    diceAnimation.stop()
                } else {
                    // diceAnimationが停止している場合，再生する．
                    diceAnimation.start()
                }
            }
        }
    }
}