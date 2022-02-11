package me.nathanfallet.myappsandroid.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.nathanfallet.myappsandroid.R
import me.nathanfallet.myappsandroid.models.MyApp

class MyAppRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val HEADER = 0
    private val ITEM = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HEADER) {
            val root = LayoutInflater.from(parent.context).inflate(R.layout.myapp_header, parent, false)
            MyAppHeaderViewHolder(root)
        } else {
            val root = LayoutInflater.from(parent.context).inflate(R.layout.myapp_item, parent, false)
            MyAppItemViewHolder(root)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyAppItemViewHolder) {
            holder.bind(MyApp.values()[position - 1])
        }
    }

    override fun getItemCount(): Int {
        return MyApp.values().size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) HEADER else ITEM
    }

}