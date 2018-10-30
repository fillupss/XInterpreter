package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int value;
    private String var;

    @Override
    public void init(ArrayList<String> a) {
        value = Integer.parseInt(a.get(0));
        if(a.size() == 2){
            var = a.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.accessRunTimeStack().store(value);
    }

    @Override
    public void printInstruction() {
        System.out.println("STORE " + value + " " + var);
    }
}