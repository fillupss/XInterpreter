package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private StringTokenizer tok;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        Program p = new Program();
        ArrayList<String> b = new ArrayList<>();
        String token, line;
        ByteCode code = null;
        try{
            // stringtokenizer to take each string per line and then check if that string represents a bytecode or not
            // if not a bytecode then store in arraylist b, which will be used in the bytecode init() function
            // if it is a bytecode then create an instance of the bytecode and store in program
            while((line = byteSource.readLine()) != null){
                tok = new StringTokenizer(line, " ");
                while(tok.hasMoreTokens()){
                    token = tok.nextToken();
                    if(CodeTable.getClassName(token) != null){
                        String temp = CodeTable.getClassName(token);
                        code = (ByteCode) (Class.forName("interpreter.bytecode." + temp).newInstance());
                        p.addCode(code);
                    }
                    else{
                        b.add(token);
                    }
                }
                code.init(b);
                b.clear();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        p.resolveAddrs();
        return p;
    }
}
