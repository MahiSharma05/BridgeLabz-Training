//Suppose you have to divide 14 pens among 3 students equally. Write a program to find how many pens each student will get if the pens must be divided equally. Also, find the remaining non-distributed pens.

class DistributionOfPens {
    public static void main(String[] args) {
        int Pens = 14;
        int students = 3;
        int pensPerStudent = Pens / students;
        int remainingPens = Pens % students;
        System.out.println("The Pen Per Student is " + pensPerStudent +" and the remaining pen not distributed is " + remainingPens);
    }
}
