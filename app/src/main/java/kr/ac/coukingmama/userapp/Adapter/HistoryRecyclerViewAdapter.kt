package kr.ac.coukingmama.userapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.history_list.view.*
import kr.ac.coukingmama.userapp.R
import kr.ac.coukingmama.userapp.data.user.History

import java.text.SimpleDateFormat
import java.util.*

class HistoryRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var historyList = ArrayList<History>()

    fun setData(history: History) {
        historyList.add(history)
        notifyDataSetChanged()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.history_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return historyList.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var viewHolder = (holder as ViewHolder).itemView
        var currentItem = historyList[position]
        var Sformat = SimpleDateFormat("YYYY년 MM월 DD일" )
        val ndate : java.util.Date = Date(((currentItem.date._seconds)  * 1000) +
                (currentItem.date._nanoseconds) / 1000000)
        val date = Sformat.format(ndate)
        viewHolder.historyDate.text = date.toString()
        viewHolder.historyNum.text = currentItem.amount.toString()
    }
}