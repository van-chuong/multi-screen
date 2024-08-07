package vn.vanchuong.multiscreen

import android.content.Context
import android.hardware.display.DisplayManager
import android.os.Bundle
import android.view.Display
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import vn.vanchuong.multiscreen.ui.screen.SecondScreenPresentation
import vn.vanchuong.multiscreen.ui.theme.MultiScreenTheme

class MainActivity : ComponentActivity() {
    private var secondScreenPresentation: SecondScreenPresentation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiScreenTheme {
                MainScreen {
                    getCustomerDisplay(this)?.let { showSecondScreen(it) }
                }
            }
        }
    }

    private fun getCustomerDisplay(context: Context): Display? {
        val displayManager = context.getSystemService(Context.DISPLAY_SERVICE) as DisplayManager
        val displays = displayManager.displays

        return if (displays.size > 1) displays[1] else null
    }

    private fun showSecondScreen(display: Display) {
        secondScreenPresentation = SecondScreenPresentation(
            context = this,
            display = display,
        )
        secondScreenPresentation?.show()
    }


    override fun onDestroy() {
        super.onDestroy()
        secondScreenPresentation?.dismiss()
    }
}

@Composable
fun MainScreen(onButtonClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onButtonClick) {
            Text("Show Second Screen")
        }
    }
}