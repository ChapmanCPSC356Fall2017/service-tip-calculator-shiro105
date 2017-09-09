package cpsc356.servicetipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class TipScreen extends AppCompatActivity {

    private TextView resultPrice_View;      // We save the Widgets as class variables
    private TextView tipDisplay_View;
    private EditText inputPrice_Text;
    private SeekBar tipScale_Bar;

    private double priceNoTipValue = 0;     // The total price without the tip added on
    private double priceWithTipValue = 0;   // The total price WITH tip
    private double tipRatio = 0;            // How much tip did the player select?
    private int tipMinValue = 1;            // The min value the tip can be

    // Handles the logic when the user interacts with the widgets on the screen.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_screen);

        // We save the widgets as Objects here for futire use
        resultPrice_View = (TextView) findViewById(R.id.result_price_editText);
        inputPrice_Text = (EditText) findViewById(R.id.total_price_editText);
        tipScale_Bar = (SeekBar) findViewById(R.id.tip_scale_SeekBar);
        tipDisplay_View = (TextView) findViewById(R.id.tip_display_textView);

        // We then wait to check to see if the user entered text into the EditText.
        inputPrice_Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            // After the player is done typing, the text will be parsed and then allow for the user to interact with other widgets
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // We check to see if the input is not empty. If so, we save the value and open up more widgets for the user to use
                if (!s.toString().isEmpty()) {
                    priceNoTipValue = Double.valueOf(s.toString());
                    tipDisplay_View.setVisibility(View.VISIBLE);
                    tipScale_Bar.setVisibility(View.VISIBLE);

                    // If the total price is already displayed, by updating the price, we can update the total as well.
                    if(resultPrice_View.getVisibility() == View.VISIBLE)
                    {
                        calculateFinalPrice();
                        displayFinalPrice();
                    }
                }
                else {
                    // We set all of the values back to zero
                    priceNoTipValue = 0;
                    priceWithTipValue = 0;

                    // And hide all of the widgets back while resetting them to their original values
                    resultPrice_View.setVisibility(View.GONE);
                    tipDisplay_View.setVisibility(View.GONE);
                    tipScale_Bar.setVisibility(View.GONE);
                    tipScale_Bar.setProgress(0);
                    tipDisplay_View.setText(getString(R.string.tip_display));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // We also check to see if the tip scale has chanced, doing logic depending on what was triggered
        tipScale_Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // We update the tipDiplay_View to reflect the current amount that we are topping
                /*
                    0-3 is 10% tip
                    4-5 is 13% tip
                    6-7 is 15% tip
                    8-9 is 20% tip
                    10 is 25% tip
                 */
                int tipValue = tipMinValue + progress;
                String rating = "";
                switch (tipValue) {
                    case 1:
                    case 2:
                    case 3:
                        tipRatio = 0.1;
                        rating = getString(R.string.bad_rate);
                        break;
                    case 4:
                    case 5:
                        tipRatio = 0.13;
                        rating = getString(R.string.ok_rate);
                        break;
                    case 6:
                    case 7:
                        tipRatio = 0.15;
                        rating = getString(R.string.normal_rate);
                        break;
                    case 8:
                    case 9:
                        tipRatio = 0.2;
                        rating = getString(R.string.good_rate);
                        break;
                    case 10:
                        tipRatio = 0.25;
                        rating = getString(R.string.great_rate);
                        break;
                }
                //int percentToDisplay = (int)(tipRatio * 100);
                //tipDisplay_View.setText(String.format(Locale.ENGLISH, "%1$s (%2$d%%)", rating, percentToDisplay));
                tipDisplay_View.setText(rating);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            // If the input text is not empty, we calculate the final price and display it
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(!inputPrice_Text.getText().toString().isEmpty()) {
                    calculateFinalPrice();
                    displayFinalPrice();
                }
            }
        });
    }

    // Calculates the total price from the tip and the total price
    private void calculateFinalPrice()
    {
        double tipAdd = priceNoTipValue * tipRatio;
        priceWithTipValue = priceNoTipValue + tipAdd;
    }

    // Displays the final price to the screen
    private void displayFinalPrice()
    {
        if(resultPrice_View.getVisibility() == View.VISIBLE) {
            resultPrice_View.setVisibility(View.INVISIBLE);
        }
        resultPrice_View.setVisibility(View.VISIBLE);
        resultPrice_View.setText(String.format(Locale.ENGLISH, "$%4.2f", priceWithTipValue));
    }
}
