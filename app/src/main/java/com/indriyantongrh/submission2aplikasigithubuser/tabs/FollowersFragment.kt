package com.indriyantongrh.submission2aplikasigithubuser.tabs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indriyantongrh.submission2aplikasigithubuser.adapter.AdapterFollowers
import com.indriyantongrh.submission2aplikasigithubuser.baseurl.NetworkConfig
import com.indriyantongrh.submission2aplikasigithubuser.DetailUserActivity
import com.indriyantongrh.submission2aplikasigithubuser.model.ItemsItem
import com.indriyantongrh.submission2aplikasigithubuser.model.ResponseFollowers
import com.indriyantongrh.submission2aplikasigithubuser.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FollowersFragment : Fragment() {
    private lateinit var rvDataUser: RecyclerView
    private lateinit var listFollowers: ArrayList<ResponseFollowers>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_followers, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvDataUser = view.findViewById(R.id.rvDataUser)
        getFollowers()

    }

    fun getFollowers(){
        val githubUser = activity!!.intent.getParcelableExtra<ItemsItem>(DetailUserActivity.EXTRA_DETAIL)
        var username =githubUser?.login
        Log.d("jajal", "username: "+username)
        NetworkConfig().getFollowers.getFollowerss(username).enqueue(object : Callback<List<ResponseFollowers>>{
            override fun onResponse(call: Call<List<ResponseFollowers>>, response: Response<List<ResponseFollowers>>) {
               Log.d("jajal 2" ,"Berhasil")
                listFollowers = response!!.body()!! as ArrayList<ResponseFollowers>
                Log.d("jajal List", "jajal" + listFollowers)
                rvDataUser.adapter = AdapterFollowers(listFollowers)
            }
            override fun onFailure(call: Call<List<ResponseFollowers>>, t: Throwable) {
                Log.d("jajal 2" ,"failure")
            }
        })
    }


}