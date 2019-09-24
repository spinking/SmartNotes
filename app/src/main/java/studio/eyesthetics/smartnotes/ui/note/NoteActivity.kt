package studio.eyesthetics.smartnotes.ui.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_note.*
import studio.eyesthetics.smartnotes.R
import studio.eyesthetics.smartnotes.models.Note
import studio.eyesthetics.smartnotes.models.NoteItem
import studio.eyesthetics.smartnotes.viewmodels.NoteViewModel

class NoteActivity : AppCompatActivity() {
    private lateinit var viewModel: NoteViewModel
    private lateinit var itemId: String
    private lateinit var viewFields : Map<String, TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        val intent = intent
        itemId = intent.getStringExtra("id")

        initViews()
        initViewModel()
    }

    private fun initViews() {
        viewFields = mapOf(
            "title" to tv_notes_title,
            "description" to tv_notes_description
        )
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        viewModel.getNotesData().observe(this, Observer { updateUI(it[itemId.toInt()]) })
    }

    private fun updateUI(note: Note) {
        note.also {
            tv_notes_title.text = it.title
            tv_notes_description.text = it.description
        }
    }
}
