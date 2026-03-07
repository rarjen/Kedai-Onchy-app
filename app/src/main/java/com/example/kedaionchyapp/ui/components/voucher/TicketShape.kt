package com.example.kedaionchyapp.ui.components.voucher

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class TicketShape(
    private val cornerRadius: Dp = 12.dp,
    private val cutoutRadius: Dp = 12.dp,
    private val cutoutPosition: Float = 0.50f // Posisi gigitan (65% dari atas)
) : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        val cr = with(density) { cornerRadius.toPx() }
        val cutR = with(density) { cutoutRadius.toPx() }
        val cutY = size.height * cutoutPosition

        val path = Path().apply {
            // Garis atas dan sudut kanan atas
            moveTo(cr, 0f)
            lineTo(size.width - cr, 0f)
            arcTo(Rect(size.width - 2 * cr, 0f, size.width, 2 * cr), 270f, 90f, false)

            // Garis kanan turun, gigitan ke dalam, lanjut ke sudut kanan bawah
            lineTo(size.width, cutY - cutR)
            arcTo(Rect(size.width - cutR, cutY - cutR, size.width + cutR, cutY + cutR), 270f, -180f, false)
            lineTo(size.width, size.height - cr)
            arcTo(Rect(size.width - 2 * cr, size.height - 2 * cr, size.width, size.height), 0f, 90f, false)

            // Garis bawah dan sudut kiri bawah
            lineTo(cr, size.height)
            arcTo(Rect(0f, size.height - 2 * cr, 2 * cr, size.height), 90f, 90f, false)

            // Garis kiri naik, gigitan ke dalam, lanjut ke sudut kiri atas
            lineTo(0f, cutY + cutR)
            arcTo(Rect(-cutR, cutY - cutR, cutR, cutY + cutR), 90f, -180f, false)
            lineTo(0f, cr)
            arcTo(Rect(0f, 0f, 2 * cr, 2 * cr), 180f, 90f, false)

            close()
        }
        return Outline.Generic(path)
    }
}