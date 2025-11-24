package com.example.bai2

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Thiết lập Toolbar
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Đặt tiêu đề và hiển thị icon menu
        supportActionBar?.title = "Inbox"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)


        // Tìm RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Tạo dữ liệu mẫu
        val emails = createSampleEmails()

        // Tạo Adapter và gán cho RecyclerView
        val adapter = EmailAdapter(emails)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    // Hàm này để tạo menu trên toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Hàm này để xử lý sự kiện khi nhấn vào các item trên toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Xử lý khi nhấn vào icon menu (3 sọc)
                Toast.makeText(this, "Menu icon clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_search -> {
                // Xử lý khi nhấn vào icon tìm kiếm
                Toast.makeText(this, "Search icon clicked", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun createSampleEmails(): List<Email> {
        return mutableListOf(
            Email(
                sender = "Edurila.com",
                subject = "$19 Only (First 10 spots) - Bestselling...",
                preview = "Are you looking to Learn Web Designin...",
                timestamp = "12:34 PM",
                color = Color.parseColor("#4285F4"), // Blue
                isRead = false,
                isStarred = false
            ),
            Email(
                sender = "Chris Abad",
                subject = "Help make Campaign Monitor better",
                preview = "Let us know your thoughts! No Images...",
                timestamp = "11:22 AM",
                color = Color.parseColor("#FBBC05"), // Yellow/Orange
                isRead = false,
                isStarred = false
            ),
            Email(
                sender = "Tuto.com",
                subject = "8h de formation gratuite et les nouvea...",
                preview = "Photoshop, SEO, Blender, CSS, WordPre...",
                timestamp = "11:04 AM",
                color = Color.parseColor("#34A853"), // Green
                isRead = false,
                isStarred = true // Email này được đánh dấu sao
            ),
            Email(
                sender = "support",
                subject = "Société Ovh : suivi de vos services - hp...",
                preview = "SAS OVH - http://www.ovh.com 2 rue K...",
                timestamp = "10:26 AM",
                color = Color.parseColor("#EA4335"), // Red
                isRead = false,
                isStarred = false
            ),
            Email(
                sender = "Matt from Ionic",
                subject = "The New Ionic Creator Is Here!",
                preview = "Announcing the all-new Creator, build...",
                timestamp = "10:15 AM",
                color = Color.parseColor("#4CAF50"), // Another Green
                isRead = false,
                isStarred = false
            ),
            Email(
                sender = "LinkedIn",
                subject = "Jobs you may be interested in",
                preview = "Hi, here are some jobs we think you'd like...",
                timestamp = "9:45 AM",
                color = Color.parseColor("#0A66C2"), // LinkedIn Blue
                isRead = true, // Email này đã đọc
                isStarred = false
            ),
            Email(
                sender = "Medium Daily Digest",
                subject = "Stories for you",
                preview = "A new story from a writer you follow...",
                timestamp = "Yesterday",
                color = Color.parseColor("#292929"), // Medium Black
                isRead = false,
                isStarred = true
            ),
            Email(
                sender = "GitHub",
                subject = "[GitHub] A third-party OAuth application...",
                preview = "Hey there! A third-party OAuth application...",
                timestamp = "Yesterday",
                color = Color.parseColor("#24292E"), // GitHub Dark
                isRead = true
            ),
            Email(
                sender = "Alice Johnson",
                subject = "Weekend plans?",
                preview = "Hey! Are we still on for Saturday? Let me know!",
                timestamp = "Sep 28",
                color = Color.parseColor("#673AB7"), // Deep Purple
                isRead = false,
                isStarred = true
            ),
            Email(
                sender = "Amazon.com",
                subject = "Your order #123-456789 has shipped!",
                preview = "Your package will be delivered on Friday...",
                timestamp = "Sep 27",
                color = Color.parseColor("#FF9900"), // Amazon Orange
                isRead = true
            ),
            Email(
                sender = "Quora Digest",
                subject = "What is the best way to learn Kotlin?",
                preview = "Top answers to your questions from Quora...",
                timestamp = "Sep 27",
                color = Color.parseColor("#B92B27"), // Quora Red
                isRead = false
            ),
            Email(
                sender = "Dropbox",
                subject = "Your storage is almost full",
                preview = "Upgrade now to get more space for your files...",
                timestamp = "Sep 26",
                color = Color.parseColor("#007EE5"), // Dropbox Blue
                isRead = false
            ),
            Email(
                sender = "Slack",
                subject = "You have a new notification",
                preview = "John Doe mentioned you in #general channel...",
                timestamp = "Sep 26",
                color = Color.parseColor("#4A154B"), // Slack Purple
                isRead = true
            ),
            Email(
                sender = "Netflix",
                subject = "New series you might like",
                preview = "Based on your watching of 'The Crown'...",
                timestamp = "Sep 25",
                color = Color.parseColor("#E50914"), // Netflix Red
                isRead = true,
                isStarred = true
            )
        )
    }
}
