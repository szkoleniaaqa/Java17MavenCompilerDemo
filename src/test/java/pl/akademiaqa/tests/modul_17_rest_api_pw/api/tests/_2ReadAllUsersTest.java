package pl.akademiaqa.tests.modul_17_rest_api_pw.api.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.modul_17_rest_api_pw.api.response.user.GetUserResponse;
import pl.akademiaqa.common.BaseApiTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class _2ReadAllUsersTest extends BaseApiTest {

    @Test
    void should_return_list_of_users_response_test() {
        APIResponse apiResponse = apiContext.get("users");
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        System.out.println(apiResponse.text());
    }

    @Test
    void should_return_list_of_users_gson_test() {
        APIResponse apiResponse = apiContext.get("users");
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        JsonArray jsonArray = new Gson().fromJson(apiResponse.text(), JsonArray.class);
        System.out.println(jsonArray);

        System.out.println(jsonArray.get(0).getAsJsonObject().get("email"));

        List<String> emails = jsonArray.asList()
                .stream()
                .map(el -> el.getAsJsonObject().get("email").getAsString())
                .collect(Collectors.toList());

        System.out.println(emails);
        Assertions.assertThat(emails).contains("Lucio_Hettinger@annie.ca");
    }

    @Test
    void should_return_list_of_users_jackson_test() throws IOException {

        APIResponse apiResponse = apiContext.get("users");
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        // JACKSON-DATABIND - zamiana odpowiedzi na JsonNode
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(apiResponse.body());
        System.out.println(jsonNode.toPrettyString());
        System.out.println(jsonNode.get(0).get("email"));
    }

    @Test
    void should_return_list_of_users_dto_test() {

        APIResponse apiResponse = apiContext.get("users");
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        // zamiana odpowiedzi na dto - GSON
        List<GetUserResponse> users = Arrays.asList(new Gson().fromJson(apiResponse.text(), GetUserResponse[].class));
        System.out.println(users);

        // zamiana odpowiedzi na dto - stream()
        JsonArray jsonArray = new Gson().fromJson(apiResponse.text(), JsonArray.class);
        List<GetUserResponse> users1 = jsonArray.asList()
                .stream()
                .map(el -> new GetUserResponse(
                        el.getAsJsonObject().get("id").getAsInt(),
                        el.getAsJsonObject().get("name").getAsString(),
                        el.getAsJsonObject().get("username").getAsString(),
                        el.getAsJsonObject().get("email").getAsString()
                ))
                .collect(Collectors.toList());

        System.out.println(users1);
    }

    @Test
    void should_return_list_of_users_with_query_params_test() {
        APIResponse apiResponse = apiContext.get("users", RequestOptions.create().setQueryParam("username", "Bret"));
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        System.out.println(apiResponse.text());
    }
}
