package com.example.imageprocessing

import android.graphics.Bitmap
import kotlin.math.abs
import kotlin.math.roundToInt

class ImageProcessor {

    /**
     * Return null if input is null.
     * */
    fun getLifeDetectionInformation(bitmap: Bitmap?): Result? {
        if (bitmap == null) return null

        val pixelGray = ScaleConverter().getGrayByARGB(bitmap)

        val ns = getNS(pixelGray)
        val ns1 = getNS1(pixelGray)
        val mad = getMeanAbsoluteDeviation(pixelGray)

        return Result(ns = ns, ns1 = ns1, mad = mad)
    }

    private fun getNS(gray: IntArray): Double {
        val min = gray.min()
        val max = gray.max()

        return (max - min) / (max).toDouble()
    }

    private fun getNS1(gray: IntArray): Double {
        val min = gray.min()
        val max = gray.max()

        return (max - min) / ((max) + (min)).toDouble()
    }

    private fun getMean(gray: IntArray): Double {
        return gray.average()
    }

    private fun getMeanAbsoluteDeviation(gray: IntArray): Double {
        var dev: Double
        var sum = 0.0
        for (i in gray.indices) {
            dev = abs(gray[i] - getMean(gray))
            sum += (dev * 100.0).roundToInt() / 100.0
        }

        return sum / gray.size.toDouble()
    }

}