package com.example.registroactivity

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ///Button
        val btnTipDoc: Button = findViewById<Button>(R.id.tipoDocButton)
        val btnFecha: Button = findViewById<Button>(R.id.fechaButton)
        val btnHobbies: Button = findViewById<Button>(R.id.HobbiesButton)
        val btnRegistro: Button = findViewById<Button>(R.id.registroButton)
        val btnReset: Button = findViewById<Button>(R.id.resetButton)

        ///EditText
        val etxtNombre: EditText = findViewById<EditText>(R.id.nombreEdit)
        val etxtApellidos: EditText = findViewById<EditText>(R.id.apellidosEdit)
        val etxtTipDoc: EditText = findViewById<EditText>(R.id.tipoDocEdit)
        val etxtDocumento: EditText = findViewById<EditText>(R.id.documentoEdit)
        val etxtFecha: EditText = findViewById<EditText>(R.id.fechaEdit)
        val etxtHobbies: EditText = findViewById<EditText>(R.id.hobbiesEdit)
        val etxtContrasena: EditText = findViewById<EditText>(R.id.contrasenaEdit)
        val etxtConfirContrasena: EditText = findViewById<EditText>(R.id.confirContraEdit)


        btnTipDoc.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Tipo de Documento")
            builder.setItems(
                arrayOf(
                    "Tarjeta de Identidad",
                    "Cédula de Ciudadania",
                    "Cédula de Extrangeria",
                    "Pasaporte",
                    "Registro Civil")
            ) { _, position ->
                when(position) {
                    0 ->
                        etxtTipDoc.setText("Tarjeta de Identidad")
                    1 ->
                        etxtTipDoc.setText("Cédula de Ciudadania")
                    2 ->
                        etxtTipDoc.setText("Cédula de Extrangeria")
                    3 ->
                        etxtTipDoc.setText("Pasaporte")
                    else ->
                        etxtTipDoc.setText("Registro Civil")
                }
            }
            builder.show()
        }

        btnFecha.setOnClickListener{
            val dialog = DatePickerDialog(this, { dialog, year, month, day ->
                Toast.makeText(this, "Seleccionó el año ".plus(year).plus(" con el mes ").plus(month).plus(" y con el día ").plus(day), Toast.LENGTH_SHORT).show()
                etxtFecha.setText("${day}/${month + 1}/${year}")
            }, 2021, 3, 13)
            dialog.show()
        }

        btnHobbies.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val list: ArrayList<String> = ArrayList()
            val hobbies: String
            builder.setTitle("Selecciona los Hobbies")
            builder.setMultiChoiceItems(arrayOf(
                "Motocicletas",
                "Automoviles",
                "Escuchar Musica",
                "Deportes"), null) { dialog, position, isChecked ->
                if(isChecked){
                    if(position == 0){
                        list.add("Motocicletas")
                    }
                    if(position == 1){
                        list.add("Automoviles")
                    }
                    if(position == 2){
                        list.add("Escuchar Musica")
                    }
                    if(position == 3){
                        list.add("Deportes")
                    }
                }
                else{
                    if(position == 0){
                        list.remove("Motocicletas")
                    }
                    if(position == 1){
                        list.remove("Automoviles")
                    }
                    if(position == 2){
                        list.remove("Escuchar Musica")
                    }
                    if(position == 3){
                        list.remove("Deportes")
                    }
                }
                etxtHobbies.setText(list.joinToString(", "))
            }
            builder.show()
        }

        btnRegistro.setOnClickListener {
            var registro = true

            if ( TextUtils.isEmpty(etxtNombre.text)){
                registro = false
            }
            if ( TextUtils.isEmpty(etxtApellidos.text)){
                registro = false
            }
            if ( TextUtils.isEmpty(etxtTipDoc.text)){
                registro = false
            }
            if ( TextUtils.isEmpty(etxtDocumento.text)){
                registro = false
            }
            if ( TextUtils.isEmpty(etxtFecha.text)){
                registro = false
            }
            if ( TextUtils.isEmpty(etxtHobbies.text)){
                registro = false
            }
            if ( TextUtils.isEmpty(etxtContrasena.text)){
                registro = false
            }
            if ( TextUtils.isEmpty(etxtConfirContrasena.text)){
                registro = false
            }
            if ( etxtContrasena.text.toString() != etxtConfirContrasena.text.toString()){
                registro = false
            }

            if (registro){
                val dialogView = layoutInflater.inflate(R.layout.terminos_condiciones, null)
                val builder = AlertDialog.Builder(this)

                builder.setTitle("Bienvenido")
                builder.setMessage("Desea registrarse?")
                builder.setView(dialogView)
                builder.show()

                val btnaceptar = dialogView.findViewById<Button>(R.id.btnaceptar)
                btnaceptar.setOnClickListener {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("nombre", etxtNombre.text.toString())
                    intent.putExtra("apellido", etxtApellidos.text.toString())
                    intent.putExtra("tipDoc", etxtTipDoc.text.toString())
                    intent.putExtra("document", etxtDocumento.text.toString())
                    intent.putExtra("fechaNaci", etxtFecha.text.toString())
                    intent.putExtra("hobbies", etxtHobbies.text.toString())
                    intent.putExtra("contrasena", etxtContrasena.text.toString())
                    this.startActivity(intent)
                }
            }else{

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Informe de Errores")
                builder.setMessage("Debe llenar todos los campos ya que son obligatorios")
                builder.setPositiveButton("Aceptar") { _, _ ->
                    Toast.makeText(this, "Campos Obligatorios", Toast.LENGTH_LONG).show()
                }
                builder.setCancelable(false)
                builder.show()
            }
        }

        btnReset.setOnClickListener(){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Limpiar Formulario")
            builder.setMessage("¿Seguro que desea limpiar el formulario?")
            builder.setPositiveButton("Aceptar") { _, _ ->
                etxtNombre.setText("")
                etxtApellidos.setText("")
                etxtTipDoc.setText("")
                etxtDocumento.setText("")
                etxtFecha.setText("")
                etxtHobbies.setText("")
                etxtContrasena.setText("")
                etxtConfirContrasena.setText("")
            }
            builder.setNegativeButton("Cancelar") { _,_ ->
                Toast.makeText(this, "No se limpio el formulario", Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Ver después", null)
            builder.setCancelable(false)
            builder.show()
        }
    }
}