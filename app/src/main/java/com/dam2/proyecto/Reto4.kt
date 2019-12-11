package com.dam2.proyecto

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto1.*
import kotlinx.android.synthetic.main.activity_reto4.*
import org.jetbrains.anko.browse

class Reto4 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto4)




        imageButton1.setOnClickListener{
            browse("https://www.instagram.com/rafxsniperyt/")



            setResult(Activity.RESULT_OK)
            finish()
        }



    }
}
