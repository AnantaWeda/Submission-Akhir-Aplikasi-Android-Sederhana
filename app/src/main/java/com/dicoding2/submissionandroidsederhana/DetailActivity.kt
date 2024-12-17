package com.dicoding2.submissionandroidsederhana

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding2.submissionandroidsederhana.databinding.ActivityDetailBinding
import com.dicoding2.submissionandroidsederhana.model.Article

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Article>(EXTRA_DATA, Article::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Article>(EXTRA_DATA)
        }


        if (data != null) {
            binding.ivIconChar.setImageResource(data.photo)
            binding.tvName.text = data.name
            binding.tvPath.text = data.path
            binding.tvElement.text = data.element

            binding.tvRelic1.text = data.nameRelic1;
            binding.tvRelic2.text = data.nameRelic2;
            binding.tvRelic3.text = data.nameRelic3;

            binding.ivRelic1.setImageResource(data.imageRelic1)
            binding.ivRelic2.setImageResource(data.imageRelic2)
            binding.ivRelic3.setImageResource(data.imageRelic3)

            binding.tvDescription.text = data.description
        }
    }
}