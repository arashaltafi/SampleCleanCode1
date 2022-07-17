package com.arash.altafi.samplecleancode.ui.characterdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.arash.altafi.samplecleancode.data.entities.Character
import com.arash.altafi.samplecleancode.data.repository.CharacterRepository
import com.arash.altafi.samplecleancode.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    private val _character = _id.switchMap { id ->
        repository.getCharacter(id)
    }
    val character: LiveData<Resource<Character>> = _character

    fun start(id: Int) {
        _id.value = id
    }

}
