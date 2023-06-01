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

public class CreateUserTest extends BaseApiTest {


    @Test
    void should_create_user() {
//        CreateUserPayload createUserPayload = new CreateUserPayload("Jan", "Kowalski", "jan@kowalski.pl");
//        CreateUserPayload createUserPayload = CreateUserPayload.builder()
//                .name("Jan")
//                .userName("Kowalski")
//                .email("jan@kowalski.pl")
//                .build();

        CreateUserPayload createUserPayload = CreateUserPayload.createDefaultPayload();
        System.out.println(createUserPayload);

        APIResponse response = apiContext.post("users",
                RequestOptions.create()
                        .setData(createUserPayload));

        PlaywrightAssertions.assertThat(response).isOK();
        Assertions.assertThat(response.status()).isEqualTo(201);

        System.out.println(response.text());
        CreateUserResponse createUserResponse = new Gson().fromJson(response.text(), CreateUserResponse.class);
        Assertions.assertThat(createUserPayload.getName()).isEqualTo(createUserResponse.getName());
        Assertions.assertThat(createUserResponse.getId()).isNotNull();
    }
}
