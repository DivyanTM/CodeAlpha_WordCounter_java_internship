package lib;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter {
    private JFrame frame;
    private JLabel title, character, word;
    private JTextArea textArea;
    private JButton btn;
    private JButton clear;

    private WordCounter() {
        frame = new JFrame("Word Counter - CodeAlpha Task1");
        frame.getContentPane().setBackground(new Color(197, 215, 248));
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title = new JLabel("<html><font size='8' color=blue>WORD COUNTER</font></html>");
        title.setBounds(250, 50, 500, 80);
        frame.add(title);

        textArea = new JTextArea(20, 30);
        textArea.setBounds(35, 200, 700, 200);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        Border blackBorder = new LineBorder(Color.black);
        Border blueBorder = new LineBorder(new Color(22, 95, 119));
        textArea.setBorder(blackBorder);
        frame.add(textArea);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(35, 200, 700, 200);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(scrollPane);

        Font font = new Font("Arial", Font.PLAIN, 16);
        textArea.setFont(font);

        Font titleFont = new Font("Arial", Font.BOLD, 18);
        title.setFont(titleFont);

        character = new JLabel();
        character.setBounds(35, 420, 300, 50);
        frame.add(character);

        word = new JLabel();
        word.setBounds(35, 470, 300, 50);
        frame.add(word);

        btn = new JButton("CALCULATE");
        btn.setBounds(120, 550, 250, 50);
        btn.setBackground(Color.PINK);
        btn.setBorder(blueBorder);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int words = 0;
                int characters = text.length();
                String[] str = text.split("\\s");
                words = str.length;

                word.setText("WORDS : " + words);
                character.setText("CHARACTERS : " + characters);
                word.setFont(titleFont);
                character.setFont(titleFont);
                word.setForeground(new Color(63, 9, 9));
                character.setForeground(new Color(63, 9, 9));

            }
        });

        clear = new JButton("CLEAR");
        clear.setBounds(420, 550, 250, 50);
        clear.setBackground(Color.PINK);
        clear.setBorder(blueBorder);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");

                word.setText("WORDS : ");
                character.setText("CHARACTERS : ");
                word.setFont(titleFont);
                character.setFont(titleFont);
                word.setForeground(new Color(63, 9, 9));
                character.setForeground(new Color(63, 9, 9));
            }
        });

        frame.add(btn);
        frame.add(clear);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        WordCounter wc = new WordCounter();
    }
}
