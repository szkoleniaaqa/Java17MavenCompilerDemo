package pl.akademiaqa.api.tests;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.api.payload.user.CreateUserPayload;
import pl.akademiaqa.api.payload.user.CreateUserResponse;
import pl.akademiaqa.common.BaseApiTest;

class UpdateUserTest extends BaseApiTest {

    @Test
    void updateUserTest() {
        CreateUserPayload createUserPayload = new CreateUserPayload();
        createUserPayload.setName("Jan");

        APIResponse createResponse = apiContext.post("users",
                RequestOptions.create()
                        .setData(createUserPayload));

        PlaywrightAssertions.assertThat(createResponse).isOK();
        Assertions.assertThat(createResponse.status()).isEqualTo(201);
        CreateUserResponse createUserResponse = new Gson().fromJson(createResponse.text(), CreateUserResponse.class);
        Assertions.assertThat(createUserResponse.getId()).isNotNull();

        createUserPayload.setEmail("bartek@akademiaqa.pl");
        System.out.println("UPDATE PAYLOAD: " + createUserPayload);

        APIResponse updateResponse = apiContext.put("users/" + createUserResponse.getId(),
                RequestOptions.create()
                        .setData(createUserPayload));

        PlaywrightAssertions.assertThat(updateResponse).isOK();
        Assertions.assertThat(updateResponse.status()).isEqualTo(200);

        CreateUserResponse updateUserResponse = new Gson().fromJson(updateResponse.text(), CreateUserResponse.class);
        Assertions.assertThat(createUserPayload.getEmail()).isEqualTo(updateUserResponse.getEmail());

        System.out.println(updateResponse.text());
    }
}
