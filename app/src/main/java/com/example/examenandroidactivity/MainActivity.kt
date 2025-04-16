package com.example.examenandroidactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val nameError = findViewById<TextView>(R.id.nameError)

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val emailError = findViewById<TextView>(R.id.emailError)

        val ageInput = findViewById<EditText>(R.id.ageInput)
        val ageError = findViewById<TextView>(R.id.ageError)

        nameInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val name = s.toString()
                if (name.length < 3) {
                    nameError.text = "El nombre debe tener al menos 3 caracteres"
                    nameError.visibility = TextView.VISIBLE
                } else {
                    nameError.visibility = TextView.GONE
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        emailInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val email = s.toString()
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailError.text = "Introduce un correo válido"
                    emailError.visibility = TextView.VISIBLE
                } else {
                    emailError.visibility = TextView.GONE
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        ageInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val age = s.toString().toIntOrNull()
                if (age == null || age < 18 || age > 99) {
                    ageError.text = "La edad debe estar entre 18 y 99 años"
                    ageError.visibility = TextView.VISIBLE
                } else {
                    ageError.visibility = TextView.GONE
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}