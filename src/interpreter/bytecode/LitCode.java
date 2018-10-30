package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    private int value;

    @Override
    public void init(ArrayList<String> a) {
        value = Integer.parseInt(a.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.accessRunTimeStack().push(value);
    }

    @Override
    public void printInstruction() {
        System.out.println("LIT " + value);
    }
}