package sapsey19.github.com.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;


public class Player implements GameObject {

    private Rect rectangle;

    private Animation idle;
    private Animation idle2;
    private Animation walkRight;
    private Animation walkLeft;
    private AnimationManager animManager;

    public boolean moving = false;


    public Rect getRectangle() {
        return rectangle;
    }

    public Player(Rect rectangle) {
        this.rectangle = rectangle;

        BitmapFactory bf = new BitmapFactory();
        Bitmap idleImg = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.idle);
        Bitmap walk1 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.walk1);
        Bitmap walk2 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.walk2);
        Bitmap idleImg2 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.idle2);

        idle = new Animation(new Bitmap[]{idleImg}, 2);
        walkRight = new Animation(new Bitmap[]{walk1, walk2}, 0.5f);
        idle2 = new Animation(new Bitmap[]{idleImg2}, 2);

        Matrix m = new Matrix();
        m.preScale(-1, 1);
        walk1 = Bitmap.createBitmap(walk1, 0, 0, walk1.getWidth(), walk1.getHeight(), m, false);
        walk2 = Bitmap.createBitmap(walk2, 0, 0, walk2.getWidth(), walk2.getHeight(), m, false);
        walkLeft = new Animation(new Bitmap[]{walk1, walk2}, 0.5f);

        animManager = new AnimationManager(new Animation[]{idle, walkRight, walkLeft, idle2});
    }

    @Override
    public void draw(Canvas canvas) {
        animManager.draw(canvas, rectangle);
    }

    @Override
    public void update() {
        animManager.update();
    }

    public void update(Point point) {
        float oldLeft = rectangle.left;
        int state = 0;

        rectangle.set(point.x - 72, point.y - 51, point.x + 72, point.y + 51);

        if (rectangle.left - oldLeft > 5)
            state = 1;
        else if (rectangle.left - oldLeft < -5)
            state = 2;
        animManager.playAnim(state);
        animManager.update();
    }
}

