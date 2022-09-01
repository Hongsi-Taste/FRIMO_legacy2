package com.gachon.frimo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gachon.frimo.adapter.CommentAdapter
import com.gachon.frimo.adapter.ContentDetailImagePagerAdapter
import com.gachon.frimo.databinding.ContentDetailBinding
import com.gachon.frimo.entity.Comment

class ContentDetail : AppCompatActivity() {

    private lateinit var binding: ContentDetailBinding
    private val comments: ArrayList<Comment> = ArrayList() // following

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ContentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Todo: Circle indicator 설정

        prepareCommentData()

        with(binding) {

            // image
            pagerImages.adapter = ContentDetailImagePagerAdapter(baseContext)
            binding.indicator.setViewPager(pagerImages)

            // like button
            buttonLike.setOnClickListener {

                // Todo: 서버에 좋아요 갯수 1개 올리라고 전송
                Toast.makeText(
                    it.context,
                    "Like button clicked, add click listener!",
                    Toast.LENGTH_SHORT
                ).show()
            }

            // enter button
            buttonEnter.setOnClickListener {

                // Todo: 서버에 comment data 전송
                Toast.makeText(
                    it.context,
                    "Enter button clicked, add click listener!",
                    Toast.LENGTH_SHORT
                ).show()
            }

            // recyclerView
            recyclerViewComment.adapter = CommentAdapter(comments)

        }

    }

    private fun prepareCommentData() {

        // Todo: 서버에서 comment data 받아오기
        comments.clear()
        comments.add(Comment(R.drawable.ic_user, "user1", "comment1"))
        comments.add(Comment(R.drawable.ic_user, "user2", "comment2"))
        comments.add(Comment(R.drawable.ic_user, "user3", "comment3"))
        comments.add(Comment(R.drawable.ic_user, "user4", "comment4"))
        comments.add(Comment(R.drawable.ic_user, "user5", "comment5"))
        comments.add(Comment(R.drawable.ic_user, "user6", "comment6"))
        comments.add(Comment(R.drawable.ic_user, "user7", "comment7"))
        comments.add(Comment(R.drawable.ic_user, "user8", "comment8"))
    }
}