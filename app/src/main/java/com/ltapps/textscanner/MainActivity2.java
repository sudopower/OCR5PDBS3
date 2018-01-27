package com.ltapps.textscanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.view.View;
import java.io.FileInputStream;


public class MainActivity2 extends AppCompatActivity {
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView1 = (TextView)findViewById(R.id.textView1);

    }
    public void  load(View view)
    {
        try {
            FileInputStream fileInputStream =  openFileInput("Code.txt");
            int read =-1;
            int i=0;
            StringBuffer buffer = new StringBuffer();
            while((read = fileInputStream.read()) != -1) {

                buffer.append((char)read);
            }
            Log.d("Code", buffer.toString());
            String name = buffer.substring(0,buffer.indexOf(" "));
            textView1.setText(name);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void  back( View view)
    {

        Intent intent= new Intent(this, Recognizer.class);
        startActivity(intent);
    }
}
