package sapsey19.github.com.game;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class Floor implements GameObject {

    private Rect rect1, rect2, rect3, rect4, rect5, rect6;

    //l,t,r,b
    public Floor() {
        rect1 = new Rect(0, 7 * (Constants.SCREEN_HEIGHT / 8) + 50, 180, (7 * (Constants.SCREEN_HEIGHT / 8) + 50) + 180);
        rect2 = new Rect(180, 7 * (Constants.SCREEN_HEIGHT / 8) + 50, 360, (7 * (Constants.SCREEN_HEIGHT / 8) + 50) + 180);
        rect3 = new Rect(360, 7 * (Constants.SCREEN_HEIGHT / 8) + 50, 540, (7 * (Constants.SCREEN_HEIGHT / 8) + 50) + 180);
        rect4 = new Rect(540, 7 * (Constants.SCREEN_HEIGHT / 8) + 50, 720, (7 * (Constants.SCREEN_HEIGHT / 8) + 50) + 180);
        rect5 = new Rect(720, 7 * (Constants.SCREEN_HEIGHT / 8) + 50, 900, (7 * (Constants.SCREEN_HEIGHT / 8) + 50) + 180);
        rect6 = new Rect(900, 7 * (Constants.SCREEN_HEIGHT / 8) + 50, 1080, (7 * (Constants.SCREEN_HEIGHT / 8) + 50) + 180);
    }

    @Override
    public void draw(Canvas canvas) {
        Drawable drawable1 = Constants.CURRENT_CONTEXT.getDrawable(R.drawable.floor);
        Drawable drawable2 = Constants.CURRENT_CONTEXT.getDrawable(R.drawable.floor);
        Drawable drawable3 = Constants.CURRENT_CONTEXT.getDrawable(R.drawable.floor);
        Drawable drawable4 = Constants.CURRENT_CONTEXT.getDrawable(R.drawable.floor);
        Drawable drawable5 = Constants.CURRENT_CONTEXT.getDrawable(R.drawable.floor);
        Drawable drawable6 = Constants.CURRENT_CONTEXT.getDrawable(R.drawable.floor);
        drawable1.setBounds(rect1);
        drawable2.setBounds(rect2);
        drawable3.setBounds(rect3);
        drawable4.setBounds(rect4);
        drawable5.setBounds(rect5);
        drawable6.setBounds(rect6);
        drawable1.draw(canvas);
        drawable2.draw(canvas);
        drawable3.draw(canvas);
        drawable4.draw(canvas);
        drawable5.draw(canvas);
        drawable6.draw(canvas);
    }

    @Override
    public void update() {
    }
}
