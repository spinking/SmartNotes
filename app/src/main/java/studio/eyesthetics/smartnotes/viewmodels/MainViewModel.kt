package studio.eyesthetics.smartnotes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import studio.eyesthetics.smartnotes.models.NoteItem
import studio.eyesthetics.smartnotes.repositories.NoteRepository

/**
 * Created by BashkatovSM on 20.09.2019
 */
class MainViewModel: ViewModel() {
    private val noteRepository = NoteRepository

    private val notes: LiveData<List<NoteItem>> = Transformations.map(noteRepository.loadNotes()) { notes ->
        return@map notes.map { it.toNoteItem() }
    }

    fun getNoteData() : LiveData<List<NoteItem>> {
        return notes
    }
}