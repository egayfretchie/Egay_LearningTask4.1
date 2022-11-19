package com.example.egay_learningtask41;

        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNumber1, etNumber2, etNumber3;
    String strNumber1, strNumber2, strNumber3, resultMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCompute = (Button) findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Computing....", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }

    public void ComputeResult(){
        etNumber1 = (EditText) findViewById(R.id.etNumber1);
        etNumber2 = (EditText) findViewById(R.id.etNumber2);
        etNumber3 = (EditText) findViewById(R.id.etNumber3);
        if(etNumber1.getText().toString().isEmpty() || etNumber2.getText().toString().isEmpty() || etNumber3.getText().toString().isEmpty()){
            strNumber1 = "0";
            strNumber2 = "0";
            strNumber3 = "0";
        }else{
            strNumber1 = etNumber1.getText().toString();
            strNumber2 = etNumber2.getText().toString();
            strNumber3 = etNumber3.getText().toString();
        }
        double rawNumber1 = Double.parseDouble(strNumber1);
        double rawNumber2 = Double.parseDouble(strNumber2);
        double rawNumber3 = Double.parseDouble(strNumber3);

        double sum = rawNumber1 + rawNumber2 + rawNumber3;
        // Casted result to int type, remove to show decimal value
        resultMessage = "The sum of " + strNumber1 + ", " + strNumber2 + ", and " + strNumber3 + " is " + (int) sum + ".";

        // Create Bundle instance, this will allow transfer of data from Activity to DialogFragment
        Bundle args = new Bundle();
        args.putString("sum", resultMessage);

        // Create a dialog instance
        DialogFragmentCustom dialogFragmentImp = new DialogFragmentCustom();
        // Pass on dialog argument(args), the result
        dialogFragmentImp.setArguments(args);
        // Display the Dialog
        dialogFragmentImp.show(getSupportFragmentManager(),"Display Result");
        // Reset EditTexts
        clearEditText();
    }
    public void clearEditText(){
        etNumber1.getText().clear();
        etNumber2.getText().clear();
        etNumber3.getText().clear();
    }
}

