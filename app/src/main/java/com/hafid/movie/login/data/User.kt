package com.hafid.movie.login.data

import com.google.gson.annotations.SerializedName


data class User(

	@field:SerializedName("user_nama")
	val userNama: String? = null,

	@field:SerializedName("user_email")
	val userEmail: String? = null,

	@field:SerializedName("user_password")
	val userPassword: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("user_hp")
	val userHp: String? = null,

	@field:SerializedName("user_level")
	val userLevel: String? = null,

	@field:SerializedName("user_tanggal")
	val userTanggal: String? = null
)