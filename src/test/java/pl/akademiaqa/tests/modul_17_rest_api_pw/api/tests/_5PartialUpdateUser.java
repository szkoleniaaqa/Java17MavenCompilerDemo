package pl.akademiaqa.tests.modul_17_rest_api_pw.api.tests;

import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.modul_17_rest_api_pw.api.payload.user.CreateUserPayload;
import pl.akademiaqa.common.BaseApiTest;
import pl.akademiaqa.tests.modul_17_rest_api_pw.api.transformers.UserTransformers;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.akademiaqa.tests.modul_17_rest_api_pw.api.assertions.StatusCodeAssertions.assert200;
import static pl.akademiaqa.tests.modul_17_rest_api_pw.api.assertions.StatusCodeAssertions.assert201;

class _5PartialUpdateUser extends BaseApiTest {

    @Test
    void should_update_user_email_test() {
        log.info("STEP 1 - CREATING NEW USER");
        CreateUserPayload user = CreateUserPayload.createDefaultPayload();
        APIResponse createResponse = apiContext.post("users", RequestOptions.create().setData(user));
        assert201(createResponse);
        final var createdUser = UserTransformers.createUpdateUserToResponseDto(createResponse);
        Assertions.assertThat(createdUser.getId()).isNotNull();
        log.info("USER CREATED: " + createdUser);

        log.info("STEP 2 - UPDATING EXISTING USER");
        JsonObject userUpdate = new JsonObject();
        userUpdate.addProperty("email", "bartek@akademiaqa.pl");
        APIResponse updateResponse = apiContext.patch("users/" + createdUser.getId(), RequestOptions.create().setData(userUpdate));
        assert200(updateResponse);

        Assertions.assertThat(UserTransformers.createUpdateUserToResponseDto(updateResponse).getEmail()).isEqualTo("bartek@akademiaqa.pl");
        log.info("Updated user: " + UserTransformers.createUpdateUserToResponseDto(updateResponse));

        log.info("STEP 3 - READING UPDATED USER");
        APIResponse readUpdatedUserResponse = apiContext.get("users/" + createdUser.getId());
        assert200(updateResponse);

        log.info("Read user: " + UserTransformers.readUserToResponseDto(readUpdatedUserResponse));
        Assertions.assertThat(UserTransformers.readUserToResponseDto(readUpdatedUserResponse).getEmail()).isEqualTo("bartek@akademiaqa.pl");
    }
}
