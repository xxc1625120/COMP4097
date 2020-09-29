package edu.hkbu.comp.comp4097.infoday.ui.events

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import edu.hkbu.comp.comp4097.infoday.R

import edu.hkbu.comp.comp4097.infoday.ui.events.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class EventRecyclerViewAdapter(
  private val values: List<DummyItem>
) : RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.fragment_event_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = values[position]
    holder.idView.text = item.id
    holder.contentView.text = item.content
  }

  override fun getItemCount(): Int = values.size

  inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val idView: TextView = view.findViewById(R.id.titleTextView)
    val contentView: TextView = view.findViewById(R.id.content)

    override fun toString(): String {
      return super.toString() + " '" + contentView.text + "'"
    }
  }
}
