package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    private String operator;
    @Override
    public void init(ArrayList<String> a) {
        operator = a.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        // we will assume that true is value 1 and false is value 0 in cases where we use logic operators
        int operand1 = vm.accessRunTimeStack().pop();
        int operand2 = vm.accessRunTimeStack().pop();
        int res = 0;
        if(operator.equals("+")){
            res = operand2 + operand1;
        }
        else if(operator.equals("-")){
            res = operand2 - operand1;
        }
        else if(operator.equals("/")){
            res = operand2 / operand1;
        }
        else if(operator.equals("*")){
            res = operand2 * operand1;
        }
        else if(operator.equals("==")){
            if(operand2 == operand1){
                res = 1;
            }
            else{
                res = 0;
            }
        }
        else if(operator.equals("!=")){
            if(operand2 != operand1){
                res = 1;
            }
            else{
                res = 0;
            }
        }
        else if(operator.equals("<=")){
            if(operand2 <= operand1){
                res = 1;
            }
            else{
                res = 0;
            }
        }
        else if(operator.equals(">")){
            if(operand2 > operand1){
                res = 1;
            }
            else{
                res = 0;
            }
        }
        else if(operator.equals(">=")){
            if(operand2 >= operand1){
                res = 1;
            }
            else{
                res = 0;
            }
        }
        else if(operator.equals("<")){
            if(operand2 < operand1){
                res = 1;
            }
            else{
                res = 0;
            }
        }
        else if(operator.equals("|")){
            if(operand2 > 0 || operand1 > 0){
                res = 1;
            }
            else{
                res = 0;
            }
        }
        else if(operator.equals("&")){
            if(operand2 > 0 && operand1 > 0){
                res = 1;
            }
            else {
                res = 0;
            }
        }
        else{
            System.out.println("Not a valid input.");
        }
        vm.accessRunTimeStack().push(res);
    }

    @Override
    public void printInstruction() {
        System.out.println("BOP " + operator);
    }
}