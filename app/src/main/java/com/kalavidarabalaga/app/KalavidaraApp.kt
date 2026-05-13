package com.kalavidarabalaga.app

import android.app.Application
import com.google.firebase.FirebaseApp

/**
 * Application class — initialises Firebase on startup.
 * Registered in AndroidManifest.xml via android:name attribute.
 */
class KalavidaraApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // Firebase initialises automatically via google-services plugin,
        // but explicit init here ensures it's ready for any edge cases.
        FirebaseApp.initializeApp(this)
    }
}
