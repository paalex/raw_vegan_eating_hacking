package tcmp.uniquename.com.app_20_01_16;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {




//    static View.OnClickListener myListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout root = new LinearLayout(this);
        Button button = new Button(this);

        button.setText("Text from code 123");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        button.setLayoutParams(params);


        root.addView(button);

        final int x = 100;
        View.OnClickListener myOnClickListener = new View.OnClickListener() {

            int y = x;
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Anonymous class x"+y++,
                        Toast.LENGTH_LONG ).show();
            }
        };



        //myListener = myOnClickListener;


       button.setOnClickListener(myOnClickListener);
       setContentView(root);
    }

//    class MyClass extends Object implements View.OnClickListener{
//
//        @Override
//        public void onClick(View v) {
//
//        }
//    }
}
