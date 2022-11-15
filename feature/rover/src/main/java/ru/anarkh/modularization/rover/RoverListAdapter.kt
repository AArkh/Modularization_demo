package ru.anarkh.modularization.rover

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ru.anarkh.core.ui.dpToPx
import ru.anarkh.modularization.domain.rover.RoverPhoto

internal class RoverListAdapter : RecyclerView.Adapter<ViewHolder>() {

    var data: List<RoverPhoto> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var setOnImageClickListener: ((RoverPhoto) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = data[position]
        val context = holder.itemView.context
        Glide.with(context)
            .asBitmap()
            .load(data.imageUrl)
            .transform(RoundedCorners(context.dpToPx(16)))
            .placeholder(ru.anarkh.modularization.core.ui.R.drawable.placeholder)
            .into(holder.image)
        holder.itemView.setOnClickListener { setOnImageClickListener?.invoke(data) }
    }

    override fun getItemCount(): Int = data.size
}

internal class ViewHolder(
    layoutInflater: LayoutInflater
) : RecyclerView.ViewHolder(layoutInflater.inflate(R.layout.epic_item, null)) {

    val image: AppCompatImageView = itemView.findViewById(R.id.image)
}