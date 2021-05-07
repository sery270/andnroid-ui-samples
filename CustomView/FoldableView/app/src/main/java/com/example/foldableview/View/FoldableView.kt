package com.example.foldableview.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
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

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//
//        // height
//        var heightMode = MeasureSpec.getMode(heightMeasureSpec)
//        var heightSize = 0
//        when(heightMode){
//            // wrap_content -> 필요로하는 크기 지정해주어야 함
//            MeasureSpec.AT_MOST -> {}
//            // match_parent, fill_parent
//            MeasureSpec.EXACTLY -> {}
//            // 특정한 크기 값이 설정되었을 때 (mode가 셋팅하지 않은 크기가 넘어올 때)
//            MeasureSpec.UNSPECIFIED -> {}
//        }
//
//        // width
//    }
}