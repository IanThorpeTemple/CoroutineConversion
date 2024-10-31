package edu.temple.coroutineconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Locale

class MainActivity : AppCompatActivity() {

    //TODO (Refactor to replace Thread code with coroutines)

    private val cakeImageView: ImageView by lazy {
        findViewById(R.id.imageView)
    }

    private val currentTextView: TextView by lazy {
        findViewById(R.id.currentTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.revealButton).setOnClickListener{


            val scope = CoroutineScope(Dispatchers.Main)

            scope.launch{
                repeat(100) {
                    currentTextView.text = String.format(Locale.getDefault(), "Current opacity: %d", it)
                    cakeImageView.alpha = it / 100f
                    delay(40)
                }
            }

//            Thread{
//                repeat(100) {
//                    handler.sendEmptyMessage(it)
//                    Thread.sleep(40)
//                }
//            }.start()
        }
    }
}