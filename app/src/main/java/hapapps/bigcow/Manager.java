package hapapps.bigcow;
import android.graphics.Color;
import android.widget.RelativeLayout;
/**
 * Created by afatehp1 on 1/22/17.
 */

public class Manager {
    protected int value;
    android.app.Activity activity;
    public Manager() {};
    public Manager(android.app.Activity receivedActivity){
        value = 0;
        activity = receivedActivity;
    }

    public void changeValue(int change){
        value = value + change;
        checkParameters();
    }
    public int getValue(){
        return value;
    }

    public void checkParameters() {
    }

    /**
     * Created by afatehp1 on 1/22/17.
     */

    public static class GrassManager extends Manager {
        int flirt = 10;
        public GrassManager(android.app.Activity receivedActivity){
            value = 0;
            activity = receivedActivity;
        }
        public void checkParameters() {
            int grass = getValue();
            if (grass < flirt) {
                RelativeLayout bull = (RelativeLayout) activity.findViewById(R.id.Bull_Activity);

                bull.setBackgroundColor(0x00000000);
            }

            else {
                RelativeLayout bull = (RelativeLayout) activity.findViewById(R.id.Bull_Activity);

                bull.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }

        }

    }

    public static class LoveManager extends Manager {
        int calf = 10;
        boolean haveCalf = false;

        public LoveManager(android.app.Activity receivedActivity) {
            value = 0;
            activity = receivedActivity;
        }

        public void checkParameters() {
            int love = getValue();
            if (calf < love) {
                value = value - 10;
                haveCalf = true;
            }
        }

        public void changeValue(int change) {
            if (!haveCalf) {
                value = value + change;
                checkParameters();
            }
        }
    }
}
