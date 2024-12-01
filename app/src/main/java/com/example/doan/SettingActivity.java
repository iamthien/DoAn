package com.example.doan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.http.POST;

public class SettingActivity extends AppCompatActivity {
    private RelativeLayout icSetting, icMap, icHome;
    private ImageView ivLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.setting);

        icSetting = findViewById(R.id.iconsetting);
        icMap = findViewById(R.id.iconlocation);
        icHome = findViewById(R.id.iconhome);
        ivLogout = findViewById(R.id.logout);

        icSetting.setOnClickListener(v -> {
            startActivity(new Intent(SettingActivity.this, SettingActivity.class));
        });
        icMap.setOnClickListener(v -> {
            startActivity(new Intent(SettingActivity.this, MapActivity.class));
        });
        icHome.setOnClickListener(v -> {
            startActivity(new Intent(SettingActivity.this, DashboardActivity.class));
        });
        ivLogout.setOnClickListener(v -> {
            startActivity(new Intent(SettingActivity.this, LoginActivity.class));
        });
    }

}