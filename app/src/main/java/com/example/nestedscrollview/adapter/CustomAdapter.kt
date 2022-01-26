package com.example.nestedscrollview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedscrollview.R
import com.example.nestedscrollview.model.User
import java.util.ArrayList

class CustomAdapter(private val context: Context, users: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val users: ArrayList<User>

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user: User = users[position]
        if (holder is CustomViewHolder) {
            val firstN = holder.firstName
            val lastN = holder.lastName
            firstN.setText(user.firstName)
            lastN.setText(user.lastName)
        }
    }

      class CustomViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var firstName: TextView
        var lastName: TextView

        init {
            firstName = view.findViewById(R.id.firstName)
            lastName = view.findViewById(R.id.lastName)
        }
    }
    init {
        this.users = users
    }
}