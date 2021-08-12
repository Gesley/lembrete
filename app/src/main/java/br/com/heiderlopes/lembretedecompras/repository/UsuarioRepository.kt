package br.com.heiderlopes.lembretedecompras.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.heiderlopes.lembretedecompras.models.RequestState
import br.com.heiderlopes.lembretedecompras.models.Usuario
import java.lang.Exception

class UsuarioRepository(private val context: Context) {

    private val SHARED_PREF = "lembretedecompras"
    private val SHARED_PREF_KEY_EMAIL = "email"

    fun logar(usuario: Usuario): LiveData<RequestState<Boolean>> {

        val response = MutableLiveData<RequestState<Boolean>>()

        if (usuario.email == "fiap@fiap.com.br" && usuario.senha == "12345") {

            val pref = context.getSharedPreferences(SHARED_PREF, 0)

            val edit = pref.edit()
            edit.putString(SHARED_PREF_KEY_EMAIL, usuario.email)
            edit.apply()

            response.value = RequestState.Success(true)
        } else {
            response.value = RequestState.Error(Exception("Usuário ou senha invalido"))
        }

        return response
    }


    fun getUsuarioLogado(): LiveData<RequestState<String>> {

        val response = MutableLiveData<RequestState<String>>()

        val pref = context.getSharedPreferences(SHARED_PREF, 0)
        val email = pref.getString(SHARED_PREF_KEY_EMAIL, "") ?: ""
        response.value = RequestState.Success(email)

        return response
    }

}