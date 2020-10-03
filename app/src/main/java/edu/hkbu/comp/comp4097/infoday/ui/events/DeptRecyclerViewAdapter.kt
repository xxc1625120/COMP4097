package edu.hkbu.comp.comp4097.infoday.ui.events

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import edu.hkbu.comp.comp4097.infoday.R
import edu.hkbu.comp.comp4097.infoday.data.Dept

class DeptRecyclerViewAdapter(
  private val values: List<Dept>
) : RecyclerView.Adapter<DeptRecyclerViewAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.fragment_event_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = values[position]
    holder.deptIdView.text = item.id
    holder.deptNameView.text = item.name
  }

  override fun getItemCount(): Int = values.size

  inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val deptIdView: TextView = view.findViewById(R.id.titleTextView)
    val deptNameView: TextView = view.findViewById(R.id.content)

    init {
      view.setOnClickListener {
        it.findNavController().navigate(
          R.id.action_eventsFragment_self,
          bundleOf(Pair("dept_id", deptIdView.text.toString()))
        )
      }
    }

  }
}
