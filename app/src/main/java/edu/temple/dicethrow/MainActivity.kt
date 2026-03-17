package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//
//        val dieFragment = DieFragment.newInstance(20)
//            .supportFragmentManager()
//            .add(R.id.fragmentContainerView, dieFragment)
//            .commit()

//        if (supportFragmentManager.findFragmentByID(R.id.fragmentContainerView) == null) {
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.fragmentContainerView, DieFragment.)
//                .commit()
//        }

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {

        supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) ?.run{
                (this as DieFragment).throwDie()
            }


        };

    }
}