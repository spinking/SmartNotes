package studio.eyesthetics.smartnotes.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import studio.eyesthetics.smartnotes.R
import studio.eyesthetics.smartnotes.ui.adapters.NoteAdapter
import studio.eyesthetics.smartnotes.ui.note.NoteActivity
import studio.eyesthetics.smartnotes.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initViewModel()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_button, menu)
        val addButton = menu?.findItem(R.id.action_add)
        addButton?.setOnMenuItemClickListener {
            val intent = Intent(this, NoteActivity::class.java)
            intent.putExtra("id", viewModel.getNewId())
            startActivity(intent)
            true
         }
        return super.onCreateOptionsMenu(menu)
    }

    private fun initViews() {
        noteAdapter = NoteAdapter {
            val intent = Intent(this, NoteActivity::class.java)
            Log.d("M_MainActivity", "${it.id}")
            intent.putExtra("id", it.id)
            startActivity(intent)
        }
        with(rv_note_list) {
            adapter = noteAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getNoteData().observe(this, Observer { noteAdapter.updateData(it) })
    }
}
