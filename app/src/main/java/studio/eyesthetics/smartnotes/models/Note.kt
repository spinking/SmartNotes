package studio.eyesthetics.smartnotes.models

import java.util.*

/**
 * Created by BashkatovSM on 20.09.2019
 */
 data class Note(
    val id: String,
    val title: String,
    val description: String?,
    val image: String?,
    val importance: Int = 0,
    val coordinates: String?
 ) {

    fun toNoteItem(): NoteItem {
        return NoteItem(
            id,
            title,
            image
        )
    }
 }