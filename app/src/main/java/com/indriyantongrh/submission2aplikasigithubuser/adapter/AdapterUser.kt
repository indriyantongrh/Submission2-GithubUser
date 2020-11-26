package com.indriyantongrh.submission2aplikasigithubuser.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.indriyantongrh.submission2aplikasigithubuser.DetailUserActivity
import com.indriyantongrh.submission2aplikasigithubuser.model.ItemsItem
import com.indriyantongrh.submission2aplikasigithubuser.R
import kotlinx.android.synthetic.main.item_user.view.*

class AdapterUser(private val listUsergithub: ArrayList<ItemsItem>) : RecyclerView.Adapter<AdapterUser.ListViewHolder>() {

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
            val mIntent = Intent(it.context, DetailUserActivity::class.java)
            mIntent.putExtra(DetailUserActivity.EXTRA_DETAIL, dataUserIntent)
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





