package com.epam.aws.lambda;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class App {

    public void handleRequest(InputStream inputStream) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                                                 .withRegion(Regions.EU_CENTRAL_1)
                                                 .build();
        s3Client.createBucket(new CreateBucketRequest(mapper.readTree(inputStream).get("bucketName").asText(),
                Regions.EU_CENTRAL_1.getName()));
    }
}
