package com.indriyantongrh.submission2aplikasigithubuser.db

import android.provider.BaseColumns

/**
 *  Create by Indriyantongrh on 11/26/20
 */

internal class DatabaseContract {

    internal class GithubColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "github"
            const val _ID = "_id"
            const val NAME = "name"
            const val FOLLOWERS = "followers"
            const val FOLLOWING = "following"
            const val AVATAR = "avatar"
        }
    }
}