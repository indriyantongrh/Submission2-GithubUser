package com.indriyantongrh.submission2aplikasigithubuser

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.View
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

    lateinit
    var progerssProgressDialog: ProgressDialog
    private val list = ArrayList<ItemsItem>()
    private lateinit var listUsergithub: ArrayList<ItemsItem>


    /// val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDataUser = findViewById(R.id.rvDataUser)
        svUserGithub = findViewById(R.id.svUserGithub)
        imageSearch = findViewById(R.id.imageSearch)

        rvDataUser.setHasFixedSize(true)


        svUserGithub.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                progerssProgressDialog = ProgressDialog(this@MainActivity)
                progerssProgressDialog.setTitle("Mencari data...")
                progerssProgressDialog.setCancelable(false)
                progerssProgressDialog.show()
                NetworkConfig().getUserss.getUserSearch2(query)
                    .enqueue(object : Callback<ResponseSearch> {
                        override fun onResponse(
                            call: Call<ResponseSearch>,
                            response: Response<ResponseSearch>
                        ) {
                            imageSearch.visibility = View.GONE
                            progerssProgressDialog.dismiss()
                            listUsergithub = response!!.body()!!.items as ArrayList<ItemsItem>
                            Log.d("jajal2", "jajal2" + listUsergithub)
                            rvDataUser.adapter = adapteruser(listUsergithub)
                            ///rvDataUser.setOnClickListener()=


                        }

                        override fun onFailure(call: Call<ResponseSearch>, t: Throwable) {
                            Log.d("jajal", "fail" + t.message)

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






