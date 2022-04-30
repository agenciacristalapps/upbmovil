package co.edu.upbmovil.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView txtResultado;
    TextView txtResultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtResultado = findViewById(R.id.txtResultado);
        txtResultado2 = findViewById(R.id.txtResultado2);

        Button b1= findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                concatenar(view);
            }
        });

    }

    public void iraRegistro(View view) {
        Intent in = new Intent(LoginActivity.this,RegistroActivity.class);
        startActivity(in);
        finish();
    }


    String pantallaCalculadora="";

    public void concatenar(View view){
        Button numero= (Button) view;//este puede ser cualquier botón numérico
        if(pantallaCalculadora.equals("")){
            pantallaCalculadora = numero.getText().toString();
        }else{
            //pantallaCalculadora = pantallaCalculadora + numero.getText().toString();
            pantallaCalculadora += numero.getText().toString();
        }
        //siempre mostramos el valor actual concatenado en la parte visual
        txtResultado.setText(pantallaCalculadora);
        if(!operacion.isEmpty()){
            igual(view);
        }
    }

    public void limpiar(View view){
        //siempre mostramos el valor actual concatenado en la parte visual
        txtResultado.setText("");
        pantallaCalculadora="";
    }

    double n1=0,n2=0,resultado=0;
    String operacion="";

    public void sumar(View view){
        n1 = Double.parseDouble(txtResultado.getText().toString());
        operacion = "+";

        txtResultado.setText("");
        pantallaCalculadora="";

    }
    public void restar(View view){
        n1 = Double.parseDouble(txtResultado.getText().toString());
        operacion = "-";
        txtResultado.setText("");
        pantallaCalculadora="";
    }
    public void multi(View view){
        n1 = Double.parseDouble(txtResultado.getText().toString());
        operacion = "*";
        txtResultado.setText("");
        pantallaCalculadora="";
    }
    public void divi(View view){
        n1 = Double.parseDouble(txtResultado.getText().toString());
        operacion = "/";
        txtResultado.setText("");
        pantallaCalculadora="";
    }

    public void igual(View view){
        boolean mostrarResultado=true;
        n2 = Double.parseDouble(txtResultado.getText().toString());

        switch (operacion){
            case "+":
                resultado = n1 + n2;
                break;
            case "-":
                resultado = n1 - n2;
                break;
            case "*":
                resultado = n1 * n2;
                break;
            case "/":
                if(n2==0){
                    Toast.makeText(getApplicationContext(),"No se puede dividir por cero",Toast.LENGTH_LONG).show();
                }else{
                    resultado = n1 / n2;
                }
                break;
        }


        if(mostrarResultado){
            txtResultado.setText(String.valueOf(resultado));
            n1 = resultado;


        }

    }


}