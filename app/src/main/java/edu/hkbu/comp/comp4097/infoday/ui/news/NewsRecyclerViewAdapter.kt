package edu.hkbu.comp.comp4097.infoday.ui.news

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import edu.hkbu.comp.comp4097.infoday.R
import edu.hkbu.comp.comp4097.infoday.data.News


/**
 * [RecyclerView.Adapter] that can display a [News].

 */
class NewsRecyclerViewAdapter(
  private val values: List<News>
) : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.fragment_news_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = values[position]
//    holder.idView.text = item.id
//    holder.contentView.text = item.content
    holder.titleTextView.text = item.title
    holder.detailTextView.text = item.detail
    Picasso.get().load(item.image).into(holder.newsImageView)


  }

  override fun getItemCount(): Int = values.size

  inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val titleTextView: TextView = view.findViewById(R.id.titleTextView)
    val detailTextView: TextView = view.findViewById(R.id.content)
    val newsImageView: ImageView = view.findViewById(R.id.newsImageView)

    override fun toString(): String {
      return super.toString() + " '" + detailTextView.text + "'"
    }
  }
}
