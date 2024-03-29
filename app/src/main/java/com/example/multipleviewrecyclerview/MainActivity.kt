package com.example.multipleviewrecyclerview

import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.ContactsContract.RawContacts.Data
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multipleviewrecyclerview.MultiViewAdapter.Companion.FIRST_VIEW
import com.example.multipleviewrecyclerview.MultiViewAdapter.Companion.SECOND_VIEW
import com.example.multipleviewrecyclerview.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import de.hdodenhof.circleimageview.BuildConfig
import java.io.File
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        progressBar = binding.progressBar

        showProgressBar()

        Handler().postDelayed({
            hideProgressBar()
            initView()
        }, 2000)


    }

    private fun initView() {
        binding.recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)

        var listAdapter = MultiViewAdapter(getList())
        listAdapter.onItemClick = {

            Toast.makeText(this, "${it.title}", Toast.LENGTH_SHORT).show()

        }

        binding.recyclerview.adapter = listAdapter

    }

    private fun getList(): ArrayList<DataModel> {

        val jsonString = getJsonDataFromAsset(applicationContext, "data.json")

        if (jsonString != null) {
            val gson = Gson()
            val listPersonType = object : TypeToken<ArrayList<DataModel>>() {}.type

            val data: ArrayList<DataModel> = gson.fromJson(jsonString, listPersonType)

            return data
        }

        return arrayListOf(( DataModel("https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",FIRST_VIEW, "Android Development", "You will be Learning the Complete Android Dev")))
    }

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }
}