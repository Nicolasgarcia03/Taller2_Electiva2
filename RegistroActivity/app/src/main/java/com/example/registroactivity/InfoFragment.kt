package com.example.registroactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_info.*

class InfoFragment(val nombre: String?, val apellido: String, val tipDoc: String,
                   val document: String, val fechaNaci: String, val hobbies: String,
                   val contrasena: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)

   }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nombreEdit.setText(nombre)
        apellidosEdit.setText(apellido)
        tipoDocEdit.setText(tipDoc)
        documentoEdit.setText(document)
        fechaEdit.setText(fechaNaci)
        hobbiesEdit.setText(hobbies)
        contrasenaEdit.setText(contrasena)
    }

}

