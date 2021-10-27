package com.example.recipeapproom

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity2 : AppCompatActivity() {
    var words = listOf<RecipeDetails>()
    lateinit var myRv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        myRv = findViewById(R.id.recyclerView)
        //progress
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait")
        progressDialog.show()
        rv()
        progressDialog.dismiss()
    }

    fun rv() {
        CoroutineScope(Dispatchers.IO).launch {
            words = RecipeDatabase.getInstance(applicationContext).RecipeDao()
                .getRecipe()
            withContext(Dispatchers.Main) {
                //recycler view
                myRv.adapter = RecyclerViewAdapter(words)
                myRv.layoutManager = LinearLayoutManager(this@MainActivity2)
            }
        }
    }
}