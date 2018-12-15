package com.bayanadam.firebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import org.w3c.dom.Text

class user_info : AppCompatActivity() {


    var firstName:TextView? = null
    var lastName:TextView? =null
    var userName:TextView? = null
    var firebaseAuth:FirebaseAuth? = null
    var firebaseDatabase: DatabaseReference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        firstName = findViewById(R.id.firstName_textview)
        lastName = findViewById(R.id.lastName_textview)
        userName = findViewById(R.id.userName_textview)
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseAuth?.currentUser!!.uid)





        firebaseDatabase?.addValueEventListener(object  : ValueEventListener {


            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(task: DataSnapshot) {


                if (task.exists()) {

                    val firstname = task.child("firstName").value as String
                    val lastname = task.child("lastName").value as String
                    val username = task.child("userName").value as String


                    firstName?.text = firstname
                    lastName?.text = lastname
                    userName?.text = username

                }


            }


        })




    }


    public fun update(view: View) {


        startActivity(Intent(this@user_info,profile_activity::class.java))
    }


    public fun changeEmail(view: View) {


        startActivity(Intent(this@user_info,changeEmail::class.java))
    }
}
