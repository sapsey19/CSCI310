package sapsey19.github.com.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.MotionEvent;

public class GamePlayScene implements Scene {
    private Rect r = new Rect();

    private Player player;
    private Point point;
    private ObstacleManager obstacleManager;

    public boolean movingPlayer = false;

    private boolean gameOver = false;
    private long gameOverTime;

    private Floor floor;


    public GamePlayScene() {
        player = new Player(new Rect(100, 100, 200, 200));
        floor = new Floor();
        point = new Point(Constants.SCREEN_WIDTH / 2, (6 * Constants.SCREEN_HEIGHT / 7)+30);
        player.update(point);
        obstacleManager = new ObstacleManager( 100, 75);
    }

    public void reset() {
        point = new Point(Constants.SCREEN_WIDTH / 2, (6 * Constants.SCREEN_HEIGHT / 7)+30);
        player.update(point);
        obstacleManager = new ObstacleManager(350, 75);
        movingPlayer = false;
    }


    @Override
    public void update() {
        if (!gameOver) {
            player.update(point);
            obstacleManager.update();
            if (obstacleManager.playerCollide(player)) {
                gameOver = true;
                gameOverTime = System.currentTimeMillis();
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        Drawable d = Constants.CURRENT_CONTEXT.getDrawable(R.drawable.background);
        d.setBounds(0, 0, 1080, 1920);
        d.draw(canvas);
        player.draw(canvas);
        floor.draw(canvas);
        obstacleManager.draw(canvas);

        if (gameOver) {
            Paint paint = new Paint();
            Paint paint2 = new Paint();
            paint.setTextSize(100);
            paint2.setTextSize(75);
            paint.setColor(Color.rgb(116, 0, 37));
            paint2.setColor(Color.rgb(233, 224, 219));
            canvas.drawColor(Color.BLACK);
            drawCenterText(canvas, paint, "Game Over");
            drawCenterText2(canvas, paint2, "Score: " + obstacleManager.score);
        }
    }

    private void drawCenterText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(r);
        int cHeight = r.height();
        int cWidth = r.width();
        paint.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        canvas.drawText(text, x, y, paint);
    }

    private void drawCenterText2(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(r);
        int cHeight = r.height();
        int cWidth = r.width();
        paint.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        canvas.drawText(text, x, y+80, paint);
    }

    @Override
    public void terminate() {
        SceneManager.ACTIVE_SCENE = 0;
    }

    @Override
    public void receiveTouch(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!gameOver && player.getRectangle().contains((int) event.getX(),(int)event.getY())) {
                    movingPlayer = true;
                    player.moving = true;
                }
                if (gameOver && System.currentTimeMillis() - gameOverTime >= 2000) {
                    reset();
                    gameOver = false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (movingPlayer && !gameOver)
                    point.set((int) event.getX(), (6 * Constants.SCREEN_HEIGHT / 7)+30);
                break;
            case MotionEvent.ACTION_UP:
                movingPlayer = false;
                player.moving = false;
                break;
        }
    }
}