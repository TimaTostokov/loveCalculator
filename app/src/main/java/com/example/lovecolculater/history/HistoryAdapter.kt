package com.example.lovecolculater.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecolculater.databinding.FragmentHistoryBinding
import com.example.lovecolculater.model.Love

class HistoryAdapter(
    val onLongClick: (loveModel: Love) -> Unit,
    val onCLick: (loveModel: Love) -> Unit
) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val historyList = ArrayList<Love>()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(loveModel: List<Love>) {
        historyList.clear()
        historyList.addAll(loveModel)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            FragmentHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(historyList[position])
    }

    override fun getItemCount() = historyList.size

    inner class HistoryViewHolder(private val binding: FragmentHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(lover: Love) {
            binding.tvHistory.text = lover.firstname
            binding.tvHistory.text = lover.secondName
            binding.tvHistory.text = lover.percentage
            binding.tvHistory.text = lover.result

            itemView.setOnLongClickListener {
                onLongClick(lover)
                true
            }

            itemView.setOnClickListener {
                onCLick(lover)
            }
        }
    }

}