package edu.gsu.httpscs.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PasswordmanagerContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordmanager_content);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MVCSplash.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("myKey", "skip");
        startActivity(intent);
    }
}
