package com.captaindeer.erikrucksack.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.captaindeer.erikrucksack.R
import com.captaindeer.erikrucksack.databinding.ActivityMainBinding
import com.captaindeer.erikrucksack.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private var auth: FirebaseAuth? = null
    private var name: TextView? = null
    private var email: TextView? = null
    private var img: CircleImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initializer
        auth = FirebaseAuth.getInstance()
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)

        //Buttons or clicks
        binding.drawerLayout.addDrawerListener(toggle)

        //User data on navegation view
        //looking the components inside nav view
        val header = binding.navView.getHeaderView(0)
        name = header.findViewById(R.id.tvNameHeader) as TextView
        email = header.findViewById(R.id.tvEmail) as TextView
        img = header.findViewById(R.id.civ_userPP) as CircleImageView

        //Set data
        Picasso.get().load(auth!!.currentUser!!.photoUrl.toString()).placeholder(R.drawable.pp).into(img)
        if (auth!!.currentUser!!.displayName != null){
            email!!.text = auth!!.currentUser!!.email.toString()
            name!!.text = auth!!.currentUser!!.displayName.toString()
        } else {
            name!!.text = "Logged with email"
            email!!.text = auth!!.currentUser!!.email.toString()
        }

        //Navegation Drawer
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                R.id.homeWorks -> Toast.makeText(this, "HomeWorks", Toast.LENGTH_SHORT).show()
                R.id.myInstagram -> Toast.makeText(this, "myInstagram", Toast.LENGTH_SHORT).show()
                R.id.home2 -> Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()

                R.id.logOut -> logOut()
            }
            true
        }

    }

    override fun onBackPressed() {
        if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            this.binding.drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    private fun logOut() {
        auth?.signOut()
        startActivity(Intent(this, LoginActivity::class.java))
        finishAffinity()
    }
}