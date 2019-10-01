package com.hafid.movie.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hafid.movie.R
import com.hafid.movie.login.LoginActivity
import com.hafid.movie.register.presenter.RegisterPresenter
import com.hafid.movie.register.presenter.RegisterView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class RegisterActivity : AppCompatActivity(), RegisterView {
    override fun onSuccessRegister(msg: String?) {
        alert {
            title = "Pesan"
            message = msg ?: ""
        }.show()
    }

    override fun onErrorResgister(msg: String?) {
        alert {
            title = "Gagal"
            message = msg ?:""
        }.show()
    }

    private lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        presenter = RegisterPresenter(this)

        btnRegister.onClick {
            val nama  = registerName.text.toString()
            val email  = registerEmail.text.toString()
            val hp  = registerHp.text.toString()
            val password  = registerPassword.text.toString()

            presenter.register(nama, email, hp, password)

        }
        linkLogin.onClick {
            startActivity<LoginActivity>()
        }
    }
}
