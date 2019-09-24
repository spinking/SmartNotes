package studio.eyesthetics.smartnotes.models

import java.util.*

/**
 * Created by BashkatovSM on 20.09.2019
 */
 data class Note(
    var id: String,
    var title: String?,
    var description: String?,
    var image: String?,
    var importance: String = "none",
    var coordinates: String?
 ) {

    fun toNoteItem(): NoteItem {
        return NoteItem(
            id,
            title,
            image
        )
    }
 }