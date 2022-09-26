package com.gl.CaseStudy1;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffMain {
	 public static Double totalCalculation (Applicant applicant) {
		 Double m1=applicant.getSubject1Mark();
		 Double m2=applicant.getSubject2Mark();
		 Double m3=applicant.getSubject3Mark();
		 if (m1<50 || m2<50 || m3<50) {
			 return 0.0;
		 }
		 else {
			 Double total=m1+m2+m3;
			 return total;
		 }
	 }
	 
	 public static Double percentageCalculation (Double total) {
		 Double per= (total/300)*100;
		 DecimalFormat df = new DecimalFormat("0.00");
		 String persentage=df.format(per);
		 return Double.parseDouble(persentage) ;
	 }
	public static void main(String[] args) {
		Integer id=100;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number applicants:");
		Integer n=Integer.parseInt(sc.nextLine());
		List<Applicant> applicantList=new ArrayList<Applicant>();
		for (int i=0;i<n;i++)
		{
			System.out.println("Enter the applicant details");
			String str=sc.nextLine();
			String[] arr = str.split(",");
			String name=arr[0];
			Double marks1=Double.parseDouble(arr[1]);
			Double marks2=Double.parseDouble(arr[2]);
			Double marks3=Double.parseDouble(arr[3]);
			try {
				if(marks1>100 || marks1<0 || marks2>100 || marks2<0 || marks3>100 || marks3<0 ) {
					throw new MarksException("\nInvalid marks; should be between 0 and 100\n");
				}
			}
			catch (MarksException e) {
				System.out.println(e.getMessage());
				continue;
			}
			Applicant a=new Applicant(name,marks1,marks2,marks3,0.0,0.0);
			a.setId(++id);
			Double total=totalCalculation(a);
			Double percentage=percentageCalculation(total);
			a.setTotal(total);
			if (total==0.0)
				continue;
			a.setPercentage(percentage);
			applicantList.add(a);
	}
		System.out.println("Output format");
		applicantList.forEach((applicant)->System.out.println(applicant));
		

}
}