package testing.belajar.belajarget

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor

class InitFastNetwork : Application() {
    override fun onCreate() {
        super.onCreate()

        AndroidNetworking.initialize(applicationContext)
        AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)

    }
}