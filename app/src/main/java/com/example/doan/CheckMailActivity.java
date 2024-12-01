package com.example.doan;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class CheckMailActivity extends AppCompatActivity {
    private EditText otp1, otp2, otp3, otp4, otp5;
    private Button btnConfirm;
    private EditText[] otpFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_mail);

        // Find views
        otp1 = findViewById(R.id.rectangle_otp_1);
        otp2 = findViewById(R.id.rectangle_otp_2);
        otp3 = findViewById(R.id.rectangle_otp_3);
        otp4 = findViewById(R.id.rectangle_otp_4);
        otp5 = findViewById(R.id.rectangle_otp_5);

        btnConfirm = findViewById(R.id.confirm_button_checkmail);
        btnConfirm.setEnabled(false);  // Disabled at init

        otpFields = new EditText[]{otp1, otp2, otp3, otp4, otp5};

        for (int i = 0; i < otpFields.length; i++) {
            final int currentIndex = i;
            otpFields[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length() == 1) {
                        // Move next
                        if (currentIndex < otpFields.length - 1) {
                            otpFields[currentIndex + 1].requestFocus();
                        }
                    }
                    checkOtpFields(); // Enable/Disable the confirm button
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });

            otpFields[i].setOnKeyListener((v, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (otpFields[currentIndex].getText().toString().isEmpty() && currentIndex > 0) {
                        otpFields[currentIndex - 1].requestFocus();
                    }
                }
                return false;
            });
        }

        // Confirm button on clicked
        btnConfirm.setOnClickListener(v -> {
            String otpCode = getOtpCode();
            Toast.makeText(CheckMailActivity.this, "Code Entered: " + otpCode, Toast.LENGTH_SHORT).show();
            // Qua activity moi hay gi do o day
        });
    }

    // Check if filled 5 digits
    private void checkOtpFields() {
        boolean isOtpComplete = true;

        for (EditText otpField : otpFields) {
            if (otpField.getText().toString().trim().isEmpty()) {
                isOtpComplete = false;
                break;
            }
        }

        // Enable/disable the button
        btnConfirm.setEnabled(isOtpComplete);

        // Change button color
        btnConfirm.setBackgroundTintList(
                ContextCompat.getColorStateList(this,
                        isOtpComplete ? R.color.custom_orange : R.color.custom_gray
                )
        );

    }

    // Concatenate OTP textField into string
    private String getOtpCode() {
        return otp1.getText().toString().trim() +
                otp2.getText().toString().trim() +
                otp3.getText().toString().trim() +
                otp4.getText().toString().trim() +
                otp5.getText().toString().trim();
    }
}
