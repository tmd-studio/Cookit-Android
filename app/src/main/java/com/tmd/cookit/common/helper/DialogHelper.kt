package com.tmd.cookit.common.helper

import android.app.Activity
import android.app.Dialog
import android.graphics.Point
import android.view.View
import com.tmd.cookit.R

object DialogHelper {

    private fun getBaseDialog(context: Activity, dialogView: View, gravity: Int): Dialog? {
        val dlg = Dialog(context, R.style.CookDialogStyle)
        dlg.setCancelable(false)
        dlg.setContentView(dialogView)
        val windowManager = context.windowManager
        val display = windowManager.defaultDisplay
        val lp2 = dlg.window!!.attributes
        lp2.x = 0
        lp2.gravity = gravity
        val point = Point()
        display.getSize(point)
        lp2.width = point.x
        dlg.window!!.attributes = lp2
        return dlg
    }


}