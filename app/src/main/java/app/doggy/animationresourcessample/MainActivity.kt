package app.doggy.animationresourcessample

import android.animation.ValueAnimator
import android.graphics.drawable.Animatable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.doggy.animationresourcessample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        /* フレームアニメーション */
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

        /* ValueAnimator */
        // TextViewに表示する文字列のリスト
        val animationTextList: List<String> = listOf(
            "あ", "い", "う", "え", "お",
        )

        // はじめの文字列を表示
        binding.countUpText.text = animationTextList[0]

        // valueAnimatorを生成
        val valueAnimator = ValueAnimator.ofInt(0, animationTextList.size - 1).apply {
            duration = resources.getInteger(R.integer.number_duration).toLong()
            addUpdateListener {
                binding.countUpText.text =
                    animationTextList[it.animatedValue.toString().toInt()]
            }
        }

        // count_up_textをクリックした時の処理
        binding.countUpText.setOnClickListener {
            valueAnimator.start()
        }
    }
}
