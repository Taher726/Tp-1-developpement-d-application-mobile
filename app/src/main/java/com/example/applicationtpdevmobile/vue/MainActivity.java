package com.example.applicationtpdevmobile.vue;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicationtpdevmobile.R;
import com.example.applicationtpdevmobile.controller.Controller;

public class MainActivity extends AppCompatActivity {

    private SeekBar sbAge;
    private EditText editText;
    private Button button;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private TextView tvAge;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        sbAge = findViewById(R.id.sbAge);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        tvAge = findViewById(R.id.tvAge);
        result = findViewById(R.id.result);
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                Log.i("Information", "onProgressChanged "+progress);
                tvAge.setText(""+ progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                int age=sbAge.getProgress();
                //System.out.println("age ="+age);
                String valmesurestr=(editText.getText().toString());
                //System.out.println("val ="+valmesure);
                boolean isFasting=radioButton1.isChecked();
                Controller controller = new Controller();
                int inputIsValid = controller.createPatient(age, isFasting, valmesurestr);
                //System.out.println("isFasting? ="+ isFasting);
                if(inputIsValid == 1){
                    Toast.makeText(MainActivity.this, "Ajouter un age > 0 et un niveau de glycémie", Toast.LENGTH_SHORT).show();
                }
                else if(inputIsValid == -1){
                    Toast.makeText(MainActivity.this, "Ajouter un age > 0", Toast.LENGTH_SHORT).show();
                    result.setText("");
                }
                else if(inputIsValid == -2){
                    Toast.makeText(MainActivity.this, "Ajouter un niveau de glycémie", Toast.LENGTH_SHORT).show();
                    result.setText("");
                }
                else{
                    controller.patient.calculer();
                    result.setText(controller.getResponse());
                }
            }
        });
    }
}