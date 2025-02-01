package com.example.myapplication7_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication7_3.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import java.text.DecimalFormat
import android.widget.Toast
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isRunning = false
    private var isPaused = false
    private var secondsElapsed = 0L
    private var stopwatchJob: Job? = null
    private val channel = Channel<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.start.setOnClickListener {
            if (!isRunning && !isPaused) {
                startStopwatch()
            } else if (isPaused) {
                showToast("Stopwatch is not stopped now!")
            }
        }

        binding.stop.setOnClickListener {
            stopStopwatch()
        }

        binding.pause.setOnClickListener {
            pauseStopwatch()
        }

        binding.resume.setOnClickListener {
            resumeStopwatch()
        }
    }

    private fun startStopwatch() {
        stopwatchJob = GlobalScope.launch(Dispatchers.Default) {
            isRunning = true
            while (isRunning) {
                delay(1000)
                secondsElapsed++
                val timeStr = formatTime(secondsElapsed)
                channel.send(timeStr)
            }
        }

        GlobalScope.launch(Dispatchers.Main) {
            channel.consumeEach {
                binding.time.text = it
            }
        }
    }

    private fun stopStopwatch() {
        isRunning = false
        isPaused = false
        secondsElapsed = 0L
        stopwatchJob?.cancel()
        binding.time.text = formatTime(secondsElapsed)
    }

    private fun pauseStopwatch() {
        isPaused = true
        stopwatchJob?.cancel()
    }

    private fun resumeStopwatch() {
        isPaused = false
        startStopwatch()
    }

    private fun formatTime(seconds: Long): String {
        val df = DecimalFormat("00")
        val h = seconds / 3600
        val m = (seconds % 3600) / 60
        val s = seconds % 60
        return "${df.format(h)}:${df.format(m)}:${df.format(s)}"
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        channel.close()
    }
}
