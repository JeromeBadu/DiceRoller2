package com.example.cs18jjb.diceroller3;

import java.util.ArrayList;
import java.util.Random;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void on_button_click(View view){

        TextView tv = (TextView) this.findViewById(R.id.numberTextview);
        TextView sv = (TextView) this.findViewById(R.id.scoretextView);
        TextView cv = (TextView) this.findViewById(R.id.wintextView);
        EditText et = (EditText) this.findViewById(R.id.numbereditText);

        int number_entered = Integer.parseInt(et.getText().toString());


        Random r = new Random();
        int number = r.nextInt(6)+1;

        if (number_entered == number)
        {
            cv.setText("You win!");
            score++;
        }

        else if (number_entered<0 || 6<number_entered)
        {
            cv.setText("please consider that this is a 6 sided die");
        }

        else
        {
            cv.setText("Try again");
        }
        et.setText(Integer.toString(number_entered));
        tv.setText(Integer.toString(number));
        sv.setText(Integer.toString(score));
    }

    public void on_button_click2(View view) {
        Random r2 = new Random();
        int number2 = r2.nextInt(6) + 1;
        TextView av = (TextView) this.findViewById(R.id.textView2);

        ArrayList<String> questions = new ArrayList<String>();
        questions.add("If you could go anywhere in the world, where would you go?");
        questions.add("If you were stranded on a desert island, what three things would you want to take with you?");
        questions.add("If you could eat only one food for the rest of your life, what would that be?");
        questions.add("If you won a million dollars, what is the first thing you would buy?");
        questions.add("If you could spend the day with one fictional character, who would it be?");
        questions.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        String qselect = questions.get(number2);
        av.setText(qselect);
    }
}
