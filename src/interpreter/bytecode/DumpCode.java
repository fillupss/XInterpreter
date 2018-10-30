package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    private String status;

    @Override
    public void init(ArrayList<String> a) {
        status = a.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if(status.equals("ON")){
            vm.isDumping(true);
        }
        else{
            vm.isDumping(false);
        }
    }

    @Override
    public void printInstruction() {
        System.out.println("DUMP " + status);
    }
}
