package com.common.basemodule.widget.image;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

/**
 * Created by klx on 2017/8/12.
 */

public class CircleImageView extends HoverImageView{

    public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setup();
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public CircleImageView(Context context) {
        super(context);
        setup();
    }

    protected void setup() {

    }

    @Override
    public void buildBoundPath(Path borderPath){
        borderPath.reset();

        final int width = getWidth();
        final int height = getHeight();
        final float cx = width * 0.5f;
        final float cy = height * 0.5f;
        final float radius = Math.min(width, height) * 0.5f;

        borderPath.addCircle(cx, cy, radius, Path.Direction.CW);
    }

    @Override
    public void buildBorderPath(Path borderPath) {
        borderPath.reset();

        final float halfBorderWidth = getBorderWidth() * 0.5f;

        final int width = getWidth();
        final int height = getHeight();
        final float cx = width * 0.5f;
        final float cy = height * 0.5f;
        final float radius = Math.min(width, height) * 0.5f;

        borderPath.addCircle(cx, cy, radius - halfBorderWidth, Path.Direction.CW);
    }
}
