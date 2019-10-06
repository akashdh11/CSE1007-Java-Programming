package question9;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

class Donor implements Serializable {
    String name, address, contact, bgroup;
    Date dold;
    int age;

    Donor(String name, String address,String contact, String bgroup, Date dold, int age) {
        this.name = name;
        this.address = address;
        this.contact=contact;
        this.bgroup = bgroup;
        this.dold = dold;
        this.age = age;
    }

    public void display() {
        System.out.println("Name:" + name + "\nAddress:" + address + "\nContact No.:"+contact+"\nBlood group:" + bgroup +
                "\nLast Date of donation:" + dold + "\nAge:" + age);
    }
}

public class Main {
    public static int getMonths(Date start) {
        Calendar startCal = new GregorianCalendar();
        startCal.setTime(start);
        Calendar endCal = new GregorianCalendar();
        endCal.setTime(new Date());

        int diffYear = endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCal.get(Calendar.MONTH) - startCal.get(Calendar.MONTH);

        return diffMonth;
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Donor donors[] = new Donor[100];

        System.out.print("Enter the No. of donors:");
        int n=read.nextInt();

        for(int i=0;i<n;i++)
        {
            System.out.println("--------------------------------------------------\nEnter Details of Donor "+ (i+1));
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter Name:");
            String name=sc.nextLine();
            System.out.print("Enter Address:");
            String address=sc.nextLine();
            System.out.print("Enter Contact No.:");
            String contact=sc.nextLine();
            System.out.print("Enter Blood Group:");
            String bgroup=sc.nextLine();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.print("Enter Date:");
                Date date = sdf.parse(sc.nextLine());
                System.out.print("Enter age:");
                int age=sc.nextInt();
                donors[0] = new Donor(name, address,contact, bgroup, date,age);
            }catch (ParseException e){
                System.out.println(e);
            }

        }

        String filename = "donations.txt";
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(donors);
            oos.close();
            fos.close();
            System.out.println("File Writting Successful \n--------------------------------------------------");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Donor[] savedDonors = (Donor[]) ois.readObject();

            fis.close();
            ois.close();

            System.out.println("Donors with A+ve and not donated for last 6 months: ");
            for (int i=0;i<n;i++) {
                if (getMonths(savedDonors[i].dold) > 6 && savedDonors[i].bgroup.equals("A+ve"))
                    savedDonors[i].display();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

