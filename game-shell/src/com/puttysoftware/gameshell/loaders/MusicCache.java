package com.puttysoftware.gameshell.loaders;

import java.util.ArrayList;

import com.puttysoftware.audio.ogg.OggPlayer;

final class MusicCache {
    // Fields
    private ArrayList<MusicCacheEntry> cache;
    private static final int INITIAL_SIZE = 10;

    // Constructor
    MusicCache() {
        this.cache = new ArrayList<>(MusicCache.INITIAL_SIZE);
    }

    // Methods
    OggPlayer getCachedMusic(final String name) {
        for (MusicCacheEntry mce : this.cache) {
            if (mce.getName().equals(name)) {
                return mce.getMusic();
            }
        }
        return null;
    }

    void addToCache(final String name, final OggPlayer music) {
        this.cache.add(new MusicCacheEntry(music, name));
    }

    boolean isInCache(final String name) {
        for (MusicCacheEntry mce : this.cache) {
            if (mce.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}