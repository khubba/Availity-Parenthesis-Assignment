package com.company;

public class Main {

    public static void main(String[] args) {
        String TestLisp = args[0];

        System.out.println("Evaluating input string of \"" + TestLisp + "\" for parenthetical validity.");

        //The goal is to evaluate the validity of parenthesis
        //My first step would be to remove all of the characters that are not '(' or ')' they are not relevant

        String TestListOnlyParenthesis = TestLisp.replaceAll("[^()]", "");

        System.out.println("This is the string with every character but \'(\' and \')\'  removed from it, \"" + TestListOnlyParenthesis + "\"");

        //Initial Idea #1
        //Now that i only have the parenthesis I just want to make sure Opens are before closes and everything nests properly.
        //My logic is to just have a counter that starts at 0, then add 1 every time I see a '(' and subtract 1 every time I see a ')'.
        //at the end of the string my total should be 0, also if at any time my counter goes negative its an instant fail because you have tried to close a group which was never opened.

        boolean TestLispIsValid = true;
        int ParenthesisCounter = 0;
        //ive been in .NET for a while. I had to look up how to iterate through the characters in a string.
        for (char ch: TestListOnlyParenthesis.toCharArray()){
            if(ch == '('){
                ParenthesisCounter++;
            }
            if(ch == ')'){
                ParenthesisCounter--;
            }
            if(ParenthesisCounter < 0){
                TestLispIsValid = false;
            }
        }
        if (ParenthesisCounter != 0){
            TestLispIsValid = false;
        }

        if(TestLispIsValid){
            System.out.println("Lisp inputed is valid, tested with a loop");
        }
        else{
            System.out.println("Lisp inputed is not valid from the loop test.");
        }



        //Second solution after half way through the first.
        //another way that I could complete this is to recursivly remove every instance of "()" until there are no more "()".
        //If at the end I do not have any characters in my parenthesis string then the string is valid.
        String TestLispParenthsisRemoved = RecursivlyRemoveParenthesisPairs(TestListOnlyParenthesis);
        if(TestLispParenthsisRemoved.equals("")){
            System.out.println("Lisp inputed is valid, tested recursivly");
        }
        else{
            System.out.println("Lisp inputed is not valid from the recursive test.");
        }
    }

    public static String RecursivlyRemoveParenthesisPairs(String ParenthesisInput){
        if(!ParenthesisInput.contains("()")){
            return ParenthesisInput;
        }
        else{
            String ParenthsisRemoved = ParenthesisInput.replace("()", "");
            return RecursivlyRemoveParenthesisPairs(ParenthsisRemoved);
        }
    }
}
