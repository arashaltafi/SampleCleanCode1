package com.arash.altafi.samplecleancode.ui.characters

import androidx.lifecycle.ViewModel
import com.arash.altafi.samplecleancode.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    repository: CharacterRepository
) : ViewModel() {

    val characters = repository.getCharacters()
}
