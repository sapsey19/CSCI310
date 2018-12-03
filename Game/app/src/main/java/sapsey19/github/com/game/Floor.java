package sapsey19.github.com.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Floor implements GameObject {

    private int color = Color.RED;
    private Rect rectangle;
    //l,t,r,b
    public Floor() {
        rectangle = new Rect(0, Constants.SCREEN_HEIGHT+300, Constants.SCREEN_WIDTH+500, Constants.SCREEN_HEIGHT);
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void update() {

    }
}
