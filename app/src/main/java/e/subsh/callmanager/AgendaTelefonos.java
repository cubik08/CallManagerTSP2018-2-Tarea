package e.subsh.callmanager;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class AgendaTelefonos extends AppCompatActivity {

    ListView lstvNumeros;
    String [] arrayNumeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_telefonos);

        lstvNumeros = (ListView) findViewById(R.id.lstNumeros);
        arrayNumeros = getResources().getStringArray(R.array.numeros);
        Bundle parametros = this.getIntent().getExtras();
        lstvNumeros.setOnItemClickListener(ItemListener());
        ArrayAdapter<String> AdapterNumeros = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,arrayNumeros);
        lstvNumeros.setAdapter(AdapterNumeros);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.mitoolbar, menu);
        return true;
    }

    protected AdapterView.OnItemClickListener ItemListener(){
        return new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), arrayNumeros[position].toString(), Toast.LENGTH_SHORT).show();
                Intent intentLlamar = new Intent(Intent.ACTION_CALL);
                intentLlamar.setData(Uri.parse(arrayNumeros[position].toString()));
                startActivity(intentLlamar);
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch(item.getItemId())
        {
            case R.id.mAcercaDe:
                Intent intentacercade = new Intent(getApplicationContext(), AcercaDe.class);
                startActivity(intentacercade);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
