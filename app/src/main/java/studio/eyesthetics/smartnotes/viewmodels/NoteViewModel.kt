package studio.eyesthetics.smartnotes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import studio.eyesthetics.smartnotes.models.Note
import studio.eyesthetics.smartnotes.repositories.NoteRepository

/**
 * Created by BashkatovSM on 23.09.2019
 */
class NoteViewModel: ViewModel() {
    private val noteRepository = NoteRepository
    private val singleNoteData = MutableLiveData<Note>(Note("","","","","",""))
    private val notes: LiveData<List<Note>> = Transformations.map(noteRepository.loadNotes()) { notes ->
        return@map notes.map { it }
    }

    fun initNoteData(id: String) {
        val note = noteRepository.loadNotes().value!!.filter { id == it.id }.first()
        singleNoteData.value!!.title = note.title
        singleNoteData.value!!.description = note.description
    }

    fun getNotesData() : LiveData<List<Note>> {
        return notes
    }

    fun getNoteData(): LiveData<Note> = singleNoteData


    fun saveNoteData(note: Note) {
        noteRepository.update(note)
        singleNoteData.value = note
    }
}