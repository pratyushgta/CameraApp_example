/**
 * This class contains methods for storing clicked media
 * MAD-E6
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */

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
