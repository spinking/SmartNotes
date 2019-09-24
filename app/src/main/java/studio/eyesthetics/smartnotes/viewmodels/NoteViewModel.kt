package studio.eyesthetics.smartnotes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import studio.eyesthetics.smartnotes.models.Note
import studio.eyesthetics.smartnotes.models.NoteItem
import studio.eyesthetics.smartnotes.repositories.NoteRepository
import java.util.*

/**
 * Created by BashkatovSM on 23.09.2019
 */
class NoteViewModel: ViewModel() {
    private val noteRepository = NoteRepository
    private val notes: LiveData<List<Note>> = Transformations.map(noteRepository.loadNotes()) { notes ->
        return@map notes.map { it }
    }

    fun getNoteData(id: String) : Note {
        return noteRepository.loadNotes().value!!.filter { id == it.id }.first()
    }

    fun getNotesData() : LiveData<List<Note>> {
        return notes
    }
}