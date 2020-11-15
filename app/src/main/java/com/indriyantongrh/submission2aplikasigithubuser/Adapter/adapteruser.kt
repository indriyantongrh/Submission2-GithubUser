package com.indriyantongrh.submission2aplikasigithubuser.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.indriyantongrh.submission2aplikasigithubuser.Model.ItemsItem
import com.indriyantongrh.submission2aplikasigithubuser.Model.ResponseSearch
import com.indriyantongrh.submission2aplikasigithubuser.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_user.view.*

class adapteruser(private val listUsergithub: ArrayList<ItemsItem>) : RecyclerView.Adapter<adapteruser.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUsergithub[position])
    }

    override fun getItemCount(): Int = listUsergithub.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
            itemView.setOnClickListener {
                event.invoke(getAdapterPosition(), getItemViewType())

            }
            return this
        }
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

interface OnItemClickCallback {
    fun onItemClicked(data: ItemsItem)
}

/*
class adapteruser internal constructor(private val data: List<ResponseSearch>?): RecyclerView.Adapter<adapteruser.MyHolder>() {


    internal var memberGithub = arrayListOf<ResponseSearch>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder{
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return MyHolder(v)
    }

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(get: ResponseSearch?) {

            itemView.tvNameUser.text = get?.items?.get(0)?.login
        }

    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

}
*/


