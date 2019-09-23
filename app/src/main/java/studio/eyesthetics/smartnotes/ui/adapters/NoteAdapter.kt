package studio.eyesthetics.smartnotes.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_note.*
import studio.eyesthetics.smartnotes.R
import studio.eyesthetics.smartnotes.models.NoteItem

/**
 * Created by BashkatovSM on 20.09.2019
 */
class NoteAdapter(val listener: (NoteItem) -> Unit) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    var items: MutableList<NoteItem> = mutableListOf()

    init {
        for(i in 0..20) {
            items.add(i,NoteItem("$i", "Title $i", "Image"))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val convertView = inflater.inflate(R.layout.item_note, parent, false)
        return  NoteViewHolder(convertView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = holder.bind(items[position], listener)

    /*fun updateData(data : List<NoteItem>) {
        val diffCallback = object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean = items[oldPos].id == data[newPos].id

            override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean = items[oldPos].hashCode() == data[newPos].hashCode()

            override fun getOldListSize(): Int = items.size

            override fun getNewListSize(): Int = data.size
        }

        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items = data
        diffResult.dispatchUpdatesTo(this)
    }*/

    inner class NoteViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bind(note: NoteItem, listener: (NoteItem) -> Unit) {
            /*if(user.avatar != null) {
                Glide.with(itemView)
                    .load(user.avatar)
                    .into(iv_avatar_user)
            } else {
                Glide.with(itemView).clear(iv_avatar_user)
                iv_avatar_user.setInitials(user.initials ?: "??")

            }*/
            tv_notes_title.text = note.title

            iv_notes_image.setBackgroundColor(Color.GREEN)

            itemView.setOnClickListener {
                listener.invoke(note)
            }
        }

    }
}