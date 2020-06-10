package ru.ifmo.loader.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class ClientSide {
    public static void main(String[] ar) throws IOException {
        ClientSide t = new ClientSide();
        t.method();
    }

    public void method() throws IOException{
        String url = "http://localhost:8080/fileupload";
        String fileName = ""; //file name to be uploaded
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        StringBody fileContent = new StringBody("Filename: " + fileName);
        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("file", fileContent);
        httppost.setEntity(reqEntity);

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity();
    }
}
