package es.joseljg.temperatura2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

    public void convertir(View view) {
        String texto = String.valueOf(edt_centigrados.getText());
        if(texto.isEmpty())
        {
            centigrados = 0.0;
        }
        else{
            centigrados = Double.valueOf(texto);
        }

        kelvin = centigrados + 273.0;
        farenheit = centigrados * 9.0/5.0 + 32.0;
        txt_kelvin.setText("kelvin: " + String.valueOf(kelvin)+"ºK");
        txt_farenheit.setText("farenheit: " + String.valueOf(farenheit)+"ºF");
        Toast.makeText(this,"conversion correcta", Toast.LENGTH_LONG).show();
    }
}