package co.uk.gsck.midi.mapper.Instructions;

public interface Instruction {

    String name = "";
    byte status = 0x00;
    byte note = 0x00;
    byte velocity = 0x00;

    void run();

}
