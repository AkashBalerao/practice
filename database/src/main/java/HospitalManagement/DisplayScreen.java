package HospitalManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.text.NumberFormat;

public class DisplayScreen{
	public static void main(String [] args) throws NumberFormatException, IOException
	{	
    	System.out.println("Welcome to Hospital Management System!");
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	HspltManagement ds = new HspltManagement();
    	
    	int choice = 0;
    	
    	do {
    		System.out.println("1. Patient Screen");
    		System.out.println("2. Doctor Screen");
    		System.out.println("3. Book Appointment");
    		System.out.println("4. Exit");
    		
    		try {
    			choice = Integer.parseInt(br.readLine());    			
    		}catch(Exception e)
    		{
    			System.out.println("Please Enter a valid option");
    		}
    		
    		switch(choice) {
    		case 1:
    			int pchoice = 0;
    			do {
    				System.out.println("1. Add Patient");
    				System.out.println("2. View Patient Details");
    				System.out.println("3. Delete Patient");
    				System.out.println("4. View Patient Appointment");
    				System.out.println("5. Back");
    				
    				pchoice = Integer.parseInt(br.readLine());
    				
    				switch(pchoice)
    				{
    				case 1:
    					try {
	    					System.out.println("Enter first_name:");
	    	    			
	    	    			String first_name = br.readLine();
	    	    			
	    	    			System.out.println("Enter last_name:");
	    	    			
	    	    			String last_name = br.readLine();
	    	    			
	    	    			System.out.println("Enter date of birth(dd-mm-yyyy):");
	    	    			String dat = br.readLine();
	    	    			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    	    			LocalDate DOB = LocalDate.parse(dat, dtf);
	    	    			Date dob = Date.valueOf(DOB);
	    	    			
	    	    			Date reg_date = Date.valueOf(LocalDate.now());
	    	    			
	    	    			System.out.println("Enter your disease:");
	    	    			String disease = br.readLine();
	    	    			
	    	    			ds.addPatient(first_name, last_name, dob, reg_date, disease);
    					}catch(Exception e)
    					{
    						System.out.println("Please Enter Valid Input");
    					}
    	    			
    	    			break;
    				case 2:
    					System.out.println("Enter Patient Id: ");
    					
    					int idv = 0;
    					try {
    						idv = Integer.parseInt(br.readLine());
    						ds.viewPatientDetails(idv);
    					}catch(NumberFormatException e)
    					{
    						System.out.println("Enter a valid ID");
    					}
    					
    					break;

    				case 3:
    					System.out.println("Enter Patient Id: ");
    					
    					int idd = 0;
    					try {
    						idd = Integer.parseInt(br.readLine());
    						ds.deletePatient(idd);
    					}catch(NumberFormatException e)
    					{
    						System.out.println("Enter a valid ID");
    					}
    			
    					break;
    				case 4:
    					System.out.println("Enter Patient Id: ");
    					
    					int idb = 0;
    					try {
    						idb = Integer.parseInt(br.readLine());
    						ds.viewPatientAppointment(idb);
    					}catch(NumberFormatException e)
    					{
    						System.out.println("Enter a valid ID");
    					}
    			
    					break;
    				default:
    					System.out.println("Please Enter Valid Input");	
    				}
    				
    			}while(pchoice!=5);
    			break;
    		case 2:
    			int dchoice = 0;
    			
    			do {
	    			System.out.println("1. Add Doctor");
					System.out.println("2. View Doctor Appointments");
					System.out.println("3. Delete Doctor");
					System.out.println("4. Back");
					
					dchoice = Integer.parseInt(br.readLine());
    				
    				switch(dchoice)
    				{
    				case 1:
    					try {
	    					System.out.println("Enter first_name:");
	    	    			
	    	    			String first_name = br.readLine();
	    	    			
	    	    			System.out.println("Enter last_name:");
	    	    			
	    	    			String last_name = br.readLine();
	    	    			
	    	    			System.out.println("Enter Specialization: ");
	    	    			
	    	    			String specialization = br.readLine();
	    	    			
	    	    			Date hire_date = Date.valueOf(LocalDate.now());
	    	    			
	    	    			ds.addDoctor(first_name, last_name, specialization, hire_date);
    					}catch(Exception e)
    					{
    						System.out.println("Please Enter Valid Input");
    					}
    	    			break;
    				case 2:
    					System.out.println("Enter Doctor Id: ");
    					
    					int idv = 0;
    					
    					try {
    						idv = Integer.parseInt(br.readLine());
    						ds.viewDocAppointmentDetails(idv);
    					}catch(NumberFormatException e)
    					{
    						System.out.println("Please Enter a Valid Input");
    					}
    					
    					
    					break;

    				case 3:
    					System.out.println("Enter Doctor Id: ");
    					
    					int idd = Integer.parseInt(br.readLine());
    					
    					ds.deleteDoctor(idd);
    					
    					break;
    				default:
    					System.out.println("Please Enter A Valid Input");
    				}
    			}while(dchoice != 4);
    			break;
    		case 3:
    			System.out.println("Enter Patient Id: ");
    			int idv = 0;
				try {
					idv = Integer.parseInt(br.readLine());
					if(ds.getPatientById(idv))
					{
						ds.getAllDoctors();		
						
						System.out.println("Enter Doctor Id to match with: ");
						
						int did = 0;
						try {
							did = Integer.parseInt(br.readLine());							
							if(ds.getDoctorById(did))
							{
								ds.bookAppointment(idv, did);
							}else{
								System.out.println("No doctor with id "+ did+" was found");
							}
						}catch(NumberFormatException s)
						{
							System.out.println("Please Enter a valid ID");
							
						}
						
					}else {
						System.out.println("No patient with id "+idv+" exists.");
					}
				}
				catch(NumberFormatException e) {
					System.out.println("Invalid Patient ID");
				}
    		case 4:
    			break;
			default:
					System.out.println("Invalid Input, Please Try Again!");
    		}
    	}while(choice!=4);
	}
}