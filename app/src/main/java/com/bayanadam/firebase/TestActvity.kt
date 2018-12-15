package com.bayanadam.firebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TestActvity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_actvity)


    }


    fun changeEmail_btn(view: View) {

        startActivity(Intent(this@TestActvity,changeEmail::class.java))
    }


    fun profile(view: View) {

        startActivity(Intent(this@TestActvity,profile_activity::class.java))
    }


    fun info(view: View) {

        startActivity(Intent(this@TestActvity,user_info::class.java))

    }

    fun image(view: View) {

        startActivity(Intent(this@TestActvity,firebase_storage::class.java))

    }
}
