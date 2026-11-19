package com.example.compteurandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    // Variable entière pour le compteur, initialisée à 0
    private var compteur: Int = 0

    // Déclaration des vues
    private lateinit var textViewCompteur: TextView
    private lateinit var buttonIncrementer: Button
    private lateinit var buttonDecrementer: Button
    private lateinit var buttonReinitialiser: Button
    private lateinit var buttonPlusCinq: Button
    private lateinit var buttonMoinsCinq: Button

    companion object {
        private const val KEY_COMPTEUR = "compteur_valeur"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Récupération des composants graphiques par leurs identifiants
        textViewCompteur = findViewById(R.id.textViewCompteur)
        buttonIncrementer = findViewById(R.id.buttonIncrementer)
        buttonDecrementer = findViewById(R.id.buttonDecrementer)
        buttonReinitialiser = findViewById(R.id.buttonReinitialiser)
        buttonPlusCinq = findViewById(R.id.buttonPlusCinq)
        buttonMoinsCinq = findViewById(R.id.buttonMoinsCinq)

        // Restauration de l'état si rotation de l'écran
        if (savedInstanceState != null) {
            compteur = savedInstanceState.getInt(KEY_COMPTEUR, 0)
        }

        // Mise à jour initiale de l'interface
        actualiserAffichage()

        // Bouton + (incrémenter de 1)
        buttonIncrementer.setOnClickListener {
            compteur++
            actualiserAffichage()
        }

        // Bouton - (décrémenter de 1)
        buttonDecrementer.setOnClickListener {
            compteur--
            actualiserAffichage()
        }

        // Bouton +5 (amélioration facultative)
        buttonPlusCinq.setOnClickListener {
            compteur += 5
            actualiserAffichage()
        }

        // Bouton -5 (amélioration facultative)
        buttonMoinsCinq.setOnClickListener {
            compteur -= 5
            actualiserAffichage()
        }

        // Bouton Réinitialiser (remet le compteur à 0)
        buttonReinitialiser.setOnClickListener {
            compteur = 0
            actualiserAffichage()
            // Toast de confirmation (amélioration facultative)
            Toast.makeText(this, getString(R.string.toast_reinitialise), Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Actualise la valeur affichée et change la couleur en fonction du signe :
     * - Vert si positif (> 0)
     * - Rouge si négatif (< 0)
     * - Noir / Neutre si nul (= 0)
     */
    private fun actualiserAffichage() {
        textViewCompteur.text = compteur.toString()

        val couleur = when {
            compteur > 0 -> ContextCompat.getColor(this, R.color.color_positif)
            compteur < 0 -> ContextCompat.getColor(this, R.color.color_negatif)
            else -> ContextCompat.getColor(this, R.color.color_neutre)
        }
        textViewCompteur.setTextColor(couleur)
    }

    // Sauvegarde de l'état avant rotation
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COMPTEUR, compteur)
    }

    // Restauration de l'état après rotation
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        compteur = savedInstanceState.getInt(KEY_COMPTEUR, 0)
        actualiserAffichage()
    }
}
