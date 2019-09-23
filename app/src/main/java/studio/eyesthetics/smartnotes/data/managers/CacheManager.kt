package studio.eyesthetics.smartnotes.data.managers

import androidx.lifecycle.MutableLiveData
import studio.eyesthetics.smartnotes.extensions.mutableLiveData
import studio.eyesthetics.smartnotes.models.Note
import studio.eyesthetics.smartnotes.utils.DataGenerator

/**
 * Created by BashkatovSM on 23.09.2019
 */
object CacheManager {
    private val notes = mutableLiveData(DataGenerator.stabNotes)

    fun loadNotes(): MutableLiveData<List<Note>> {
        return notes
    }

    fun nextNoteId(): String {
        val lastId = notes.value!!.last().id.toInt() + 1
        return lastId.toString()
    }

    fun insertNote(note: Note) {
        val copy = notes.value!!.toMutableList()
        copy.add(note)
        notes.value = copy
    }
}