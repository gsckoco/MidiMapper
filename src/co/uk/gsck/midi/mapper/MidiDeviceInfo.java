package co.uk.gsck.midi.mapper;

import javax.sound.midi.MidiDevice;

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
}
