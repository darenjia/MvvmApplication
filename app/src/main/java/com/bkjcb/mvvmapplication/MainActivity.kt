package com.bkjcb.mvvmapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavGraphBuilder
import com.bkjcb.mvvmapplication.databinding.MainActivityBinding
import com.bkjcb.mvvmapplication.ui.main.MainFragment
import com.bkjcb.mvvmapplication.ui.main.MainViewModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<MainActivityBinding>(this,R.layout.main_activity)
    }
}