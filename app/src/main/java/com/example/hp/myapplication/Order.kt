package com.example.hp.myapplication

import kotlin.collections.ArrayList

class Order(override val menuOrder: ArrayList<String>) : MenuOrder {

    override fun add(element: String) {
        menuOrder.add(element)
    }

    override fun clear() {
        menuOrder.clear()
    }

    override fun done() {
        menuOrder.clear()
    }

    override fun del(elementIndex: Int) {
        menuOrder.removeAt(elementIndex)
    }
    fun getOrder():ArrayList<String>{
        return this.menuOrder
    }
}