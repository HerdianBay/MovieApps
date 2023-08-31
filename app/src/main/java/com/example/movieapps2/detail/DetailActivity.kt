package com.example.movieapps2.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.movieapps2.R
import com.example.movieapps2.core.domain.model.Movie
import com.example.movieapps2.core.ui.MovieAdapter
import com.example.movieapps2.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DATA = "data"
    }

    private val detailViewModel : DetailViewModel by viewModel()
    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailMovie = intent.getParcelableExtra<Movie>(DATA)
        supportActionBar?.title = detailMovie?.title
        showDetailMovie(detailMovie)
    }

    private fun showDetailMovie(detailMovie : Movie?) {
        detailMovie?.let {
            Glide.with(this@DetailActivity)
                .load(MovieAdapter.BASEURL + detailMovie.posterPath)
                .into(binding.ivDetailImage)
            binding.overview.text = detailMovie.overview

            var favorite = detailMovie.favorite
            setStatusFavorite(favorite)
            binding.fab.setOnClickListener {
                favorite = !favorite
                detailViewModel.updateFavoriteMovie(detailMovie, favorite)
                setStatusFavorite(favorite)
            }
        }
    }

    private fun setStatusFavorite(favorite : Boolean) {
        if (favorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.favorite_full))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.favorite_border))
        }
    }
}