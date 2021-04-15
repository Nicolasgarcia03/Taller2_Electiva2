package com.example.registroactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    var hobb: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val infoButton: Button = findViewById<Button>(R.id.infoButton)
        val hobbiesButton: Button = findViewById<Button>(R.id.hobbiesButton)

        ///Hobbies


        ///Extras
        val nombre = intent.getStringExtra("nombre").toString()
        val apellido = intent.getStringExtra("apellido").toString()
        val tipDoc = intent.getStringExtra("tipDoc").toString()
        val document = intent.getStringExtra("document").toString()
        val fechaNaci = intent.getStringExtra("fechaNaci").toString()
        hobb = intent.getStringExtra("hobbies").toString()
        val contrasena = intent.getStringExtra("contrasena").toString()

        infoButton.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.container, InfoFragment(nombre, apellido, tipDoc,
                                                        document, fechaNaci, hobb,
                                                        contrasena), null )
            transaction.commit()
        }

        hobbiesButton.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            val HobbiesFragment = HobbiesFragment() { hobbies ->
                hobb = hobbies
            }
            transaction.add(R.id.container, HobbiesFragment, null )
            transaction.commit()
        }
    }
}