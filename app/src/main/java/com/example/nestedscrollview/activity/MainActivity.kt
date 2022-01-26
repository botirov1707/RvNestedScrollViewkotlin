package com.example.nestedscrollview.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedscrollview.R
import com.example.nestedscrollview.adapter.CustomAdapter
import com.example.nestedscrollview.model.User
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var nestedScrollView:NestedScrollView
    private lateinit var context:Context
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        val users = prepareUserList()
        refreshAdapter(users)
    }

    private fun initViews() {
        context = this
        nestedScrollView = findViewById(R.id.nestedScrollView)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(context, 1))
    }

    private fun refreshAdapter(users: ArrayList<User>) {
        val adapter = CustomAdapter(context, users)
        recyclerView.adapter = adapter
        nestedScrollView!!.isNestedScrollingEnabled = false
    }

    private fun prepareUserList(): ArrayList<User> {
        val users = ArrayList<User>()
        for (i in 1..20) {
            users.add(User("$i Uchqun", "$i Azimboyev"))
        }
        return users
    }
}