/**
 * This class contains methods for the handling the photo view fragment
 * MAD-E6
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */

package com.example.mad_e5_cameraapplication;
import com.example.mad_e5_cameraapplication.MediaManager;
import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class PhotoFragment extends Fragment {

    ImageView image;
    Button shutter_button;
    Button remove_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photo, container, false);
        image = view.findViewById(R.id.photo_image);
        shutter_button = view.findViewById(R.id.photo_button);
        remove_button = view.findViewById(R.id.remove_button);

        final int pic_id = 123; //request-id of clicked image

        shutter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent,pic_id);
            }
        });

        // EXTRA QoL improvements
        // to fix the clicked image so that it doesnt change if fragment is reloaded
        if (MediaManager.getCapturedImage() != null) {
            image.setImageBitmap(MediaManager.getCapturedImage());
        }

        // to remove the clicked image
        remove_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.monke3);
                MediaManager.setCapturedImage(null);
                Toast.makeText(getActivity(),"monkas is beck",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123 && resultCode == RESULT_OK){
            assert data != null;
            Bitmap photo = (Bitmap) data.getParcelableExtra("data");
            image.setImageBitmap(photo);
            MediaManager.setCapturedImage(photo);
        } else{
            Toast.makeText(getActivity(),"Sadge",Toast.LENGTH_SHORT).show();
        }
    }
}