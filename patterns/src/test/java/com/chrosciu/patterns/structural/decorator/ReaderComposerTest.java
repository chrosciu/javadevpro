package com.chrosciu.patterns.structural.decorator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ReaderComposerTest {
    private final String originalText = "Marcin Chrost";
    private final InputStream inputStream = new ByteArrayInputStream(originalText.getBytes());
    private final Reader reader = new InputStreamReader(inputStream);

    @Test
    public void rawTest() {
        ReaderComposer readerComposer = new ReaderComposer(false, false);
        Reader composedReader = readerComposer.compose(reader);
        String text = composedReader.getText();
        Assertions.assertThat(text).isEqualTo("Marcin Chrost");
    }

    @Test
    public void lowerCaseTest() {
        ReaderComposer readerComposer = new ReaderComposer(true, false);
        Reader composedReader = readerComposer.compose(reader);
        String text = composedReader.getText();
        Assertions.assertThat(text).isEqualTo("marcin chrost");
    }

    @Test
    public void underscoreTest() {
        ReaderComposer readerComposer = new ReaderComposer(false, true);
        Reader composedReader = readerComposer.compose(reader);
        String text = composedReader.getText();
        Assertions.assertThat(text).isEqualTo("Marcin_Chrost");
    }

    @Test
    public void lowerCaseAndUnderscoreTest() {
        ReaderComposer readerComposer = new ReaderComposer(true, true);
        Reader composedReader = readerComposer.compose(reader);
        String text = composedReader.getText();
        Assertions.assertThat(text).isEqualTo("marcin_chrost");
    }
}
