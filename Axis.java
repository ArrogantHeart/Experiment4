package com.example.experiment4;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Axis {
    private int nMinX;
    private int nMaxX;
    private int nMinY;
    private int nMaxY;

    private Rect mRect;

    public Axis(Rect rect) {
        nMinX = -10;
        nMaxX = 10;
        nMinY = -10;
        nMaxY = 10;
        mRect = rect;
    }

    public int convertXLP2DP (double x) {
        return mRect.left + (int) (mRect.width() / (double) (nMaxX - nMinX) * (x - nMinX));
    }

    public int convertYLP2DP (double y) {
        return mRect.bottom - (int) (mRect.height() / (double) (nMaxY - nMinY) * (y - nMinX));
    }

    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        double nX = (double)(nMaxX-nMinX)/20;
        double nY = (double)(nMaxY-nMinY)/20;

        canvas.drawLine(convertXLP2DP(nMinX), convertYLP2DP(0), convertXLP2DP(nMaxX), convertYLP2DP(0), paint);
        canvas.drawLine(convertXLP2DP(0), convertYLP2DP(nMaxY), convertXLP2DP(0), convertYLP2DP(nMinY), paint);

        paint.setStrokeWidth(1);
        paint.setTextSize(9);
        canvas.drawText("0", convertXLP2DP(nX), convertYLP2DP(-nY), paint);
        canvas.drawText(nMinX + "", convertXLP2DP(nMinX+nX), convertYLP2DP(-nY), paint);
        canvas.drawText(nMinX+"",convertXLP2DP(nMaxX-nX), convertYLP2DP(-nY),paint);
        canvas.drawText(nMinY+"",convertXLP2DP(-nX), convertYLP2DP(nMinY+nY),paint);
        canvas.drawText(nMinY+"",convertXLP2DP(-nX), convertYLP2DP(nMaxY-nY),paint);
    }

}
