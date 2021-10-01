package es.joseljg.temperatura2021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private double centigrados = 0.0;
    private double kelvin = 0.0;
    private double farenheit = 0.0;
    private EditText edt_centigrados = null;
    private TextView txt_kelvin = null;
    private TextView txt_farenheit = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_centigrados = (EditText) findViewById(R.id.edt_centigrados);
        txt_kelvin = (TextView) findViewById(R.id.txt_kelvin);
        txt_farenheit = (TextView) findViewById(R.id.txt_farenheit);
    }

    public void ocultarTeclado(Activity activity)
    {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService (Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow (activity.getCurrentFocus (). getWindowToken (), 0);
    }

    public void convertir(View view) {
            ocultarTeclado(this);
            String texto = String.valueOf(edt_centigrados.getText());
             if(texto.isEmpty())
               {
            centigrados = 0.0;
               }
               else{
            centigrados = Double.valueOf(texto);
              }

            Log.i("pepito", "los grados centigrados valen " + String.valueOf(centigrados));
            kelvin = centigrados + 273.0;
            Log.i("pepito", "los kelvin valen " + String.valueOf(kelvin));
            farenheit = centigrados * 9.0/5.0 + 32.0;
            Log.i("pepito", "los grados farenheit valen" + String.valueOf(farenheit));
            txt_kelvin.setText("kelvin: " + String.valueOf(kelvin)+"ºK");
            txt_farenheit.setText("farenheit: " + String.valueOf(farenheit)+"ºF");
            Toast.makeText(this,"conversion correcta", Toast.LENGTH_LONG).show();



    }
}