package foodzamo.user.com.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
EditText enter_postal_code;
    Button save_postal_code;

    SharedPreferences sharedpreferences_location;
    public static final String mypreference_pincode = "mypreference_pincode";
    public static final String pincode = "pincode";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedpreferences_location = getSharedPreferences(mypreference_pincode,
                Context.MODE_PRIVATE);

        enter_postal_code=(EditText)findViewById(R.id.enter_postal_pin);
        save_postal_code=(Button)findViewById(R.id.save_postal_code);

        save_postal_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=enter_postal_code.getText().toString();

                if(s.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Postal code is empty!",Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences.Editor editor=sharedpreferences_location.edit();
                editor.putString(pincode,s);
                editor.commit();

                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });


    }

}
