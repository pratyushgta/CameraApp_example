/**
 * This class contains methods for handling the fragments
 * MAD-E6
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */

package com.example.mad_e5_cameraapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;

import com.example.mad_e5_cameraapplication.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;

public class MainActivity extends AppCompatActivity {
    @NonNull
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            if (item.getItemId() == R.id.nav_home) {
                selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.nav_photo) {
                selectedFragment = new PhotoFragment();
            } else if (item.getItemId() == R.id.nav_video) {
                selectedFragment = new VideoFragment();
            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout, selectedFragment).commit();
            }
            return true;
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout, new HomeFragment()).commit();
    }
}