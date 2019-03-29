package co.uk.gsck.midi.mapper.Instructions;

abstract class Instruction {

    private String instructionName = "";

    public Instruction(String name, byte status, byte d1) {
        this.instructionName = name;
    }

}
