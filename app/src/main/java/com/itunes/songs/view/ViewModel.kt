package com.itunes.songs.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.itunes.songs.WebServices.NetworkHelper
import com.itunes.songs.models.model.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class ViewModel(context: Application) : AndroidViewModel(context) {

    private var listaProyectos = MutableLiveData<ArrayList<Songs>>()

    private val Disposable: CompositeDisposable? = CompositeDisposable()

    fun getData(artist: String) {

        NetworkHelper.createGitHubAPI().getSong(artist)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                Disposable!!.add(it)
            }
            .doOnError {
                var t = 0
            }
            .doOnNext { data ->

                listaProyectos.value = data.results as ArrayList<Songs>?

            }
            .subscribe()
    }


    fun getObservable(): MutableLiveData<ArrayList<Songs>> {
        return listaProyectos
    }


    override fun onCleared() {
        Disposable!!.clear()
    }

}