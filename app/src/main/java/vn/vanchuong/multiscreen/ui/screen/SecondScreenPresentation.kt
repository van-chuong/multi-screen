package vn.vanchuong.multiscreen.ui.screen

import android.app.Presentation
import android.content.Context
import android.os.Bundle
import android.view.Display
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import vn.vanchuong.multiscreen.ui.util.PresentationLifecycleOwner


class SecondScreenPresentation(
    context: Context,
    display: Display,
) : Presentation(context, display) {

    private val lifecycleOwner = PresentationLifecycleOwner()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleOwner.onCreate()

        val composeView = ComposeView(context).apply {
            setContent {
                SecondScreen()
            }
        }

        lifecycleOwner.attachToDecorView(composeView)
        setContentView(composeView)
    }

    override fun onStart() {
        super.onStart()
        lifecycleOwner.onStart()
    }
}

@Composable
fun SecondScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("SecondScreen", color = Color.Black)
    }
}
