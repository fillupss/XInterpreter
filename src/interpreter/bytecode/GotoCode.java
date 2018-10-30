package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {
    private String func;
    private int dest;

    @Override
    public void init(ArrayList<String> a) {
        func = a.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setPc(dest);
    }

    @Override
    public String toString() {
        return "GotoCode";
    }

    public String getFunc(){
        return func;
    }

    public void setDest(int i){
        dest = i;
    }

    @Override
    public void printInstruction() {
        System.out.println("GOTO " + func);
    }
}