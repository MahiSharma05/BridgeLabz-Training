package ExaminationSystem;

import java.util.Scanner;

public class OnlineExaminationSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Student student = null;
        Exam exam = null;

        EvaluationStrategy objectiveEval = new ObjectiveEvaluation();
        EvaluationStrategy descriptiveEval = new DescriptiveEvaluation();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== ONLINE EXAMINATION SYSTEM =====");
            System.out.println("1. Create Exam");
            System.out.println("2. Enroll Student");
            System.out.println("3. Start Exam & Submit Answers");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Exam Name: ");
                    String examName = input.nextLine();

                    exam = new Exam(examName, 3, 60000); // 1 min exam

                    exam.addQuestion(new Question(1, "Java is platform independent? (yes/no)", "yes", true));
                    exam.addQuestion(new Question(2, "Java support OOP? (yes/no)", "yes", true));

                    System.out.println("Exam created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int sid = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Student Name: ");
                    String sname = input.nextLine();

                    student = new Student(sid, sname);
                    System.out.println("Student enrolled successfully!");
                    break;

                case 3:
                    if (student == null || exam == null) {
                        System.out.println("Create exam and enroll student first!");
                        break;
                    }

                    exam.startExam();
                    int score = 0;

                    try {
                        for (int i = 0; i < exam.getQuestionCount(); i++) {

                            if (exam.isTimeOver()) {
                                throw new ExamTimeExpiredException("Exam time expired!");
                            }

                            Question q = exam.getQuestions()[i];
                            System.out.println(q.getQuestionText());
                            String ans = input.nextLine();

                            if (q.isObjective())
                                score += objectiveEval.evaluate(q, ans);
                            else
                                score += descriptiveEval.evaluate(q, ans);
                        }

                        System.out.println("Exam completed!");
                        System.out.println("Final Score: " + score);

                    } catch (ExamTimeExpiredException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    exit = true;
                    System.out.println(" Online Examination Finished");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        input.close();
    }
}

