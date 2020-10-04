package edu.hkbu.comp.comp4097.infoday.ui.events

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import edu.hkbu.comp.comp4097.infoday.R
import edu.hkbu.comp.comp4097.infoday.data.AppDatabase
import edu.hkbu.comp.comp4097.infoday.data.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class BookmarkEventRecyclerViewAdapter(
  private val values: List<Event>
) : RecyclerView.Adapter<BookmarkEventRecyclerViewAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.fragment_bookmark_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = values[position]
    holder.deptIdView.text = item.deptId + ":" + item.id
    holder.eventTitleView.text = item.title
  }

  override fun getItemCount(): Int = values.size



  override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
    ItemTouchHelper(myCallback()).attachToRecyclerView(recyclerView)
    super.onAttachedToRecyclerView(recyclerView)
  }
  inner class myCallback : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
    override fun onMove(
      recyclerView: RecyclerView,
      viewHolder: RecyclerView.ViewHolder,
      target: RecyclerView.ViewHolder
    ): Boolean { return false }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
      val holder = viewHolder as ViewHolder
      //assume your idView contains deptID and contentView contains event's title
      val unbookmarkItem = values.find { it.deptId+ ":" + it.id == holder.deptIdView.text}
      unbookmarkItem?.bookmarked = false
      if (unbookmarkItem != null)
        CoroutineScope(Dispatchers.IO).launch {
          AppDatabase.getInstance(viewHolder.itemView.context).
          eventDao().update(unbookmarkItem)
        }
    }
  }

  inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val deptIdView: TextView = view.findViewById(R.id.item_number)
    val eventTitleView: TextView = view.findViewById(R.id.content)


  }
}
