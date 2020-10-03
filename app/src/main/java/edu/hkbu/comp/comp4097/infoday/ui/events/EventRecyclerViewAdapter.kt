package edu.hkbu.comp.comp4097.infoday.ui.events

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import edu.hkbu.comp.comp4097.infoday.R
import edu.hkbu.comp.comp4097.infoday.data.Event


/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class EventRecyclerViewAdapter(
  private val values: List<Event>
) : RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.fragment_event_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = values[position]
    holder.deptIdView.text = item.deptId + ":" + item.id
    holder.eventTitleView.text = item.title
  }

  override fun getItemCount(): Int = values.size

  inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val deptIdView: TextView = view.findViewById(R.id.titleTextView)
    val eventTitleView: TextView = view.findViewById(R.id.content)


  }
}
