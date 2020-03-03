/* ____________________________________________
|
| Subject : Kolculator => Kotlin + Calculator
|______________________________________________
|
| Author : Mersad Akbari :)
| 2019 DEC 31
|______________________________________________
|
| Content me:
|     Gmail       : Mersad23Akbari@gmail.com
|     GitHub      : MersadAkbari
|____________________________________________*/

package iran.mersad.kolculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.properties.Delegates
import kotlin.text.Regex

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // functions
        fun maketoast(x:String){
            Toast.makeText(applicationContext, x,Toast.LENGTH_LONG).show()
        }

        // variables
        var zero = findViewById<Button>(R.id.button19)
        var one = findViewById<Button>(R.id.button14)
        var two = findViewById<Button>(R.id.button15)
        var three = findViewById<Button>(R.id.button16)
        var four = findViewById<Button>(R.id.button11)
        var five = findViewById<Button>(R.id.button12)
        var six = findViewById<Button>(R.id.button13)
        var seven = findViewById<Button>(R.id.button8)
        var eight = findViewById<Button>(R.id.button9)
        var nine = findViewById<Button>(R.id.button10)
        var zarb = findViewById<Button>(R.id.button)
        var jam = findViewById<Button>(R.id.button4)
        var menha = findViewById<Button>(R.id.button7)
        var run = findViewById<Button>(R.id.button2)
        var taghsim = findViewById<Button>(R.id.button5)
        var noghte = findViewById<Button>(R.id.button3)
        var pak = findViewById<Button>(R.id.button6)
        var vorodi = findViewById<EditText>(R.id.editText)
        var content = findViewById<LinearLayout>(R.id.content)
        var regex = Regex("(.*)(\\*|\\-|\\+|\\/)(.*)")
        var doubleregex = Regex(".*\\.(\\d*)")
        var pasokh:Int = 666
        var javab:Double = 9.6
        var avali:Double = 9.7
        var dovomi:Double = 9.8
        var amalvand:Any = "*"
        var matn = vorodi.text
        var error:Boolean = false

        // Codes

		//when run button clicked :
        run.setOnClickListener {
            error = false
            try {
                // find operator and operand with regex
                amalvand = regex.find(matn)!!.groups[2]!!.value
                avali = regex.find(matn)!!.groups[1]!!.value.toDouble()
                dovomi = regex.find(matn)!!.groups[3]!!.value.toDouble()
            } catch (e: Exception) {
                maketoast("Error ! Input is invalid Bro !")
                error = true
            }
            // diagnosis the operator
            try {
                when (amalvand) {
                    "*" -> javab = avali * dovomi
                    "+" -> javab = avali + dovomi
                    "-" -> javab = avali - dovomi
                    "/" -> javab = avali / dovomi
                    else -> {
                        maketoast("Error ! the operator is invallid Bro !")
                        error = true
                    }
                }
            } catch (e: Exception) {
                maketoast("Error !!")
            }

            // find floats
            try {
                pasokh = doubleregex.find(javab.toString())!!.groups[1]!!.value.toInt()
            } catch (e: Exception) {
                maketoast("Error !!!!")
                error = true
            }
            if(!error) {
                try {
                    // if answer was not float :
                    if (pasokh == 0) {
                        matn.clear()
                        matn.append(javab.toInt().toString())
                    }

                    //if answer was float :
                    else {
                        matn.clear()
                        matn.append(javab.toString())
                    }
                } catch (e: Exception) {
                    maketoast("Error!")
                }
            }
        }

        // when other Buttons clicked :
        content.setOnClickListener {
            maketoast("Gmail : Mersad23Akbari@gmail.com\nGitHub : MersadAkbari")
        }
        zero.setOnClickListener {
            matn.append("0")
        }
        one.setOnClickListener {
            matn.append("1")
        }
        two.setOnClickListener {
            matn.append("2")
        }
        three.setOnClickListener {
            matn.append("3")
        }
        four.setOnClickListener {
            matn.append("4")
        }
        five.setOnClickListener {
            matn.append("5")
        }
        six.setOnClickListener {
            matn.append("6")
        }
        seven.setOnClickListener {
            matn.append("7")
        }
        eight.setOnClickListener {
            matn.append("8")
        }
        nine.setOnClickListener {
            matn.append("9")
        }
        noghte.setOnClickListener {
            matn.append(".")
        }
        jam.setOnClickListener {
            matn.append("+")
        }
        menha.setOnClickListener {
            matn.append("-")
        }
        zarb.setOnClickListener {
            matn.append("*")
        }
        taghsim.setOnClickListener {
            matn.append("/")
        }
        pak.setOnClickListener {
            try{
                var ghabli:String = matn.toString()
                matn.clear()
                matn.append(ghabli.substring(0,ghabli.length-1))
            }
            catch (e:Exception){

            }

        }
        pak.setOnLongClickListener {
            try{
                var ghabli:String = matn.toString()
                matn.clear()
                matn.append(ghabli.removeRange(0,ghabli.length))
            }
            catch (e:Exception){
            }
            true
        }
    }
}
