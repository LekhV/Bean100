package com.example.lekh.bean2.Activitys;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lekh.bean2.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ConnectionPlus extends AppCompatActivity {
    private Button buttonBarCodeScan;
    private Button buttonEnterCode;
    private Button buttonEnterCode2;
    private EditText editEnterCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_plus);

        buttonEnterCode = (Button) findViewById(R.id.buttonEnterCode);
        buttonEnterCode2 = (Button) findViewById(R.id.buttonEnterCode2);
        editEnterCode = (EditText) findViewById(R.id.editTextEnterCode);

        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        setTitle("Connections");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setSupportActionBar(toolbar1);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonEnterCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonEnterCode.setVisibility(View.INVISIBLE);
                buttonEnterCode2.setVisibility(View.VISIBLE);

                editEnterCode.setVisibility(View.VISIBLE);
            }
        });

        buttonEnterCode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonEnterCode.setVisibility(View.VISIBLE);
                buttonEnterCode2.setVisibility(View.INVISIBLE);

                editEnterCode.setVisibility(View.INVISIBLE);
            }
        });

        buttonBarCodeScan = findViewById(R.id.buttonScanCode);
        buttonBarCodeScan.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        //initiate scan with our custom scan activity
        new IntentIntegrator(ConnectionPlus.this).setCaptureActivity(ActivityScanQRCode.class).initiateScan();
    }
    });


}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //We will get scan results here
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //check for null
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Scan Cancelled", Toast.LENGTH_LONG).show();
            } else {
                //show dialogue with result
                showResultDialogue(result.getContents());
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    //method to construct dialogue with scan results
    public void showResultDialogue(final String result) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Scan Result")
                .setMessage("Scanned result is " + result)
                .setPositiveButton("Copy result", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Scan Result", result);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(ConnectionPlus.this, "Result copied to clipboard", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        dialog.dismiss();
                    }
                })
                .show();
    }

}


