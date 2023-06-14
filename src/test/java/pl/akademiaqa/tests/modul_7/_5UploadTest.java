package pl.akademiaqa.tests.modul_7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class _5UploadTest extends BaseTest {

    @Test
    void uploadSingleFileTest() {
        page.navigate("http://localhost:7080/upload");

        page.setInputFiles("#file-upload", Paths.get("upload/zakaz_wjazdu_2.jpeg"));
        page.waitForTimeout(3000);
        page.setInputFiles("#file-upload", new Path[0]); // usunięcie pliku z uploadu
        page.setInputFiles("#file-upload", Paths.get("upload/zakaz_wjazdu_1.jpeg"));
        page.locator("#file-submit").click();
        assertThat(page.getByText("File Uploaded!")).isVisible();
    }

    @Test
    void uploadMultipleFilesTest() {
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

        page.setInputFiles("#filesToUpload", new Path[]{
                Paths.get("upload/zakaz_wjazdu_1.jpeg"),
                Paths.get("upload/zakaz_wjazdu_2.jpeg")});
        page.waitForTimeout(3000);
    }
}
