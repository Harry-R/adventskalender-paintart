package de.harry_r.adventskalender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.harry_r.adventskalender.Utils.Utils;

public class MainActivity extends AppCompatActivity {

    private int[] images = {
            R.drawable.zimtstern,
            R.drawable.kerze,
            R.drawable.kugel,
            R.drawable.stern,
            R.drawable.stiefel,
            R.drawable.stern_blau,
            R.drawable.unicorn,
            R.drawable.schlitten,
            R.drawable.weihnachtsmann
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_main);
    }

    private void doDoorAction(int number, Button door) {
        switch (Utils.checkDate(number)) {
            case 0:
                Utils.showCommentTooEarly(this);
                break;
            case 1:
                openDoor(number, door);
                break;
            case 2:
                Utils.showCommentTooLate(this);
                openDoor(number, door);
                break;

        }
    }

    private void openDoor(int number, Button door) {
        door.setText("");
        door.setBackgroundResource(images[number-1]);
        door.setEnabled(false);
    }


    public void clickDoor(View view) {
        Button door = (Button) view;
        int number = Integer.parseInt(door.getText().toString());
        doDoorAction(number, door);
    }

}
