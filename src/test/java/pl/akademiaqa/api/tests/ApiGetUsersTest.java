package pl.akademiaqa.api.tests;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.HttpHeader;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.api.payload.user.CreateUserPayload;
import pl.akademiaqa.api.payload.user.CreateUserResponse;
import pl.akademiaqa.utils.Properties;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ApiGetUsersTest {

    Playwright playwright;
    APIRequest request;
    APIRequestContext apiContext;

    @BeforeEach
    void createContextAndPage() {
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
    void should_return_single_user() throws IOException {
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");

//        Playwright playwright = Playwright.create();
//        APIRequest request = playwright.request();
//        APIRequestContext requestContext = request.newContext(new APIRequest.NewContextOptions()
//                .setBaseURL(Properties.getProperty("app.api.url"))
//                .setExtraHTTPHeaders(headers));

        APIResponse apiResponse = apiContext.get("users/10");

//        System.out.println(apiResponse.text());
//        System.out.println(Arrays.asList(apiResponse.body()));
//        System.out.println(apiResponse.status());
//        System.out.println(apiResponse.headers());
//        System.out.println(apiResponse.statusText());
//        System.out.println(apiResponse.ok());
//        System.out.println(apiResponse.url());

        PlaywrightAssertions.assertThat(apiResponse).isOK();
        Assertions.assertThat(apiResponse.status()).isEqualTo(200);

        // TEXT
        // GSON - ZAMIANA ODPOWIEDZI NA JsonObject
//        JsonObject jsonResponse = new Gson().fromJson(apiResponse.text(), JsonObject.class);
//        System.out.println(jsonResponse.get("name"));

        // BODY
        // JACKSON-DATABIND - ZAMIANA response.body na obiekt
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(apiResponse.body());
//        System.out.println(jsonNode.toPrettyString());

        // NAGŁÓWKI
        Map<String, String> headers = apiResponse.headers();
        Assertions.assertThat(headers.get("content-type")).isEqualTo("application/json; charset=utf-8");

        List<HttpHeader> httpHeaders = apiResponse.headersArray();
        httpHeaders.forEach(header -> System.out.println(header.name + " : " + header.value));
    }

    @Test
    void should_return_single_with_query_params() {
        APIResponse apiResponse = apiContext.get("users",
                RequestOptions.create()
                        .setQueryParam("username", "Bret")
        );

        PlaywrightAssertions.assertThat(apiResponse).isOK();
        Assertions.assertThat(apiResponse.status()).isEqualTo(200);

        System.out.println(apiResponse.text());
    }

    @Test
    void should_return_list_of_users() throws IOException {
        APIResponse apiResponse = apiContext.get("users");
        PlaywrightAssertions.assertThat(apiResponse).isOK();
        Assertions.assertThat(apiResponse.status()).isEqualTo(200);

        JsonArray jsonArray = new Gson().fromJson(apiResponse.text(), JsonArray.class);

        List<String> names = jsonArray.asList()
                .stream()
                .map(el -> el.getAsJsonObject().get("name").getAsString())
                .collect(Collectors.toList());

        System.out.println(names);
        Assertions.assertThat(names).contains("Mrs. Dennis Schulist");

        // ZAMIANA ODPOWIEDZI NA DTO GSON
        List<CreateUserPayload> users = Arrays.asList(new Gson().fromJson(apiResponse.text(), CreateUserPayload[].class));
        System.out.println(users);

        CreateUserPayload user = users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase("sincere@april.biz"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Can not find user with given email"));

        System.out.println(user.getUserName());

        // ZMIANA ODPOWIEDZI NA DTO - stream()
//        List<UserDTO> users = jsonArray.asList()
//                .stream()
//                .map(el -> new UserDTO(
//                        el.getAsJsonObject().get("name").getAsString(),
//                        el.getAsJsonObject().get("username").getAsString(),
//                        el.getAsJsonObject().get("email").getAsString()
//                ))
//                .collect(Collectors.toList());
//
//        System.out.println(users);
    }

    @Test
        // nie wiem za bardzo po co jest ten dispose
    void two_api_calls_in_one_test() {
        System.out.println("First call");
        APIResponse apiResponse = apiContext.get("users/1");
        PlaywrightAssertions.assertThat(apiResponse).isOK();
        System.out.println(apiResponse.text());
//        apiResponse.dispose();

        System.out.println("Second call");
        apiContext.get("users/10");
        System.out.println(apiResponse.text());
    }

    @Test
    void should_return_single_user_as_pojo() {
        APIResponse apiResponse = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(apiResponse).isOK();
        System.out.println(apiResponse.text());

        CreateUserResponse createUserResponse = new Gson().fromJson(apiResponse.text(), CreateUserResponse.class);
        System.out.println(createUserResponse);
    }
}
