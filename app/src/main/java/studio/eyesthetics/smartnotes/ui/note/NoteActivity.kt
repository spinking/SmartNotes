package studio.eyesthetics.smartnotes.ui.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_note.*
import studio.eyesthetics.smartnotes.R
import studio.eyesthetics.smartnotes.models.Note
import studio.eyesthetics.smartnotes.viewmodels.NoteViewModel

class NoteActivity : AppCompatActivity() {

    companion object {
        const val IS_EDIT_MODE = "IS_EDIT_MODE"
    }

    var isEditMode = false
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

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
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

        note.toMap().also {
            for((k,v) in viewFields) {
                v.text = it[k].toString()
            }
        }
        /*note.also {
            tv_notes_title.text = it.title
            tv_notes_description.text = it.description
        }*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edit, menu)
        val editButton = menu?.findItem(R.id.action_edit)
        editButton?.setOnMenuItemClickListener {
           isEditMode = !isEditMode
           showCurrentMode(isEditMode)
            true
        }
        return super.onCreateOptionsMenu(menu)
    }

    private fun showCurrentMode(isEdit: Boolean) {
        val info = viewFields.filter { setOf("title", "description").contains(it.key) }
        for((_,v) in info) {
            v as EditText
            v.isFocusable = isEdit
            v.isFocusableInTouchMode = isEdit
            v.isEnabled = isEdit
            v.background.alpha = if(isEdit) 255 else 0
        }
    }
}
