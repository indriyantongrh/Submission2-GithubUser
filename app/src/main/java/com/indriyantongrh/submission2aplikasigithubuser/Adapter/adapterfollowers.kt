package com.indriyantongrh.submission2aplikasigithubuser.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.indriyantongrh.submission2aplikasigithubuser.Model.ItemsItem
import com.indriyantongrh.submission2aplikasigithubuser.Model.ResponseFollowers
import com.indriyantongrh.submission2aplikasigithubuser.R
import kotlinx.android.synthetic.main.item_user.view.*

/**
 *  Create by Indriyantongrh on 11/18/20
 */

class adapterfollowers (private val listFollowers: ArrayList<ResponseFollowers>) : RecyclerView.Adapter<adapterfollowers.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listFollowers[position])
    }

    override fun getItemCount(): Int = listFollowers.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(followers: ResponseFollowers) {
            with(itemView) {
                Glide.with(this)
                        .load(followers.avatar_url)
                        .apply(RequestOptions().override(150, 130))
                        .into(ivAvatar)
                tvNameUser.text = followers.login
            }
        }
    }
}