package com.indriyantongrh.submission2aplikasigithubuser.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseDetails(
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
		val siteAdmin: Boolean? = null,
		val name: String? = null,
		val company: String? = null,
		val blog: String? = null,
		val location: String? = null,
		val email: String? = null,
		val hireable: Boolean? = null,
		val bio: String? = null,
		val twitterUsername: String? = null,
		val public_repos: Int? = null,
		val publicGists: Int? = null,
		val followers: Int? = null,
		val following: Int? = null,
		val createdAt: String? = null,
		val updatedAt: String? = null
) : Parcelable
