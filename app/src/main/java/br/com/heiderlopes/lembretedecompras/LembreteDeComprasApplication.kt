package br.com.heiderlopes.lembretedecompras

import android.app.Application
import com.facebook.stetho.Stetho

class LembreteDeComprasApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

}