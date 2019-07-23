package sg.edu.rp.c346.demodialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnDemoDialog, btnDemoDialog2, btnDemoDialog3, btnExercise3, btnDemoDialog4;

    TextView tvDemo2, tvDemo3, tvExercise3, tvDemo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemoDialog = findViewById(R.id.btnDialog);
        btnDemoDialog2 = findViewById(R.id.btnDialog2);
        btnDemoDialog3 = findViewById(R.id.btnDialog3);
        btnExercise3 = findViewById(R.id.btnExercise3);
        btnDemoDialog4 = findViewById(R.id.btnDialog4);

        tvDemo2 = findViewById(R.id.tvDemo2);
        tvDemo3 = findViewById(R.id.tvDemo3);
        tvExercise3 = findViewById(R.id.tvExercise3);
        tvDemo4 = findViewById(R.id.tvDemo4);

        btnDemoDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create Dialog Builder //
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Set dialog details //
                /*
                builder.setTitle("Demo 1 Simple Dialog");
                builder.setMessage("I can develop Android App!");
                builder.setCancelable(false);
                builder.setPositiveButton("Close", null);
                */

                builder.setTitle("Congratulations");
                builder.setMessage("You have completed a simple Dialog Box");
                builder.setCancelable(true);
                builder.setPositiveButton("Dismiss", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btnDemoDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create Dialog Builder //
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Set dialog details //
                builder.setTitle("Demo 2");
                builder.setMessage("Select 1 of the Buttons below.");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected Positive.");
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected Negative.");
                    }
                });

                builder.setNeutralButton("Cancel", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btnDemoDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the input.xml layout file //
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain UI component in the input.xml layout //
                // Needs to be declared FINAL so that it can be used in the onClick() method later //
                final EditText etInput = viewDialog.findViewById(R.id.editText);

                // Create Dialog Builder //
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Set dialog details //
                builder.setView(viewDialog);
                builder.setTitle("Demo 3");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String message = etInput.getText().toString();
                        tvDemo3.setText(message);
                    }
                });

                builder.setNegativeButton("CANCEL", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btnExercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.exercise3, null);

                final EditText etInput1 = viewDialog.findViewById(R.id.et1);
                final EditText etInput2 = viewDialog.findViewById(R.id.et2);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(viewDialog);
                builder.setTitle("Exercise 3");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            double sum1 = Double.parseDouble(etInput1.getText().toString());
                            double sum2 = Double.parseDouble(etInput2.getText().toString());
                            double totalSum = sum1 + sum2;
                            tvExercise3.setText("The sum is " + totalSum);
                        } catch (Exception e) {
                            tvExercise3.setText("Error while parsing numbers!");
                        }
                    }
                });

                builder.setNegativeButton("CANCEL", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btnDemoDialog4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                };

                DatePickerDialog dateDialog = new DatePickerDialog(MainActivity.this, dateListener, 2014, 11, 31);
                dateDialog.show();
            }
        });

    }
}
