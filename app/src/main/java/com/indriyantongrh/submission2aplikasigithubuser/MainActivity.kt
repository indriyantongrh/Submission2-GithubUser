package com.indriyantongrh.submission2aplikasigithubuser

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.indriyantongrh.submission2aplikasigithubuser.Adapter.adapteruser
import com.indriyantongrh.submission2aplikasigithubuser.Baseurl.NetworkConfig
import com.indriyantongrh.submission2aplikasigithubuser.Model.ItemsItem
import com.indriyantongrh.submission2aplikasigithubuser.Model.ResponseSearch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var rvDataUser: RecyclerView
    private lateinit var svUserGithub: SearchView
    private lateinit var imageSearch: ImageView
    private lateinit var imageNotFound: ImageView
    lateinit
    var progerssProgressDialog: ProgressDialog
    private lateinit var listUsergithub: ArrayList<ItemsItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvDataUser = findViewById(R.id.rvDataUser)
        svUserGithub = findViewById(R.id.svUserGithub)
        imageSearch = findViewById(R.id.imageSearch)
        imageNotFound = findViewById(R.id.imageNotFound)
        imageSearch.visibility = View.VISIBLE
        rvDataUser.setHasFixedSize(true)
        svUserGithub.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                progerssProgressDialog = ProgressDialog(this@MainActivity)
                progerssProgressDialog.setMessage("Mencari data...")
                progerssProgressDialog.setCancelable(false)
                progerssProgressDialog.show()
                NetworkConfig().getUserss.getUserSearch2(query)
                        .enqueue(object : Callback<ResponseSearch> {
                            override fun onResponse(
                                    call: Call<ResponseSearch>,
                                    response: Response<ResponseSearch>
                            ) {
                                if (response!!.body()!!.totalCount == 0) {
                                    progerssProgressDialog.dismiss()
                                    imageSearch.visibility = View.GONE
                                    imageNotFound.visibility = View.VISIBLE
                                } else {
                                    imageSearch.visibility = View.GONE
                                    imageNotFound.visibility = View.GONE
                                    progerssProgressDialog.dismiss()
                                    listUsergithub = response!!.body()!!.items as ArrayList<ItemsItem>
                                    rvDataUser.adapter = adapteruser(listUsergithub)
                                }
                            }
                            override fun onFailure(call: Call<ResponseSearch>, t: Throwable) {
                                Log.d("Failure", "Fialed Connect" + t.message)
                            }
                        })
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }
        })
    }
}






