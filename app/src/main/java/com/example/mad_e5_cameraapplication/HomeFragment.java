/**
 * This class contains methods for the home screen of the camera app
 * MAD-E6
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */

package com.example.mad_e5_cameraapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}