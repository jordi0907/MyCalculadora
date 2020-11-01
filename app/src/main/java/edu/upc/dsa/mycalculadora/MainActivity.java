package edu.upc.dsa.mycalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double valorSumado=0, resultado, valorTrigo;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnSuma, btnResta, btnMultiplica, btnDivide, btnTng, btnSin, btnCos, btnC,btnResultado;
    private TextView textDisplay;
    private String mostrar, operador, operadorTrigo, checkedTrigonometria;
    private boolean primeraOperacion= true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnSuma = (Button) findViewById(R.id.btnSuma);
        btnResta = (Button) findViewById(R.id.btnResta);
        btnMultiplica = (Button) findViewById(R.id.btnMultiplica);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnTng = (Button) findViewById(R.id.btnTng);
        btnSin = (Button) findViewById(R.id.btnSin);
        btnCos = (Button) findViewById(R.id.btnCos);
        btnC = (Button) findViewById(R.id.btnC);
        btnResultado = (Button) findViewById(R.id.btnResultado);
        textDisplay = (TextView) findViewById(R.id.textDisplay);

    }




    public void btn1Clicked(View v){
        mostrar =  textDisplay.getText().toString();
        mostrar = mostrar +"1";
        textDisplay.setText(mostrar);

    }

    public void btn2Clicked(View v){
        mostrar =  textDisplay.getText().toString();
        mostrar = mostrar +"2";
        textDisplay.setText(mostrar);

    }
    public void btn3Clicked(View v){
        mostrar =  textDisplay.getText().toString();
        mostrar = mostrar +"3";
        textDisplay.setText(mostrar);

    }
    public void Btn4Clicked(View v) {
        mostrar = textDisplay.getText().toString();
        textDisplay.setText(mostrar + "4");
    }
    public void Btn5Clicked(View v) {
        mostrar = textDisplay.getText().toString();
        textDisplay.setText(mostrar + "5");
    }
    public void Btn6Clicked(View v) {
        mostrar = textDisplay.getText().toString();
        textDisplay.setText(mostrar + "6");
    }
    public void Btn7Clicked(View v) {
        mostrar = textDisplay.getText().toString();
        textDisplay.setText(mostrar + "7");
    }
    public void Btn8Clicked(View v) {
        mostrar = textDisplay.getText().toString();
        textDisplay.setText(mostrar + "8");
    }
    public void Btn9Clicked(View v) {
        mostrar = textDisplay.getText().toString();
        textDisplay.setText(mostrar + "9");
    }
    public void Btn0Clicked(View v) {
        mostrar = textDisplay.getText().toString();
        textDisplay.setText(mostrar + "0");
    }
    public void btnCClicked(View v){
        textDisplay.setText("");
        valorSumado = 0;
        mostrar="";
        primeraOperacion = true;
        operador = "";

    }

    public void btnSumaClicked(View v){
        mostrar =  textDisplay.getText().toString();
        if (primeraOperacion == true ){
            valorSumado = Double.parseDouble(mostrar);
            }
        else{
            calculo(operador);}

        textDisplay.setText("");
        primeraOperacion = false;
        operador = "suma";

    }
    public void btnMultiplicaClicked(View v) {
        mostrar = textDisplay.getText().toString();
        if(valorSumado == 0){
            valorSumado=1;
        }
        if (primeraOperacion == true ) {
            valorSumado = Double.parseDouble(mostrar);
        }
        else{
            calculo(operador);}

        textDisplay.setText("");
        primeraOperacion = false;
        operador = "multiplicar";
    }

    public void btnDividirClicked(View v) {
        mostrar = textDisplay.getText().toString();
        if(valorSumado == 0){
            valorSumado=1;
        }
        if (primeraOperacion == true ) {
            valorSumado = valorSumado / Double.parseDouble(mostrar);
        }
        else{
            calculo(operador);}

        textDisplay.setText("");
        primeraOperacion = false;
        operador = "dividir";
    }

    public void btnSinClicked(View v) {
        mostrar = textDisplay.getText().toString();
        if(checkedTrigonometria=="radianes") {

            valorTrigo = Math.sin((Double.parseDouble(mostrar)));
            textDisplay.setText(String.valueOf(valorTrigo));
            operadorTrigo = "sin";
        }
        else{
            valorTrigo = Math.sin(Math.toRadians(Double.parseDouble(mostrar)));
            textDisplay.setText(String.valueOf(valorTrigo));
            operadorTrigo = "sin";
        }
    }

    public void btnCosClicked(View v) {
        mostrar = textDisplay.getText().toString();
        valorTrigo = Math.cos((Double.parseDouble(mostrar)));
        textDisplay.setText(String.valueOf(valorTrigo));
        operadorTrigo = "cos";
    }

    public void btnTangClicked(View v) {
        mostrar = textDisplay.getText().toString();
        valorTrigo = Math.tan((Double.parseDouble(mostrar)));
        textDisplay.setText(String.valueOf(valorTrigo));
        operadorTrigo = "tang";
    }


    public void btnResultadoClicked(View v){
        mostrar =  textDisplay.getText().toString();
        if ( operador ==  "suma") {
            resultado = Double.parseDouble(mostrar) + valorSumado ;
        }
        else if (operador == "multiplicar"){
            resultado = Double.parseDouble(mostrar) * valorSumado ;
        }
        else if (operador == "dividir"){
            resultado = Double.parseDouble(mostrar) / valorSumado ;
        }
        else if (((operadorTrigo == "sin" )|| (operadorTrigo=="cos") || (operadorTrigo =="tang")) && (primeraOperacion ==true)){
            resultado = valorTrigo;
        }
        textDisplay.setText(String.valueOf(resultado));
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioDegrees:
                if (checked)
                    checkedTrigonometria = "degress";// Pirates are the best
                break;
            case R.id.radioRadians:
                if (checked)
                    checkedTrigonometria = "radianes";// Ninjas rule
                break;
        }
    }

    public void calculo(String opera){
        if (primeraOperacion == false) {
            mostrar = textDisplay.getText().toString();
            switch (opera) {
                case "suma":
                    valorSumado = valorSumado + Double.parseDouble(mostrar);
                    break;
                case "multiplicar":
                    valorSumado = valorSumado * Double.parseDouble(mostrar);
                    break;
                case "dividir":
                    valorSumado = valorSumado / Double.parseDouble(mostrar);
                    break;
                case "sin1":
                    valorSumado = Math.sin((Double.parseDouble(mostrar)));
                    break;
            }
        }


    }

}


