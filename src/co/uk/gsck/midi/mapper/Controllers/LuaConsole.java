package co.uk.gsck.midi.mapper.Controllers;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;

public class LuaConsole extends OutputStream {

    private TextArea output;

    public LuaConsole(TextArea ta) {
        this.output = ta;
    }

    @Override
    public void write(int i) throws IOException {
        output.appendText(String.valueOf((char) i));
    }
}