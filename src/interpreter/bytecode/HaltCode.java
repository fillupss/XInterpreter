package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode{

    @Override
    public void init(ArrayList<String> a) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setIsRunning(false);
    }

    @Override
    public void printInstruction() {
        System.out.println("HALT");
    }
}
