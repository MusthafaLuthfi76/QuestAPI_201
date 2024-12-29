package com.example.praktikum10

import android.app.Application
import com.example.praktikum10.dependenciesinjection.AppContainer
import com.example.praktikum10.dependenciesinjection.MahasiswaContainer

class MahasiswaApplications: Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}