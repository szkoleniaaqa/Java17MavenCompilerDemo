package pl.akademiaqa.tests.modul_8.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ContactUsDTO {

    private String subjectHeading;
    private String emailAddress;
    private String orderReference;
    private String fileToUpload;
    private String message;

    public static ContactUsDTO getDefaultContactUsDTO() {
        return ContactUsDTO.builder()
                .subjectHeading("Webmaster")
                .emailAddress("demo@demo.com")
                .orderReference("12345")
                .fileToUpload("upload/zakaz_wjazdu_2.jpeg")
                .message("This is sample message")
                .build();
    }
}
