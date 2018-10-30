package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack; // need to double check if its Integer
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    // print everything that is currently on the runtime stack seperated by frames
    public void dump(){
        // print the values of the runtimestack from the most recent frame to the second last frame
        if(framePointer.size() > 0){
            for(int i = 0; i < framePointer.size()-1; i++){
                System.out.print("[");
                int frameIndex = framePointer.get(i);
                int nextFrameIndex = framePointer.get(i+1);
                for(int j = frameIndex; j < nextFrameIndex; j++){
                    if(j == nextFrameIndex -1){
                        System.out.print(runTimeStack.get(j));
                    }
                    else{
                        System.out.print(runTimeStack.get(j) + ",");
                    }
                }
                System.out.print("]");
            }
            // print the values of the runtimestack on the last frame
            int k = framePointer.peek();
            while(k < runTimeStack.size()){
                if(k == framePointer.peek()){
                    System.out.print("[");
                }
                if(k == runTimeStack.size()-1){
                    System.out.println(runTimeStack.get(k) + "]");
                }
                else{
                    System.out.print(runTimeStack.get(k) + ",");
                }
                k++;
            }
        }
        // case when the same frame is together in the framepointer or for the beginning when there is no value on the
        // runtimestack
        if((framePointer.size() <= 1 && runTimeStack.size() == 0) || (framePointer.peek() == runTimeStack.size())){
            System.out.println("[]");
        }
    }

    public int peek(){
        return this.runTimeStack.get(runTimeStack.size()-1);

    }

    public int pop(){
        int out = 0;
        if(runTimeStack.size() > 0){
            out = this.runTimeStack.remove(runTimeStack.size()-1);
        }
        return out;
    }

    public int push(int i){
        this.runTimeStack.add(i);
        return i;
    }

    public void newFrameAt(int offset){
        framePointer.push(runTimeStack.size()-offset);
    }

    public void popFrame(){
        int value = framePointer.pop();
        int res = runTimeStack.get(runTimeStack.size()-1);
        for(int i = runTimeStack.size()-1; i >= value; i--){
            runTimeStack.remove(i);
        }
        runTimeStack.add(res);
    }

    public int store(int offset){
        int top = this.pop();
        runTimeStack.add(framePointer.peek() + offset ,top);
        return top;
    }

    public int load(int offset){
        this.runTimeStack.add(runTimeStack.get(framePointer.peek() + offset));
        return runTimeStack.get(runTimeStack.size()-1);

    }

    public Integer push(Integer val){
        runTimeStack.add(val);
        return val;
    }



}
