package com.example.memepro

import android.accessibilityservice.GestureDescription.StrokeDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONObject
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    val url : String = "https://meme-api.com/gimme"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var nxt : Button = findViewById(R.id.next)


        ftch()

        nxt.setOnClickListener{
        ftch()

        }

    }

    private fun ftch() {
        var image : ImageView = findViewById(R.id.image)
        val queue = Volley.newRequestQueue(this)


        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                Log.e("Response","geteMemeData : " + response.toString())
                var res = JSONObject(response)


                Glide.with(this).load(res.get("url")).into(image);
            },
            {
                Toast.makeText(this@MainActivity,"some error occured",Toast.LENGTH_SHORT).show()
            })

        queue.add(stringRequest)
    }
}