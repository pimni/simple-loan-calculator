package th.ac.su.pimnipa.simpleloancalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import th.ac.su.pimnipa.simpleloancalculator.Utils.getJsonDataFromAsset
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.pimnipa.simpleloancalculator.data.Promo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputMoney = findViewById<EditText>(R.id.inputMoney)
        val inputPercent = findViewById<EditText>(R.id.inputPercent)
        val inputYear = findViewById<EditText>(R.id.inputYear)
        val btnCal = findViewById<Button>(R.id.btnCal)
        val btnRec = findViewById<Button>(R.id.btnRec)

        btnCal.setOnClickListener() {
            var inputMoney = inputMoney.text.toString().toDouble()
            var inputPercent = inputPercent.text.toString().toDouble()
            var inputYear = inputYear.text.toString().toDouble()
            var tvResult: Double = 0.0
            var num1: Double = 0.0
            var num2: Double = 0.0
            var num3: Double = 0.0

            num1 = (inputMoney * (inputPercent / 100) * inputYear)
            num2 = inputMoney + num1
            num3 = num2 / (inputYear * 12)
            tvResult = num3
            tvResult.toString()


            var intent = Intent(this@MainActivity, ResultActivity::class.java)
            intent.putExtra("inputMoney", inputMoney.toString())
            intent.putExtra("num1", num1.toString())
            intent.putExtra("num2", num2.toString())
            intent.putExtra("num3", num3.toString())
            intent.putExtra("tvResult", tvResult.toString())
            startActivity(intent)
        }


        val jsonFileString = getJsonDataFromAsset(applicationContext, "promotion.json")
        val gson = Gson()
        val listItemType = object : TypeToken<ArrayList<Promo>>() {}.type

        var promoList: ArrayList<Promo> = gson.fromJson(jsonFileString, listItemType)
    }
}