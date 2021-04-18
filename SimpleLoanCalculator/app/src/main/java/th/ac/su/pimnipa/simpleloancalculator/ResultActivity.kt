package th.ac.su.pimnipa.simpleloancalculator

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val okBtn = findViewById<Button>(R.id.btnBack);
        btnBack.setOnClickListener {
            var intent = Intent()
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }

}