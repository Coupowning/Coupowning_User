package kr.ac.coukingmama.userapp.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.ac.coukingmama.userapp.R
import kr.ac.coukingmama.userapp.data.store.StoreProfile

class StoreProfileAdapter(private val context: Context) : RecyclerView.Adapter<StoreProfileAdapter.ViewHolder>() {

    var datas = mutableListOf<StoreProfile>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imgProfile: ImageView = itemView.findViewById(R.id.img_rv_photo)

        fun bind(item: StoreProfile) {
            Log.d("adapter", item.image)
            Glide.with(context).load(item.image).centerCrop().into(imgProfile)
        }
    }
}
