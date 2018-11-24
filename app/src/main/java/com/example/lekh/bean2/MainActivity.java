package com.example.lekh.bean2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    Button btnEmail;
    Button btnLink;
    Button btnFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmail = (Button) findViewById(R.id.buttonConnectEmail);
        btnLink = (Button) findViewById(R.id.buttonConnectLinkedIn);
        btnFace = (Button) findViewById(R.id.buttonConnectFacebook);
    }

    @Override
    public void onClick (View view){
        switch (view.getId()) {
            case R.id.buttonConnectEmail:
                Intent intent = new Intent(MainActivity.this, ActivitySignIn.class);
                startActivity(intent);
                break;

            case R.id.buttonConnectLinkedIn:
                Intent intent2 = new Intent(MainActivity.this, ActivitySignIn.class);
                startActivity(intent2);
                break;

            case R.id.buttonConnectFacebook:
                Intent intent3 = new Intent(MainActivity.this, ActivityNavigator.class);
                startActivity(intent3);
                break;

            default:
                break;

        }
    }
}