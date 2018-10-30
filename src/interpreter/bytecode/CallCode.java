package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {
    private String function;
    private int dest;
    @Override
    public void init(ArrayList<String> a) {
        function = a.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.push(vm.getPc());
        vm.setPc(dest);
    }

    @Override
    public String toString() {
        return "CallCode";
    }

    public String getFunc(){
        return function;
    }

    public void setDest(int i){
        dest = i;
    }

    @Override
    public void printInstruction() {
        System.out.println("CALL " + function);
    }
}