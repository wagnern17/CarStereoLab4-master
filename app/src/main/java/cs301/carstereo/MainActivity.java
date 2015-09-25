package cs301.carstereo;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private ToggleButton powerButton;
    private Button presetBut1;
    private Button presetBut2;
    private Button presetBut3;
    private Button presetBut4;
    private Button volButUp;
    private Button volButDown;
    private Button seekUp;
    private Button seekDown;
    private TextView radioTxt;
    private TextView volPosTxt;
    private TextView volNegTxt;
    private Switch amFmSwitch;
    private boolean isFM;
    private int AM;
    private int FM;
    private double dFM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        powerButton = (ToggleButton) findViewById(R.id.powerButton);
        presetBut1 = (Button) findViewById(R.id.preset1);
        presetBut2 = (Button) findViewById(R.id.preset2);
        presetBut3 = (Button) findViewById(R.id.preset3);
        presetBut4 = (Button) findViewById(R.id.preset4);
        volButUp = (Button) findViewById(R.id.volUpButton);
        volButDown = (Button) findViewById(R.id.volDownButton);
        radioTxt = (TextView) findViewById(R.id.radioText);
        volPosTxt = (TextView) findViewById(R.id.volPos);
        volNegTxt = (TextView) findViewById(R.id.volNeg);
        seekUp = (Button) findViewById(R.id.seekUp);
        seekDown = (Button) findViewById(R.id.seekDown);
        amFmSwitch = (Switch) findViewById(R.id.amFmSwitch);

        powerButton.setOnClickListener(this);
        amFmSwitch.setOnClickListener(this);
        seekUp.setOnClickListener(this);
        seekDown.setOnClickListener(this);
        AM = 530;
        FM = 881;
        dFM = 88.1;
        radioTxt.setText(Integer.toString(AM) + "kHz");




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

    @Override
    public void onClick(View v) {
        if(v==powerButton) {
            if(powerButton.isChecked()){
                presetBut1.setBackgroundColor(Color.WHITE);
                presetBut2.setBackgroundColor(Color.WHITE);
                presetBut3.setBackgroundColor(Color.WHITE);
                presetBut4.setBackgroundColor(Color.WHITE);
                volButUp.setBackgroundColor(Color.WHITE);
                volButDown.setBackgroundColor(Color.WHITE);
                radioTxt.setBackgroundColor(Color.WHITE);
                volPosTxt.setBackgroundColor(Color.WHITE);
                volNegTxt.setBackgroundColor(Color.WHITE);
                seekDown.setBackgroundColor(Color.WHITE);
                seekUp.setBackgroundColor(Color.WHITE);
            }
            else {
                presetBut1.setBackgroundColor(Color.BLACK);
                presetBut2.setBackgroundColor(Color.BLACK);
                presetBut3.setBackgroundColor(Color.BLACK);
                presetBut4.setBackgroundColor(Color.BLACK);
                volButUp.setBackgroundColor(Color.BLACK);
                volButDown.setBackgroundColor(Color.BLACK);
                radioTxt.setBackgroundColor(Color.BLACK);
                volPosTxt.setBackgroundColor(Color.BLACK);
                volNegTxt.setBackgroundColor(Color.BLACK);
                seekDown.setBackgroundColor(Color.BLACK);
                seekUp.setBackgroundColor(Color.BLACK);
            }
        }
        if (v==amFmSwitch) {
            if (amFmSwitch.isChecked()) {
                isFM = true;
                radioTxt.setText(Double.toString(dFM) + "MHz");
            } else {
                isFM = false;
                radioTxt.setText(Integer.toString(AM) + "kHz");
            }
        }

        if (v==seekUp) {
            if (isFM) {
                if (FM == 1079) {
                    FM = 881;
                } else {
                    FM = FM + 2;
                }
                dFM = ((double) FM) / 10.0;
                radioTxt.setText(Double.toString(dFM) + "MHz");
            }
            else {
                if (AM == 1700) {
                    AM = 530;
                } else {
                    AM = AM + 10;
                }
                radioTxt.setText(Integer.toString(AM) + "kHz");
            }
        }
        if (v==seekDown){
            if (isFM) {
                if (FM == 881) {
                    FM = 1079;
                } else {
                    FM = FM - 2;
                }
                dFM = ((double) FM) / 10.0;
                radioTxt.setText(Double.toString(dFM) + "MHz");
            }
            else {
                if (AM == 530) {
                    AM = 1700;
                } else {
                    AM = AM - 10;
                }
                radioTxt.setText(Integer.toString(AM) + "kHz");
            }
        }
    }
}