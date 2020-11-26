package com.indriyantongrh.submission2aplikasigithubuser.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *  Create by Indriyantongrh on 11/18/20
 */
@Parcelize
class ResponseFollowers(
        val login: String? = null,
        val id: Int? = null,
        val node_id: String? = null,
        val avatar_url: String? = null,
        val gravatarId: String? = null,
        val url: String? = null,
        val htmlUrl: String? = null,
        val followersUrl: String? = null,
        val followingUrl: String? = null,
        val gistsUrl: String? = null,
        val starredUrl: String? = null,
        val subscriptionsUrl: String? = null,
        val organizationsUrl: String? = null,
        val reposUrl: String? = null,
        val eventsUrl: String? = null,
        val receivedEventsUrl: String? = null,
        val type: String? = null,
        val siteAdmin: Boolean? = null
) : Parcelable
