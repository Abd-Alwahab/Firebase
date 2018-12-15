package com.bayanadam.firebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.AuthCredential



class changeEmail : AppCompatActivity() {



    var user_email:EditText? =null
    var user_password:EditText? =null
    var new_email:EditText? = null
    var update: Button? = null
    var firebaseauth:FirebaseAuth? =null
    var user:FirebaseUser? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_email)


        user_email = findViewById(R.id.email_edit_text_change)
        user_password = findViewById(R.id.password_edit_text_change)
        new_email = findViewById(R.id.newemail_edit_text_change)
        update = findViewById(R.id.update_btn)
        firebaseauth = FirebaseAuth.getInstance()
        user = firebaseauth?.currentUser


        update?.setOnClickListener {

            UpdateEmail()
        }


    }


        private fun UpdateEmail() {


            var email = user_email?.text.toString().trim()
            var password = user_password?.text.toString().trim()
            var newemial = new_email?.text.toString().trim()



            var userInfo = EmailAuthProvider.getCredential(email,password)


            user?.reauthenticate(userInfo)?.addOnCompleteListener(object : OnCompleteListener<Void> {
                override fun onComplete(p0: Task<Void>) {

                    user!!.updateEmail(newemial).addOnCompleteListener(object : OnCompleteListener<Void> {
                        override fun onComplete(task: Task<Void>) {


                            if (task.isSuccessful) {

                                Toast.makeText(applicationContext,"You Email Has been Updated",Toast.LENGTH_SHORT).show()
                            }

                            else {


                                val error = task.exception?.message
                                Toast.makeText(applicationContext,"Error" + error,Toast.LENGTH_SHORT).show()


                            }


                        }


                    })


                }


            })


        }

}
