package hapapps.bigcow;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainCowActivity extends AppCompatActivity {

    hapapps.bigcow.Manager.GrassManager grassMng = new hapapps.bigcow.Manager.GrassManager(this);
    hapapps.bigcow.Manager.LoveManager loveMng = new hapapps.bigcow.Manager.LoveManager(this);
    hapapps.bigcow.Calf calf = new hapapps.bigcow.Calf(this);
    public static final String EXTRA_MESSAGE = "bigcow.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cow);


    }

    public void eatGrass(View v) {
        grassMng.changeValue(1);

        TextView counter = (TextView) findViewById(R.id.GrassCounter);
        counter.setText(Integer.toString(grassMng.getValue()));
        if (grassMng.getValue() >= grassMng.flirt) {
            if (!loveMng.isUnlocked) {

                loveMng.unlock(findViewById(R.id.Bull_Activity));
            }
        }

    }

    public void feelTheLove(View v) {
        if (grassMng.getValue() >= grassMng.flirt) {
            if (loveMng.isUnlocked) {
                if (!loveMng.haveCalf) {
                    loveMng.changeValue(1);
                    TextView counter = (TextView) findViewById(R.id.BullCounter);
                    counter.setText(Integer.toString(loveMng.getValue()));
                    grassMng.changeValue(-10);
                    TextView grscounter = (TextView) findViewById(R.id.GrassCounter);
                    grscounter.setText(Integer.toString(grassMng.getValue()));
                    if (loveMng.haveCalf) {
                        createCalf(this);
                    }
                }
            }
        }


    }

    public void createCalf(final Activity MainCowActivity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("You gave birth to a calf! What would you like to name it?");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String m_Text = input.getText().toString();
                Intent intent = new Intent(MainCowActivity, CalfActivity.class);
                intent.putExtra(EXTRA_MESSAGE, m_Text);
                startActivity(intent);
            }
        });
        builder.show();
    }

}
