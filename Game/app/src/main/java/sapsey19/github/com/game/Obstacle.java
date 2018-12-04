package sapsey19.github.com.game;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class Obstacle implements GameObject {
    private Rect rectangle;

    public Obstacle(int startX) {
        rectangle = new Rect(startX, 0, startX + 90, 90);
    }

    public Rect getRectangle() {
        return rectangle;
    }

    public void incrementY(float y) {
        rectangle.top += y;
        rectangle.bottom += y;
    }

    public boolean playerCollide(Player player) {
        return Rect.intersects(rectangle, player.getRectangle()) || Rect.intersects(rectangle, player.getRectangle());
    }

    @Override
    public void draw(Canvas canvas) {
        Drawable drawable = Constants.CURRENT_CONTEXT.getDrawable(R.drawable.buzzsaw);
        drawable.setBounds(rectangle);
        drawable.draw(canvas);
    }

    @Override
    public void update() {
    }

    public void update(Point point) {
        rectangle.set(point.x - rectangle.width() / 2, point.y - rectangle.height() / 2, point.x + rectangle.width() / 2, point.y + rectangle.height() / 2);
    }
}
