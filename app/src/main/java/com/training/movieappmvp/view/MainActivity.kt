package com.training.movieappmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.training.movieappmvp.R
import com.training.movieappmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var nowPlayingFragment: NowPlayingFragment
    private lateinit var popularFragment: PopularFragment
    private lateinit var upcomingFragment: UpcomingFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        nowPlayingFragment= NowPlayingFragment()
        popularFragment= PopularFragment()
        upcomingFragment= UpcomingFragment()
        binding.bottomMenu.setOnNavigationItemReselectedListener {
                menuItem->
            when(menuItem.itemId){
                R.id.upcoming->openFragment(upcomingFragment)
                R.id.popular->openFragment(popularFragment)
                R.id.nowplaying->openFragment(nowPlayingFragment)
            }
        }

    }
    private fun openFragment(fragment: Fragment)= supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()

}