package com.tmd.cookit.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.tmd.cookit.R
import com.tmd.core_lib.ResizeImageView

class MsgImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val tvDesc: TextView
    private val ivCover: ResizeImageView

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MsgImageView)
        val backgroundColor =
            typedArray.getColor(
                R.styleable.MsgImageView_ivBackgroundColor,
                resources.getColor(R.color.colorPlaceHolder)
            )
        typedArray.recycle()

        val childView = LayoutInflater.from(context).inflate(R.layout.layout_msg_image, this)
        childView.setBackgroundColor(backgroundColor)
        tvDesc = findViewById(R.id.tvImageDesc)
        ivCover = findViewById(R.id.ivCover)

        contentDescription?.let { tvDesc.text = it }

    }

    fun setImageDesc(desc: String) {
        tvDesc.text = desc
    }

    fun setImage(url: String) {
        //todo: set image view
    }

}