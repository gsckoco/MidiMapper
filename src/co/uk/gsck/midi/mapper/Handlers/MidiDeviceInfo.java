package co.uk.gsck.midi.mapper.Handlers;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;

public class MidiDeviceInfo {
    private MidiDevice.Info info;
    private int id;
    public MidiDeviceInfo(MidiDevice.Info info, int id) {
        this.info = info;
        this.id = id;
    }

    public MidiDevice.Info getInfo() {
        return info;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return this.info.getName();
    }

    public MidiDevice getDevice() throws MidiUnavailableException {
        return MidiSystem.getMidiDevice(this.info);
    }
}
