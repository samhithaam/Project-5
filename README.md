# Project-5

There are 5 classes: Student, Teacher, Quiz, Server, and Client. 

STUDENT CLASS: The Student class allows users to take quizzes and view their graded quizzes. In Student.java, there is a method, generateRandomNums(int start, int end, int length), that returns an array of randomly generated numbers that the printQuiz(boolean randomized, String quizTitle, Scanner scanner) method uses to print the questions and answer choices in a random order. The Student class also prints the timestamp after the student submits a quiz. The calling of methods takes place in main, where there are try catch blocks to ensure that the user input is valid. viewGradedQuiz() relies heavily on the StudentSubmissions.txt text file, and therefore, there is a readFile() method in Student.java.

TEACHER CLASS: The Teacher class allows teachers to create, edit, and delete quizzes. Grading is also handled in Teacher.java; teachers are given the ability to assign a certain number of points for each answer. 

QUIZ CLASS: The Quiz class stores all of the quizzes, the questions that belong to each quiz, the corresponding answer choices, and a boolean value that determines whether or not the printQuiz method in Student.java should print the questions and answer choices in a randomized format, all in an ArrayList called quizzes. The readFile() method uses the contents of quizList.txt to update the ArrayList.


All five of these classes work with each other in order to allow students and teachers to create, edit and delete accounts. Teachers can create/edit/delete quizzes and assign points, whereas students can only access and take quizzes.

COMPILING AND RUNNING: In order to run our program, you need to run Client.java, which will give you the option to create/edit/delete an account, or sign in. After choosing one of the above options, you will have to specify whether you are a student or a teacher. If the user chooses to create/edit/delete an account, the information they input is stored in or removed from an ArrayList. If the user chooses to sign in, and they are successful in doing so, the main method in either Student or Teacher is called. If the user is a student, they are given the option to either take a quiz or view their graded quizzes. If the user is a teacher, they are given the option to either create/edit/delete quizzes, or view and grade student submissions if they exist. 

Note: To help the program smoothly, the user should have the files "quizList.txt", "StudentUsernames.txt", "StudentPasswords.txt", "TeacherUsernames.txt", "TeacherPasswords.txt", "pointList.txt", and "StudentSubmissions.txt" already created. The teacher and student quiz tools should also be used in full screen mode. 

TESTING: We tested the code by trying all possible input values when prompted and seeing if all output printed as expected. That's when we realized that we needed to add while loops to keep prompting the user for input until input is valid. 

Team Members: Ritu Atreyas, Samhitha Mupharaphu, Serena Gauri Ronanki, Rithvik Thiagu

Submission:
Ritu Atreyas: report on Brightspace; Vocareum workspace
