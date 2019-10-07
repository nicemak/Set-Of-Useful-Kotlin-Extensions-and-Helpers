package com.crazylegend.kotlinextensions.palette

import android.graphics.Bitmap
import androidx.palette.graphics.Palette


/**
 * Created by hristijan on 10/7/19 to long live and prosper !
 */


/**
 * Synchronous palette generator from a bitmap
 */
val Bitmap.palette get() = Palette.from(this).generate()


fun Bitmap.palette(paletteCallback: (palette: Palette?) -> Unit) {
    Palette.from(this).generate {
        paletteCallback(it)
    }
}

fun Bitmap.buildPalette(buildCallback: Palette.Builder.() -> Unit) {
    val builder = Palette.Builder(this)
    builder.buildCallback()
}