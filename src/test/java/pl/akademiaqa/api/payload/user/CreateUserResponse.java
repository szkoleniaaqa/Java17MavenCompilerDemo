package pl.akademiaqa.api.payload.user;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class CreateUserResponse {

    private int id;
    private String name;
    @SerializedName("username")
    private String userName;
    private String email;
    private String website;

    public CreateUserResponse(int id, String name, String userName, String email, String website) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.website = website;
    }

    @Override
    public String toString() {
        return "CreateUserResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
