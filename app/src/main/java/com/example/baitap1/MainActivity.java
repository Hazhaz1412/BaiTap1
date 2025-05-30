package com.example.baitap1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtKilo = findViewById(R.id.txtKilo);
        EditText txtPound = findViewById(R.id.txtPound);
        Button btnConvert = findViewById(R.id.btnConvert);
        txtPound.setEnabled(false); // không thể nhấn hay chỉnh

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kiloText = txtKilo.getText().toString().trim();
                if (!kiloText.isEmpty()) {
                    try {
                        double kilo = Double.parseDouble(kiloText);
                        double pound = kilo * 2.20462;
                        txtPound.setText(String.format("%.2f", pound));
                    } catch (NumberFormatException e) {
                        txtPound.setText("Invalid input");
                    }
                } else {
                    txtPound.setText("Enter kg");
                }
            }
        });
    }
}
