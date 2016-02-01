package space.firstorder.hc;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;

public class FirstOrderInputProcessor extends CameraInputController {
    final Runnable changeColorsAction;

    public FirstOrderInputProcessor(Camera c, Runnable changeColors) {
        super(c);
        changeColorsAction = changeColors;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        Gdx.app.log("ECE150", "Button touchdown: " + screenX + ", " + screenY);
        if (screenX < 200 && screenY < 200 && screenX >= 50 && screenY >= 50) { /* add the condition for finding whether we are clicking the lower-left logo position */
            if (changeColorsAction != null) {
                // call the changeColorsAction runnable interface, implemented in Main
                changeColorsAction.run();
                return true;
            }
        }

        // otherwise, just do camera input controls
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
