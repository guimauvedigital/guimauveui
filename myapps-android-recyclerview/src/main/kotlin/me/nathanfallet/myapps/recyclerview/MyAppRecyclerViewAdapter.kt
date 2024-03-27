package me.nathanfallet.myapps.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.nathanfallet.myapps.android.R
import me.nathanfallet.myapps.extensions.android
import me.nathanfallet.myapps.models.MyApp

class MyAppRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
            holder.bind(MyApp.entries.android[position - 1])
        }
    }

    override fun getItemCount(): Int {
        return MyApp.entries.android.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) HEADER else ITEM
    }

}
