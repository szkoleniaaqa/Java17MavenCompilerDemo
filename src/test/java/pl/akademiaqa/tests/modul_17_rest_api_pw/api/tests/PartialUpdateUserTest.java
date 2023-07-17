package pl.akademiaqa.tests.modul_17_rest_api_pw.api.tests;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.modul_17_rest_api_pw.api.payload.user.CreateUserPayload;
import pl.akademiaqa.tests.modul_17_rest_api_pw.api.response.user.CreateUpdateUserResponse;
import pl.akademiaqa.common.BaseApiTest;

class PartialUpdateUserTest extends BaseApiTest {

    @Test
    void updateUserTest() {
        APIResponse createResponse = apiContext.post("users",
                RequestOptions.create()
                        .setData(CreateUserPayload.createDefaultPayload()));

        PlaywrightAssertions.assertThat(createResponse).isOK();
        Assertions.assertThat(createResponse.status()).isEqualTo(201);
        CreateUpdateUserResponse createUserResponse = new Gson().fromJson(createResponse.text(), CreateUpdateUserResponse.class);
        Assertions.assertThat(createUserResponse.getId()).isNotNull();

        JsonObject updateUserPayload = new JsonObject();
        updateUserPayload.addProperty("email", "bartek123@bartek123.pl");

        APIResponse updateResponse = apiContext.patch("users/" + createUserResponse.getId(),
                RequestOptions.create()
                        .setData(updateUserPayload));

        PlaywrightAssertions.assertThat(updateResponse).isOK();
        Assertions.assertThat(updateResponse.status()).isEqualTo(200);

        CreateUpdateUserResponse updateUserResponse = new Gson().fromJson(updateResponse.text(), CreateUpdateUserResponse.class);
        Assertions.assertThat(updateUserPayload.get("email").getAsString()).isEqualTo(updateUserResponse.getEmail());

        System.out.println(updateResponse.text());
    }
}
