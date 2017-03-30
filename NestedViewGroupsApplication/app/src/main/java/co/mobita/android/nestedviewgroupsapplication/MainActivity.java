package co.mobita.android.nestedviewgroupsapplication;

import java.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        displayChange(numberOfCoffees);
    }

    // This function changes the quantity
    private void displayChange(int number){
        int price = number * 5;
        String thanksMessage = "Thank you!";
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format((double) price) + "\n" + thanksMessage);
    }
}
