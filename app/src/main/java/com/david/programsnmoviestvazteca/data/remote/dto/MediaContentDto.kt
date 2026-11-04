package com.david.programsnmoviestvazteca.data.remote.dto


import com.google.gson.annotations.SerializedName

data class MediaContentDto(

    @SerializedName("id")
    val id: Int,

    @SerializedName("url")
    val url: String?,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String?,

    @SerializedName("language")
    val language: String?,

    @SerializedName("genres")
    val genres: List<String>?,

    @SerializedName("status")
    val status: String?,

    @SerializedName("runtime")
    val runtime: Int?,

    @SerializedName("averageRuntime")
    val averageRuntime: Int?,

    @SerializedName("premiered")
    val premiered: String?,

    @SerializedName("ended")
    val ended: String?,

    @SerializedName("officialSite")
    val officialSite: String?,

    @SerializedName("schedule")
    val schedule: ShowScheduleDto?,

    @SerializedName("rating")
    val rating: ShowRatingDto?,

    @SerializedName("weight")
    val weight: Int?,

    @SerializedName("network")
    val network: ShowNetworkDto?,

    @SerializedName("webChannel")
    val webChannel: ShowNetworkDto?,

    @SerializedName("dvdCountry")
    val dvdCountry: ShowCountryDto?,

    @SerializedName("externals")
    val externals: ShowExternalsDto?,

    @SerializedName("image")
    val image: ShowImageDto?,

    @SerializedName("summary")
    val summary: String?,

    @SerializedName("updated")
    val updated: Long?,

    @SerializedName("_links")
    val links: ShowLinksDto?
)

data class ShowScheduleDto(
    @SerializedName("time")
    val time: String?,

    @SerializedName("days")
    val days: List<String>?
)

data class ShowRatingDto(
    @SerializedName("average")
    val average: Double?
)

data class ShowImageDto(
    @SerializedName("medium")
    val medium: String?,

    @SerializedName("original")
    val original: String?
)

data class ShowCountryDto(
    @SerializedName("name")
    val name: String?,

    @SerializedName("code")
    val code: String?,

    @SerializedName("timezone")
    val timezone: String?
)

data class ShowNetworkDto(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("country")
    val country: ShowCountryDto?,

    @SerializedName("officialSite")
    val officialSite: String?
)

data class ShowExternalsDto(
    @SerializedName("tvrage")
    val tvrage: Int?,

    @SerializedName("thetvdb")
    val thetvdb: Int?,

    @SerializedName("imdb")
    val imdb: String?
)

data class ShowLinksDto(
    @SerializedName("self")
    val self: ShowLinkDto?,

    @SerializedName("previousepisode")
    val previousEpisode: ShowLinkDto?
)

data class ShowLinkDto(
    @SerializedName("href")
    val href: String?,

    @SerializedName("name")
    val name: String?
)