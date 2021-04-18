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
//            var a: Double = lega.text.toString().toDouble()
//            var aa:Double = a*1
//            var b: Double = legb.text.toString().toDouble()
//            var bb:Double = b*1
//            var c:Double =  ((a*a) + (b*b))
//            var sqc = Math.sqrt(c)

            var intent = Intent(this@MainActivity, ResultActivity::class.java)
//            intent.putExtra("a",aa.toString())
//            intent.putExtra("b",bb.toString())
//            intent.putExtra("c",sqc.toString())
            startActivity(intent)
        }


        val jsonFileString = getJsonDataFromAsset(applicationContext,"promotion.json")
        val gson = Gson()
        val listItemType = object : TypeToken<ArrayList<Promo>>(){}.type

        var promoList : ArrayList<Promo> = gson.fromJson(jsonFileString,listItemType)
}