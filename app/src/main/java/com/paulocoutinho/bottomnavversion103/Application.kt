package com.paulocoutinho.bottomnavversion103

import androidx.multidex.MultiDexApplication
import com.cioccarellia.kite.Kite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class Application : MultiDexApplication(), CoroutineScope {

    override val coroutineContext = Dispatchers.Main

    companion object {

        lateinit var instance: Application
            private set
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        Kite.fly(this)
    }

}
