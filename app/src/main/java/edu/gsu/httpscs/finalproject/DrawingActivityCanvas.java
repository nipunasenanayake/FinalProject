package edu.gsu.httpscs.finalproject;

import java.io.ByteArrayOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DrawingActivityCanvas extends Activity {

    private Button button_save;
    private GestureOverlayView gesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.drawing_activity_canvas);

        gesture = (GestureOverlayView) findViewById(R.id.gestures);
        button_save = (Button) findViewById(R.id.save_button);

        button_save.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {


                    Bitmap gestureImg = gesture.getGesture().toBitmap(100, 100,
                            8, Color.BLACK);

                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    gestureImg.compress(Bitmap.CompressFormat.PNG, 100, bos);
                    byte[] bArray = bos.toByteArray();

                    Intent intent = new Intent(DrawingActivityCanvas.this, DrawingActivityImage.class);

                    intent.putExtra("draw", bArray);
                    startActivity(intent);



                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(DrawingActivityCanvas.this, "No draw on the string",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

