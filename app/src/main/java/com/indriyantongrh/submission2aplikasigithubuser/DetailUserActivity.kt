package com.indriyantongrh.submission2aplikasigithubuser

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.indriyantongrh.submission2aplikasigithubuser.baseurl.NetworkConfig
import com.indriyantongrh.submission2aplikasigithubuser.model.ItemsItem
import com.indriyantongrh.submission2aplikasigithubuser.model.ResponseDetails
import com.indriyantongrh.submission2aplikasigithubuser.tabs.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_detail_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }
    lateinit
    var progerssProgressDialog: ProgressDialog
    private lateinit var tvNameUser: TextView
    private lateinit var tvFollowers: TextView
    private lateinit var tvFollowing: TextView
    private lateinit var tvRepository: TextView
    private lateinit var ivAvatar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)
        val actionBar = supportActionBar
        actionBar?.title= "Detail User"
        supportActionBar?.setHomeAsUpIndicator(R.drawable.backicon)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        tvNameUser = findViewById(R.id.tvNameUser)
        tvFollowers = findViewById(R.id.tvFollowers)
        tvFollowing = findViewById(R.id.tvFollowing)
        tvRepository = findViewById(R.id.tvRepository)
        ivAvatar = findViewById(R.id.ivAvatar)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)
        supportActionBar?.elevation = 0f

        getDetail()
    }

    fun getDetail(){
        val githubUser = intent.getParcelableExtra<ItemsItem>(EXTRA_DETAIL)
        var username = githubUser?.login
        progerssProgressDialog = ProgressDialog(this)
        progerssProgressDialog.setMessage("Loading ...")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()
        NetworkConfig().getDetail.getDetails(username).enqueue(object: Callback<ResponseDetails>{
            override fun onResponse(call: Call<ResponseDetails>, response: Response<ResponseDetails>) {
                progerssProgressDialog.hide()
                val getValue = response.body()
                Glide.with(this@DetailUserActivity)
                        .load(getValue?.avatar_url)
                        .into(ivAvatar);
                if(getValue?.name==null){
                    tvNameUser.text = getValue?.login
                }else{
                    tvNameUser.text = getValue?.name
                }
                tvFollowers.text = getValue?.followers.toString()
                tvFollowing.text = getValue?.following.toString()
                tvRepository.text = getValue?.public_repos.toString()+ getString(R.string.respository)

            }

            override fun onFailure(call: Call<ResponseDetails>, t: Throwable) {
                Log.d("Failure", "Gagal Connection")
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
