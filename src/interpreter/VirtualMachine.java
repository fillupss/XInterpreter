package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning, isDumping;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        isRunning = true;
        isDumping = true;
        while(isRunning){
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if(isDumping){
                code.printInstruction();
                runStack.dump();
            }
            pc++;
        }
    }

    public void setIsRunning(boolean status){
        isRunning = status;
    }

    public boolean isDumping(boolean status){
        return isDumping = status;
    }

    // need to create this function so that the virtual machine can have access to the runTimeStack when
    // called from the byteCodes
    public RunTimeStack accessRunTimeStack(){
        return runStack;
    }

    // these two functions mainly used for byteCodes that involves branching
    public void setPc(int i){
        this.pc = i;
    }

    public int getPc(){
        return pc;
    }

    // these two functions used for CallCode
    public void push(int i){
        this.returnAddrs.push(i);
    }

    public int pop(){
        return this.returnAddrs.pop();
    }

}