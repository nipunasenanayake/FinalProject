package edu.gsu.httpscs.finalproject;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PasswordManagerLoginActivity extends BaseActivity implements View.OnTouchListener{

    @BindView(R.id.password_manager_login_img)
    ImageView imageView;

    @BindView(R.id.password_manager_login_et)
    EditText editText;

    @BindView(R.id.password_manager_login_layout)
    LinearLayout layout;



    GestureDetector mGestureDetector;
    private int sumX =0;
    private int sumY =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_manager_login);
        ButterKnife.bind(this);
        rotation();

        mGestureDetector = new GestureDetector(this,new PasswordManagerLoginActivity.simpleGestureListener());//
        layout.setOnTouchListener(this);
        layout.setFocusable(true);
        layout.setClickable(true);
        layout.setLongClickable(true);



    }


    private void rotation(){
        ObjectAnimator animator= ObjectAnimator.ofFloat(imageView,"rotationY",0,360,0);
        animator.setDuration(4000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(2);
        animator.start();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

            sumX+=distanceX;
            sumY+=distanceY;
            //shortToast("on scroll");


            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (sumX<0){
                if(Math.abs(sumX)>200){



                    if (editText.getText().toString().equals("12345")){
                        shortToast("Login Success");
                        Intent intent =new Intent("edu.gsu.httpscs.finalproject.PasswordmanagerContentActivity");
                        startActivity(intent);
                    }else{
                        shortToast("Incorrect Pin");
                    }



                }
            }

            if (sumX>0){
                if(Math.abs(sumX)>200){

                   // shortToast("right to left");


                }
            }

            if (sumY<0){
                if(Math.abs(sumY)>200){
                    //shortToast("You scroll from top to bottom");
                }
            }

            if (sumY>0){
                if(Math.abs(sumY)>200){
                    //shortToast("You scroll from bottom to top");
                }
            }



            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {

            super.onShowPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {

            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {

            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {

            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {

            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {

            return super.onSingleTapUp(e);
        }

    }

    }
