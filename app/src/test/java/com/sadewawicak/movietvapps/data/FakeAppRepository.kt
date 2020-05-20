package com.sadewawicak.movietvapps.data

import com.sadewawicak.movietvapps.data.source.AppRepository

class FakeAppRepository (remoteRepository: AppRepository) {
    var remoteRepositorys = remoteRepository
}