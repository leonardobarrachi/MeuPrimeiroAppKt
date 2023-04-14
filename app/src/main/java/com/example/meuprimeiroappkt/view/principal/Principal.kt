package com.example.meuprimeiroappkt.view.principal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meuprimeiroappkt.databinding.ActivityPrincipalBinding
import com.example.meuprimeiroappkt.view.contatos.TelaContatos
import com.example.meuprimeiroappkt.view.editais.TelaEditais
import com.example.meuprimeiroappkt.view.eventos.TelaEventos
import com.example.meuprimeiroappkt.view.login.Login
import com.example.meuprimeiroappkt.view.orcamento.TelaOrcamento
import com.example.meuprimeiroappkt.view.turismo.TelaTurismo
import com.google.firebase.auth.FirebaseAuth

class Principal : AppCompatActivity() {
    private lateinit var binding:ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityPrincipalBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.btSair.setOnClickListener {
                FirebaseAuth.getInstance()
                    .signOut()//recupera a instancia do servidor e sai do sistema pelo .sigOut
                val voltaTelaLogin = Intent(this, Login::class.java) // após sair volta para tela login
                startActivity(voltaTelaLogin) // ir para tela login
                finish() // fim

            }
            binding.button.setOnClickListener {
                val irEditais = Intent(this,TelaEditais::class.java)
                startActivity(irEditais)
            }

            binding.button4.setOnClickListener {
                val irEventos = Intent(this,TelaEventos::class.java)
                startActivity(irEventos)
            }

            binding.button5.setOnClickListener {
                val irTurismo = Intent(this,TelaTurismo::class.java)
                startActivity(irTurismo)
            }

             binding.button6.setOnClickListener {
               val irOrcamento = Intent(this,TelaOrcamento::class.java)
                 startActivity(irOrcamento)
        }

             binding.button7.setOnClickListener {
                 val irContatos = Intent(this,TelaContatos::class.java)
                 startActivity(irContatos)
        }



    }

}