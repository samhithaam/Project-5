import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;
import java.io.File;
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
import javax.swing.JTable;
import javax.swing.SwingUtilities;


public class StudentGUI extends JComponent implements ActionListener, Runnable {
    JButton submitBtn1;
    JButton submitBtn2;
    JButton submitBtn3;
    JButton submitBtn4;
    ButtonGroup bgroup;
    JRadioButton opt1;
    JRadioButton opt2;

    String selQuiz = "";
    boolean option1Selected; //opt1.isSelected();
    boolean option2Selected; //opt2.isSelected();

    JPanel cPanel;
    JPanel sPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new StudentGUI());
    }

    public void run() {
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

        opt1.addActionListener(this);
        opt2.addActionListener(this);

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
        ArrayList studentSubmissionsLocal = new ArrayList<>();
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
                submitBtn2Function(quizTitle, studentSubmissionsLocal, quizChoice);
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
                        studentSubmissionsLocal.add(k, answer);
                        m = 0;
                        k += 3;
                    }
                }

                try {
                    submitBtn3Function(studentSubmissionsLocal);
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

    protected void submitBtn1Function(ArrayList<JRadioButton> quizName) {

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
            ArrayList<String> studentQuizanswers = Student.readFile("src/StudentSubmissions.txt");
            if (studentQuizanswers == null || studentQuizanswers.size() == 0) {
                cPanel.add(new JLabel("There aren't any submissions yet!"));
                return;
            }
            int[] pointValues = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            int totalPoints = 0;

            for (int i = 0; i < studentQuizanswers.size(); i += 3) {
                cPanel.add(new JLabel("\nQuestion: " + studentQuizanswers.get(i)));
                cPanel.add(new JLabel("Correct Answer: " + studentQuizanswers.get(i + 1)));
                cPanel.add(new JLabel("Your Answer: " + studentQuizanswers.get(i + 2)));
                cPanel.add(new JLabel("Points Earned: " + pointValues[i / 3]));
                totalPoints += pointValues[i / 3];
            }
            cPanel.add(new JLabel("\nTotal Points: " + totalPoints));
            cPanel.revalidate();
            cPanel.repaint();

            sPanel.remove(submitBtn1);
            sPanel.add(submitBtn3);

            sPanel.revalidate();
            sPanel.repaint();

        }

    }

    protected void submitBtn2Function(String quizTitle, ArrayList studentSubmissionsLocal,
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
                            studentSubmissionsLocal.add(quiz.getQuestions().get(i));
                            studentSubmissionsLocal.add(quiz.getCorrectAnswers().get(i));

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
                            studentSubmissionsLocal.add(quiz.getQuestions().get(index));
                            studentSubmissionsLocal.add(quiz.getCorrectAnswers().get(index));
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

    protected void submitBtn3Function(ArrayList<String> array) throws IOException {
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

    protected void submitBtn4Function() {

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
}

