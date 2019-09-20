package studio.eyesthetics.smartnotes.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import studio.eyesthetics.smartnotes.R
import studio.eyesthetics.smartnotes.ui.adapters.NoteAdapter
import studio.eyesthetics.smartnotes.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initToolbar()
        initViews()
        //initViewModel()
    }

    /*private fun initToolbar() {
        setSupportActionBar(toolbar)
    }*/

    private fun initViews() {
        noteAdapter = NoteAdapter()
        with(rv_note_list) {
            adapter = noteAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    /*private fun initViewModel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }*/
}
