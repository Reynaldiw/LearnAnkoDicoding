package com.reynaldiwijaya.learnankodicoding

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        verticalLayout {
//            imageView(R.drawable.dicoding).
//                    lparams(width = matchParent) {
//                        margin = dip(20)
//                        padding = dip(20)
//        }
//
//        val name = editText(){
//            hint = "Whats your name ?"
//        }
//
//
//        button("Say Hello")
//
//    }
//
//
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)


    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                imageView(R.drawable.dicoding).
                    lparams(width = matchParent) {
                        padding = dip(20)
                        margin = dip(20)
                    }

                val name = editText {
                    hint = "What's your name ?"
                }

                button("Say Hello") {
                    onClick {
                        alert ("Pindah halaman ?") {
                            yesButton { startActivity<SecondActivity>("aldi" to name.text.toString())
                                toast("Hello ${name.text}, Welcome to Dicoding")
                            }
                            noButton {  }
                        }.show()
                        Log.d("TAG", name.text.toString())
                    }
                }

                button("Selector") {
                    onClick {
                        val club = listOf("Barcelona", "Manchaster United", "PSG", "Barcelona", "Chelsea")
                        selector("Hello, What's football club do you love ?", club, { _, i ->
                            toast("Your favorite football club is ${club[i]}, right ?")
                        })
                    }
                }
                button("Progress Dialog") {
                    onClick {
                        indeterminateProgressDialog("Hello, Please wait").show()
                    }
                }
                button("Snackbar") {
                    onClick {
                        snackbar( this,"Hello ${name.text}")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(8)
                }
            }
        }
    }
}
