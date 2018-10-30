package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    private int levels;

    @Override
    public void init(ArrayList<String> a) {
        levels = Integer.parseInt(a.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.accessRunTimeStack().newFrameAt(levels);
    }

    @Override
    public void printInstruction() {
        System.out.println("ARGS " + levels);
    }
}
