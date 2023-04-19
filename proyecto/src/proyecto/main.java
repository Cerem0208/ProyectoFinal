package proyecto;
import proyecto.PlataformaBicicletas;
import java.util.Scanner;
import java.util.Timer;

public class main {

    public static void main(String[] args) {

        login log = new login();
        Scanner scan = new Scanner(System.in);
        PlataformaBicicletas PB = new PlataformaBicicletas();
        parqueo[] Parqueo1 = new parqueo[3];						//SE INICIALIZAN LOS 3 PARQUEOS
        parqueo[] Parqueo2 = new parqueo[4];
        parqueo[] Parqueo3 = new parqueo[5];

        int nMenuLogin = 1;

        while (nMenuLogin != 0) {									//PROCESO DE LOGIN
            System.out.println("Presione 1 para ingresar como usuario: ");
            System.out.println("Preisone 2 para ingresar como trabajador: ");
            System.out.println("Presione 0 para finalizar el programa: ");
            nMenuLogin = scan.nextInt();
            scan.nextLine();
            if (nMenuLogin == 1) {
                System.out.println("Ingrese su nombre completo: ");	//RECOLECCIÓN DE DATOS DE USUARIO
                log.setsName(scan.nextLine());

                System.out.println("Ingrese su nombre de usuario: ");
                log.setsUsername(scan.nextLine());

                System.out.println("Ingrese su dirección física: ");
                log.setsAddress(scan.nextLine());

                System.out.println("Ingrese su correo: ");
                log.setsMail(scan.nextLine());

                System.out.println("Ingrese su contraseña: ");
                log.setsPassword(scan.nextLine());

                System.out.println("Inicio de sesión");
                log.mlogin();										//SE LLAMA A LA FUNCIÓN LOGIN DE USUARIO
                System.out.println("Inicio sesión existosamente!");

                PB.mostrarDisp_1(Parqueo1);
                PB.mostrarDisp_2(Parqueo2);
                PB.mostrarDisp_3(Parqueo3);
                int menu_aloren_devbic = 1;
                while (menu_aloren_devbic != 0) {

                    System.out.println("Digite la acción que quiere realizar:");
                    System.out.println("1 = Alquiler o renta de una bicicleta");
                    System.out.println("0 = Salir del menú");

                    menu_aloren_devbic = scan.nextInt();
                    scan.nextLine();

                    if (menu_aloren_devbic == 1) {

                        int alq_rent = 1;
                        while (alq_rent != 0) {
                            System.out.println("Digite el parqueo en el que se encuentra: ");
                            System.out.println("Parqueo 1");
                            System.out.println("Parqueo 2");
                            System.out.println("Parqueo 3");
                            System.out.println("O digite 0 para salir del menu");
                            alq_rent = scan.nextInt();
                            scan.nextLine();
                            if (alq_rent == 1) {

                                PB.alquilar_1(Parqueo1);
                                break;

                            } else {
                                if (alq_rent == 2) {

                                    PB.alquilar_2(Parqueo2);
                                    break;
                                } else {
                                    if (alq_rent == 3) {

                                        PB.alquilar_3(Parqueo3);
                                        break;
                                    } else {
                                        System.out.println("Digite una opción valida");
                                    }
                                }
                            }
                        }
                    }
                }

            } else {
                if (nMenuLogin == 2) {
                    log.tLogin();										//SE LLAMA A LA FUNCIÓN LOGIN DE TRABAJADOR

                    int nMenu1 = 1;
                    int nMenu2 = 1;

                    while (nMenu1 != 0) {
                        System.out.println("Presione 1 agregar bicicletas: ");
                        System.out.println("Presione 2 modificar el precio: ");
                         System.out.println("Presione 3 para ver la disponibiidad en los parqueos ");
                         System.out.println("Presione 4 para ver el reporte con las bicicletas alquiladas y los montos recaudados");

                        System.out.println("Presione 0 para salir de este menú: ");
                        nMenu1 = scan.nextInt();
                        scan.nextLine();
                        if (nMenu1 == 1) {
                              System.out.println("Ingrese en cual parqueo desea agregar una bicicleta (1,2 o 3)");
                              int nAgregarBici = scan.nextInt();
                              scan.nextLine();
                              PB.agregarBicicleta(nAgregarBici);
                        } else if (nMenu1 == 2) {
                        	System.out.println("Ingrese el nuevo precio por hora para el alquiler de bicicletas:");
                        	double nuevoPrecio = scan.nextDouble();
                        	PB.cambiarPrecioPorHora(nuevoPrecio);
                        } else if (nMenu1 == 3) {
                        	System.out.println("La disponibilidad de los parqueos es la siguente:");
                        	PB.mostrarDisponibilidadParqueos();
                        }  else if (nMenu1 == 4) {
                        	System.out.println("El reporte de las bicicletas alquiladas es el siguiente: ");
                        	PB.generarReporte();
                        }
                    }
                }
            }
           
      
        }
//----------------------------------------------------------------------------------------------------------------------------
		

	}
	
}
