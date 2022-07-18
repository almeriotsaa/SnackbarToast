package com.example.toastandsnackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.toastandsnackbar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    /*private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSnackbar.setOnClickListener {
            val snackbar = Snackbar.make(binding.root, "Berhasil Muncul", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("Retry"){
                Snackbar.make(binding.root, "Retry Di Pencet", Snackbar.LENGTH_SHORT).show()
            }.show()
        }

        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "Ini Toast", Toast.LENGTH_SHORT).show()
        }
    }*/
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn_toast)
        val layoutInflater: LayoutInflater = layoutInflater
        val viewLay =
            layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_layout))
        btn.setOnClickListener {
            val custom_toast =
                Toast.makeText(this@MainActivity, "Toast:Gravity.Top", Toast.LENGTH_SHORT)
            custom_toast.view = viewLay
            custom_toast.show()
        }

        // create a snackbar

        val btnSnackbar = findViewById<Button>(R.id.btn_snackbar)
        btnSnackbar.setOnClickListener {
            val snackbar = Snackbar.make(
                findViewById(R.id.btn_toast),
                "Berhasil Muncul",
                Snackbar.LENGTH_INDEFINITE
            )
            snackbar.setAction("Retry") {
                Snackbar.make(findViewById(R.id.btn_toast), "Retry Di Pencet", Snackbar.LENGTH_SHORT)
                    .show()
            }.show()

        }
    }

}