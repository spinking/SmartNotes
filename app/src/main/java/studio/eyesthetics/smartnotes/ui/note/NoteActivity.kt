package studio.eyesthetics.smartnotes.ui.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.item_note.*
import studio.eyesthetics.smartnotes.R
import studio.eyesthetics.smartnotes.models.Note
import studio.eyesthetics.smartnotes.viewmodels.NoteViewModel

class NoteActivity : AppCompatActivity() {

    companion object {
        const val IS_EDIT_MODE = "IS_EDIT_MODE"
    }

    private lateinit var viewModel: NoteViewModel
    private var isEditMode = false
    private lateinit var viewFields : Map<String, TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        initView(savedInstanceState)
        initViewModel()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putBoolean(IS_EDIT_MODE, isEditMode)
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        viewModel.getNoteData().observe(this, Observer{updateUI(it)})
    }

    private fun updateUI(note: Note) {
        note.toMap().also {
            for ((k, v) in viewFields) {
                v.text = it[k].toString()
            }
        }
    }

    private fun initView(savedInstanceState: Bundle?) {
        viewFields = mapOf(
            "title" to tv_note_title,
            "description" to tv_note_description,
            "coordinates" to tv_note_coordinates
        )

        isEditMode = savedInstanceState?.getBoolean(IS_EDIT_MODE, false) ?: false
        showCurrentMode(isEditMode)
    }

    private fun showCurrentMode(isEdit: Boolean) {
        val info = viewFields.filter { setOf("title", "description", "coordinates").contains(it.key) }
        for((_, v) in info) {
            v as EditText
            v.isFocusable = isEdit
            v.isFocusableInTouchMode = isEdit
            v.isEnabled = isEdit
        }
    }

    private fun saveNoteInfo() {
        Note(
            title = tv_note_title.text.toString(),
            description = tv_note_description.text.toString(),
            coordinates = tv_note_coordinates.text.toString()

        ).apply {
            viewModel.saveProfileData(this)
        }
    }
}
