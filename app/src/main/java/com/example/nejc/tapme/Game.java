package com.example.nejc.tapme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.DialogPreference;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class Game extends Activity {
    final Context context = this;
    private TextView resultView;
    private TextView resultView_2;
    private TextView resultView_3; //game over
    private TextView resultView_4; // score
    private TextView resultView_5; // clicks
   // private TextView resultView_6;
    //private TextView resultView_7;
    public boolean condition;
    public boolean condition_2;
    public int result;
    public int tmp;
    private Button myButton;
    //public static boolean a;
   // public static class nejc {
      //  public static boolean a;
  //  }
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Button insert=(Button) findViewById(R.id.button2);
        btn = (Button) findViewById(R.id.button2);
        resultView_2 = (TextView) findViewById(R.id.textView);
         new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                condition_2 = false;
                condition = true;
                resultView_2.setText("Time remaining: " + millisUntilFinished / 1000);
                //nejc.a = true;
            }

            public void onFinish() {
                condition_2 = true;
                condition = false;
                resultView_2.setText("Game Over!");
               // nejc.a = false;
               // condition = Integer.parseInt(String.valueOf(resultView_2.getText()));
               /* new AlertDialog.Builder(context)
                        .setTitle("Game Over")
                        .setMessage("Your score is: " + String.valueOf(resultView.getText()) + "! " + "Start over?" )
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getBaseContext(), Game.class);
                                startActivity(intent);
                                // execute
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getBaseContext(), Main.class);
                                startActivity(intent);
                                // do nothing
                            }
                        })
                        //.setIcon(android.R.drawable.ic_dialog_alert)
                        .show();*/
            }
        }.start();



            insert.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    //myButton = (Button) findViewById(R.id.button2);
                    resultView = (TextView) findViewById(R.id.textView1);
                    //Random random_1 = new Random();
                    //int button_x = random_1.nextInt(400 - 10) + 10;
                    //myButton.setWidth(button_x);
                    // myButton.setHeight(button_x);

                    if (condition) {
                        int counter = Integer.parseInt(String.valueOf(resultView.getText()));
                        counter += 1;
                        result = counter;
                        String string = String.valueOf(Integer.valueOf(counter));
                        resultView.setText(string);
                        Random random = new Random();
                        int x = random.nextInt(350 - 150) + 150;
                        int y = random.nextInt(650 - 150) + 150;
                        btn.setX(x);
                        btn.setY(y);
                    } else {
                        resultView_2 = (TextView) findViewById(R.id.textView); // time
                        resultView = (TextView) findViewById(R.id.textView1); // 0
                        resultView_3 = (TextView) findViewById(R.id.textView3); //game over
                        resultView_4 = (TextView) findViewById(R.id.textView4); // score
                        resultView_5 = (TextView) findViewById(R.id.textView2); // clicks
                        resultView_2.setText("");
                        resultView.setText("");
                        resultView_3.setText("Game Over!");
                        resultView_4.setText("Score: " + result);
                        resultView_5.setText("");
                    }
                }

            });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
