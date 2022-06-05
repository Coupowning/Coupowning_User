package kr.ac.coukingmama.userapp.Adapter

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.provider.TedPermissionProvider.context
import kotlinx.android.synthetic.main.coupon_item_list.view.*
import kr.ac.coukingmama.userapp.R
import kr.ac.coukingmama.userapp.data.user.StoreList
import java.util.ArrayList

class HomeRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var listener : OnItemClickListener
    var storeList =  ArrayList<StoreList>()


    fun setData(loc: Int, user: StoreList){
        storeList.add(loc, user)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.coupon_item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return storeList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var viewHolder = (holder as ViewHolder).itemView
        var currentItem = storeList[position]


        viewHolder.storeName.text = currentItem.storeName
        viewHolder.storeAddress.text = currentItem.storeLocation
        viewHolder.currentStamp.text = currentItem.currStamp.toString()

        for(i in 1..currentItem.currStamp){
            var stampId = viewHolder.getResources().getIdentifier("stamp_" + i,"id", viewHolder.context.packageName)
            var iv = viewHolder.findViewById<ImageView>(stampId)
            iv.setImageResource(R.drawable.ic_stamp_image)
        }
        for(i in (currentItem.currStamp + 1)..10){
            var stampId = viewHolder.getResources().getIdentifier("stamp_" + i,"id", viewHolder.context.packageName)
            var iv = viewHolder.findViewById<ImageView>(stampId)
            iv.setImageResource(R.drawable.ic_emptystamp)
        }

        viewHolder.setOnClickListener {
            listener!!.onItemClick(it, currentItem, position)
        }

        Glide.with(context).asBitmap().load(currentItem.storeImage).into(viewHolder.storeImage!!)


    }

    interface OnItemClickListener{
        fun onItemClick(v:View, data: StoreList, pos : Int)
    }

    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }


}
