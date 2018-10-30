package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    private int input;

    @Override
    public void init(ArrayList<String> a) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        Scanner r = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        if(r.hasNextInt()){
            input = r.nextInt();
            vm.accessRunTimeStack().push(input);
        }
        else{
            System.out.println("Not an Integer!!!!");
            vm.setIsRunning(false);
        }
    }

    @Override
    public void printInstruction() {
        System.out.println("READ ");
    }
}