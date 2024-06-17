package com.guiireal.api.services;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.guiireal.api.domain.event.Event;
import com.guiireal.api.domain.event.EventRequestDTO;

@Service
public class EventService {
    public Event createEvent(EventRequestDTO data) {
        String imageUrl = null;

        if (data.image() != null) {
            imageUrl = this.uploadImage(data.image());
        }

        Event newEvent = new Event();

        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setDate(new Date(data.date()));
        newEvent.setImageUrl(imageUrl);

        return newEvent;
    }

    private String uploadImage(MultipartFile image) {
        return "";
    }
}
