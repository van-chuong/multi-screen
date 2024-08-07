package vn.vanchuong.mutil_screen_xml

import android.app.Presentation
import android.content.Context
import android.os.Bundle
import android.view.Display
import android.view.LayoutInflater
import android.view.Window
import androidx.databinding.DataBindingUtil
import vn.vanchuong.mutil_screen_xml.databinding.SencondaryScreenBinding

class SecondScreenPresentation(
    display: Display,
    context: Context
) : Presentation(context, display) {

    private lateinit var binding: SencondaryScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.sencondary_screen, null, false)
        setContentView(binding.root)
    }
}