package com.hafid.movie.movie.data


import android.content.ContentValues
import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "favorite_movie")
class ResultsItem(

	@PrimaryKey(autoGenerate = false)
	@ColumnInfo(name = "id")
	var id: Int? = null,

	@ColumnInfo(name = "original_title")
	@SerializedName("original_title")
	var originalTitle: String? = null,

	@ColumnInfo(name = "overview")
	var overview: String? = null,

	@ColumnInfo(name = "vote_average")
	@SerializedName("vote_average")
	var voteAverage: Float = 0f,

	@ColumnInfo(name = "poster_path")
	@SerializedName("poster_path")
	var posterPath: String? = null,

	@ColumnInfo(name = "backdrop_path")
	@SerializedName("backdrop_path")
	var backdropPath: String? = null,

	@ColumnInfo(name = "release_date")
	@SerializedName("release_date")
	var releaseDate: String? = null

) : Parcelable {
	constructor(source: Parcel) : this(
		source.readValue(Int::class.java.classLoader) as Int?,
		source.readString(),
		source.readString(),
		source.readFloat(),
		source.readString(),
		source.readString(),
		source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeValue(id)
		writeString(originalTitle)
		writeString(overview)
		writeFloat(voteAverage)
		writeString(posterPath)
		writeString(backdropPath)
		writeString(releaseDate)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<com.hafid.movie.movie.data.ResultsItem> = object : Parcelable.Creator<com.hafid.movie.movie.data.ResultsItem> {
			override fun createFromParcel(source: Parcel): com.hafid.movie.movie.data.ResultsItem =
				ResultsItem(source)
			override fun newArray(size: Int): Array<com.hafid.movie.movie.data.ResultsItem?> = arrayOfNulls(size)
		}

		fun fromContentValues(values: ContentValues?): com.hafid.movie.movie.data.ResultsItem {
			return ResultsItem(
				values?.getAsInteger("id"),
				values?.getAsString("original_title"),
				values?.getAsString("overview"),
				values!!.getAsFloat("vote_average"),
				values.getAsString("poster_path"),
				values.getAsString("backdrop_path"),
				values.getAsString("release_date")
			)
		}
	}
}

