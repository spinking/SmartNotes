package studio.eyesthetics.smartnotes.utils

import studio.eyesthetics.smartnotes.models.Note
import kotlin.random.Random

/**
 * Created by BashkatovSM on 23.09.2019
 */

object DataGenerator {

    val stabNotes = generateNotes(20)

    private fun generateNotes(count: Int) : List<Note> {
        val list = mutableListOf<Note>()
        for(i in 0 until count) {
            list.add(
                Note(
                    "$i",
                    "Title #$i",
                    "Description for note number $i",
                    "",
                    Random.nextInt(0, 3),
                    "i"
                )
            )
        }
        return list
    }

}

