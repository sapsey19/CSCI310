package sapsey19.github.com.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class ObstacleManager implements GameObject{
    //higher index == lower on screen == higher y value
    private ArrayList<Obstacle> obstacles;
    private int playerGap;
    private int obstacleGap;
    private int obstacleHeight;
    private int color;

    private long startTime;
    private long initTime;

    private int score = 0;

    public ObstacleManager(int playerGap, int obstacleGap, int obstacleHeight, int color) {
        this.playerGap = 0;
        this.obstacleGap = obstacleGap;
        this.obstacleHeight = obstacleHeight;
        this.color = color;

        startTime = initTime = System.currentTimeMillis();

        obstacles = new ArrayList<>();
        populateObstacles();
    }

    private void populateObstacles() {
        int currY = -5*Constants.SCREEN_HEIGHT/4;
        int counter =  0;
        while(counter < 4) {
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(new Obstacle(obstacleHeight, color, xStart, currY));
            currY += obstacleHeight + obstacleGap;
            counter++;
        }
    }

    public boolean playerCollide(RectPlayer player) {
        for(Obstacle drop : obstacles) {
            if(drop.playerCollide(player))
                return true;
        }
        return false;
    }


    @Override
    public void draw(Canvas canvas) {

        for(Obstacle drop : obstacles)
            drop.draw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.GRAY);
        canvas.drawText("Score: " + endTime, 50, 50 + paint.descent() - paint.ascent(), paint);

    }

    @Override
    public void update() {
        if(startTime < Constants.INIT_TIME)
            startTime = Constants.INIT_TIME;
         int elapsedTime = (int)(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        float speed = (float)(Math.sqrt(1 + (startTime - initTime)/200.0))*Constants.SCREEN_HEIGHT/10000.0f;
        for(Obstacle drop : obstacles)
            drop.incrementY(speed * elapsedTime);
        if(obstacles.get(obstacles.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(0, new Obstacle(obstacleHeight, color, xStart, obstacles.get(0).getRectangle().top - obstacleHeight - obstacleGap));
            obstacles.remove(obstacles.size() -1);
            score++;
        }
    }
}
