package com.example.registroactivity

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_hobbies.*

class HobbiesFragment(val listener: (String) -> Unit) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_hobbies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var Hobbies: String = ""
        HobbiesButton.setOnClickListener{
            val builder = AlertDialog.Builder(requireContext())
            val list: ArrayList<String> = ArrayList()
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
                        list.add("Automóviles")
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
                hobbiesEdit.setText(list.joinToString(", "))

            }
            builder.show()
        }
        CallBackButton.setOnClickListener {
            listener(hobbiesEdit.text.toString())
        }
    }

}