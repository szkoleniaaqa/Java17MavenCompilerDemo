package pl.akademiaqa.tests.modul_17_rest_api_pw.api.payload.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreatePostPayload {

    private String title;
    private String body;
    private String userId;

    public static CreatePostPayload createDefaultPayload() {
        return CreatePostPayload.builder()
                .title("Default title")
                .body("Default body")
                .userId("1")
                .build();
    }
}
