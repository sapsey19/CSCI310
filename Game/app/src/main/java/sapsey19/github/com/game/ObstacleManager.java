package sapsey19.github.com.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class ObstacleManager implements GameObject {
    //higher index == lower on screen == higher y value
    private ArrayList<Obstacle> obstacles;
    private int obstacleGap;
    private int obstacleHeight;

    private long startTime;
    private long initTime;

    protected int score = 0;

    private Queue<Obstacle> addedOb;

    public ObstacleManager(int obstacleGap, int obstacleHeight) {
        this.obstacleGap = obstacleGap;
        this.obstacleHeight = obstacleHeight;
        startTime = initTime = System.currentTimeMillis();
        obstacles = new ArrayList<>();
        addedOb = new LinkedList<>();
        populateObstacles();
        update();
    }

    private void populateObstacles() {
        int counter = 0;
        while (counter < 1) {
            addObject();
            counter++;
        }
    }

    public boolean playerCollide(Player player) {
        for (Obstacle drop : obstacles) {
            if (drop.playerCollide(player))
                return true;
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        for (Obstacle ob : obstacles)
            ob.draw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.BLACK);
        canvas.drawText("Score: " + score, 75, 75 + paint.descent() - paint.ascent(), paint);
    }

    public void addObject() {
        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH));
        Obstacle ob = new Obstacle(xStart);
        obstacles.add(ob);
        addedOb.add(ob);
    }

    private boolean spawnZone1() {
        return (obstacles.get(obstacles.size() - 1).getRectangle().top == 600);
    }

    private boolean spawnZone2() {
        return (obstacles.get(obstacles.size() - 1).getRectangle().top == 210);
    }

    @Override
    public void update() {
        int speed = 30;
        if (startTime < Constants.INIT_TIME)
            startTime = Constants.INIT_TIME;
        startTime = System.currentTimeMillis();
        for (Obstacle drop : obstacles) {
            drop.incrementY(speed);
        }
        if (addedOb.peek().getRectangle().bottom >= 7*(Constants.SCREEN_HEIGHT/8)+50) {
            addedOb.peek().incrementY(1000);
            addedOb.remove();
            score++;
        }
        if (spawnZone1())
            addObject();
        if (spawnZone2() && score > 9)
            addObject();
    }
}