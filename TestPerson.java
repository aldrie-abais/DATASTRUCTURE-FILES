/******************************************************************************

Name: Aldrie U. Abais
Date: 02-15-2025
Description: 

*******************************************************************************/
class Person{
    
    private String lastName;
    private String firstName;
    private String middleName;
    private String storeMidName;
    private char sex;
    
    public Person(){
        lastName = "";
        firstName = "";
        middleName = "";
        sex = ' ';
    }
    public Person(String lastName, String firstName, String middleName, char sex){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.sex = sex;
    }
    
    public void setLastName(String lastName){
        if(lastName.equals("")){
            System.out.println("Invalid last name");
        }
        else
            this.lastName = lastName;
    }
    
    public void setFirstName(String firstName){
        if(firstName.equals(""))
            System.out.println("Invalid first name");
        else
            this.firstName = firstName;
    }
    
    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }    
    
    public void setStoreMidName(String storeMidName){
        this.storeMidName = storeMidName;
    }
    
    public void setSex(char sex){
        if(sex == 'M' || sex == 'm' && sex == 'F' || sex == 'f')
            this.sex = sex;
        else
            System.out.println("Invalid sex (M or F only).");
    }
    
    public String getLastName(){ return lastName; }
    public String getFirstName(){ return firstName; }
    public String getMiddleName(){ return middleName; }
    public String getStoreMidName(){ return storeMidName; }
    public char getSex(){ return sex; }
    
    public void marry(Person p){
        if( (this.sex == 'M' || this.sex == 'm') && (p.sex == 'M' || p.sex == 'm')
            ||
            (this.sex == 'F' || this.sex == 'f') && (p.sex == 'F' || p.sex == 'f')
          )
        {
            System.out.println("Sorry, this program cannot process this request.");
        }
        
        else{
            if(this.sex == 'F' || this.sex == 'f'){
                this.storeMidName = this.middleName;
                this.middleName = this.lastName;
                this.lastName = p.lastName;
            }else{
                p.setStoreMidName(p.getMiddleName());
                p.setMiddleName(p.getLastName());
                p.setLastName(this.lastName);
            }
        }
    }
    
    public void divorce(Person p){
            if(this.sex == 'F' || this.sex == 'f'){
                this.lastName = this.middleName;
                this.middleName = this.storeMidName;
            }else{
                p.setLastName(p.getMiddleName());
                p.setMiddleName(p.getStoreMidName());
            }        
    }
    
    public void display(){
        System.out.println(lastName + ", " + firstName + "  " + middleName +  "(" + sex + ")" );
    }
    
}

public class TestPerson
{
	public static void main(String[] args) {
		Person lalaki = new Person("Santos", "Mario", "J", 'M');
		Person babae = new Person("Quinto", "Luisa", "K", 'F');
		Person party3 = new Person("Perez", "Mark", "", 'm');
		
		lalaki.display();
		babae.display();
		lalaki.marry(babae);
		
		System.out.println();
		
		System.out.println("Happily Married!");
		babae.display();
		System.out.println();
		
		System.out.println("Sadly Divorced!");
		babae.divorce(lalaki);
		
		babae.display();

        // lalaki.display();
        // party3.display();
        
        // party3.marry(lalaki);
	}
}