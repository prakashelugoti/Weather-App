package foodzamo.user.com.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {
TextView textView;

    SharedPreferences sharedpreferences_location;
    public static final String mypreference_pincode = "mypreference_pincode";
    public static final String pincode = "pincode";
    public static final String city = "city";
    public static final String country = "country";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        sharedpreferences_location = getSharedPreferences(mypreference_pincode,
                Context.MODE_PRIVATE);
        textView=(TextView)findViewById(R.id.details);

        String data="Country: "+sharedpreferences_location.getString(country,"")
                +"\nCity: "+sharedpreferences_location.getString(city,"")
                +"\nPincode: "+sharedpreferences_location.getString(pincode,"");

        textView.setText(data);


    }

    @Override
    public void onBackPressed()
    {
        finish();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
