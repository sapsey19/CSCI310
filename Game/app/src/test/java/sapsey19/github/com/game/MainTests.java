package sapsey19.github.com.game;

import android.graphics.Rect;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTests {

    @Test
    public void obstacleTest() {
        //Tests that addObject correctly adds an object to the obstacle arrayList
        ObstacleManager manager = new ObstacleManager(100, 100);
        assertEquals(manager.obstacles.size(), 1);
        manager.addObject();
        assertEquals(manager.obstacles.size(), 2);
        manager.addObject();
        assertEquals(manager.obstacles.size(), 3);

        //Tests that the obstacle is incrementing correctly
        assertEquals(manager.addedOb.peek().getRectangle().top, 30);
        manager.addedOb.peek().incrementY(50);
        assertEquals(manager.addedOb.peek().getRectangle().top, 80);
    }
}
