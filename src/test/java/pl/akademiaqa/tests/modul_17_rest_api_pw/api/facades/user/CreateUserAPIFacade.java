package pl.akademiaqa.tests.modul_17_rest_api_pw.api.facades.user;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.tests.modul_17_rest_api_pw.api.payload.user.CreateUserPayload;
import pl.akademiaqa.tests.modul_17_rest_api_pw.api.response.user.CreateUpdateUserResponse;
import pl.akademiaqa.tests.modul_17_rest_api_pw.api.transformers.UserTransformers;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.akademiaqa.tests.modul_17_rest_api_pw.api.assertions.StatusCodeAssertions.assert201;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserAPIFacade {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CreateUserAPIFacade.class);

    public static CreateUpdateUserResponse createUser(APIRequestContext apiContext) {
        log.info("STEP 1 - CREATING NEW USER");
        CreateUserPayload user = CreateUserPayload.createDefaultPayload();
        APIResponse createResponse = apiContext.post("users", RequestOptions.create().setData(user));
        assert201(createResponse);
        final var createdUser = UserTransformers.createUpdateUserToResponseDto(createResponse);
        Assertions.assertThat(createdUser.getId()).isNotNull();
        log.info("USER CREATED: " + createdUser);

        return createdUser;
    }
}
