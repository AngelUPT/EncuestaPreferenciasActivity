package com.angelcorrea.encuestapreferenciasactivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val colorFavoritoEditText = findViewById<EditText>(R.id.editTextText)
        val comidaFavoritaEditText = findViewById<EditText>(R.id.editTextText2)
        val enviarButton = findViewById<Button>(R.id.button)

        enviarButton.setOnClickListener {
            val colorFavorito = colorFavoritoEditText.text.toString()
            val comidaFavorita = comidaFavoritaEditText.text.toString()

            if (colorFavorito.isEmpty() || comidaFavorita.isEmpty()) {
                    Toast.makeText(this, "Completa todos los campos.", Toast.LENGTH_SHORT).show()
            } else {
                val mensaje = """
                    Color Favorito: $colorFavorito
                    Comida Favorita: $comidaFavorita
                """.trimIndent()

                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            }
        }
    }
}