package com.example.jetpackwithmvvm.custom_views.draw_path

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawPath(
    context: Context,
    attrs: AttributeSet?) : View(context, attrs) {

    private var paint : Paint? = null
    private var path : Path? = null

    init {
        paint = Paint()
        path = Path()
        paint!!.color = Color.BLACK
        paint!!.strokeWidth = 10f
        paint!!.style = Paint.Style.STROKE
        paint!!.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        canvas!!.drawPath(path!!,paint!!)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val xPos : Float = event!!.x
        val yPos :Float = event.y

        when(event.action){
            MotionEvent.ACTION_DOWN->{
                path!!.moveTo(xPos,yPos)
            }
            MotionEvent.ACTION_MOVE->{
                path!!.lineTo(xPos,yPos)
            }
            MotionEvent.ACTION_UP->{

            }
            else->{

            }
        }
        invalidate()
        return true
    }

}