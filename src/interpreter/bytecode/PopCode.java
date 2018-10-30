package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    private int levels;

    @Override
    public void init(ArrayList<String> a) {
        levels = Integer.parseInt(a.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        for(int i = 0; i < levels; i++){
            vm.accessRunTimeStack().pop();
        }
    }

    @Override
    public void printInstruction() {
        System.out.println("POP " + levels);
    }
}