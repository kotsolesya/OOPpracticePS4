package com.eventdnb.practike.oop.oneday;
import java.util.*;

public class StudentGroup
{
	public StudentGroup(String namegroup) {
		this.namegroup = namegroup;
	}

	private String namegroup;
	private String liststudent = "Parshuk; Piskivy; Kotolup;";
	public String getListstudent() {
		return liststudent;
	}
	public void setListstudent(String liststudent) {
		this.liststudent = liststudent;
	}
	public String getListsubjects() {
		return listsubjects;
	}
	public void setListsubjects(String listsubjects) {
		this.listsubjects = listsubjects;
	}
	public String getArticlesschedule() {
		return articlesschedule;
	}
	public void setArticlesschedule(String articlesschedule) {
		this.articlesschedule = articlesschedule;
	}
	public String getListpresents() {
		return listpresents;
	}
	public void setListpresents(String listpresents) {
		this.listpresents = listpresents;
	}
	public String getListmarks() {
		return listmarks;
	}
	public void setListmarks(String listmarks) {
		this.listmarks = listmarks;
	}

	private String listsubjects = "OOP; IZVP; KPZ;";
	private String articlesschedule = "Monday: OOP; Thursday: KPZ; Sunday: IZVP;";
	private String listpresents = "Parshuk: present; Kotolup: epsent; Piskovy: present;";
	private String listmarks = "Parshuk: 5,5,5; Kotolup= 2,3,2; Piskovy: 3,4,4;";
	
	public String getNamegroup() {
		return namegroup;
	}
	public void setNamegroup(String namegroup) {
		this.namegroup = namegroup;
	}

	public static void main(String[] args){
		 Scanner ng = new Scanner(System.in); 
		 StudentGroup stOb = new StudentGroup("PS-4");
		 
	     String group;
	     System.out.print("Програма перегляду даних про студентів"+"\n"+"Виберыть подальші дії 'Перегляд даних - show' або  'Редагування - input date'");
	     while(true){
	     group = ng.nextLine(); 
	     if(group.equals("show")){	 
		System.out.print("Name Group: "+stOb.getNamegroup()+"\n");
		System.out.print("List Student: "+stOb.getListstudent()+"\n");
		System.out.print("List Subjects: "+stOb.getListsubjects()+"\n");
		System.out.print("Articles Schedule: "+stOb.getArticlesschedule()+"\n");
		System.out.print("List Presents: "+stOb.getListpresents()+"\n");
		System.out.print("List Marks: "+stOb.getListmarks()+"\n");
		}	
	     else if(group.equals("input date")){
	    	 
	    	 System.out.print("Name Group: ");
	    	 Scanner ng1 = new Scanner(System.in);
	    	 stOb.setNamegroup(ng1.nextLine());
	    	 System.out.print("List Student: ");
	    	 Scanner ls = new Scanner(System.in);
	    	 stOb.setListstudent(ls.nextLine());
	    	 System.out.print("List Subjects: ");
	    	 Scanner lb = new Scanner(System.in);
	    	 stOb.setListsubjects(lb.nextLine());
	    	 System.out.print("Articles Schedule: ");
	    	 Scanner as = new Scanner(System.in);
	    	 stOb.setArticlesschedule(as.nextLine());
	    	 System.out.print("List Presents: ");
	    	 Scanner lp = new Scanner(System.in);
	    	 stOb.setListpresents(lp.nextLine());
	    	 System.out.print("List Marks: ");
	    	 Scanner lm = new Scanner(System.in);
	    	 stOb.setListmarks(lm.nextLine()); 
	    }
	      
	     else{System.out.print("Invalid input date!"); 
	    	 break;}
	     }
	}
}
