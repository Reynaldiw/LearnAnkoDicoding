package com.reynaldiwijaya.learnankodicoding

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("aldi") ?: ""
        Log.d("TAGI", name)

        verticalLayout {
            imageView(R.drawable.dicoding).
                lparams(width = matchParent) {
                    padding = dip(20)
                    margin = dip(20)
                }

            textView {
                gravity = Gravity.CENTER
                textColor = Color.BLACK
                textSize = 24f
                text = "Hello $name, Welcome to Dicoding"

            }.lparams(width = matchParent) {
                margin = dip(20)
            }
        }

    }


    }