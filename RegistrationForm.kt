package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.autostrings.DBHelper

class RegistrationForm : AppCompatActivity() {

//    private lateinit var fname : EditText
//    private lateinit var lname : EditText
//    private lateinit var houseno : EditText
//    private lateinit var city : EditText
//    private lateinit var state : EditText
//    private lateinit var pincode : EditText
//    private lateinit var phoneno : EditText
//    private lateinit var email : EditText
//    private lateinit var manufacturer : EditText
//    private lateinit var model : EditText
//    private lateinit var year : EditText
//    private lateinit var submitbtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_form)
        var dbHelper = DBHelper (applicationContext)

        val submitbtn = this.findViewById<Button>(R.id.submitbtn);

        fun register():Boolean? {
            val fname = this.findViewById<EditText>(R.id.fname);
            val lname = this.findViewById<EditText>(R.id.lname);
            val houseno = this.findViewById<EditText>(R.id.houseno);
            val city = this.findViewById<EditText>(R.id.city);
            val state = this.findViewById<EditText>(R.id.state);
            val pincode = this.findViewById<EditText>(R.id.pincode);
            val phoneno = this.findViewById<EditText>(R.id.phoneno);
            val email = this.findViewById<EditText>(R.id.email);
            val manufacturer = this.findViewById<EditText>(R.id.manufacturer);
            val model = this.findViewById<EditText>(R.id.model);
            val year = this.findViewById<EditText>(R.id.year);

            return dbHelper.registerUser(
                phoneno.text.toString(),
                fname.text.toString(),
                lname.text.toString(),
                houseno.text.toString(),
                city.text.toString(),
                state.text.toString(),
                pincode.text.toString(),
                email.text.toString(),
                manufacturer.text.toString(),
                model.text.toString(),
                year.text.toString());

        }


        submitbtn.setOnClickListener {

            if (register() == true) {
                Toast.makeText(applicationContext, "Successfully Registered", Toast.LENGTH_SHORT).show()

                var intent = Intent(this, SuccessfullyRegistered::class.java)
                startActivity(intent)

            }

            else {
                Toast.makeText(applicationContext, "Unable to register!", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this, SuccessfullyRegistered::class.java)
                startActivity(intent)
            }

        }

    }

    class SuccessfullyRegistered {

    }
}