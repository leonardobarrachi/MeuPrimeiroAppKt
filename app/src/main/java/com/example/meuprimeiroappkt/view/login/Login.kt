package com.example.meuprimeiroappkt.view.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meuprimeiroappkt.databinding.ActivityLoginBinding
import com.example.meuprimeiroappkt.view.cadastro.Cadastro
import com.example.meuprimeiroappkt.view.principal.Principal
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btEntrar.setOnClickListener{ view->
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()){
                val snackbar = Snackbar.make(view,"Preencha todos os campos", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show() // caso não corresponda mostrará mensagem

            }else{
                auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener { autenticacao ->
                    if(autenticacao.isSuccessful){
                      goToPrincipal()
                    }
                }.addOnFailureListener {

                    val snackbar = Snackbar.make(view,"Erro de login", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show() // mostra de nensagem de erro generico
                }
            }
        }

        binding.textTelaCadastro.setOnClickListener {
            val intent = Intent(this,Cadastro::class.java)
            startActivity(intent)
        }
    }
    private fun goToPrincipal(){
        val intent = Intent(this, Principal::class.java)
        startActivity(intent)
        finish()
    }
// variável userNow verifica se o usuário esta logado.. se sim vai para a principal
    // se desativar a função abaixo o sistema voltará para a tela de login
    override fun onStart() {
        super.onStart()
        val userNow = FirebaseAuth.getInstance().currentUser
        if(userNow != null){ // se for nulo não tem usuário logado
            goToPrincipal()

        }
    }
}