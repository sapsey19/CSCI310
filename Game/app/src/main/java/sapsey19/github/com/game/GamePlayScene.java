package sapsey19.github.com.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;

public class GamePlayScene implements Scene {
    private Rect r = new Rect();

    private RectPlayer player;
    private Point point;
    private ObstacleManager obstacleManager;

    private boolean movingPlayer = false;

    private boolean gameOver = false;
    private long gameOverTime;

    private Floor floor;


    public GamePlayScene() {
        player = new RectPlayer(new Rect(100, 100, 200, 200), Color.rgb(0, 0, 255));
        point = new Point(Constants.SCREEN_WIDTH / 2, 7 * Constants.SCREEN_HEIGHT / 8);
        player.update(point);
        obstacleManager = new ObstacleManager( 100, 75);
        floor = new Floor();
    }

    public void reset() {
        point = new Point(Constants.SCREEN_WIDTH / 2, 7 * Constants.SCREEN_HEIGHT / 8);
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
        canvas.drawColor(Color.WHITE);
        player.draw(canvas);
        obstacleManager.draw(canvas);

        if (gameOver) {
            Paint paint = new Paint();
            paint.setTextSize(100);
            paint.setColor(Color.RED);
            drawCenterText(canvas, paint, "Game Over");
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

    @Override
    public void terminate() {
        SceneManager.ACTIVE_SCENE = 0;
    }

    @Override
    public void receiveTouch(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!gameOver && player.getRectangle().contains((int) event.getX(),(int)event.getY()))
                    movingPlayer = true;
                if (gameOver && System.currentTimeMillis() - gameOverTime >= 2000) {
                    reset();
                    gameOver = false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (movingPlayer && !gameOver)
                    point.set((int) event.getX(), 7 * Constants.SCREEN_HEIGHT/8);
                break;
            case MotionEvent.ACTION_UP:
                movingPlayer = false;
                break;
        }
    }
}