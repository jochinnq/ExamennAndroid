package com.example.examenandroidactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
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

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            val name = nameInput.text.toString()
            val email = emailInput.text.toString()
            val age = ageInput.text.toString().toIntOrNull() ?: 0

            if (name.length >= 3 && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && age in 18..99) {
                val intent = Intent(this, PokemonListActivity::class.java)
                intent.putExtra("USER_NAME", name)
                startActivity(intent)
            }
        }

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