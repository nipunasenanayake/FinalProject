package edu.gsu.httpscs.finalproject.Gesture;

import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import android.gesture.GestureStroke;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

import java.util.ArrayList;

import edu.gsu.httpscs.finalproject.R;

public class GestureActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {
    GestureOverlayView gestureOverlayView;
    private Bitmap bitmap;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);


        imageView = (ImageView) findViewById(R.id.imageView1);
        gestureOverlayView = (GestureOverlayView) findViewById(R.id.gestureOverlayView1);
//add listener to the gesture overlay view
        gestureOverlayView.addOnGesturePerformedListener(this);
//Create object of Display class to get width and height of device to create a bitmap image of screen size.
        Display display = getWindowManager().getDefaultDisplay();
        bitmap = Bitmap.createBitmap(display.getWidth(), display.getHeight(), Bitmap.Config.ARGB_8888);

    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {

//Create object of canvas and paint class for drawing.
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
// gesture.getStrokes() method will return an array list of Gesture Strokes.
        ArrayList<GestureStroke> gestureStrokes = gesture.getStrokes();
        for (GestureStroke ges : gestureStrokes) {
//canvas.drawLines method draws the lines on bitmap image by using given points and paint object.
            canvas.drawLines(ges.points, paint);
        }
//finally display the image using setImageBitmap method in image view as shown below.
        imageView.setImageBitmap(bitmap);
    }

}

