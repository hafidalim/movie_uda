package com.hafid.movie.movie.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hafid.movie.DetailActivity
import com.hafid.movie.R
import com.hafid.movie.movie.data.ResultsItem
import kotlinx.android.synthetic.main.item_movie.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MovieAdapter(var data: List<ResultsItem?>?) : RecyclerView.Adapter<MovieAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return  MyHolder(view)
    }

    override fun getItemCount() = data?.size ?:0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            intent.putExtra("movie", data?.get(position))
            holder.itemView.context.startActivity(intent)
        }

    }

    class MyHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get : ResultsItem?){
            itemView.tv_title.text = get?.originalTitle
            Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w185/"+get?.posterPath).into(itemView.img_poster)
            itemView.tv_rate.text = get?.voteAverage.toString()
        }
    }


}