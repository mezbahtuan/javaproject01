package JavaProject;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Filee {
    
    public Filee(){
    }
    
    public void AddEmployee(String st1 , char[] ca) {
        if(st1.length()>3 && ca.length>2){
            if(ConfirmAdd()){
                String st2 = CHtoSTR(ca);
                File f1 = new File("src\\JavaProject\\FileEmployee.txt");
                PrintWriter pr = null;
                
                try{
                    FileWriter fr = new FileWriter(f1,true);
                    BufferedWriter br = new BufferedWriter(fr);
                    pr = new PrintWriter(br);
                }catch(IOException e){ }
                if(f1.exists() == false){
                    try {
                        f1.createNewFile();
                    } catch (IOException ex) { }
                }
                String strr = st1+" "+st2;
                pr.println(strr);
                pr.close();
                
                Success("Addition Successfull !!!");
            }
        }
        else{
            Error("UserName & Password must be larger than 3 Words !!");
        }
        
    }
    
    public void AddFood(String st1) {
                File f1 = new File("src\\JavaProject\\FileFood.txt");
                PrintWriter pr = null;
                
                try{
                    FileWriter fr = new FileWriter(f1,true);
                    BufferedWriter br = new BufferedWriter(fr);
                    pr = new PrintWriter(br);
                }catch(IOException e){ }
                if(f1.exists() == false){
                    try {
                        f1.createNewFile();
                    } catch (IOException ex) { }
                }
                pr.println(st1);
                pr.close();
        
        
    }
    
    public boolean CheckEployee(String st1 , char[] ca) {
        String st2 = CHtoSTR(ca);
        String st = st1 +" "+ st2;
        File f1 = new File("src\\JavaProject\\FileEmployee.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(f1);
        } catch (FileNotFoundException ex) { }
        boolean x = false;
        
        while(sc.hasNext()){
            try{
            if(st.equalsIgnoreCase(sc.nextLine())){
                x = true;
                break;
            }
            }catch(Exception e){ }
        }
        return x;
    }
    private int number = 0;
    public String item(String st){
        File f1 = new File("src\\JavaProject\\FileFood.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(f1);
        } catch (FileNotFoundException ex) { }
        String x,y,z;
        int n = 0,num;
        while(sc.hasNext()){
            try{
                x= sc.next();
                y= sc.next();
                z= sc.next();
                num = Integer.parseInt(z);
            if(x.equalsIgnoreCase(st)){
                n = n + num;
            }
            }catch(Exception e){ }
        }
            z=""+n;
            arr2[number1] = n;
            number1++;
            number +=n;
            
            return z;
    }
    
    private int[] arr2 = new int[20];
    private int number1=0;
    private int[] arr = {120,110,90,90,70,350,400,450,180,150,80,20,140,10,10,30,90,20,30,30};
    
    public String Money(){
        int total = 0;
        
        for (int i = 0; i < 20; i++) {
            total += arr[i]*arr2[i];
        }
        return ""+total+".00";
    }
    
    public String totalItem(){
        String s = ""+number;
        return s;
    }
    
    
    public boolean CheckManager(String st1 , char[] ca) {
        String st2 = CHtoSTR(ca);
        String st = st1 +" "+ st2;
        File f1 = new File("src\\JavaProject\\FileManager.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(f1);
        } catch (FileNotFoundException ex) { }
        boolean x = false;
        
        while(sc.hasNext()){
            try{
            if(st.equalsIgnoreCase(sc.nextLine())){
                x = true;
                break;
            }
            }catch(Exception e){ }
        }
        return x;
    }
    public String[] MakeString(){
        File f1 = new File("src\\JavaProject\\FileEmployee.txt");
        Scanner sc = null;
        
        try {
            sc = new Scanner(f1);
        } catch (FileNotFoundException ex) { }
        
        String[] str = new String[30];
        int i=0;
        while(sc.hasNext()){
            str[i] = sc.nextLine();
            i++;
        }
        sc.close();
        
        return str;
    }
    
    public void blankFile(){
        File f1 = new File("src\\JavaProject\\FileEmployee.txt");
        PrintStream p = null;
        try {
            p = new PrintStream(f1);
        } catch (FileNotFoundException ex) { }
        p.print("");
        p.close();
    }
    
    public void RemoveEmployee(String st1 , char[] ca){
        if(ConfirmDel()){
           String st2 = CHtoSTR(ca);
                File f1 = new File("src\\JavaProject\\FileEmployee.txt");
                PrintWriter pr = null;
                
                try{
                    FileWriter fr = new FileWriter(f1,true);
                    BufferedWriter br = new BufferedWriter(fr);
                    pr = new PrintWriter(br);
                }catch(IOException e){ }
                
                String[] str = MakeString();
                blankFile();
                String s = st1+" "+st2;
                int i = 0;
                while(str[i] != null){
                    if(!str[i].equalsIgnoreCase(s)){
                      pr.println(str[i]);
                    }
                    i++;
                }
                pr.close();
        }
    }
    
    public void ForgetPass(String st1 , char[] ca){
        String st2 = CHtoSTR(ca);
        String s = st1+" "+st2;
        File f1 = new File("src\\JavaProject\\FileEmployee.txt");
        PrintWriter pr = null;
        
            try{
                FileWriter fr = new FileWriter(f1,true);
                BufferedWriter br = new BufferedWriter(fr);
                pr = new PrintWriter(br);
            }catch(IOException e){ }
            
        REm(st1,passR(st1));
        String[] str = MakeString();
        blankFile();
        int i = 0;
        while(str[i] != null){
            pr.println(str[i]);
            i++;
        }
        pr.println(s);
        pr.close();
        Success("Changing Password Successful.");
    }
    
    public String passR(String st1){
        File f1 = new File("src\\JavaProject\\FileEmployee.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(f1);
        } catch (FileNotFoundException ex) { }
        
        String a,b = null;
        while(sc.hasNext()){
            a = sc.next();
            b = sc.next();
            if(a.equalsIgnoreCase(st1)){
                break;
            }
        }
        return b;
    }
    
    public String CHtoSTR(char[] ch){
        String s = "";
        for(char x : ch){
            s += x;
        }
        return s; 
    }
    
    public boolean ConfirmDel(){
        int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to REMOVE this Employee ??");
        if(n == 0)
            return true;
        else
            return false;   
    }
    
    public boolean ConfirmLogOut(){
        int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to Log Out ??");
        if(n == 0)
            return true;
        else
            return false;   
    }
    
    public boolean ConfirmFood(){
        int n = JOptionPane.showConfirmDialog(null, "Are you sure you don't want to edit ??");
        if(n == 0)
            return true;
        else
            return false;   
    }
    
    public boolean ConfirmAdd(){
        int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to ADD this Employee ??");
        if(n == 0)
            return true;
        else
            return false;   
    }
    
    public void Error(String st){
        JOptionPane.showMessageDialog(null, st , "Error!!" , JOptionPane.ERROR_MESSAGE);
    }
    
    public void Success(String st){
        JOptionPane.showMessageDialog(null, st , "Successful !!" , JOptionPane.INFORMATION_MESSAGE);
    }
    
    public boolean FirstName(String st1){
        File f1 = new File("src\\JavaProject\\FileEmployee.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(f1);
        } catch (FileNotFoundException ex) { }
        boolean x = false;
        
        String a;
        while(sc.hasNext()){
            a = sc.next();
            if(a.equalsIgnoreCase(st1)){
                x = true;
                break;
            }
        }
        return x;
    }
    
    public void REm(String st1 , String st2){
                File f1 = new File("src\\JavaProject\\FileEmployee.txt");
                PrintWriter pr = null;
                
                try{
                    FileWriter fr = new FileWriter(f1,true);
                    BufferedWriter br = new BufferedWriter(fr);
                    pr = new PrintWriter(br);
                }catch(IOException e){ }
                
                String[] str = MakeString();
                blankFile();
                String s = st1+" "+st2;
                int i = 0;
                while(str[i] != null){
                    if(!str[i].equalsIgnoreCase(s)){
                      pr.println(str[i]);
                    }
                    i++;
                }
                pr.close();
    }
}
