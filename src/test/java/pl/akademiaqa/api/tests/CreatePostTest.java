package pl.akademiaqa.api.tests;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.api.payload.post.CreatePostPayload;
import pl.akademiaqa.api.payload.post.CreatePostResponse;
import pl.akademiaqa.common.BaseApiTest;
import pl.akademiaqa.utils.Properties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

class CreatePostTest extends BaseApiTest {

    // CREATE POST WITH DIFFERENT PAYLOADS: STRING | DTO | JSONOBJECT | MAP | JSON FILE

    @Test
    void should_create_post() throws IOException {
        String postId = null;

        // MAP
        Map<String, String> data = new HashMap<>();
        data.put("title", "foo");
        data.put("body", "bar");
        data.put("userId", "1");

        // FILE
        byte[] fileBytes = getPayloadFromFile("post.json");

        // DTO
        CreatePostPayload postDTO = new CreatePostPayload();
        postDTO.setTitle("foofoo");
        postDTO.setBody("barbar");
        postDTO.setUserId("111");

        // JSONOBJECT
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("title", "fooJO");
        jsonObject.addProperty("body", "barJO");
        jsonObject.addProperty("userId", "222");

        // STRING
        String stringBody = "{\n" +
                "    \"userId\": 1,\n" +
                "    \"title\": \"this is title\",\n" +
                "    \"body\": \"this is body\"\n" +
                "}";

        APIResponse response = apiContext.post("posts", RequestOptions.create()
                .setData(fileBytes));
        PlaywrightAssertions.assertThat(response).isOK();

        // TEXT
        System.out.println("String:" + response.text());

        // DTO
        CreatePostResponse createPostResponse = new Gson().fromJson(response.text(), CreatePostResponse.class);
        System.out.println("DTO: " + createPostResponse);
        System.out.println(createPostResponse.getTitle());

        // JSONOBJECT
        JsonObject createPostResponseJson = new Gson().fromJson(response.text(), JsonObject.class);
        System.out.println("JsonObject: " + createPostResponseJson);
        System.out.println(createPostResponseJson.get("title"));
        postId = createPostResponseJson.get("id").getAsString();

        // MAP
        HashMap createPostResponseMap = new Gson().fromJson(response.text(), HashMap.class);
        System.out.println("Map: " + createPostResponseMap);
        System.out.println(createPostResponseMap.get("title"));

//        // SEND GET TO CHECK IS POST CREATED
//        System.out.println("GET:");
//        APIResponse getResponse = apiContext.get("posts/" + postId);
//        PlaywrightAssertions.assertThat(getResponse).isOK();
//        System.out.println(getResponse.text());
    }

    private byte[] getPayloadFromFile(String fileName) throws IOException {
        return Files.readAllBytes(Path.of(Properties.getProperty("app.json.file.path") + fileName));
    }
}
