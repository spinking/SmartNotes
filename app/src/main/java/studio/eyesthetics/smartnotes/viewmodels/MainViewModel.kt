package studio.eyesthetics.smartnotes.viewmodels

import androidx.lifecycle.ViewModel
import studio.eyesthetics.smartnotes.repositories.NoteRepository

/**
 * Created by BashkatovSM on 20.09.2019
 */
class MainViewModel: ViewModel() {
    private val noteRepository = NoteRepository
}