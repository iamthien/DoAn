package com.example.doan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreatePasswdActivity extends AppCompatActivity {
    private Button btnConfirm;
    private TextView tvLogin;
    private boolean isPasswordVisible = false;
    private EditText etPassword, etRePassword;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_passwd);

        btnConfirm = findViewById(R.id.confirm_button_createpasswd);
        btnConfirm.setOnClickListener(v -> {
            startActivity(new Intent(CreatePasswdActivity.this, LoginActivity.class));
        });

        tvLogin = findViewById(R.id.text_login);
        tvLogin.setOnClickListener(v -> {
            startActivity(new Intent(CreatePasswdActivity.this, LoginActivity.class));
        });

        etPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    int drawableEnd = 2; // right drawable index
                    if (event.getRawX() >= (etPassword.getRight() - etPassword.getCompoundDrawables()[drawableEnd].getBounds().width())) {
                        togglePasswordVisibility();
                        return true;
                    }
                }
                return false;
            }
        });

        etRePassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    int drawableEnd = 2; // right drawable index
                    if (motionEvent.getRawX() >= (etRePassword.getRight() - etRePassword.getCompoundDrawables()[drawableEnd].getBounds().width())) {
                        togglePasswordVisibility();
                        return true;
                    }
                }
                return false;
            }
        });

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void togglePasswordVisibility() {
        // Save cursor
        int cursorPosition = etPassword.getSelectionStart();

        // Toggle password visibility
        if (isPasswordVisible) {
            etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            etPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.visibility_off), null);
            isPasswordVisible = false;
        } else {
            etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            etPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.visibility_on), null);
            isPasswordVisible = true;
        }

        // Restore cursor pos
        etPassword.setSelection(cursorPosition);
    }
}