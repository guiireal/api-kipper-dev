package com.guiireal.api.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.guiireal.api.domain.event.Event;
import com.guiireal.api.domain.event.EventRequestDTO;

@Service
public class EventService {
    @Autowired
    private AmazonS3 s3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

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

    private String uploadImage(MultipartFile multipartFile) {
        String fileName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        try {
            File file = this.convertMultiPartToFile(multipartFile);
            s3Client.putObject(bucketName, fileName, file);

            file.delete();

            return s3Client.getUrl(bucketName, fileName).toString();
        } catch(Exception e) {
            System.out.println("Erro ao subir o arquivo: " + e.getMessage());
            return null;
        }
    }

    private File convertMultiPartToFile(MultipartFile multipartFile) throws IOException {
        File convertedFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convertedFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        
        return convertedFile;
    }
}
