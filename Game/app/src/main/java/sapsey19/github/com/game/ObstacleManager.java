package sapsey19.github.com.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.lang.reflect.Array;
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

    private int score = 0;

    private Queue<Obstacle> addedOb;
    private int counter = 0;


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
        int currY = -5 * Constants.SCREEN_HEIGHT / 4;
        int counter = 0;
        while (counter < 1) {
            int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH));
            //obstacles.add(new Obstacle(obstacleHeight, color, xStart, currY));
            addObject();
            currY += obstacleHeight + obstacleGap;
            counter++;
        }
    }

    public boolean playerCollide(RectPlayer player) {
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
        paint.setColor(Color.GRAY);
        canvas.drawText("Score: " + score, 50, 50 + paint.descent() - paint.ascent(), paint);

    }

    public void addObject() {
        int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH));
        Obstacle ob = new Obstacle(obstacleHeight, xStart, 0);
        obstacles.add(ob);
        addedOb.add(ob);
        //counter++;
    }

    private boolean spawnZone1() {
        return (obstacles.get(obstacles.size() - 1).getRectangle().top == 600);
    }

    private boolean spawnZone2() {
        return (obstacles.get(obstacles.size() - 1).getRectangle().top == 200);
    }


    @Override
    public void update() {
        int speed = 20;
        if (startTime < Constants.INIT_TIME)
            startTime = Constants.INIT_TIME;
        startTime = System.currentTimeMillis();
        for (Obstacle drop : obstacles) {
            drop.incrementY(speed);
        }
        if (addedOb.peek().getRectangle().top >= Constants.SCREEN_HEIGHT) {
            addedOb.remove();
            score++;
        }
        if (spawnZone1())
            addObject();
        if (spawnZone2() && score > 10)
            addObject();
    }

}


//
// || obstacles.get(obstacles.size() - 1).getRectangle().top == 601 || obstacles.get(obstacles.size() - 1).getRectangle().top == 602 || obstacles.get(obstacles.size() - 1).getRectangle().top == 603
//         || obstacles.get(obstacles.size() - 1).getRectangle().top == 604 || obstacles.get(obstacles.size() - 1).getRectangle().top == 605 || obstacles.get(obstacles.size() - 1).getRectangle().top == 606 || obstacles.get(obstacles.size() - 1).getRectangle().top == 607
//         || obstacles.get(obstacles.size() - 1).getRectangle().top == 607 || obstacles.get(obstacles.size() - 1).getRectangle().top == 608


//    if (obstacles.get(obstacles.size() - 1).getRectangle().top == 600) {
//            int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH));
//            obstacles.add(0, new Obstacle(obstacleHeight, color, xStart, obstacles.get(0).getRectangle().top - obstacleHeight - obstacleGap));
//            System.out.println("Screen Height: " + Constants.SCREEN_HEIGHT/3);
//            System.out.println("Object Position: " + obstacles.get(obstacles.size() - 1).getRectangle().top);
//            if(obstacles.get(obstacles.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT)
//            obstacles.remove(obstacles.size()-1);


//    @Override
//    public void update() {
//        if(startTime < Constants.INIT_TIME)
//            startTime = Constants.INIT_TIME;
//        int elapsedTime = (int)(System.currentTimeMillis() - startTime);
//        startTime = System.currentTimeMillis();
//        float speed = (float)(Math.sqrt(1 + (startTime - initTime)/200.0))*Constants.SCREEN_HEIGHT/10000.0f;
//        for(Obstacle drop : obstacles)
//            drop.incrementY(speed * elapsedTime);
//        if(obstacles.get(obstacles.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {
//            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
//            obstacles.add(0, new Obstacle(obstacleHeight, color, xStart, obstacles.get(0).getRectangle().top - obstacleHeight - obstacleGap));
//            obstacles.remove(obstacles.size() -1);
//            score++;
//        }
//    }
