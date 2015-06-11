/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 */
public class Calculator extends java.util.Observable {
   String count ="",c; 
   int x,y;
   
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
     /**顯示數字
      * 
      */
    public void appendDigit(int digit) {
        count += String.valueOf(digit);
        getDisplay();
       
    }
    /**顯示點.
     * 
     * @param s 
     */
    public void appendDot(String s) {
        count += String.valueOf(s);
        getDisplay();
    }
    /**加減乘除的功能
     * 
     * @param operator 
     */
    public void performOperation(Operator operator) {
        /**
         * 這裡是加+
         */
        if(operator == Operator.PLUS)
        {
           x  = Integer.parseInt(count);
           count = "";
           c ="+";
           getDisplay();
           
        }
        /**
         * 這裡是減-
         */
        if(operator == Operator.MINUS)
        {
           x  = Integer.parseInt(count);
           count = "";
           c ="-";
           getDisplay();
        }
        /**
         * 這裡是乘*
         */
        if(operator == Operator.TIMES)
        {
           x  = Integer.parseInt(count);
           count = "";
           c ="*";
           getDisplay();
        }
        /**
         * 這裡是除/
         */
        if(operator == Operator.OVER)
        {
           x  = Integer.parseInt(count);
           count = "";
           c ="/";
           getDisplay();
        }
        /**
         * 這裡是等於=
         * 依各種運算符號來判斷執行的結果
         */
        if(operator == Operator.EQUAL)
        {
            if(c =="+")
            {
            y = Integer.parseInt(count);
            count = String.valueOf(x+y);
            getDisplay();
            count = "";
            }
            if(c =="-")
            {
            y = Integer.parseInt(count);
            count = String.valueOf(x-y);
            getDisplay();
            count = "";
            }
            if(c =="*")
            {
            y = Integer.parseInt(count);
            count = String.valueOf(x*y);
            getDisplay();
            count = "";
            }
            if(c =="/")
            {
            y = Integer.parseInt(count);
            count = String.valueOf(x/y);
            getDisplay();
            count = "";
            }
        }
        
    }
    /**
     * 更新回傳值
     * @return 
     */
    public String getDisplay() {
        // TODO code application logic here
        setChanged();
        notifyObservers(count);
        return null;
    }
    /**
     * 依傳過來的運算符號來判斷執行哪一種運算符號的程式
     * @param operator 
     */
    public void operator(String operator)
    {
        if(operator == "+") performOperation(Operator.PLUS);
        if(operator == "-") performOperation(Operator.MINUS);
        if(operator == "=") performOperation(Operator.EQUAL);
        if(operator == "*") performOperation(Operator.TIMES);
        if(operator == "/") performOperation(Operator.OVER);
    }
   

}
