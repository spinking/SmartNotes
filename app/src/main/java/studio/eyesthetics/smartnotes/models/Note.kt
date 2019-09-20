package studio.eyesthetics.smartnotes.models

/**
 * Created by BashkatovSM on 20.09.2019
 */
 data class Note(
    val id: String,
    val title: String,
    val image: String?,
    val text: String?,
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