package com.example.imageprocessing

import android.graphics.Bitmap

class ScaleConverter {

    fun getGrayByARGB(bitmap: Bitmap): IntArray {
        val pixelA = IntArray(bitmap.width * bitmap.height)
        val pixelR = IntArray(bitmap.width * bitmap.height)
        val pixelG = IntArray(bitmap.width * bitmap.height)
        val pixelB = IntArray(bitmap.width * bitmap.height)

        val pixelGray = IntArray(bitmap.width * bitmap.height)
        val pixelValues = IntArray(bitmap.width * bitmap.height)

        bitmap.getPixels(
            pixelValues,
            0,
            bitmap.width,
            0,
            0,
            bitmap.width,
            bitmap.height
        )

        for (i in pixelValues.indices) {
            val pixelValue = pixelValues[i]

            pixelA[i] = pixelValue shr 24 and 0xFF
            pixelR[i] = pixelValue shr 16 and 0xFF
            pixelG[i] = pixelValue shr 8 and 0xFF
            pixelB[i] = pixelValue shr 0 and 0xFF

            val avg: Int = (pixelR[i] + pixelG[i] + pixelB[i]) / 3
            pixelGray[i] = ((pixelA[i] shl 24) or (avg shl 16) or (avg shl 8) or avg) and 0xFF
        }

        return pixelGray
    }

}