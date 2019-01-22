package com.valery.myapplication.ui.base

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import com.valery.myapplication.R
import com.valery.myapplication.utils.extensions.attrColor
import com.valery.myapplication.utils.extensions.convertDpToPx

class DividerItemDecorator(
    context: Context,
    paddingStartDp: Float = 16f,
    paddingEndDp: Float = 16f,
    height: Float = 1f,
    colorAttr: Int = R.attr.colorAccent
) : RecyclerView.ItemDecoration() {
    private lateinit var dividerPaint: Paint

    private var height: Float = context.convertDpToPx(height)
    private var paddingStart: Float = context.convertDpToPx(paddingStartDp)
    private var paddingEnd: Float = context.convertDpToPx(paddingEndDp)
    private var dividerColor: Int = context.attrColor(colorAttr)

    init {
        val styledAttributes = context.obtainStyledAttributes(ATTRS)
        styledAttributes.recycle()
        initDividerPaint()
    }

    private fun initDividerPaint() {
        dividerPaint = Paint()
        dividerPaint.color = dividerColor
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + height
            c.drawRect(left.toFloat() + paddingStart, top.toFloat(), right.toFloat() - paddingEnd, bottom, dividerPaint)
        }
    }

    companion object {
        private val ATTRS = intArrayOf(android.R.attr.listDivider)
    }
}