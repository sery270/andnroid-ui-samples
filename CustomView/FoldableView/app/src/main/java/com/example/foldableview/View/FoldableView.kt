package com.example.foldableview.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.res.use
import com.example.foldableview.R

class FoldableView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {
    // 뭐가 다른지 공부해야함
//class FoldableView(context: Context, attrs: AttributeSet) : View(context) {

    // property
    private var mColor = "FFFF00FF"

    // attrs property
    private var folded = false
    private var color = Color.BLACK


    init {
        /** View 배경색 설정하는 방법 1 : 초기화할 때, 딱 한번만 설정하고자 할 때 **/
//        setBackgroundColor(Color.BLUE)


//        Log.d("init", "attrs : ${attrs.attributeCount}")



        if (attrs != null) {


            getStyleableAttrs(attrs)

            for (i in 0 until attrs.attributeCount) {

                if (attrs.getAttributeName(i).equals("color")) {
                    val tmp = attrs.getAttributeValue(i)
                    Log.d("attrsattrs", "attrs : ${tmp}")
                    if (tmp.isNullOrEmpty()) {
                        // 코드에서 사용할 색상 코드로 변환
                        when (tmp.length) {
                            // alpha 채널 값의 유무로 분기
                            7 -> mColor = tmp.replace("#", "FF")
                            9 -> mColor = tmp.replace("#", "")
                        }
                    }
                }
            }
        }
    }

    // attrs property 초기화하는 함수
    private fun getStyleableAttrs(attrs: AttributeSet) {
        context.theme.obtainStyledAttributes(attrs, R.styleable.FoldableView, 0, 0)
            .use {
                folded = it.getBoolean(R.styleable.FoldableView_folded, false)
                color = it.getColor(R.styleable.FoldableView_color, Color.BLACK)
        }
    }

    @ExperimentalStdlibApi
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val pnt = Paint()
        /** String을 16 진수로 바꾸고, Int로 바꿔줌 **/
//        pnt.color = mColor.toLong(16).toInt()
        Log.d("onDraw", "onDraw : ${R.styleable.FoldableView_color}")
        pnt.color = color
        /** View 배경색 설정하는 방법 2 : 초기화 이후에, 여러 번 설정 및 변경해야할 때 **/
//        canvas.drawColor(Color.GRAY)
        canvas.drawCircle(100F, 100F, 80F, pnt)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        // height
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        var heightSize = 0
        when (heightMode) {
            // wrap_content -> 필요로하는 크기 지정해주어야 함
            MeasureSpec.AT_MOST -> {
                heightSize = 200
            }
            // match_parent, fill_parent
            MeasureSpec.EXACTLY -> {
                heightSize = MeasureSpec.getSize(heightMeasureSpec)
            }
            // 특정한 크기 값이 설정되었을 때 -> 설정받은 크기 넣어주면 됨
            MeasureSpec.UNSPECIFIED -> {
                heightSize = heightMeasureSpec
            }
        }

        // width
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        var widthSize = 0
        when (widthMode) {
            // wrap_content -> 필요로하는 크기 지정해주어야 함
            MeasureSpec.AT_MOST -> {
                widthSize = 200
            }
            // match_parent, fill_parent
            MeasureSpec.EXACTLY -> {
                widthSize = MeasureSpec.getSize(widthMeasureSpec)
            }
            // 특정한 크기 값이 설정되었을 때 -> 설정받은 크기 넣어주면 됨
            MeasureSpec.UNSPECIFIED -> {
                widthSize = widthMeasureSpec
            }
        }

        Log.d("onMeasure", "widthSize : $widthSize && heightSize : $heightSize")

        setMeasuredDimension(widthSize, heightSize)
    }
}