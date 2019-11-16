package com.donationalerts.youtubeparser.exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(Long id){
        super("Could not found City with id: "+id);
    }
}
