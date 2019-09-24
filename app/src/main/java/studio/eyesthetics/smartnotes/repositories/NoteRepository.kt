package studio.eyesthetics.smartnotes.repositories

import androidx.lifecycle.MutableLiveData
import studio.eyesthetics.smartnotes.data.managers.CacheManager
import studio.eyesthetics.smartnotes.models.Note

/**
 * Created by BashkatovSM on 23.09.2019
 */
object NoteRepository {

    private val notes = CacheManager.loadNotes()

    fun loadNotes(): MutableLiveData<List<Note>> {
        return notes
    }

    fun update(note: Note) {
        val copy = notes.value!!.toMutableList()
        val ind = notes.value!!.indexOfFirst{ it.id == note.id }
        if(ind == -1) return
        copy[ind] = note
        notes.value = copy
    }
}