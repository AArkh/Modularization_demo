package ru.anarkh.modularization.apod

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ru.anarkh.core.ui.dpToPx
import ru.anarkh.modularization.apod.impl.R
import ru.anarkh.modularization.domain.apod.ApodNetModel

internal class ApodListAdapter : RecyclerView.Adapter<ViewHolder>() {

    var data: List<ApodNetModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var setOnImageClickListener: ((ApodNetModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = data[position]
        val context = holder.itemView.context
        Glide.with(context)
            .asBitmap()
            .load(data.url)
            .transform(RoundedCorners(context.dpToPx(16)))
            .placeholder(ru.anarkh.modularization.core.ui.R.drawable.placeholder)
            .into(holder.image)
        holder.itemView.setOnClickListener { setOnImageClickListener?.invoke(data) }
    }

    override fun getItemCount(): Int = data.size
}

internal class ViewHolder(
    layoutInflater: LayoutInflater
) : RecyclerView.ViewHolder(layoutInflater.inflate(R.layout.apod_item, null)) {

    val image: AppCompatImageView = itemView.findViewById(R.id.image)
}