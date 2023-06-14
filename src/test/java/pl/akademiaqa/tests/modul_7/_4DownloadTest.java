package pl.akademiaqa.tests.modul_7;

import com.microsoft.playwright.Download;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

import java.nio.file.Paths;

public class _4DownloadTest extends BaseTest {

    // Są dwie możliwości ściągania plików.
    // JEDEN: Tak jak w dialogu: zarejestrowanie handlera i potem kliknięcie

    // DRUGI: Klilknięcie, poczekanie aż się ściągnie i zapisanie pliku.
    // PW domyślnie ściąga plik do tmp i po usunięciu kontekstu - usuwa plik.
    // Trzba go gdzieś zapisać na stałe!

    @Test
    void downloadWithHandlerTest() {
        page.navigate("http://localhost:7080/download");

        // 1. Utworzenie handlera, i powiedzenie co będzie zrobione, a dopiero potem kliknięcie w download.
        page.onDownload(download -> {
            download.saveAs(Paths.get("downloads/some-file.txt"));
        });
        page.getByText("some-file.txt").click();
    }

    @Test
    void downloadWithSaveTest() {
        page.navigate("http://localhost:7080/download");

        // 2. Kliknięcie a potem zapisanie.
        Download download = page.waitForDownload(() -> page.getByText("some-file.txt").click());
        download.saveAs(Paths.get("downloads/some-file.txt"));
    }
}
