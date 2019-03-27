package com.example.wisataindonesia

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_wisata.view.*

class WisataAdapter(val data : List<DataWisata>) : RecyclerView.Adapter<WisataAdapter.MyHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): WisataAdapter.MyHolder {
        val view = LayoutInflater.from(p0.context)
            .inflate(R.layout.item_wisata,p0,false)

        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: WisataAdapter.MyHolder, p1: Int) {
        p0.bind(data.get(p1))
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: DataWisata) {
            itemView.itemName.text = get.nama_tempat
            itemView.itemLokasi.text = get.lokasi

            Glide.with(itemView.context)
                .load(get.gambar)
                .error(R.mipmap.ic_launcher)
                .into(itemView.itemImg)
        }

    }

}