package com.example.personalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //inserting the editText where the user will input
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inserting the display text
        display = findViewById(R.id.textView);

        //using a function to get rid of the keyboard when they try to enter some text, setting it to false
        display.setShowSoftInputOnFocus(false);

        //getting rid of the text in the display when the user clicks on it
        display.setOnClickListener(view -> {
            //if statement to see if it is equal to
            if (getString(R.string.display).equals(display.getText().toString())) {
                display.setText("");
            }
        });
    }


    //creating the string to add method to add the input wherever the user inserts it
    private void updateText (String strToAdd)
    {
        //storing the original version of the string
        String oldStr = display.getText().toString();
        //using an int to get the index of the cursor
        int cursorPos = display.getSelectionStart();
        //dividing the string by the left and right side depending on the cursor pos
        String leftStr = oldStr.substring(0,cursorPos);
        //getting the right side
        String rightStr = oldStr.substring(cursorPos);


        //using if statements to set clear the default text when started
        if (getString(R.string.display).equals(display.getText().toString()))
        {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);

        }
        //else, do it normally
        else
        {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

    public void zeroBtn(View view)
    {
        //using the update text to add the buttons
        updateText("0");

    }

    //method for all the buttons
    public void oneBtn(View view)
    {
        //using the update text to add the buttons
        updateText("1");

    }

    public void twoBtn(View view)
    {
        //using the update text to add the buttons
        updateText("2");

    }

    public void threeBtn(View view)
    {
        //using the update text to add the buttons
        updateText("3");

    }

    public void fourBtn(View view)
    {
        //using the update text to add the buttons
        updateText("4");

    }

    public void fiveBtn(View view)
    {
        //using the update text to add the buttons
        updateText("5");

    }

    public void sixBtn(View view)
    {
        //using the update text to add the buttons
        updateText("6");

    }

    public void sevenBtn(View view)
    {
        //using the update text to add the buttons
        updateText("7");

    }

    public void eightBtn(View view)
    {
        //using the update text to add the buttons
        updateText("8");

    }

    public void nineBtn(View view)
    {
        //using the update text to add the buttons
        updateText("9");

    }

    //method for all of the other buttons
    public void clearBtn(View view)
    {
        //setting the display to nothing
        display.setText("");

    }

    public void parenthesesBtn(View view)
    {
        //getting the cursor pos
        int cursorPos  = display.getSelectionStart();
        //creating the variables for open and closed parentheses
        int openPar = 0;
        int closedPar = 0;

        //getting the text length
        int textLen = display.getText().length();

        //creating a for loop to go through and check for open and closed parentheses
        for (int i = 0; i < cursorPos; i++)
        {
            //if statement to see if there is an open parentheses
            if (display.getText().toString().charAt(i) == '(')
            {
                //add one to the open parentheses
                openPar += 1;
            }
            //if statement to see if there is an closed parentheses
            if (display.getText().toString().charAt(i) == ')')
            {
                //add one to the open parentheses
                closedPar += 1;
            }

        }

        //if they equal each other
        if (openPar == closedPar || display.getText().toString().charAt(textLen - 1) == '(')
        {
            //add another parentheses
            updateText("(");
        }
        //if they dont equal each other
        else if (closedPar < openPar && display.getText().toString().charAt(textLen - 1) != '(')
        {
            //add another parentheses
            updateText(")");
        }
        display.setSelection(cursorPos + 1);

    }

    public void exponentBtn(View view)
    {
        //using the update text to add the buttons
        updateText("^");

    }

    public void divideBtn(View view)
    {
        //using the update text to add the buttons
        updateText("÷");

    }

    public void multiplyBtn(View view)
    {
        //using the update text to add the buttons
        updateText("*");

    }

    public void minusBtn(View view)
    {
        //using the update text to add the buttons
        updateText("-");

    }

    public void addBtn(View view)
    {
        //using the update text to add the buttons
        updateText("+");

    }

    public void equalsBtn(View view)
    {
        //using the update text to add the buttons
        updateText("=");

    }

    public void plusMinusBtn(View view)
    {
        //using the update text to add the buttons
        updateText("+/-");

    }

    public void pointBtn(View view)
    {
        //using the update text to add the buttons
        updateText(".");

    }

    public void backspaceBtn(View view)
    {
        //getting the index of the cursor
        int cursorPos = display.getSelectionStart();
        //getting the length of the string
        int textLen = display.getText().length();

        //if there is no text then create a new spannable
        if (cursorPos != 0 && textLen != 0)
        {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }

    }


}