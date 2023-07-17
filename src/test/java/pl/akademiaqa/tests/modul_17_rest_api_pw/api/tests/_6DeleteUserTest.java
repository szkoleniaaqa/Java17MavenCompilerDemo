package pl.akademiaqa.tests.modul_17_rest_api_pw.api.tests;

import com.microsoft.playwright.APIResponse;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.modul_17_rest_api_pw.api.facades.user.CreateUserAPIFacade;
import pl.akademiaqa.common.BaseApiTest;

import static pl.akademiaqa.tests.modul_17_rest_api_pw.api.assertions.StatusCodeAssertions.*;

class _6DeleteUserTest extends BaseApiTest {

    @Test
    void should_delete_existing_user_test() {
        final var createdUser = CreateUserAPIFacade.createUser(apiContext);

        log.info("STEP 2 - DELETING EXISTING USER");
        final var deleteResponse = apiContext.delete("users/" + createdUser.getId());
        assert200(deleteResponse);

        log.info("STEP 3 - READING DELETED USER");
        APIResponse readUpdatedUserResponse = apiContext.get("users/" + createdUser.getId());
        assert404(readUpdatedUserResponse);
    }
}
