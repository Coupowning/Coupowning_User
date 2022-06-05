package kr.ac.coukingmama.userapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kr.ac.coukingmama.userapp.R
import kr.ac.coukingmama.userapp.data.cafe.CafeProfile

class CafeProfileAdapter(private val context: Context) : RecyclerView.Adapter<CafeProfileAdapter.ViewHolder>() {

    var datas = mutableListOf<CafeProfile>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false)


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

        fun bind(item: CafeProfile) {
            Glide.with(itemView).load(item.img).into(imgProfile)

        }
    }
}
