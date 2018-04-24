package e.subsh.callmanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAceptar;
    EditText edtContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        edtContrasena = (EditText) findViewById(R.id.edtContrasena);
        btnAceptar.setOnClickListener(OnClickAceptar);
    }

    public View.OnClickListener OnClickAceptar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        String usuario = edtContrasena.getText().toString();
        if (usuario.compareTo("244466666") == 0)
        {
            Intent intentgenda = new Intent(MainActivity.this,AgendaTelefonos.class);
            startActivity(intentgenda);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"contraseña incorrecta", Toast.LENGTH_SHORT).show();
        }
        }
    };
}
