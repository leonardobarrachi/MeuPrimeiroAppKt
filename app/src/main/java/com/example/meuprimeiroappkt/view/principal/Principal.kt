package com.example.meuprimeiroappkt.view.principal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meuprimeiroappkt.databinding.ActivityPrincipalBinding
import com.example.meuprimeiroappkt.view.login.Login
import com.google.firebase.auth.FirebaseAuth

class Principal : AppCompatActivity() {
    private lateinit var binding:ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSair.setOnClickListener {
            FirebaseAuth.getInstance().signOut()//recupera a instancia do servidor e sai do sistema pelo .sigOut
            val voltaTelaLogin = Intent(this, Login::class.java) // após sair volta para tela login
            startActivity(voltaTelaLogin) // ir para tela login
            finish() // fim
            
        }
    }
}