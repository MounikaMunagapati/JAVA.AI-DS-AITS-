public class Student{
    String StudentName;
	int RollNo;
	int Age;
	String Department;
	public Student(String StudentName,int RollNo,int Age,String Department){
	   this.StudentName = StudentName;
	   this.RollNo = RollNo;
	   this.Age = Age;
	   this.Department = Department;
	}
	void display(){
	   System.out.println("StudentName="+StudentName);
	   System.out.println("RollNo="+RollNo);
	   System.out.println("Age="+Age);
	   System.out.println("Department="+Department);
	   System.out.println("----------------");
	}
	public static void main(String[] args){
	   Student[] std = new Student[5];
	   std[0] = new Student("Anjali",3008,19,"AI&DS");
	   std[1] = new Student("Leela",3044,20,"AI&ML");
	   std[2] = new Student("Akhila",3006,21,"CSE");
	   std[3] = new Student("Amrutha",3007,19,"AI&DS");
	   std[4] = new Student("Manaswitha",3050,22,"CSE");
	   
	   for(int i=0;i<std.length;i++)
	   std[i].display();
	}
}