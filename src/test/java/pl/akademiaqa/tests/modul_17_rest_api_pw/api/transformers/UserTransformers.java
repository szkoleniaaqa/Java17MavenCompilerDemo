package pl.akademiaqa.tests.modul_17_rest_api_pw.api.transformers;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.akademiaqa.tests.modul_17_rest_api_pw.api.response.user.CreateUpdateUserResponse;
import pl.akademiaqa.tests.modul_17_rest_api_pw.api.response.user.GetUserResponse;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTransformers {

    public static GetUserResponse readUserToResponseDto(APIResponse response) {
        return new Gson().fromJson(response.text(), GetUserResponse.class);
    }

    public static CreateUpdateUserResponse createUpdateUserToResponseDto(APIResponse response) {
        return new Gson().fromJson(response.text(), CreateUpdateUserResponse.class);
    }
}
