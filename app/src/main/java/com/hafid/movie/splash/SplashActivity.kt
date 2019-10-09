package com.hafid.movie.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.hafid.movie.MainActivity
import com.hafid.movie.R
import com.hafid.movie.login.LoginActivity
import com.hafid.movie.utils.SessionManager
import kotlinx.coroutines.delay
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var sesi = SessionManager(this)
        Handler().postDelayed(Runnable {
            if (sesi.isLogin){
                startActivity<MainActivity>()
            }else{
                startActivity<LoginActivity>()
            }
            finish()

        }, 2000)
    }
}
