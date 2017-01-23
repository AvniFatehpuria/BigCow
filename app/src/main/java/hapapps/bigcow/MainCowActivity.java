package hapapps.bigcow;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.os.Bundle;
import hapapps.bigcow.Manager;

public class MainCowActivity extends AppCompatActivity {
    //int grassEaten = 0;
    hapapps.bigcow.Manager.GrassManager grassMng = new hapapps.bigcow.Manager.GrassManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cow);


    }

    public void eatGrass(View v) {
        grassMng.changeValue(1);

        TextView counter = (TextView) findViewById(R.id.GrassCounter);
        counter.setText(Integer.toString(grassMng.getValue()));
    }


}
