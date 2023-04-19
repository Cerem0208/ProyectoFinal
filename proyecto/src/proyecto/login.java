package proyecto;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class login {

	public String sName;
	public String sUsername;
	public String sAddress;
	public String sMail;
	public String sPassword;
	
	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsUsername() {
		return sUsername;
	}

	public void setsUsername(String sUsername) {
		this.sUsername = sUsername;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public String getsMail() {
		return sMail;
	}

	public void setsMail(String sMail) {
		Scanner scan = new Scanner(System.in);
		if(!sMail.contains("@")) {
			scan = new Scanner(System.in);
			
			System.out.println("Esta no es una cuenta de correo válida, porfavor ingrese una que contenga @: ");
			String sMail2 = scan.nextLine();
			setsMail(sMail2);
			
        }else{
        	this.sMail = sMail;
        }
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		 String sRequirenments = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,10}$";
		 Scanner scan;
		 
		   if (!sPassword.matches(sRequirenments)) {
			   scan = new Scanner(System.in);
		       System.out.println("Contraseña no válida. debe contener, un carácter especial, una mayúscula, un número y ser entre 6-10 carácteres, pruebe nuevamente: ");  
		       String sPassword2 = scan.nextLine();
		       setsPassword(sPassword2);
		   }else {
			   this.sPassword = sPassword;
		   }
		}
	
	public void mlogin() {							//LOGIN DE USUARIO
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Ingrese su usuario o correo: ");
		String sUsernameInput = scan.nextLine();
		System.out.println("Ingrese su contraseña: ");
		String sPasswordInput = scan.nextLine();

		while((!sUsernameInput.equals(sUsername) && !sUsernameInput.equals(sMail)) || !sPasswordInput.equals(sPassword)){
			System.out.println("Usuario o contraseña incorrectos pruebe nuevamente...");
			System.out.println("Ingrese su usuario o correo: ");
			sUsernameInput = scan.nextLine();
			System.out.println("Ingrese su contraseña: ");
			sPasswordInput = scan.nextLine();
		}
	}
	
	public void tLogin() {							//LOGIN TRABAJADOR
		Scanner scan = new Scanner(System.in);
		int nCarne1 = 1234;
		
		System.out.println("Ingrese el carné de trabajador: ");
		int nCarne = scan.nextInt();
		
		while(!(nCarne1 == nCarne)) {
			System.out.println("Carné no válido, pruebe nuevamente...");
			System.out.println("Ingrese su carné: ");
			nCarne = scan.nextInt();
		}
	}
	
}


	


