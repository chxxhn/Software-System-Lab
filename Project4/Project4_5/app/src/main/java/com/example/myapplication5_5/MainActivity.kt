package com.example.myapplication5_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication5_5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //TODO : viewpager 추가
        val datas = mutableListOf<String>()
        for (i in 1..3) {
            datas.add("Item $i")
        }

        //// TODO : 뷰페이저에 어댑터를 연결, 방향 설정
        binding.viewpager.adapter = MyPagerAdapter(this)
        binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        //drawer 추가
        val drawer = findViewById<DrawerLayout>(R.id.drawer)
        //TODO : ActionBarDrawerToggle 추가
        toggle = ActionBarDrawerToggle(
            this, binding.drawer,
            R.string.drawer_opened, R.string.drawer_closed
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}