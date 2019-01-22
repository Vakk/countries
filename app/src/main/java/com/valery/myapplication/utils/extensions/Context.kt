
package com.valery.myapplication.utils.extensions

import android.content.Context
import android.util.TypedValue
import org.intellij.lang.annotations.Flow

fun Context.convertDpToPx(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
}

fun Context.attrColor(colorId: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(colorId, typedValue, true)
    return typedValue.data
}
