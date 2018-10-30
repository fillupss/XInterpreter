package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public abstract class ByteCode {

    public abstract void init(ArrayList<String> a);

    public abstract void execute(VirtualMachine vm);

    public abstract void printInstruction();

    // toString will be used when comparing byteCode objects during the Program class
    public String toString(){
        return "";
    };


}
