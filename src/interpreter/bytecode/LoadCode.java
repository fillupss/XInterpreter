package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    private int level;
    private String var;
    @Override
    public void init(ArrayList<String> a) {
        level = Integer.parseInt(a.get(0));
        if(a.size() == 2){
            var = a.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.accessRunTimeStack().load(level);
    }

    @Override
    public void printInstruction() {
        System.out.println("LOAD" + level + " " + var);
    }
}
