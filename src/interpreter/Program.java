package interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interpreter.bytecode.*;


public class Program {

    private ArrayList<ByteCode> program;
    private String[] add;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    // method to access the ArrayList
    public void addCode(ByteCode c){
        program.add(c);
    }

    public int getSize() {
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {
        // first we need to understand that branching will result at the label bytecode
        // as a result we need to determine where the program counter is at for each label
        // also we need to know what the instance variable is stored at the init() function for labelCode(function name)
        // after working with the pc and function name, we will store the function name to a string array
        // and set it at the index of where the pc is at.
        add = new String[getSize()];

        for(int i = 0; i < program.size(); i++){
            if(getCode(i).toString().equals("LabelCode")){
                LabelCode temp = (LabelCode) getCode(i);
                add[i] = temp.display();
            }
        }
        // change from array to list so we can get the index of the function name from label
        List<String> address = Arrays.asList(add);

        // we will consider the bytecodes that work with branching; GotoCode, FalseBranchCode, and CallCode
        // each of those have a function name stored in their instance variable so we need to connect that
        // to the pc we found earlier when working with LabelCode
        for(int j = 0; j < program.size(); j++){
            if(getCode(j).toString().equals("GotoCode")){
                int something = address.indexOf(((GotoCode) getCode(j)).getFunc());
                ((GotoCode) getCode(j)).setDest(something);
            }
            else if(getCode(j).toString().equals("FalseBranchCode")){
                int some = address.indexOf(((FalseBranchCode)getCode(j)).getFunc());
                ((FalseBranchCode) getCode(j)).setDest(some);
            }
            else if(getCode(j).toString().equals("CallCode")){
                int link = address.indexOf(((CallCode)getCode(j)).getFunc());
                ((CallCode) getCode(j)).setDest(link);
            }
        }

    }




}
