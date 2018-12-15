package button.android_buttom_ui.com.buttonui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.graphics.drawable.shapes.Shape
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button

class Button(context: Context, var attr:AttributeSet) : Button(context,attr,R.attr.borderlessButtonStyle) {

    enum class ButtonType(val typeNumber: Int){
        Muittin(1), MaybeLater(2),
        MaybeLater2(3)
    }
    var color: String? = null
    var strokeColor: String? = null
    var strokeWidth: Int = 0
    var buttonType:Int = 0
    var cornerRadius: Int = 0
    var shapeType: Int = 0
    var gradient:GradientDrawable? = null

    init {
        setAttr()
        when(ButtonType.values()[buttonType-1]){
            ButtonType.Muittin -> {
                setMuittinProperties()
            }
            ButtonType.MaybeLater -> {}
            ButtonType.MaybeLater2 -> {}
        }
        invalidate()
        requestLayout()
    }

    private fun setAttr(){
        context.theme.obtainStyledAttributes(
            attr,
            R.styleable.Button,
            0, 0).apply {
            try {
                buttonType  = getInteger(R.styleable.Button_buttonType,resources.getInteger(R.integer.defButtonType))
                strokeColor = resources.getString(R.string.defStrokeColor)
                getString(R.styleable.Button_strokeColor)?.let {
                    strokeColor = it
                }
                shapeType = getInteger(R.styleable.Button_shape,resources.getInteger(R.integer.defShapeType))
                color = resources.getString(R.string.defColor)
                getString(R.styleable.Button_backgroundColor)?.let {
                    color = it
                }
                strokeWidth = getInt(R.styleable.Button_strokeWidth,resources.getInteger(R.integer.defStrokeWidth))
                cornerRadius = getInt(R.styleable.Button_cornerRadius,resources.getInteger(R.integer.defCornerRadius))
            } finally {
                recycle()
            }
        }

    }

    private fun setMuittinProperties(){
        paint.isAntiAlias = false
        isAllCaps = false
        gradient = GradientDrawable()
        gradient?.cornerRadius = cornerRadius.toFloat()
        when(shapeType){
            1 -> gradient?.shape = GradientDrawable.RECTANGLE
            2 -> gradient?.shape = GradientDrawable.OVAL
            3 -> gradient?.shape = GradientDrawable.RING
        }
        gradient?.setColor(Color.parseColor(color))
        gradient?.setStroke(strokeWidth,Color.parseColor(strokeColor))
        gradient?.state = IntArray(1){android.R.attr.state_pressed}
        background = gradient
    }




}