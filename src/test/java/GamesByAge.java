import org.testng.annotations.Test;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GamesByAge {

    // if we want to remember / store an object in Java,
    // we have to make a class; so every Student read from the JSON file
    // shall have a logical representation
    public class Student {

        // we make the members public, otherwise we need to write
        // a getter method for each of them. this would make it all
        // more complicated.

        public String name;
        public Integer age;
    }

    // we want to create groups of students
    // but for that, we need to know what is the
    // minimum and maximum age of the students
    // in that group because a group can have students
    // 1 year older or 1 year younger
    public class StudentAgeGroup {

        public int minAge;
        public int maxAge;

        // here we will assign the students to the age group
        public ArrayList<Student> students = new ArrayList<>();

        // this method checks if a student would fit in the
        // age range of that group
        boolean isInAgeRange(int studentsAge) {
            if (studentsAge >= minAge && studentsAge <= maxAge) {
                return true;
            }
            return false;
        }
    }

    // this class just stores all the data, input and result output
    public class StudentData {

        // this will be filled by Gson JSON file read
        public ArrayList<Student> allStudents;

        // this will be constructed by the algorithm
        public ArrayList<StudentAgeGroup> studentAgeGroups;
    }

    @Test
    public void test() throws IOException {

        // first we need the path of the directory of the project
        // so that we can read the students from the JSON file
        String projectDirectoryPath = System.getProperty("user.dir");

        // the static method get() in the Paths class can resolve a filesystem path form a constructed path string
        // it makes sure, that the path is correctly written
        Path currentRelativePath = Paths.get(projectDirectoryPath + "/students.json");

        // a JSON must first be read as text before it can be converted to a logical
        // data structure. Here we read the whole file as string from the filesystem path
        String jsonText = Files.readString(currentRelativePath);

        // Gson is a JSON library for Java, written by Google engineers. It allows us to read
        // in a JSON file and map it to Java classes automatically
        Gson gson = new Gson();

        // read in allStudents by using GSON to convert/read-in 1:1 to the StudentData members
        StudentData studentData = gson.fromJson(jsonText, StudentData.class);

        // by now, we have the studentGroups.allStudents read-in and converted to an ArrayList
        // now we want to see, how many grouping possibilities we have
        // In general there can only be as many groups as there are different ages
        // in the cohort of students. Now we want to find what different ages there are:
        ArrayList<Integer> ageDistributionList = new ArrayList<>();

        // each individual students age is read in this loop
        // but only if that age is not already in the age distribution list we add it
        for (int i=0; i < studentData.allStudents.size(); i++) {

            // this is just for better readability. A "temporary" variable to work with
            Student currentStudent = studentData.allStudents.get(i);

            // now we want to see if the age distribution list doesn't already have a person of that age
            if (!ageDistributionList.contains(currentStudent.age)) {
                // this age seems not to be known yet (e.g. first person who is 18 found, first person who is 19, ..)
                ageDistributionList.add(currentStudent.age);
            }
        }

        // After knowing the different single ages that exist in this group,
        // we need to come up with the actual match groups. They can be of age +1 and -1 year.
        // Example: [18s,19s,20s] and [21s,22s,23s] and [24s,25s,26s].
        // We need to create these groups.

        // Therefor we make a list where we can store these groups logically.
        // First, no student will be assigned, we only make sure we know the possible groups itself.
        studentData.studentAgeGroups = new ArrayList<>();

        // for each single age, we create a group...
        for (int i=0; i<ageDistributionList.size(); i++) {

            int age = ageDistributionList.get(i);

            // here we define the age range per group
            // so in case we have 18s, it becomes 17 to 19
            StudentAgeGroup ageGroup = new StudentAgeGroup();
            ageGroup.minAge = age - 1;
            ageGroup.maxAge = age + 1;

            // we add the student group to the list of groups we possibly want to assign the students too
            studentData.studentAgeGroups.add(ageGroup);
        }

        // after knowing the age groups we want to group the students into,
        // we can iterate through all students and just see, in which age group they fit!
        for (int i=0; i < studentData.allStudents.size(); i++) {

            Student currentStudent = studentData.allStudents.get(i);

            for (int j = 0; j<studentData.studentAgeGroups.size(); j++) {

                StudentAgeGroup currentAgeGroup = studentData.studentAgeGroups.get(j);

                if (currentAgeGroup.isInAgeRange(currentStudent.age)) {
                    currentAgeGroup.students.add(currentStudent);
                    // we assigned the student to an age group
                    // now we need to make sure, the student is not added
                    // to another age group -- how can the student be in two groups
                    // at the same time? That's why we break the loop (inner loop)
                    // and so the outer loop will just continue with the next student
                    break;
                }
            }
        }

        // here we have the students assigned to their respective age groups
        // if the grouping should be different, we can randomize or sort
        // the input allStudents list and/or change the minAge and maxAge age range

        // now lets print the results per age group
        for (int i = 0; i<studentData.studentAgeGroups.size(); i++) {

            StudentAgeGroup studentGroup = studentData.studentAgeGroups.get(i);

            // some logically possible groups might not have students, don't print them
            if (studentGroup.students.size() > 0) {

                // print the students assigned to each existing group
                System.out.println("Group " + i+1 + ": Students: " + gson.toJson(studentGroup.students));
            }
        }
    }
}