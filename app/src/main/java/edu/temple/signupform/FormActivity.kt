package edu.temple.signupform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //get views for input and button

        val name = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val passwordCheck = findViewById<EditText>(R.id.passwordConfirmation)

        val saveButton = findViewById<Button>(R.id.saveButton)

        //create event listener for save button

        saveButton.setOnClickListener{

            //make sure every field has data entered
            if(name.text.isBlank()){
                name.error = "Please fill out the name field."
            } else if(email.text.isBlank()){
                email.error = "Please fill out the email field."
            } else if(password.text.isBlank()){
                password.error = "Please fill out the password field."
            } else if(passwordCheck.text.isBlank()){
                passwordCheck.error = "Please fill out the password field."
            }

            //make sure the password and password confirmation match
            else if(!password.text.toString().equals(passwordCheck.text.toString())) {
                Toast.makeText(this@FormActivity, "Please make sure password and password confirmation match.", Toast.LENGTH_LONG).show()
            }

            //no black fields, passwords match
            else {
                Toast.makeText(this@FormActivity, "Welcome to the SignUpForm App, " + name.text + "!", Toast.LENGTH_LONG).show()
            }
        }
    }
}