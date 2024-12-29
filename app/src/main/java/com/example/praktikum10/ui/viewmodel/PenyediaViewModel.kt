package com.example.praktikum10.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.praktikum10.MahasiswaApplications

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiMahasiswa().container.kontakRepository) }
        initializer { InsertViewModel(aplikasiMahasiswa().container.kontakRepository) }
    }
}

fun CreationExtras.aplikasiMahasiswa(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)