package co.mobita.android.nestedviewgroupsapplication;

import java.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import co.mobita.android.nestedviewgroupsapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Get the order amount
    protected int getAmount(){
        TextView quantity = (TextView)findViewById(R.id.quantity_text_view);
        int amount = Integer.parseInt(quantity.getText().toString());
        return amount;
    }

    /*
        This functions returns the given name
     */
    protected String getName(){
        EditText name = (EditText) findViewById(R.id.name_edit_text);
        return name.getText().toString();
    }

    /*
        This function returns the coffee is with chocolate or not
     */
    protected String withChocolate(){
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_check_box);
        if(chocolate.isChecked())
            return "true";
        return "false";
    }

    /*
        This function returns the coffee is with whipped cream or not
     */
    protected String withCream(){
        CheckBox cream = (CheckBox) findViewById(R.id.cream_check_box);
        if(cream.isChecked())
            return "true";
        return "false";
    }

    // increase the amount
    public void increase(View view){
        changeAmount(1);
    }

    // decrease the amount
    public void decrease(View view){
        if(getAmount()>0)
            changeAmount(-1);
    }

    // Change the amount
    protected void changeAmount(int number){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        int newAmount = getAmount();
        newAmount += number;
        quantityTextView.setText("" + newAmount);
    }

    // This function runs When the button pressed
    public void submitOrder(View view){
        int numberOfCoffees = getAmount();
        orderSummary(numberOfCoffees);
    }

    /*
        This function summarize the order
        @param number: amount of ordered coffee
     */
    private void orderSummary(int number){
        String messageForName = "Name: " + getName() + "\n";
        String whippedCream = "Add whipped cream? " + withCream() + "\n";
        String chocolate = "Add chocolate? " + withChocolate() + "\n";
        String quantity = "Quantity: " + number + "\n";
        String prize = "Total: " + NumberFormat.getCurrencyInstance().format((double) calculatePrize(number)) + "\n";
        String thanksMessage = "Thank you!";
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(messageForName + whippedCream + chocolate + quantity + prize + thanksMessage);
    }

    private int calculatePrize(int quantity){
        int aCupPrize = 5;

        if (Boolean.parseBoolean(withChocolate()))
            aCupPrize += 2;

        if (Boolean.parseBoolean(withCream()))
            aCupPrize += 1;

        return quantity * aCupPrize;
    }
}
