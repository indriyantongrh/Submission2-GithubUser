package com.indriyantongrh.submission2aplikasigithubuser.Adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.indriyantongrh.submission2aplikasigithubuser.DetailUser
import com.indriyantongrh.submission2aplikasigithubuser.Model.ItemsItem
import com.indriyantongrh.submission2aplikasigithubuser.Model.ResponseSearch
import com.indriyantongrh.submission2aplikasigithubuser.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_user.view.*
import kotlin.math.log

class adapteruser(private val listUsergithub: ArrayList<ItemsItem>) : RecyclerView.Adapter<adapteruser.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUsergithub[position])

        val data = listUsergithub[position]
        holder.itemView.setOnClickListener {
            val dataUserIntent = ItemsItem(
                data.login,
                data.avatarUrl,
                data.url,
                data.htmlUrl,
                data.followersUrl,
                data.followingUrl
            )
            Log.d("jajalinten",  "jajalinten"+dataUserIntent)
            val mIntent = Intent(it.context, DetailUser::class.java)
            mIntent.putExtra(DetailUser.EXTRA_DETAIL, dataUserIntent)
            it.context.startActivity(mIntent)
        }

    }

    override fun getItemCount(): Int = listUsergithub.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(itemsItem: ItemsItem) {
            with(itemView){
                Glide.with(this)
                    .load(itemsItem.avatarUrl)
                    .apply(RequestOptions().override(150, 130))
                    .into(ivAvatar)
                tvNameUser.text = itemsItem.login
                }
            }
        }
    }





