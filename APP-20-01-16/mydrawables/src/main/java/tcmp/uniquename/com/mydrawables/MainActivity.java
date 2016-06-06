package tcmp.uniquename.com.mydrawables;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();



        findViewById(R.id.button2).setOnClickListener(this);

        Button b = new Button(this);
        b.setId(R.id.my_id);

        resources.getConfiguration().locale = new Locale("iw");
        Configuration configuration = new Configuration();
        configuration.locale = new Locale("iw");
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        Toast.makeText(this,
                getString(R.string.test_str),
                Toast.LENGTH_LONG).show();


    }

    @Override
    public void onClick(View v) {
        v.setSelected(! v.isSelected());


    }
}
