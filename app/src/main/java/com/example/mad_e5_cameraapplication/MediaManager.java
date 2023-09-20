package com.example.mad_e5_cameraapplication;

import android.graphics.Bitmap;
import android.net.Uri;

public class MediaManager {
    private static Bitmap capturedImage;
    private static Uri capturedVideo;

    public static Bitmap getCapturedImage() {
        return capturedImage;
    }

    public static void setCapturedImage(Bitmap image) {
        capturedImage = image;
    }

    public static Uri getCapturedVideo() {
        return capturedVideo;
    }

    public static void setCapturedVideo(Uri video) {
        capturedVideo = video;
    }
}
