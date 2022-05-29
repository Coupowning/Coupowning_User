package kr.ac.coukingmama.userapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.coupon_item_list.view.*
import kr.ac.coukingmama.userapp.R
import kr.ac.coukingmama.userapp.data.user.StoreList
import kr.ac.coukingmama.userapp.data.user.User
import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList

class HomeRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var storeList =  ArrayList<StoreList>()
    fun setData(user: StoreList){
        storeList.add(user)
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

    }

    interface OnItemClickListener{
        fun onItemClick(v:View, data: User, pos : Int)
    }
    private var listener : AdapterView.OnItemClickListener? = null
    fun setOnItemClickListener(listener : AdapterView.OnItemClickListener) {
        this.listener = listener
    }
}
