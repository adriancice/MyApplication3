package app.adrian.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

public class MainActivity extends AppCompatActivity{

    private Button boton;
    private final String GREETER = "Hello from the other side";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       boton = (Button) findViewById(R.id.buttonMain);

         boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Acceder al segundo activity y mandarle un String
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("greeter", GREETER);
                startActivity(intent);
            }
        });



         //Tomar los datos del intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String greeter = bundle.getString("greeter");
            Toast.makeText(MainActivity.this, greeter, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
        }


    }



}
