package com.example.hp.acsapp.utils;

/**
 * Created by HP on 2/7/2018.
 */

public interface PlayerAdapter {

    void loadMedia(int resourceId);

    void release();

    boolean isPlaying();

    void play();

    void reset();

    void pause();

    void initializeProgressCallback();

    void seekTo(int position);
}
