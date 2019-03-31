package co.uk.gsck.midi.mapper.Handlers

import co.uk.gsck.midi.mapper.Controllers.Main
import javafx.application.Platform
import javax.sound.midi.MidiMessage
import javax.sound.midi.Receiver

class MidiCallback : Receiver {
    var main: Main? = null;
    constructor(main: Main) {
        this.main = main;
    }

    override fun send(message: MidiMessage?, timeStamp: Long) {
        var bytes : ByteArray = message!!.message;
        System.out.println("${bytes[0]}, ${bytes[1]}, ${bytes[2]}")

        Platform.runLater {
            main!!.setLastMIDIMessage("${bytes[0]}, ${bytes[1]}, ${bytes[2]}");
        }

    }

    override fun close() {

    }
}