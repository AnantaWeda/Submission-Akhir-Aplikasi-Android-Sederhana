package com.dicoding2.submissionandroidsederhana.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding2.submissionandroidsederhana.R
import com.dicoding2.submissionandroidsederhana.model.Article

class ListArticleAdapter(private val listArticle: ArrayList<Article>) : RecyclerView.Adapter<ListArticleAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_article,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listArticle.size;

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listArticle[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listArticle[holder.adapterPosition])
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Article)
    }
}