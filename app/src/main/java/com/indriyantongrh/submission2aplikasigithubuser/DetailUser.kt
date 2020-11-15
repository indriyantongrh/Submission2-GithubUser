package com.indriyantongrh.submission2aplikasigithubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indriyantongrh.submission2aplikasigithubuser.Tabs.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)
        supportActionBar?.elevation = 0f
    }
}