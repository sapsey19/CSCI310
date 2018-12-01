package sapsey19.github.com.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class Obstacle implements GameObject {

    private int color;
    private Rect rectangle;

    private Animation img;
    private AnimationManager manager;

    public Obstacle(int rectHeight, int color, int startX, int startY) {
        this.color = color;
        rectangle = new Rect(startX, 0, startX + 50, 50);
    }

    public Rect getRectangle() {
        return rectangle;
    }

    public void incrementY(float y) {
        rectangle.top += y;
        rectangle.bottom += y;
    }

    public boolean playerCollide(RectPlayer player) {
        return Rect.intersects(rectangle, player.getRectangle()) || Rect.intersects(rectangle, player.getRectangle());
    }

    @Override
    public void draw(Canvas canvas) {
//        Paint paint = new Paint();
//        paint.setColor(color);
//        canvas.drawRect(rectangle, paint);

        //manager.draw(canvas, rectangle);
        Drawable drawable = Constants.CURRENT_CONTEXT.getResources().getDrawable(R.drawable.hurt);
        drawable.setBounds(rectangle);
        drawable.draw(canvas);
    }

    @Override
    public void update() {
        manager.update();
    }

    public void update(Point point) {
        rectangle.set(point.x - rectangle.width() / 2, point.y - rectangle.height() / 2, point.x + rectangle.width() / 2, point.y + rectangle.height() / 2);

        manager.playAnim(0);
        manager.update();
    }
}
