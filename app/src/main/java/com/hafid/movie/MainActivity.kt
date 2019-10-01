package com.hafid.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hafid.movie.register.presenter.RegisterPresenter
import com.hafid.movie.register.presenter.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}


