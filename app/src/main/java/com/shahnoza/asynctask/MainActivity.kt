package com.shahnoza.asynctask

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var progressBar: ProgressBar
    var startTime=0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textView=findViewById(R.id.btnAsynctask)
        progressBar=findViewById(R.id.pg)
        MyAsync()


    }
    inner class MyAsync: AsyncTask<Void?, Void?, Void?>(){
        override fun onPreExecute() { // oqim boshlanishi
            super.onPreExecute()
            progressBar.visibility = View.VISIBLE
            progressBar.setProgress(100,true)

        }

        override fun doInBackground(vararg params: Void?): Void? {
            // oqim o`rtasi beriladigan vazifalar shu yerda yoziladi
            //returning()
            for (i in 0..60){
                startTime+=i
                Thread.sleep(100)
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            // vazifalar yakunlangach shu funktsiya ishga tushadi va ishni yakunlaydi
            textView.text = "$startTime%"
            Toast.makeText(this@MainActivity, "Yakunlandi!", Toast.LENGTH_SHORT).show()
            progressBar.visibility = View.GONE
        }


    }

}