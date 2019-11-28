package com.axiaworks.toda.utils

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

object AnalyticsUtils {
    private var firebaseAnalytics: FirebaseAnalytics? = null

    private fun getAnalytics(context: Context): FirebaseAnalytics {
        firebaseAnalytics?.let{
            return it
        }?:run {
            return FirebaseAnalytics.getInstance(context).apply {
                firebaseAnalytics = this
            }
        }
    }

    fun sendClickEventLog(context: Context, itemId: String) {
        getAnalytics(context).logEvent(
            FirebaseAnalytics.Event.SELECT_CONTENT,
            Bundle().apply{
                putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button")
                putString(FirebaseAnalytics.Param.ITEM_ID, itemId)
            }
        )
    }
}