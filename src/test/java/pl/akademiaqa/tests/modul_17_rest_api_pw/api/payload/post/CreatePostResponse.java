package pl.akademiaqa.tests.modul_17_rest_api_pw.api.payload.post;

import lombok.Data;

@Data
public class CreatePostResponse {

    private int id;
    private String title;
    private String body;
    private String userId;
}
