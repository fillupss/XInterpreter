package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
    private String instruction;
    private int dest;

    @Override
    public void init(ArrayList<String> a) {
        instruction = a.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int condition = vm.accessRunTimeStack().pop();
        if(condition == 0){
            vm.setPc(dest); // change later
        }
    }

    @Override
    public String toString() {
        return "FalseBranchCode";
    }

    public String getFunc(){
        return instruction;
    }

    public void setDest(int i){
        dest = i;
    }

    @Override
    public void printInstruction() {
        System.out.println("FALSEBRANCH " + instruction);
    }
}
