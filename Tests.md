# Student.java (Gauri)
Test cases:
To take quiz
•	User launches application.
•	User chooses take quiz .
•	After selection, user selects take quiz option’s adjacent button and click on SUBMIT button below.
If student chooses to -take quiz and there no available quizzes : 
•	Expected result: User is notified that there are no available quizzes.
•	After clicking on OK button, the application is exited.

If student chooses to -take quiz and there are available quizzes in the quizList.txt:
•	The user can view all the available quizzes .
•	After selecting the quiz the user wants to take , the user clicks on the adjacent button of the desired quiz and submits it by clicking on the SUBMIT button below.
•	Now, the user can view and take the selected quiz.
•	To take the quiz , user has to choose an answer from the given choices by clicking on the adjacent button of the selected choice.
•	After finishing the quiz, user clicks on the DONE button.
Expected result: quiz is submitted and user gets submission success message.
•	After clicking on OK button , the application is exited.

To view grade:
•	User launches application
•	User chooses the option view grade.
•	After selection, user selects view grade option’s adjacent button and click on SUBMIT button below.
If student chooses to -view grade and there no graded quizzes:
Expected result: User is notified that there are no graded quizzes.

If student chooses to -view grade and there are graded quizzes available:
•	The application is navigated to frame where all the graded quizzes are available.
•	On this frame, the user clicks on the adjacent button of the desired quiz grade he wants to view and submits it by clicking on the SUBMIT button below.
•	After selecting quiz, the application navigates to frame where the grade is available.
Expected result: Graded quiz is visible to the user .
After clicking on DONE button, thank you message appears.
•	By clicking on DONE button, the application is exited.

# Teacher.java (Rithvik)
Test cases:

Steps:
Test 1:
  User launches application.
User selects the ‘Create Quiz’ button.
User enters a quiz title via the keyboard.
User selects the ‘no’ option to randomize questions.
User enters a question via the keyboard.
User enters the first answer choice via the keyboard. 
User enters the second answer choice via the keyboard. 
User enters the third answer choice via the keyboard. 
User enters the fourth answer choice via the keyboard. 
User enters the correct answer choice via the keyboard. 
User selects the ‘no’ options to enter another question.
Expected result: Application creates the quiz and displays a confirmation message.
Test Status: Passed. 

Test 2:
User launches application.
User selects the ‘Create Quiz’ button.
User enters a quiz title via the keyboard.
User selects the ‘yes’ option to randomize questions.
User enters a question via the keyboard.
User enters the first answer choice via the keyboard. 
User enters the second answer choice via the keyboard. 
User enters the third answer choice via the keyboard. 
User enters the fourth answer choice via the keyboard. 
User enters the correct answer choice via the keyboard. 
User selects the ‘no’ options to enter another question.
Expected result: Application creates the quiz and displays a confirmation message.
Test Status: Passed. 

Test 3:
User launches application.
User selects the ‘Create Quiz’ button.
User enters a quiz title via the keyboard.
User selects the ‘yes’ option to randomize questions.
User enters a question via the keyboard.
User enters the first answer choice via the keyboard. 
User enters the second answer choice via the keyboard. 
User enters the third answer choice via the keyboard. 
User enters the fourth answer choice via the keyboard. 
User enters a correct answer choice not in the answer choices via the keyboard. 
Expected result: Application displays an error message for inputting a correct answer not among the answer choices
Test Status: Passed. 

Test 4:
User launches application.
User selects the ‘Create Quiz’ button.
User enters a quiz title via the keyboard.
User selects the ‘yes’ option to randomize questions.
User enters a question via the keyboard.
User enters the first answer choice via the keyboard. 
User enters the second answer choice via the keyboard. 
User enters the third answer choice via the keyboard. 
User enters the fourth answer choice via the keyboard. 
User enters a correct answer choice via the keyboard. 
User selects the ‘yes’ option to enter another question.
User enters a question via the keyboard.
User enters the first answer choice via the keyboard. 
User enters the second answer choice via the keyboard. 
User enters the third answer choice via the keyboard. 
User enters the fourth answer choice via the keyboard. 
User enters a correct answer choice via the keyboard. 
User selects the ‘no’ options to enter another question.
Expected result: Application creates the quiz and displays a confirmation message.
Test Status: Passed. 

Test 5: 
User launches application.
User selects the ‘Create Quiz’ button.
User enters a quiz title via the keyboard.
User selects the ‘yes’ option to randomize questions.
User enters a question via the keyboard.
User enters the first answer choice via the keyboard. 
User enters the second answer choice via the keyboard. 
User enters the third answer choice via the keyboard. 
User enters the fourth answer choice via the keyboard. 
User enters a correct answer choice via the keyboard. 
User selects the ‘no’ option to enter another question.
User selects the ‘Edit Quiz’ button.
User enters a quiz title via the keyboard.
User selects ‘yes’ to edit the question.
User enters a new question via the keyboard.
User selects ‘yes’ to edit the randomization.
User selects ‘no’ for the new randomization.
User selects ‘yes’ to edit the answer choices.
User selects ‘1’ from the dropdown menu.
User enters a new answer choice 1 via the keyboard
User selects ‘yes’ to edit the correct answer choice.
User selects ‘yes’ to edit the answer choices.
User enters a new correct answer choice via the keyboard.
User selects ‘2’ from the dropdown menu.
User enters a new answer choice 2 via the keyboard
User selects ‘no’ to edit the correct answer choice.
User selects ‘3’ from the dropdown menu.
User enters a new answer choice 3 via the keyboard
User selects ‘no’ to edit the correct answer choice.
User selects ‘4’ from the dropdown menu.
User enters a new answer choice 4 via the keyboard
User selects ‘no’ to edit the correct answer choice.
User selects ‘no’ to edit another question.
User selects ‘no’ to edit another quiz.
Expected result: Application edits the quiz and displays a confirmation message.
Test Status: Passed. 

Test 6:
User launches application.
User selects the ‘Create Quiz’ button.
User enters a quiz title via the keyboard.
User selects the ‘no’ option to randomize questions.
User enters a question via the keyboard.
User enters the first answer choice via the keyboard. 
User enters the second answer choice via the keyboard. 
User enters the third answer choice via the keyboard. 
User enters the fourth answer choice via the keyboard. 
User enters a correct answer choice via the keyboard. 
User selects the ‘no’ option to enter another question.
User selects the ‘Edit Quiz’ button.
User enters a quiz title via the keyboard.
User selects ‘yes’ to edit the question.
User enters a new question via the keyboard.
User selects ‘yes’ to edit the randomization.
User selects ‘yes’ for the new randomization.
User selects ‘yes’ to edit the answer choices.
User selects ‘1’ from the dropdown menu.
User enters a new answer choice 1 via the keyboard
User selects ‘yes’ to edit the correct answer choice.
User enters a new correct answer choice via the keyboard.
User selects ‘yes’ to edit another answer.
User selects ‘2’ from the dropdown menu.
User enters a new answer choice 2 via the keyboard
User selects ‘no’ to edit the correct answer choice.
User selects ‘3’ from the dropdown menu.
User enters a new answer choice 3 via the keyboard
User selects ‘no’ to edit the correct answer choice.
User selects ‘4’ from the dropdown menu.
User enters a new answer choice 4 via the keyboard
User selects ‘no’ to edit the correct answer choice.
User selects ‘no’ to edit another question.
User selects yes to edit another quiz.
User enters a quiz title via the keyboard.
User selects ‘yes’ to edit the question.
User enters a new question via the keyboard.
User selects ‘no’ to edit the randomization.
User selects ‘yes’ to edit the answer choices.
User selects ‘1’ from the dropdown menu.
User enters a new answer choice 1 via the keyboard
User selects ‘yes’ to edit the correct answer choice.
User enters a correct answer choice not in the answer choices via the keyboard.
Expected result: Application displays an error message for inputting a correct answer not among the answer choices
Test Status: Passed. 

Test 7:
User launches application.
User selects the ‘Create Quiz’ button.
User enters a quiz title via the keyboard.
User selects the ‘no’ option to randomize questions.
User enters a question via the keyboard.
User enters the first answer choice via the keyboard. 
User enters the second answer choice via the keyboard. 
User enters the third answer choice via the keyboard. 
User enters the fourth answer choice via the keyboard. 
User enters a correct answer choice via the keyboard. 
User selects the ‘no’ option to enter another question.
User selects the ‘Edit Quiz’ button.
User enters a quiz title not created via the keyboard.
Expected result: Application displays an error message for inputting a quiz title that does not exist.
Test Status: Passed. 

Test 8:
User launches application.
User selects the ‘Create Quiz’ button.
User enters a quiz title via the keyboard.
User selects the ‘no’ option to randomize questions.
User enters a question via the keyboard.
User enters the first answer choice via the keyboard. 
User enters the second answer choice via the keyboard. 
User enters the third answer choice via the keyboard. 
User enters the fourth answer choice via the keyboard. 
User enters a correct answer choice via the keyboard. 
User selects the ‘no’ option to enter another question.
User selects the ‘Edit Quiz’ button.
User enters a quiz title via the keyboard.
User selects ‘yes’ to edit the question.
User enters a new question via the keyboard.
User selects ‘no’ to edit the randomization.
User selects ‘no’ to edit the answer choices.
User selects ‘no’ to edit another quiz.
Expected result: Application displays a confirmation message for editing the quiz and completing editing.
Test Status: Passed. 

Test 9:
User launches application.
User selects the ‘Create Quiz’ button.
User enters a quiz title via the keyboard.
User selects the ‘no’ option to randomize questions.
User enters a question via the keyboard.
User enters the first answer choice via the keyboard. 
User enters the second answer choice via the keyboard. 
User enters the third answer choice via the keyboard. 
User enters the fourth answer choice via the keyboard. 
User enters a correct answer choice via the keyboard. 
User selects the ‘no’ option to enter another question.
User selects the ‘Delete Quiz’ button.
User enters the name of the quiz to delete via the keyboard.
Expected result: Application displays a confirmation message for deleting the quiz.
Test Status: Passed. 

Test 10:
User launches application.
User selects the ‘Create Quiz’ button.
User enters a quiz title via the keyboard.
User selects the ‘no’ option to randomize questions.
User enters a question via the keyboard.
User enters the first answer choice via the keyboard. 
User enters the second answer choice via the keyboard. 
User enters the third answer choice via the keyboard. 
User enters the fourth answer choice via the keyboard. 
User enters a correct answer choice via the keyboard. 
User selects the ‘no’ option to enter another question.
User selects the ‘Delete Quiz’ button.
User enters the name of the quiz that does not exist to delete via the keyboard.
Expected result: Application displays an error message notifying the quiz does not exist.
Test Status: Passed. 
Test 11:


User launches application
User selects the ‘View Submissions’ button.
Expected result: Application displays the questions, correct answers, and student answers.
Test Status: Passed. 

Test 11:
User launches application
User selects the ‘View Submissions’ button with no student submissions
Expected result: Application displays an error message for not having student submissions.
Test Status: Passed. 

Test 12:
User launches application
User selects the ‘Assign Point Values’ Button 
User selects  the ‘Ok’ button to the student submissions being displayed
User enters how many points they want to assign to the question
Expected result: Application assigns the points and displays a confirmation message.
Test Status: Passed. 

Test 13:
User launches application
User selects the ‘Assign Point Values’ Button with no student submissions.
Expected result: Application displays an error message for not having student submissions.
Test Status: Passed. 

Test 14:
User launches application.
User selects the ‘Exit’ button.
Expected result: Application displays an exit message and closes the program.
Test Status: Passed. 


# Server.java and Client.java (Ritu)
Test cases:
