package pl.akademiaqa.tests.modul_17_rest_api_pw.api.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.modul_17_rest_api_pw.api.response.user.GetUserResponse;
import pl.akademiaqa.utils.Properties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

class _1ReadSingleUserTest {

    Playwright playwright;
    APIRequest request;
    APIRequestContext apiContext;

    @BeforeEach
    void beforeEach() {
        // PW
        playwright = Playwright.create();

        // API
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        request = playwright.request();
        apiContext = request.newContext(new APIRequest.NewContextOptions()
                .setBaseURL(Properties.getProperty("app.api.url"))
                .setExtraHTTPHeaders(headers));
    }

    @Test
    void should_return_single_user_response_test() {
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");

//        Playwright playwright = Playwright.create();
//        APIRequest request = playwright.request();
//        APIRequestContext requestContext = request.newContext(new APIRequest.NewContextOptions()
//                .setBaseURL(Properties.getProperty("app.api.url"))
//                .setExtraHTTPHeaders(headers));

        APIResponse apiResponse = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(apiResponse).isOK();
        Assertions.assertThat(apiResponse.status()).isEqualTo(200);

        // PW RESPONSE
        System.out.println(apiResponse.status());
        System.out.println(apiResponse.statusText());
        System.out.println(apiResponse.ok());
        System.out.println(apiResponse.text());
        System.out.println(apiResponse.body());
        System.out.println(new String(apiResponse.body(), StandardCharsets.UTF_8));
        System.out.println(apiResponse.headers());
        System.out.println(apiResponse.url());
    }

    @Test
    void should_return_single_user_gson_test() {

        APIResponse apiResponse = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        // GSON - zamiana odpowiedzi na JsonObject
        JsonObject jsonResponse = new Gson().fromJson(apiResponse.text(), JsonObject.class);
        System.out.println(jsonResponse);
        System.out.println(jsonResponse.get("name"));
        System.out.println(jsonResponse.get("email"));
    }

    @Test
    void should_return_single_user_jackson_test() throws IOException {

        APIResponse apiResponse = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        // JACKSON-DATABIND - zamiana odpowiedzi na JsonNode
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(apiResponse.body());
        System.out.println(jsonNode.toPrettyString());
        System.out.println(jsonNode.get("phone"));
    }

    @Test
        // deserializacja
    void should_return_single_user_dto_test() {

        // serializacja - obiekt na json
        // deserializacja - json na obiekt

        APIResponse apiResponse = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        // zamiana odpowiedzi na dto - gson
        final var user = new Gson().fromJson(apiResponse.text(), GetUserResponse.class);
        System.out.println(user);
        System.out.println(user.getUserName());
    }
}
