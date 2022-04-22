package id.ac.umn.app.a006

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.view.View
import id.ac.umn.app.a006.databinding.ActivityServiceBinding



class ServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonStart.setOnClickListener(View.OnClickListener {
            MyService.startService(this, "Foreground Service is running...")
        })
        binding.buttonStop.setOnClickListener(View.OnClickListener {
            MyService.stopService(this)
        })
    }
}