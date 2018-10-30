package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    private String function;
    @Override
    public void init(ArrayList<String> a) {
        if(a.size()!= 0){
            function = a.get(0);
        }

    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.accessRunTimeStack().popFrame();
        vm.setPc(vm.pop());
    }

    @Override
    public void printInstruction() {
        System.out.println("RETURN " + function);
    }
}

