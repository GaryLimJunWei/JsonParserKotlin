package com.example.garylim.jsonparser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main2.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class Main2Activity : AppCompatActivity() {

    var arr = arrayListOf<String>()
    //Creating an ArrayList to store the value
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
            var json: String ? = null
            try
            {
                //Using InputStream to read the Json File
                var inputStream : InputStream = assets.open("First.json")
                //Storing the Json File inside json variable
                /*
                * The use keyword is an inline function used to execute given block
                * function on this resource. Additional benefits that even if there is an
                * exception while executing the given block function, it is expected
                * that the resource is closed down correctly
                * */

                /*
                * The it keyword is used in Kotlin when you have a function literal with
                * exactly one parameters you don't have to define the parameter explicitly
                * and you can use it. This make it easier to use without specifying.
                * */
                json = inputStream.bufferedReader().use { it.readText() }


                /*
                * Creating an JSONArray to store the data of the file
                * Using a for loop to display
                * */
                var jsonarr = JSONArray(json)
                for(i in 0..jsonarr.length()-1)
                {
                    //Creating an object and store the array of Json File
                    var jsonobj = jsonarr.getJSONObject(i)
                    arr.add("Name : "+(jsonobj.getString("first_name")) + " " + jsonobj.getString("last_name"))
                    arr.add("Gender : " +(jsonobj.getString("gender")))
                    arr.add("Email : " +(jsonobj.getString("email")))
                    arr.add("IP Address : " +(jsonobj.getString("ip_address")))
                    arr.add(" ")
                }


                // Creating an Adapter to convert the Array into ListView
                var adpt = ArrayAdapter(this,android.R.layout.simple_list_item_1,arr)
                json_text.adapter = adpt

            }
            catch (e : IOException)
            {
                println("Error")
            }



    }
}
