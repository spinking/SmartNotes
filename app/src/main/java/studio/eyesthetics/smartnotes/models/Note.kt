package studio.eyesthetics.smartnotes.models

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

    fun toMap() : Map<String, String?> = mapOf(
        "title" to title,
        "description" to description,
        "image" to image,
        "importance" to importance,
        "coordinates" to coordinates
    )

 }