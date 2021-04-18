package th.ac.su.pimnipa.simpleloancalculator

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.tvOutput)

        val inputMoney = intent.getStringExtra("inputMoney")
        val num1 = intent.getStringExtra("num1")
        val num2 = intent.getStringExtra("num2")
        val num3 = intent.getStringExtra("num3")
        val result = intent.getStringExtra("tvResult")
        tvResult.setText(result)

        val okBtn = findViewById<Button>(R.id.btnBack);
        btnBack.setOnClickListener {
            var intent = Intent()
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }

}