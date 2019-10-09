package com.hafid.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.hafid.movie.favorite.FavoriteFragment
import com.hafid.movie.movie.MovieFragment
import com.hafid.movie.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_tab.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = HomeTabAdapter(supportFragmentManager)
        pager.adapter = adapter

        tabs.setupWithViewPager(pager)

        val view = LayoutInflater.from(this).inflate(R.layout.item_tab, null)
        view.tabImg.setImageResource(R.drawable.ic_movie_black_24dp)
        view.tabTitle.text = "Movie"
        tabs.getTabAt(0)?.customView = view

        val viewHistory = LayoutInflater.from(this).inflate(R.layout.item_tab, null)
        viewHistory.tabImg.setImageResource(R.drawable.ic_favorite_black_24dp)
        viewHistory.tabTitle.text = "Favorite"
        tabs.getTabAt(1)?.customView = viewHistory

        val viewProfile = LayoutInflater.from(this).inflate(R.layout.item_tab, null)
        viewProfile.tabImg.setImageResource(R.drawable.ic_person_black_24dp)
        viewProfile.tabTitle.text = "Profile"
        tabs.getTabAt(2)?.customView = viewProfile
    }

    class HomeTabAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {

            var fragment = Fragment()
            when(position){
                0->fragment = MovieFragment()
                1->fragment = FavoriteFragment()
                2->fragment = ProfileFragment()

            }
            return fragment


        }

        override fun getCount() = 3

        override fun getPageTitle(position: Int): CharSequence? {
            var nameTab = ""
            when(position){
                0-> nameTab = "Movie"
                1-> nameTab = "Favorite"
                2-> nameTab = "Profile"

            }
            return nameTab

            return super.getPageTitle(position)
        }



    }
}
