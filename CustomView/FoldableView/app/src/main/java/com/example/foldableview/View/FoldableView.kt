package com.example.foldableview.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.provider.SyncStateContract
import android.util.AttributeSet
import android.util.Log
import android.view.View

class FoldableView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val pnt = Paint()
        pnt.color = Color.CYAN

        canvas.drawColor(Color.GRAY)
        canvas.drawCircle(100F, 100F, 80F, pnt)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        // height
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        var heightSize = 0
        when(heightMode){
            // wrap_content -> 필요로하는 크기 지정해주어야 함
            MeasureSpec.AT_MOST -> {heightSize = 200}
            // match_parent, fill_parent
            MeasureSpec.EXACTLY -> {heightSize = MeasureSpec.getSize(heightMeasureSpec)}
            // 특정한 크기 값이 설정되었을 때 -> 설정받은 크기 넣어주면 됨
            MeasureSpec.UNSPECIFIED -> {heightSize = heightMeasureSpec}
        }

        // width
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        var widthSize = 0
        when(widthMode){
            // wrap_content -> 필요로하는 크기 지정해주어야 함
            MeasureSpec.AT_MOST -> {widthSize = 200}
            // match_parent, fill_parent
            MeasureSpec.EXACTLY -> {widthSize = MeasureSpec.getSize(widthMeasureSpec)}
            // 특정한 크기 값이 설정되었을 때 -> 설정받은 크기 넣어주면 됨
            MeasureSpec.UNSPECIFIED -> {widthSize = widthMeasureSpec}
        }

        Log.d("onMeasure", "widthSize : $widthSize && heightSize : $heightSize")

        setMeasuredDimension(widthSize, heightSize)
    }
}