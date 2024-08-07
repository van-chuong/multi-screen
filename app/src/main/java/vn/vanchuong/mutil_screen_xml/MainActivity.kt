package vn.vanchuong.mutil_screen_xml

import android.content.Context
import android.hardware.display.DisplayManager
import android.os.Bundle
import android.view.Display
import androidx.appcompat.app.AppCompatActivity
import vn.vanchuong.mutil_screen_xml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var secondScreenPresentation: SecondScreenPresentation? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            getDisplay(this@MainActivity)?.let { showSecondScreen(it) }
        }
    }


    private fun getDisplay(context: Context): Display? {
        val displayManager = context.getSystemService(Context.DISPLAY_SERVICE) as DisplayManager
        val displays = displayManager.displays

        return if (displays.size > 1) displays[1] else null
    }

    private fun showSecondScreen(display: Display) {
        secondScreenPresentation = SecondScreenPresentation(display, this@MainActivity)
        secondScreenPresentation?.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        secondScreenPresentation?.dismiss()
    }
}