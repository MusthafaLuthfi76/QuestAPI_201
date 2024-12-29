package com.example.praktikum10.viewmodel

import androidx.lifecycle.ViewModel
import coil.network.HttpException
import com.example.praktikum10.model.Mahasiswa
import com.example.praktikum10.repository.MahasiswaRepository
import okio.IOException



sealed class HomeUiState{
    data class Success(val mahasiswa: List<Mahasiswa>): HomeUiState()

    object Error: HomeUiState()
    object Loading: HomeUiState()
}

class HomeViewModel(private val mhs: MahasiswaRepository): ViewModel(){
    var mhsUiState: HomeUiState by _root_ide_package_.androidx.compose.runtime.mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getMhs()
    }

    fun getMhs(){
        viewModelScope.launch{
            mhsUIState = HomeUiState.Loading
            mhsUIState = try{
                HomeUiState.Success(mhs.getMahasiswa())
            }
            catch(e: IOException){
                HomeUiState.Error
            }
            catch(e: HttpException){
                HomeUiState.Error
            }
        }
    }
}

fun deleteMhs(nim: String){
    viewModelScope.launch{
        try {
            mhs.deleteMahasiswa(nim)
        }
        catch (e: IOException){
            HomeUiState.Error
        }
        catch (e: HttpException){
            HomeUiState.Error
        }
    }
}