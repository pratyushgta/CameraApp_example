package com.example.mad_e5_cameraapplication;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoFragment extends Fragment {
    VideoView video;
    Button shutter_button;
    Button remove_button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        video = view.findViewById(R.id.video_view);
        shutter_button = view.findViewById(R.id.video_button);
        remove_button = view.findViewById(R.id.remove_button);

        MediaController mediaController = new MediaController(getContext()); // instead of getContect(), use 'this'
        mediaController.setAnchorView(video);
        video.setMediaController(mediaController);

        final int vid_id = 123; //request-id of clicked video

        shutter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera_intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(camera_intent,vid_id);
            }
        });

        // EXTRA QoL improvements
        // to fix the clicked video so that it doesnt change if fragment is reloaded
        if(MediaManager.getCapturedVideo() != null){
            video.setVideoURI(MediaManager.getCapturedVideo());
        }

        remove_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //video.setVideoURI(null);
                Uri videoUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.bread);
                video.setVideoURI(videoUri);
                MediaManager.setCapturedVideo(videoUri);
                Toast.makeText(getActivity(), "bread \uD83D\uDC4D", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 123 && resultCode == RESULT_OK){
            Uri videoUri = data.getData();
            video.setVideoURI(videoUri);
            video.start();
            MediaManager.setCapturedVideo(videoUri);
        }

    }
}