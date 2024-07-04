import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberbutton = new JButton[10];
    JButton[] funcbutton = new JButton[9];
    JButton addButton, subButton, multiButton, divButton;
    JButton decButton, equalButton, delButton, clearButton, negativeButton;
    JPanel panel;
    Font myfont = new Font("Ink Free", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operators;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myfont);
        textfield.setEditable(false);
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.GREEN);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("*");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("Del");
        clearButton = new JButton("Clr");
        negativeButton = new JButton("(-)");

        funcbutton[0] = addButton;
        funcbutton[1] = subButton;
        funcbutton[2] = multiButton;
        funcbutton[3] = divButton;
        funcbutton[4] = decButton;
        funcbutton[5] = equalButton;
        funcbutton[6] = delButton;
        funcbutton[7] = clearButton;
        funcbutton[8] = negativeButton;

        Color funcButtonColor = new Color(255, 165, 0); // Orange color
        for (int i = 0; i < 9; i++) {
            funcbutton[i].addActionListener(this);
            funcbutton[i].setFont(myfont);
            funcbutton[i].setFocusable(false);
            funcbutton[i].setBackground(funcButtonColor);
            funcbutton[i].setForeground(Color.BLACK);
        }
        Color numberButtonColor = new Color(173, 216, 230); // Light Blue color
        for (int j = 0; j < 10; j++) {
            numberbutton[j] = new JButton(String.valueOf(j));
            numberbutton[j].addActionListener(this);
            numberbutton[j].setFont(myfont);
            numberbutton[j].setFocusable(false);
            numberbutton[j].setBackground(numberButtonColor);
            numberbutton[j].setForeground(Color.BLACK);
        }

        negativeButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clearButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.DARK_GRAY);

        panel.add(numberbutton[1]);
        panel.add(numberbutton[2]);
        panel.add(numberbutton[3]);
        panel.add(addButton);
        panel.add(numberbutton[4]);
        panel.add(numberbutton[5]);
        panel.add(numberbutton[6]);
        panel.add(subButton);
        panel.add(numberbutton[7]);
        panel.add(numberbutton[8]);
        panel.add(numberbutton[9]);
        panel.add(multiButton);
        panel.add(decButton);
        panel.add(numberbutton[0]);
        panel.add(equalButton);
        panel.add(divButton);

        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        frame.add(panel);
        frame.add(negativeButton);
        frame.add(delButton);
        frame.add(clearButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberbutton[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operators = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operators = '-';
            textfield.setText("");
        }
        if (e.getSource() == multiButton) {
            num1 = Double.parseDouble(textfield.getText());
            operators = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operators = '÷';
            textfield.setText("");
        }
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textfield.getText());
            switch (operators) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '÷':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clearButton) {
            textfield.setText("");
        }
        if (e.getSource() == delButton) {
            String str = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                textfield.setText(textfield.getText() + str.charAt(i));
            }
        }
        if (e.getSource() == negativeButton) {
            double te = Double.parseDouble(textfield.getText());
            te = te * (-1);
            textfield.setText(String.valueOf(te));
        }
    }
}
