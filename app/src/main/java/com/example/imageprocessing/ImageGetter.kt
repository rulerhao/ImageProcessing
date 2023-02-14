package com.example.imageprocessing

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File


class ImageGetter {

    fun getImage(path: String): Bitmap? {
        val file = File(path)
        if (file.exists()) {
            return BitmapFactory.decodeFile(file.absolutePath)
        }
        return null
    }

}