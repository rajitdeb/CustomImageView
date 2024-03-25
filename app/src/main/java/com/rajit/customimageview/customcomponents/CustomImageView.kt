package com.rajit.customimageview.customcomponents

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.card.MaterialCardView
import com.rajit.customimageview.R
import java.util.Random

class CustomImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var imageCard: MaterialCardView
    private lateinit var nameInitialTv: TextView
    private lateinit var imageIv: ImageView
    private lateinit var root: ConstraintLayout

    init {
        initCustomImageView()
    }

    private fun initCustomImageView() {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.custom_imageview, this, true)

        imageCard = view.findViewById(R.id.imageCard)
        nameInitialTv = view.findViewById(R.id.nameInitialTv)
        imageIv = view.findViewById(R.id.imgView)
        root = view.findViewById(R.id.root)
    }

    fun getRootViewClick(): View {
        return root
    }

    fun setCustomImage(uri: Uri) {

        // If setting Image in the Custom ImageView
        // TextView = INVISIBLE
        // Image Card, ImageView = VISIBLE
        nameInitialTv.visibility = View.GONE
        imageCard.visibility = View.VISIBLE
        imageIv.visibility = View.VISIBLE
        imageIv.setImageURI(uri)

    }

    fun setNameInitialAsImage(initial: String) {

        // If NOT setting Image in the Custom ImageView
        // Image Card, TextView = VISIBLE
        // ImageView = INVISIBLE
        imageIv.visibility = View.GONE
        nameInitialTv.visibility = View.VISIBLE
        imageCard.visibility = View.VISIBLE

        val initialTxt = getInitial(initial)
        if (initialTxt != null) {
            setRandomBackgroundColor()
            setInitialTextColor()
            nameInitialTv.text = initialTxt
        }
    }

    private fun getInitial(initialTxt: String): String? {
        if (initialTxt.trim().isNotEmpty()) {
            return initialTxt.first().toString()
        }

        return null
    }

    private fun setInitialTextColor() {
        nameInitialTv.setTextColor(
            ContextCompat.getColor(context, R.color.white)
        )
    }

    private fun setRandomBackgroundColor() {
        val random = Random()
        val randomColor = Color.argb(
            255,
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256)
        )

        imageCard.setCardBackgroundColor(randomColor)
    }
}