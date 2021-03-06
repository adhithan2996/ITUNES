package com.itunes.songs.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class model {
    class Songs : Serializable {
        @SerializedName("wrapperType")
        @Expose
        var wrapperType: String? = null

        @SerializedName("kind")
        @Expose
        var kind: String? = null

        @SerializedName("artistId")
        @Expose
        var artistId: Int? = null

        @SerializedName("trackId")
        @Expose
        var trackId: Int? = null

        @SerializedName("artistName")
        @Expose
        var artistName: String? = null

        @SerializedName("trackName")
        @Expose
        var trackName: String? = null

        @SerializedName("trackCensoredName")
        @Expose
        var trackCensoredName: String? = null

        @SerializedName("artistViewUrl")
        @Expose
        var artistViewUrl: String? = null

        @SerializedName("trackViewUrl")
        @Expose
        var trackViewUrl: String? = null

        @SerializedName("previewUrl")
        @Expose
        var previewUrl: String? = null

        @SerializedName("artworkUrl30")
        @Expose
        var artworkUrl30: String? = null

        @SerializedName("artworkUrl60")
        @Expose
        var artworkUrl60: String? = null

        @SerializedName("artworkUrl100")
        @Expose
        var artworkUrl100: String? = null

        @SerializedName("collectionPrice")
        @Expose
        var collectionPrice: Float? = null

        @SerializedName("trackPrice")
        @Expose
        var trackPrice: Float? = null

        @SerializedName("collectionHdPrice")
        @Expose
        var collectionHdPrice: Float? = null

        @SerializedName("trackHdPrice")
        @Expose
        var trackHdPrice: Float? = null

        @SerializedName("releaseDate")
        @Expose
        var releaseDate: String? = null

        @SerializedName("collectionExplicitness")
        @Expose
        var collectionExplicitness: String? = null

        @SerializedName("trackExplicitness")
        @Expose
        var trackExplicitness: String? = null

        @SerializedName("trackTimeMillis")
        @Expose
        var trackTimeMillis: Int? = null

        @SerializedName("country")
        @Expose
        var country: String? = null

        @SerializedName("currency")
        @Expose
        var currency: String? = null

        @SerializedName("primaryGenreName")
        @Expose
        var primaryGenreName: String? = null

        @SerializedName("contentAdvisoryRating")
        @Expose
        var contentAdvisoryRating: String? = null

        @SerializedName("collectionId")
        @Expose
        var collectionId: Int? = null

        @SerializedName("collectionName")
        @Expose
        var collectionName: String? = null

        @SerializedName("collectionCensoredName")
        @Expose
        var collectionCensoredName: String? = null

        @SerializedName("collectionViewUrl")
        @Expose
        var collectionViewUrl: String? = null

        @SerializedName("discCount")
        @Expose
        var discCount: Int? = null

        @SerializedName("discNumber")
        @Expose
        var discNumber: Int? = null

        @SerializedName("trackCount")
        @Expose
        var trackCount: Int? = null

        @SerializedName("trackNumber")
        @Expose
        var trackNumber: Int? = null

        @SerializedName("isStreamable")
        @Expose
        var isStreamable: Boolean? = null

        companion object {
            private const val serialVersionUID = 5258835397994180391L
        }
    }

    class Response : Serializable {
        @SerializedName("resultCount")
        @Expose
        var resultCount: Int? = null

        @SerializedName("results")
        @Expose
        var results: List<Songs>? = null

        companion object {
            private const val serialVersionUID = 691985073147663355L
        }
    }
}