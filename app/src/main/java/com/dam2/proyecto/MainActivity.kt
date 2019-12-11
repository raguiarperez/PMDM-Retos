package com.dam2.proyecto

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.service.autofill.Validators.and
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_reto1.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.toast

const val PICK_RETO1_REQUEST = 1
const val PICK_RETO2_REQUEST = 2
const val PICK_RETO3_REQUEST = 3
const val PICK_RETO4_REQUEST = 4

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //reto1

        boton1.setOnClickListener{
            //buscar con browser en internet en otra activity
            val intent = Intent(this, Reto1::class.java)//creamos el intent
            startActivityForResult(intent, PICK_RETO1_REQUEST)//iniciamos
        }

        //reto2
        boton2.setOnClickListener{
            //buscar con browser en internet en otra activity
            val intent2 = Intent(this, Reto2::class.java)//creamos el intent
            startActivityForResult(intent2, PICK_RETO2_REQUEST)//iniciamos
        }

        //reto3
        boton3.setOnClickListener{
            //buscar con browser en internet en otra activity
            val intent3 = Intent(this, Reto3::class.java)//creamos el intent
            startActivityForResult(intent3, PICK_RETO3_REQUEST)//iniciamos
        }

        boton4.setOnClickListener{
            //buscar con browser en internet en otra activity
            val intent4 = Intent(this, Reto4::class.java)//creamos el intent
            startActivityForResult(intent4, PICK_RETO4_REQUEST)//iniciamos
            Log.d("TAAAAG!!!!!!!!", "btn")
        }

    }

    @SuppressLint("ResourceAsColor")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("MisErrores","errores")

        //Reto1
        if (requestCode == PICK_RETO1_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if ((data?.getStringExtra("resp").toString()).equals("1923")){
                    boton1.setBackgroundColor(Color.GREEN)//boton verde= acierto
                    Log.d("MisErrores","errores verde")
                    toast("CORRECTO")//toast informativa
                }else {
                    boton1.setBackgroundColor(Color.RED)//boton rojo= error
                    Log.d("MisErrores","errores rojo")
                    toast("INCORRECTO")//toast informativa
                }
            }else{
                respuesta.setText("Error al pasar datos")
            }
            boton1.setEnabled(false)//desactivamos el reto, ya se ha realizado
        }

        //Reto2

        if (requestCode == PICK_RETO2_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if (data?.getBooleanExtra("resp",false)!!.equals(true)){
                    boton2.setBackgroundColor(Color.GREEN)//boton verde= acierto
                    Log.d("MisErrores","errores verde")
                    toast("CORRECTO")//toast informativa
                }else {
                    boton2.setBackgroundColor(Color.RED)//boton rojo= error
                    Log.d("MisErrores","errores rojo")
                    toast("INCORRECTO")//toast informativa
                }
            }else{
                respuesta.setText("Error al pasar datos")
            }
            boton2.setEnabled(false)//desactivamos el reto, ya se ha realizado
        }

        //Reto3

        if (requestCode == PICK_RETO3_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if ((data?.getStringExtra("resp1").toString().equals("6"))){
                    boton3.setBackgroundColor(Color.GREEN)//boton verde= acierto
                    Log.d("MisErrores","errores verde")
                    toast("CORRECTO")//toast informativa
                }else {
                    boton3.setBackgroundColor(Color.RED)//boton rojo= error
                    Log.d("MisErrores","errores rojo")
                    toast("INCORRECTO")//toast informativa
                }
            }else{
                respuesta.setText("Error al pasar datos")
            }
            boton3.setEnabled(false)//desactivamos el reto, ya se ha realizado
        }


        //Reto 4
        if (requestCode == PICK_RETO4_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if (data?.getBooleanExtra("resp",false)!!.equals(true)){
                    boton4.setBackgroundColor(Color.GREEN)//boton verde= acierto
                    Log.d("MisErrores","errores verde")
                    toast("CORRECTO")//toast informativa
                }else {
                    boton4.setBackgroundColor(Color.RED)//boton rojo= error
                    Log.d("MisErrores","errores rojo")
                    toast("INCORRECTO")//toast informativa
                }
            }else{
                respuesta.setText("Error al pasar datos")
            }
            boton4.setEnabled(false)//desactivamos el reto, ya se ha realizado
        }





    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
