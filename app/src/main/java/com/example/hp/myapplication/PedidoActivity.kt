package com.example.hp.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class PedidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        //Codigo necesario para desplegar la orden del cliente

        val orderArray = myAplication.ClientOrder.getOrder()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, orderArray)

        val orderView: ListView = this.findViewById(R.id.orderList)
        orderView.adapter = adapter

        orderView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemPosition = position
                myAplication.ClientOrder.del(itemPosition)
                adapter.notifyDataSetChanged()

            }
        }
        //Codigo para el boton de limpiar pedido
        val clearButton:Button = this.findViewById(R.id.clearButton)
        clearButton.setOnClickListener {
            myAplication.ClientOrder.clear()
            adapter.notifyDataSetChanged()
        }

        //Codigo para el boton de hacer pedido
        val makeOrderButton:Button = this.findViewById(R.id.makeOrder)
        makeOrderButton.setOnClickListener {
            myAplication.ClientOrder.done()
            adapter.notifyDataSetChanged()
            Toast.makeText(applicationContext,"Su orden se ha realizado al restaurante más cercano",Toast.LENGTH_SHORT).show()
        }
    }


    fun showHome(view: View){
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
