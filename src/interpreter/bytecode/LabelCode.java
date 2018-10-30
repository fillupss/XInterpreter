package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    private String name;
    @Override
    public void init(ArrayList<String> a) {
        name = a.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    public String toString() {
        return "LabelCode";
    }

    public String display(){
        return name;
    }

    @Override
    public void printInstruction() {
        System.out.println("LABEL " + name);
    }
}
