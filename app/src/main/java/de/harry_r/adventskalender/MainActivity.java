package de.harry_r.adventskalender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import de.harry_r.adventskalender.Utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_main);
    }

    private void doDoorAction(int number) {
        switch (Utils.checkDate(number)) {
            case 0:
                Utils.showCommentTooLate(this);
                break;
            case 1:
                // show image
                break;
            case 2:
                Utils.showCommentTooEarly(this);
                break;

        }
    }


    public void open_door(View view) {
        Button door = (Button) view;
        int number = Integer.parseInt(door.getText().toString());
        doDoorAction(number);
    }

}
