package com.david.programsnmoviestvazteca.ui.navigation

object Routes {
    const val MEDIA = "media"
    const val MEDIADETAILS = "details"

    const val MEDIA_ID = "mediaId"

    const val MEDIA_DETAILS_ROUTE =
        "$MEDIADETAILS/{$MEDIA_ID}"

    fun mediaDetails(mediaId: Int): String {
        return "$MEDIADETAILS/$mediaId"
    }
}