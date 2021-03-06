/**
 * A class definition for Run
 *
 * @author Amirhossein
 */
public class Run {
    public static void main(String[] args) {
        /*
         * Creating sample student objects.
         * setting grade for each student.
         */
        Student std1 = new Student("Ehsan", "Edalat", "9031066");
        std1.setGrade(20);
        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
        std2.setGrade(20);
        Student std3 = new Student("Ali", "Moghadam", "9031056");
        std3.setGrade(9);
        Student std4 = new Student("Davood", "Khodadoost", "9031055");
        std4.setGrade(21);
        Student std5 = new Student("Ahmad", "Asadi", "9031054");
        std5.setGrade(20);

        /*
         * Creating sample Lab object.
         */
        Lab lab = new Lab(4, "Friday");

        /*
         * enrolling students to lab.
         */
        lab.enrollStudent(std1);
        lab.enrollStudent(std2);
        lab.enrollStudent(std3);
        lab.enrollStudent(std4);
        lab.enrollStudent(std5);

        /*
         * testing lab methods("calculateAvg" , "print")
         */

        lab.calculateAvg();
        lab.print();
    }
}
