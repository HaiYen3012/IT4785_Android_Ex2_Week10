package com.example.bai2

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) :
    RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderInitial: TextView = itemView.findViewById(R.id.tvSenderInitial)
        val sender: TextView = itemView.findViewById(R.id.tvSender)
        val subject: TextView = itemView.findViewById(R.id.tvSubject)
        val preview: TextView = itemView.findViewById(R.id.tvPreview)
        val timestamp: TextView = itemView.findViewById(R.id.tvTimestamp)
        val star: ImageView = itemView.findViewById(R.id.ivStar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_email, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emails[position]

        holder.sender.text = email.sender
        holder.subject.text = email.subject
        holder.preview.text = email.preview
        holder.timestamp.text = email.timestamp
        holder.senderInitial.text = email.sender.first().toString().uppercase()

        // Đặt màu nền cho chữ cái
        holder.senderInitial.background.setTint(email.color)

        // 1. Cập nhật trạng thái chữ đậm/thường
        if (!email.isRead) {
            holder.sender.setTypeface(null, Typeface.BOLD)
            holder.subject.setTypeface(null, Typeface.BOLD)
        } else {
            holder.sender.setTypeface(null, Typeface.NORMAL)
            holder.subject.setTypeface(null, Typeface.NORMAL)
        }

        // 2. Cập nhật icon ngôi sao
        if (email.isStarred) {
            holder.star.setImageResource(R.drawable.ic_star_filled)
        } else {
            holder.star.setImageResource(R.drawable.ic_star_border)
        }

        // 3. Xử lý sự kiện click vào ngôi sao
        holder.star.setOnClickListener {
            email.isStarred = !email.isStarred // Đảo ngược trạng thái
            notifyItemChanged(position) // Cập nhật lại chỉ item này
        }

        // Xử lý click vào cả email để đánh dấu là đã đọc
        holder.itemView.setOnClickListener {
            if (!email.isRead) {
                email.isRead = true
                notifyItemChanged(position)
            }
        }
    }

    override fun getItemCount() = emails.size
}
