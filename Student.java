import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;


public class Student extends JComponent implements ActionListener {
    private static JButton submitBtn1;
    private static JButton submitBtn2;
    private static JButton submitBtn3;
    private static JButton submitBtn4;
    private static ButtonGroup bgroup;
    private static JRadioButton opt1;
    private static JRadioButton opt2;

    String selQuiz = "";
    static boolean option1Selected; //opt1.isSelected();
    static boolean option2Selected; //opt2.isSelected();

    private static JPanel cPanel;
    private static JPanel sPanel;

    private static ArrayList<String> studentSubmissions = new ArrayList<>();

    public static void main(String [] args) {
        SwingUtilities.invokeLater((Runnable) new Student());
        start();
    }

    public static void start() {
        System.out.println("running");
        JFrame frame = new JFrame();
        frame.setTitle("Student");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());

        opt1 = new JRadioButton("Would you like to -Take a quiz?");
        opt2 = new JRadioButton("Would you like to -View your graded quiz/quizzes?");

        bgroup = new ButtonGroup();
        bgroup.add(opt1);
        bgroup.add(opt2);
        submitBtn1 = new JButton("Submit");
        submitBtn2 = new JButton("Submit");
        submitBtn3 = new JButton("Done");
        submitBtn4 = new JButton("Submit");

        cPanel = new JPanel();
        cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));

        cPanel.add(opt1);
        cPanel.add(opt2);

        opt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String optionSelected =
                        ((JRadioButton) e.getSource()).getActionCommand();
                if (opt1.isSelected() || optionSelected.startsWith("Take")) {
                    opt1.setSelected(true);
                    option1Selected = true;

                    opt2.setSelected(false);
                    option2Selected = false;
                }
            }
        });
        opt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String optionSelected =
                        ((JRadioButton) e.getSource()).getActionCommand();
                if (opt2.isSelected() || optionSelected.startsWith("View")) {
                    opt2.setSelected(true);
                    opt1.setSelected(false);

                    option1Selected = false;
                    option2Selected = true;
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(cPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        content.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        sPanel = new JPanel();
        sPanel.add(submitBtn1);
        content.add(sPanel, BorderLayout.SOUTH);
        ArrayList<JRadioButton> quizName = new ArrayList<JRadioButton>();
        ArrayList studentSubmissions = new ArrayList<>();
        ArrayList<JRadioButton> quizChoice = new ArrayList<JRadioButton>();

        submitBtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("inside submit button click");
                submitBtn1Function(quizName);

            }
        });

        submitBtn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String quizTitle = "";
                for (JRadioButton button : quizName) {
                    if (button.isSelected()) {
                        quizTitle = button.getText();
                    }
                }
                //System.out.println("inside submit  button 2 click");
                submitBtn2Function(quizTitle, studentSubmissions, quizChoice);
            }
        });

        submitBtn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String answer = null;
                String[] choices = {"A", "B", "C", "D"};
                //System.out.println("inside submit  button 3 click");
                int k = 2;
                int m = 0;
                for (JRadioButton button : quizChoice) {
                    if (button.isSelected()) {
                        answer = choices[m];
                    }
                    m++;
                    if (m == 4) {
                        studentSubmissions.add(k, answer);
                        m = 0;
                        k += 3;
                    }
                }

                try {
                    submitBtn3Function(studentSubmissions);
                } catch (IOException ex) {

                }


            }
        });
        submitBtn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("inside submit button click");
                submitBtn4Function();

            }
        });
    }

    protected static void submitBtn1Function(ArrayList<JRadioButton> quizName) {

        if (!option1Selected && !option2Selected) {
            JOptionPane.showMessageDialog(null, "Please make a selection!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else if (option1Selected) {
            //System.out.println("Option 1 selected");
            cPanel.remove(opt1);
            cPanel.remove(opt2);
            int i = 0;

            for (Quiz quiz : Quiz.readFile("src/quizList.txt")) {

                quizName.add(new JRadioButton(quiz.getQuizName()));
                quizName.get(i).setText(quiz.getQuizName());
                cPanel.add(quizName.get(i));
                i++;
            }
            cPanel.revalidate();
            cPanel.repaint();

            sPanel.remove(submitBtn1);
            sPanel.add(submitBtn2);
            sPanel.revalidate();
            sPanel.repaint();

        } else if (option2Selected) {
            cPanel.remove(opt1);
            cPanel.remove(opt2);
            int k = 0;
            ArrayList<String> studentSubmissions= readFile("src/StudentSubmissions.txt");

            if (studentSubmissions == null || studentSubmissions.size() == 0) {
                cPanel.add(new JLabel("There aren't any submissions yet!"));
                return;
            }
            if (Teacher.getPointValues().size() == 0) {
                cPanel.add (new JLabel("Your teacher hasn't graded your quiz(zes) yet!"));
                return;
            }

            for (int i = 0; i < studentSubmissions.size(); i += 3) {
                cPanel.add(new JLabel("\nQuestion: " +studentSubmissions.get(i)));
                cPanel.add(new JLabel("Correct Answer: " + studentSubmissions.get(i + 1)));
                cPanel.add(new JLabel("Your Answer: " + studentSubmissions.get(i + 2)));
                cPanel.add(new JLabel("Points Earned: " + Teacher.getPointValues().get(i / 3)));

            }
            cPanel.add(new JLabel("\nTotal Points: " + Teacher.getTotalPoints()));
            cPanel.revalidate();
            cPanel.repaint();

            sPanel.remove(submitBtn1);
            sPanel.add(submitBtn3);

            sPanel.revalidate();
            sPanel.repaint();

        }

    }

    protected static void submitBtn2Function(String quizTitle, ArrayList studentSubmissions,
                                             ArrayList<JRadioButton> quizChoice) {
        if ("".equals(quizTitle)) {
            JOptionPane.showMessageDialog(null, "Please make a selection!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Component[] c1 = cPanel.getComponents();
            for (int i = 0; i < c1.length; i++) {
                cPanel.remove(c1[i]);
            }
            JScrollPane qz = new JScrollPane();
            System.out.println(quizTitle);
            ArrayList<Quiz> quizzes = Quiz.readFile("src/quizList.txt");
            for (Quiz quiz : Objects.requireNonNull(quizzes)) {

                if (quiz.getQuizName().equalsIgnoreCase(quizTitle)) {
                    if (!quiz.isRandomized()) {
                        int pos = 0;
                        int j = 0;
                        for (int i = 0; i < quiz.getQuestions().size(); i++) {
                            studentSubmissions.add(quiz.getQuestions().get(i));
                            studentSubmissions.add(quiz.getCorrectAnswers().get(i));

                            cPanel.add(new JLabel(quiz.getQuestions().get(i))); // print question
                            quizChoice.add(new JRadioButton(quiz.getAnswerChoices().get(pos)));
                            cPanel.add(quizChoice.get(j));
                            j++;
                            quizChoice.add(new JRadioButton(quiz.getAnswerChoices().get(pos + 1))); // print option
                            cPanel.add(quizChoice.get(j));
                            j++;
                            quizChoice.add(new JRadioButton(quiz.getAnswerChoices().get(pos + 2))); // print option
                            cPanel.add(quizChoice.get(j));
                            j++;
                            quizChoice.add(new JRadioButton(quiz.getAnswerChoices().get(pos + 3))); // print option
                            cPanel.add(quizChoice.get(j));
                            j++;
                            pos += 4;
                        }
                    } else {
                        int pos = 0;
                        int j = 0;
                        int index = 0;
                        ArrayList<Integer> randomNumsQ = generateRandomNums(0, quiz.getQuestions().size(),
                                quiz.getQuestions().size());
                        for (Integer integer : randomNumsQ) {
                            index = integer;
                            studentSubmissions.add(quiz.getQuestions().get(index));
                            studentSubmissions.add(quiz.getCorrectAnswers().get(index));
                            cPanel.add(new JLabel(quiz.getQuestions().get(index)));
                            // randomize order of answer choices when printed to terminal
                            pos = index * 4;
                            // for each question, a list of random numbers is required
                            ArrayList<Integer> randomNumsA = generateRandomNums(1, 3, 3);
                            quizChoice.add(new JRadioButton(quiz.getAnswerChoices().get(pos)));
                            cPanel.add(quizChoice.get(j));
                            j++;
                            quizChoice.add(new JRadioButton(quiz.getAnswerChoices().get(pos + randomNumsA.get(0))));
                            cPanel.add(quizChoice.get(j));
                            j++;
                            quizChoice.add(new JRadioButton(quiz.getAnswerChoices().get(pos + randomNumsA.get(1))));
                            cPanel.add(quizChoice.get(j));
                            j++;
                            quizChoice.add(new JRadioButton(quiz.getAnswerChoices().get(pos + randomNumsA.get(2))));
                            cPanel.add(quizChoice.get(j));
                            j++;
                        }
                    }
                }
            }
            cPanel.revalidate();
            cPanel.repaint();

            Component[] s = sPanel.getComponents();
            for (int i = 0; i < s.length; i++) {
                sPanel.remove(s[i]);
            }
            sPanel.add(submitBtn3);

            sPanel.revalidate();
            sPanel.repaint();
        }
    }

    protected static void submitBtn3Function(ArrayList<String> array) throws IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(new File("src/StudentSubmissions.txt")));
        for (String s : array) {
            System.out.println(s);
            wr.write(s + "\n");
        }
        wr.close();
        JOptionPane.showMessageDialog(null, "Your quiz has been submitted!",
                "Quiz Submitted", JOptionPane.INFORMATION_MESSAGE);
        //System.out.println("submitBtn3  selected");
    }

    protected static void submitBtn4Function() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String optionSelected =
                ((JRadioButton) e.getSource()).getActionCommand();
        if (opt1.isSelected() || optionSelected.startsWith("Take")) {
            opt1.setSelected(true);
            option1Selected = true;

            opt2.setSelected(false);
            option2Selected = false;
        } else if (opt2.isSelected() || optionSelected.startsWith("View")) {
            opt2.setSelected(true);
            opt1.setSelected(false);

            option1Selected = false;
            option2Selected = true;
        }
    }

    public void submitQuiz(String qName, HashMap qDetails) {

    }

    public static ArrayList<Integer> generateRandomNums(int start, int end, int length) {
        ArrayList<Integer> list = new ArrayList<>();
        int num = 0;
        while (list.size() != length) {
            num = (int) (Math.random() * end + start);
            if (list.size() == 0) {
                list.add(num);
            } else {
                if (!list.contains(num)) {
                    list.add(num);
                }
            }
        }
        return list;
    }

    public static ArrayList<String> readFile(String fileName) {
        if (!new File(fileName).exists()) {
            return null;
        }

        try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))) {
            ArrayList<String> fileContents = new ArrayList<>();
            String line = new String("");
            while ((line = bfr.readLine()) != null) {
                fileContents.add(line);
            }
            if (fileContents.size() == 0) {
                return null;
            } else {
                return fileContents;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ArrayList<String> getStudentSubmissions() {
        return studentSubmissions;
    }
}
