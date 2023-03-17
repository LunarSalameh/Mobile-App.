package com.example.assinment1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {

    lateinit var name: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.enter_your_name)
        val button:Button=findViewById(R.id.ButtonAge)
        val result:TextView=findViewById(R.id.Age_result)

        var year = " "
        var month = " "

        val spinnerYear:Spinner=findViewById(R.id.enter_year)
        val optionsYear= arrayOf("choose","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006")
        spinnerYear.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,optionsYear)

        spinnerYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                year = optionsYear.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


            val spinnerMonth:Spinner=findViewById(R.id.enter_month)
        val optionsMonth= arrayOf("choose","1","2","3","4","5","6","7","8","9","10","11","12")
        spinnerMonth.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,optionsMonth)

        spinnerMonth.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                month = optionsMonth.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


            button.setOnClickListener{
                val y=year.toInt()
                val m=month.toInt()
                result.text= ageCalculation(y,m,name.text.toString())
        }
    }
}

public fun ageCalculation(ye:Int, mo:Int, na:String):String{
    var yr = 2023 - ye
    var mr=0
    if (mo<=3)
        mr=3-mo
    else {
        mr = 13-mo
        yr--
    }
// adding and subtracting because we are in march, other wise there will be negative value

return " $na is $yr years and $mr month"

}