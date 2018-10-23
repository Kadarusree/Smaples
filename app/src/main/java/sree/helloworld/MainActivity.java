package sree.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.paytabs.paytabs_sdk.payment.ui.activities.PayTabActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makePayment(View view) {
        Intent in = new Intent(MainActivity.this, PayTabActivity.class);
        in.putExtra("pt_merchant_email", "ksreekanthyadav@gmail.com");
        //this a demo account for testing the sdk
        in.putExtra("pt_secret_key",
                "lYZfJw1Vc479QSWZDtgtLAZYh7F0UEFgCFvmbwinBpxritrVWIoIinHAvmAq1gGEVb07IivjI2L0wdWtVlbeJSOefpEhGkVBwWJe");
        //Add your Secret Key Here
        /*in.putExtra("pt_transaction_title", "Sreekanth");
        in.putExtra("pt_amount", 2.0);
        in.putExtra("pt_currency_code", "USD"); //Use Standard 3 character ISO
        in.putExtra("pt_shared_prefs_name", "myapp_shared");
        in.putExtra("pt_customer_email", "ksreekanthyadav@gmail.com");
        in.putExtra("pt_customer_phone_number", "918008546001");
        in.putExtra("pt_order_id", "1234567");
        in.putExtra("pt_product_name", "Samsung Galaxy S6");
        in.putExtra("pt_timeout_in_seconds", "300"); //Optional
//Billing Address
        in.putExtra("pt_address_billing", "Flat 1,Building 123, Road 2345");
        in.putExtra("pt_city_billing", "Hyderabad");
        in.putExtra("pt_state_billing", "Telangana");
        in.putExtra("pt_country_billing", "IND");
        in.putExtra("pt_postal_code_billing", "500082");

        //Put Country Phone code if Postal code not available '00973'
//Shipping Address
        in.putExtra("pt_address_shipping", "Flat 1,Building 123, Road 2345");
        in.putExtra("pt_city_shipping", "Hyderabad");
        in.putExtra("pt_state_shipping", "Telangana");
        in.putExtra("pt_country_shipping", "IND");
        in.putExtra("pt_postal_code_shipping", "500082");
        //Put Country Phone code if Postalcode not available '00973'*/

        in.putExtra("pt_transaction_title", "Mr. John Doe");
        in.putExtra("pt_amount", 1.0);
        in.putExtra("pt_currency_code", "USD"); //Use Standard 3 character ISO
        in.putExtra("pt_shared_prefs_name", "myapp_shared");
        in.putExtra("pt_customer_email", "ksreekanthyadav@gmail.com");
        in.putExtra("pt_customer_phone_number", "0097300001");
        in.putExtra("pt_order_id", "1234567");
        in.putExtra("pt_product_name", "Samsung Galaxy S6");
        in.putExtra("pt_timeout_in_seconds", "300"); //Optional
//Billing Address
        in.putExtra("pt_address_billing", "Flat 1,Building 123, Road 2345");
        in.putExtra("pt_city_billing", "Hyderabad");
        in.putExtra("pt_state_billing", "Telangana");
        in.putExtra("pt_country_billing", "IND");
        in.putExtra("pt_postal_code_billing", "500082"); //Put Country Phone code if Postal

//Shipping Address
        in.putExtra("pt_address_billing", "Flat 1,Building 123, Road 2345");
        in.putExtra("pt_city_billing", "Hyderabad");
        in.putExtra("pt_state_billing", "Telangana");
        in.putExtra("pt_country_billing", "IND");
        in.putExtra("pt_postal_code_billing", "500082"); //Put Country Phone code if Postal

        int requestCode = 0;
        startActivityForResult(in, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        SharedPreferences shared_prefs = getSharedPreferences("myapp_shared", MODE_PRIVATE);
        String pt_response_code = shared_prefs.getString("pt_response_code", "");
        String pt_transaction_id = shared_prefs.getString("pt_transaction_id", "");
        Toast.makeText(MainActivity.this, "PayTabs Response Code : " + pt_response_code,
                Toast.LENGTH_LONG).show();
        Toast.makeText(MainActivity.this, "Paytabs transaction ID after payment : " +
                pt_transaction_id, Toast.LENGTH_LONG).show();
    }
}
