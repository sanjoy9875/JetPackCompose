package com.example.jetpackwithmvvm.custom_views.imogies

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class SadFaceView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    // Paint object for coloring and styling
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    // Some colors for the face background, eyes and mouth.
    private var faceColor = Color.YELLOW
    private var eyesColor = Color.DKGRAY
    private var mouthColor = Color.RED
    private var borderColor = Color.BLACK
    // Face border width in pixels
    private var borderWidth = 4.0f
    // View size in pixels
    private var size = 320

    private val mouthPath = Path()

    override fun onDraw(canvas: Canvas) {
        // call the super method to keep any drawing from the parent side.
        super.onDraw(canvas)

        drawFaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // 1
        size = Math.min(measuredWidth, measuredHeight)
        // 2
        setMeasuredDimension(size, size)
    }

    private fun drawFaceBackground(canvas: Canvas) {
        // 1
        paint.color = faceColor
        paint.style = Paint.Style.FILL

        // 2
        val radius = size / 2f

        // 3
        canvas.drawCircle(size / 2f, size / 2f, radius, paint)

        // 4
        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth

        // 5
        canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)
    }

    private fun drawEyes(canvas: Canvas) {
        // 1
        paint.color = eyesColor
        paint.style = Paint.Style.FILL

        // 2
        val leftEyeRect = RectF(size * 0.32f, size * 0.23f, size * 0.43f, size * 0.50f)
        canvas.drawOval(leftEyeRect, paint)

        // 3
        val rightEyeRect = RectF(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f)
        canvas.drawOval(rightEyeRect, paint)
    }

    private fun drawMouth(canvas: Canvas) {
        // 1
        mouthPath.moveTo(size * 0.22f, size * 0.7f)
        // 2
        // Sad mouth path
        mouthPath.quadTo(size * 0.5f, size * 0.50f, size * 0.78f, size * 0.7f)
        mouthPath.quadTo(size * 0.5f, size * 0.60f, size * 0.22f, size * 0.7f)

        // 4
        paint.color = mouthColor
        paint.style = Paint.Style.FILL
        // 5
        canvas.drawPath(mouthPath, paint)
    }


}