package com.example.hp.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MenuActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val menuArray = arrayOf("Big Mac", "Big Tasty","Cajita Feliz","Mac flury","Papas","Sprite","Coca Cola")

        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,menuArray)

        val menuView:ListView = this.findViewById(R.id.menuList)
        menuView.adapter = adapter

        menuView.onItemClickListener= object: AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemValue= menuView.getItemAtPosition(position) as String
                myAplication.ClientOrder.add(itemValue)
                Toast.makeText(applicationContext,"Se ha agregado $itemValue",Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun showHome(view: View){
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

