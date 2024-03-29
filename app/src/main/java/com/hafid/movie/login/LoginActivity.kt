package com.hafid.movie.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hafid.movie.MainActivity
import com.hafid.movie.R
import com.hafid.movie.login.data.User
import com.hafid.movie.login.presenter.LoginPresenter
import com.hafid.movie.login.presenter.LoginView
import com.hafid.movie.register.RegisterActivity
import com.hafid.movie.utils.SessionManager
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.yesButton

class LoginActivity : AppCompatActivity(), LoginView {
    private lateinit var presenter: LoginPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)
        btnLogin.onClick {
            presenter.login(edtEmail.text.toString(), edtPassword.text.toString())

        }
        linkRegister.onClick {
            startActivity<RegisterActivity>()
        }
    }

    override fun onSuccessLogin(user: User?, msg: String?) {
        val sesi = SessionManager(this)
        sesi.cerateLoginSession("1")
        sesi.email = user?.userEmail
        sesi.nama = user?.userNama
        sesi.phone  = user?.userHp

        startActivity<MainActivity>()
        startActivity<MainActivity>()

    }

    override fun onErrorLogin(msg: String?) {
        alert {
            title = "Informasi"
            message = msg ?:""
            yesButton {

            }

        }.show()
    }
}
