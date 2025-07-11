package Week2Assignment;

import java.util.*;

/*
 * 					 User
 * 				/			\
 * 			Student			Admin
 * 
 * 				RecorManager<T>
 *
 * 
 */

enum Subjects{
    telugu,hindi,english,maths,physics,chem;
}

public class RecordManager<T extends User> {
    private ArrayList<T> records = new ArrayList<>();
    
    private final int ADMIN_LIMIT = 2;

    void addUser(T user)
    {
    	if(user instanceof Admin)
    	{
    		if(records.size()>=ADMIN_LIMIT)
    		{
    			System.out.println("Admin records are full; no new admins can be added.");
    			return;
    		}
    	}
        records.add(user);
//        System.out.println("Added successfully!");
    }

    void updateUser(int id, T user)
    {
        records.set(id, user);
    }

    void deleteUser(T user)
    {
        records.remove(user);
    }

    void getDetails(T user) {
    	if(user==null)
    	{
    		System.out.println("No such Id exits");
    		return;
    	}
        if (user instanceof Student) {
            System.out.printf("%-10s %-20s %-10s ", "ID", "Name", "Age");
            for (Subjects subject : Subjects.values()) {
                System.out.printf("%-10s", subject);
            }
            System.out.printf("%-10s", "Average");
            System.out.println("\n-------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.printf("%-10s %-20s %-10s ", "ID", "Name", "Age");
            System.out.println("\n-------------------------------------------------------------------------------------------------------------");
        }
        user.viewDetials();
    }

    void getAllDetails() {
        if (records.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        T firstUser = records.get(0);
        if (firstUser instanceof Student) {
            System.out.printf("%-10s %-20s %-10s ", "ID", "Name", "Age");
            for (Subjects subject : Subjects.values()) {
                System.out.printf("%-10s", subject);
            }
            System.out.printf("%-10s", "Average");
            System.out.println("\n-------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.printf("%-10s %-20s %-10s ", "ID", "Name", "Age");
            System.out.println("\n-------------------------------------------------------------------------------------------------------------");
        }

        for (T t : records) {
            t.viewDetials();
        }
    }

    void getStudentsByGrade()
    {
        ArrayList<Student> students = new ArrayList<>();
        for(User t : records)
        {
            if(t instanceof Student)
            {
                students.add((Student)t);
            }
        }
        Collections.sort(students, (a, b)->b.getGrade()-a.getGrade());
        System.out.printf("%-10s %-20s %-10s ", "ID", "Name", "Age");
        for (subs subject : subs.values()) {
            System.out.printf("%-10s", subject);
        }
        System.out.printf("%-10s","Grade");
        System.out.println("\n" + "-------------------------------------------------------------------------------------------------------------");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    T getUser(int id)
    {
    	if(id<records.size())
    	{
    		return records.get(id);    		
    	}
    	return null;
    }

    boolean checkCredentials(int id, String name)
    {
        // System.out.println(id+" "+name);
        boolean hasId=false,hasName=false;
        for(User u: records)
        {
            if(u.Id == id)
            {
                hasId = true;
            }
            if(name.equalsIgnoreCase(u.name))
            {
                hasName = true;
            }
        }
        return hasId && hasName;
    }

    boolean checkCredentials(int id)
    {
        boolean hasId = false;
        for(User u: records)
        {
            if(u.Id == id)
            {
                hasId = true;
                break;
            }
        }
        return hasId;
    }

    void overallPercentage(T user)
    {
        if(user instanceof Student)
        {
            Student s = (Student)user;
            getDetails(user);
            System.out.print("\nRemarks: ");
            s.displayRemarks();
            System.out.println();

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Record Management");

        RecordManager<Admin> aManager = new RecordManager<>();
        RecordManager<Student> sManager = new RecordManager<>();

        Admin adm = new Admin("Akash", 23);
        aManager.addUser(adm);

        Student student1 = new Student("Alice Johnson", 20, new int[]{85, 78, 92, 88, 79, 95});
        Student student2 = new Student("Bob Williams", 22, new int[]{72, 65, 80, 70, 68, 75});
        Student s1 = new Student("Ravi Kumar", 21, new int[]{85, 78, 92, 88, 79, 95});
        Student s2 = new Student("Anjali Sharma", 20, new int[]{72, 65, 80, 75, 70, 68});
        Student s3 = new Student("Manoj Verma", 22, new int[]{95, 88, 94, 90, 87, 96});
        Student s4 = new Student("Pooja Singh", 19, new int[]{60, 58, 64, 55, 62, 59});
        Student s5 = new Student("Arjun Reddy", 23, new int[]{82, 76, 85, 81, 79, 84});
        Student s6 = new Student("Kavya Iyer", 20, new int[]{90, 85, 93, 88, 92, 94});
        Student s7 = new Student("Rahul Deshmukh", 21, new int[]{68, 70, 75, 73, 72, 69});
        Student s8 = new Student("Meera Joshi", 22, new int[]{88, 82, 91, 89, 84, 90});

        sManager.addUser(student1);
        sManager.addUser(student2);
        sManager.addUser(s1);
        sManager.addUser(s2);
        sManager.addUser(s3);
        sManager.addUser(s4);
        sManager.addUser(s5);
        sManager.addUser(s6);
        sManager.addUser(s7);
        sManager.addUser(s8);

        int choice = 0;

        do{
            System.out.println("Choose your role:");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();


            if(choice==1)
            {
                int adminChoice = 0;

                do{
                    System.out.println("Login Screen");
                    System.out.print("Enter ID: ");
                     int id = sc.nextInt();
//                    int id = 0;
                    System.out.println("Enter Username: ");
                     String username = sc.next();
//                    String username = "akash";
                     if(aManager.checkCredentials(id, username)==true)
                     {
                             break;
                         }else{
                                 System.out.println("Invalid Credentials! Try Again!");
                         }
                        break;
                }while(true);

                do{
                    System.out.println("\n--- Admin Menu ---");
                    System.out.println("1. Add new Admin");
                    System.out.println("2. Update Admin Record");
                    System.out.println("3. Get Admin Records");
                    System.out.println("4. Go to Student Records");
                    System.out.println("5. Exit");

                    adminChoice=sc.nextInt();

                    switch (adminChoice) {
                    	case 1:
                    		System.out.print("Enter your name: ");
//                    		sc.nextLine();
                            String name = sc.next();

                            int age = 0;
                            while (true) {
                                try {
                                    System.out.print("Enter your age: ");
                                    age = Integer.parseInt(sc.next()); // Ensuring only numbers are entered
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input! Please enter a valid number for age.");
                                }
                            }
                            
                            Admin adm2 = new Admin(name, age);
                            aManager.addUser(adm2);
                            break;
                    	
                        case 2:
                            System.out.println("Enter your Id: ");
                            int aId = sc.nextInt();
                            System.out.println("Enter your name: ");
                            String aname = sc.next();
                            System.out.println("Enter your age: ");
                            int aage = sc.nextInt();
                            Admin snewAdmin = new Admin(aname, aage);
                            aManager.updateUser(aId, snewAdmin);
                            break;
                        case 3:
                            aManager.getAllDetails();
                            break;
                        case 4:
                            int sdc = 0;

                            do{
                                System.out.println("1. Add Student Record");
                                System.out.println("2. Update Student Record");
                                System.out.println("3. Delete Student Record");
                                System.out.println("4. View Student Records");
                                System.out.println("5. Get Specific Record");
                                System.out.println("6. Get Students by Grade");
                                System.out.println("7. Exit");
                                System.out.println("Enter your choice: ");
                                sdc = sc.nextInt();

                                switch (sdc) {
                                    case 1:
                                         System.out.print("Enter student name: ");
                                         String name1 = sc.next();
                                         System.out.print("Enter student age: ");
                                         int age1 = sc.nextInt();
                                         int[] grades = new int[6];
                                         System.out.println("Enter grades for 6 subjects:");
                                         for (int i = 0; i < 6; i++) {
                                             System.out.print(Subjects.values()[i] + ": ");
                                             grades[i] = sc.nextInt();
                                         }

                                         Student s = new Student(name1, age1, grades);
                                         sManager.addUser(s);
                                        // Student student1 = new Student("Alice Johnson", 20, new int[]{85, 78, 92, 88, 79, 95});
                                        // Student student2 = new Student("Bob Williams", 22, new int[]{72, 65, 80, 70, 68, 75});
                                        // Student s1 = new Student("Ravi Kumar", 21, new int[]{85, 78, 92, 88, 79, 95});
                                        // Student s2 = new Student("Anjali Sharma", 20, new int[]{72, 65, 80, 75, 70, 68});
                                        // Student s3 = new Student("Manoj Verma", 22, new int[]{95, 88, 94, 90, 87, 96});
                                        // Student s4 = new Student("Pooja Singh", 19, new int[]{60, 58, 64, 55, 62, 59});
                                        // Student s5 = new Student("Arjun Reddy", 23, new int[]{82, 76, 85, 81, 79, 84});
                                        // Student s6 = new Student("Kavya Iyer", 20, new int[]{90, 85, 93, 88, 92, 94});
                                        // Student s7 = new Student("Rahul Deshmukh", 21, new int[]{68, 70, 75, 73, 72, 69});
                                        // Student s8 = new Student("Meera Joshi", 22, new int[]{88, 82, 91, 89, 84, 90});

                                        // sManager.addUser(student1);
                                        // sManager.addUser(student2);
                                        // sManager.addUser(s1);
                                        // sManager.addUser(s2);
                                        // sManager.addUser(s3);
                                        // sManager.addUser(s4);
                                        // sManager.addUser(s5);
                                        // sManager.addUser(s6);
                                        // sManager.addUser(s7);
                                        // sManager.addUser(s8);
                                        break;
                                        
                                    case 2:
                                        System.out.print("Enter student Id to update: ");
                                        int id = sc.nextInt();
                                        Student orginalStudent = sManager.getUser(id);
                                        System.out.println("1. Update Name\n2. Update Age\n3. Update Grades");
                                        int updateChoice = sc.nextInt();
                                        sc.nextLine();
                                        switch (updateChoice) {
                                            case 1:
                                                System.out.print("Enter new name: ");
                                                sManager.getUser(id).name = sc.nextLine();
                                                break;
                                            case 2:
                                                System.out.print("Enter new age: ");
                                                sManager.getUser(id).age = sc.nextInt();
                                                break;
                                            case 3:
                                                System.out.print("Enter subject index to update (0-5): ");
                                                int subjectIndex = sc.nextInt();
                                                if (subjectIndex >= 0 && subjectIndex < 6) {
                                                    System.out.print("Enter new grade for " + Subjects.values()[subjectIndex] + ": ");
                                                    sManager.getUser(id).grades[subjectIndex] = sc.nextInt();
                                                } else {
                                                    System.out.println("Invalid subject index.");
                                                }
                                                break;
                                            default:
                                                System.out.println("Invalid choice.");
                                                break;
                                            }
                                        sManager.updateUser(id, orginalStudent);
                                        break;
                                    case 3:
                                        System.out.print("Enter student Id to delete: ");
                                        int delid = sc.nextInt();
                                        sManager.deleteUser(sManager.getUser(delid));
                                        break;
                                    case 4:
                                        sManager.getAllDetails();
                                        break;
                                    case 5:
                                        System.out.print("Enter student Id to get detials: ");
                                        int spcid = sc.nextInt();
                                        sManager.getDetails(sManager.getUser(spcid));
                                        break;
                                    case 6:
                                        sManager.getStudentsByGrade();
                                        break;
                                    default:
                                        break;
                                }
                            }while(sdc!=7);
                            break;
                        default:
                            break;
                    }
                }while(adminChoice!=5);
            }else if(choice==2)
            {
                int id = 0;
                do{
                    System.out.println("Login Screen");
                    System.out.print("Enter Student ID: ");
                     id = sc.nextInt();
                     if(sManager.checkCredentials(id)==true)
                     {
                         break;
                     }else{
                         System.out.println("Invalid Credentials! Try Again!");
                     }
                }while(true);

                int stuChoice = 0;
                do{
                    System.out.println("\n--- Student Menu ---");
                    System.out.println("1. View Student Record");
                    System.out.println("2. Update Student Record");
                    System.out.println("3. Calculate Overall Grade Percentage");
                    System.out.println("4. Exit");

                    stuChoice=sc.nextInt();

                    switch(stuChoice)
                    {
                        case 1:
                            sManager.getDetails(sManager.getUser(id));
                            break;
                        case 2:
                            Student orginalStudent = sManager.getUser(id);
                            System.out.println("1. Update Name\n2. Update Age\n3. Update Grades");
                            int updateChoice = sc.nextInt();
                            sc.nextLine();
                            switch (updateChoice) {
                                case 1:
                                    System.out.print("Enter new name: ");
                                    sManager.getUser(id).name = sc.nextLine();
                                    break;
                                case 2:
                                    System.out.print("Enter new age: ");
                                    sManager.getUser(id).age = sc.nextInt();
                                    break;
                                case 3:
                                    System.out.print("Enter subject index to update (0-5): ");
                                    int subjectIndex = sc.nextInt();
                                    if (subjectIndex >= 0 && subjectIndex < 6) {
                                        System.out.print("Enter new grade for " + Subjects.values()[subjectIndex] + ": ");
                                        sManager.getUser(id).grades[subjectIndex] = sc.nextInt();
                                    } else {
                                        System.out.println("Invalid subject index.");
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                                }
                            sManager.updateUser(id, orginalStudent);
                            break;
                        case 3:
                            sManager.overallPercentage(sManager.getUser(id));
                            break;
                    }
                }while(stuChoice!=4);
            }
        }while(choice!=3);
    }
}
