package pl.akademiaqa.api.payload.user;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUserPayload {
    private String name;
    @SerializedName("username")
    private String userName;
    private String email;

    public static CreateUserPayload createDefaultPayload() {
        return CreateUserPayload.builder()
                .name("Joe Black")
                .userName("jblack")
                .email("default@email.com")
                .build();
    }
}
