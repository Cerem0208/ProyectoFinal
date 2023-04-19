package proyecto;
import java.sql.Time;
import java.util.Scanner;
import java.util.Timer;
import proyecto.parqueo;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class PlataformaBicicletas {
    parqueo Parqueo1 = new parqueo(0, 0, null, null, 0);
    parqueo Parqueo2 = new parqueo(0, 0, null, null, 0);
    parqueo Parqueo3 = new parqueo(0, 0, null, null, 0);

    parqueo[] Parqueos1 = new parqueo[3];
    parqueo[] Parqueos2 = new parqueo[4];
    parqueo[] Parqueos3 = new parqueo[5];
    Timer timer = new Timer();

    private double precioPorHora = 10000; // Precio por hora por defecto en colones
    private int totalAlquileres = 0;	
    private double totalRecaudado = 0;
    private double precio_con_IVA = 0;
    private double precio_sin_IVA = 0;
    private double IVA = 0;
    double p_m, p_s;

    public void llenar_parqueo1(parqueo[] array) {
        Scanner scan; //= new Scanner(System.in);
        for (int i = 0; i < Parqueos1.length; i++) {
            scan = new Scanner(System.in);

            System.out.println("Ingrese la disponibilidad de la bicicleta número: " + i + 1 + " (0 para no disponible /1 para disponible)");
            int m = scan.nextInt();
            if (m == 1) {
                Parqueo1.setnBicicleta(i + 1);
                Parqueo1.setnDisponibilidad(i + 1);
                Parqueos1[i] = new parqueo(i, i, null, null, 0);
            } else {
                if (m == 0) {
                    System.out.println("No disponible");
                }
            }
        }
    }

    public void llenar_parqueo2(parqueo[] array) {
        Scanner scan; //= new Scanner(System.in);
        for (int i = 0; i < Parqueos2.length; i++) {
            scan = new Scanner(System.in);

            System.out.println("Ingrese la disponibilidad de la bicicleta número: " + i + 1 + " (0 para no disponible /1 para disponible)");
            int m = scan.nextInt();
            if (m == 1) {
                Parqueo2.setnBicicleta(i + 1);
                Parqueo2.setnDisponibilidad(i + 1);
                Parqueos2[i] = new parqueo(i, i, null, null, 0);
            } else {
                if (m == 0) {
                    System.out.println("No disponible");
                }
            }
        }
    }

    public void llenar_parqueo3(parqueo[] array) {
        Scanner scan; //= new Scanner(System.in);
        for (int i = 0; i < Parqueos3.length; i++) {
            scan = new Scanner(System.in);
            System.out.println("Ingrese la disponibilidad de la bicicleta número: " + i + 1 + " (0 para no disponible /1 para disponible)");
            int m = scan.nextInt();
            if (m == 1) {
                Parqueo3.setnBicicleta(i + 1);
                Parqueo3.setnDisponibilidad(i + 1);
                Parqueos3[i] = new parqueo(i, i, null, null, 0);
            } else {
                if (m == 0) {
                    System.out.println("No disponible");
                }
            }
        }
    }

    public void mostrarDisp_1(parqueo[] array) {
        System.out.println("En el parqueo #1 hay " + Parqueo1.getnBicicleta() + " bicicletas disponibles");
    }

    public void mostrarDisp_2(parqueo[] array) {
        System.out.println("En el parqueo #2 hay " + Parqueo2.getnBicicleta() + " bicicletas disponibles");
    }

    public void mostrarDisp_3(parqueo[] array) {

        System.out.println("En el parqueo #3 hay " + Parqueo3.getnBicicleta() + " bicicletas disponibles");
    }

    public void alquilar_1(parqueo[] array) {
       
        DecimalFormat formato = new DecimalFormat("0.00");
        Scanner scan;
        scan = new Scanner(System.in);
        if (Parqueo1.getnDisponibilidad() > 0) {
            Parqueo1.setnDisponibilidad(Parqueo1.getnDisponibilidad() - 1);
            Parqueo1.setnBicicleta(Parqueo1.getnBicicleta() - 1);
            System.out.println("Has alquilado una bicicleta en el parqueo #1");
            System.out.println("Cada hora son " + precioPorHora + " colones + IVA");
            System.out.println("Presiona 1 para iniciar el contador y 0 para detenerlo.");
            Time horaInicioRenta = new Time(System.currentTimeMillis());
            Parqueo1.setnTiempoRenta(horaInicioRenta);
            totalAlquileres++;
            if (scan.nextInt() == 1) {
                Time horaInicioContador = new Time(System.currentTimeMillis());
                System.out.println(" a las "+ horaInicioContador.getHours()+ ":" + horaInicioContador.getMinutes() + ":" + horaInicioContador.getSeconds());
                if (scan.nextInt() == 0) {
                    Time horaFinContador = new Time(System.currentTimeMillis());
                    long duracionReal = (horaFinContador.getTime() - horaInicioContador.getTime()) / 1000;
                    long minutos = duracionReal / 60;
                    long segundos = duracionReal % 60;
                    System.out.println("La bicicleta fue utilizada por " + minutos + ":" + segundos + " minutos.");

                    Time horaDevolucion = new Time(System.currentTimeMillis());
                    Parqueo3.setnTiempoDevolucion(horaDevolucion);

                    int disp_1 = 3 - Parqueo1.getnDisponibilidad();
                    int disp_2 = 4 - Parqueo2.getnDisponibilidad();
                    int disp_3 = 5 - Parqueo3.getnDisponibilidad();

                    System.out.println("Digite el parqueo en el que va a realizar la devolución: ");
                    System.out.println("1 = En el parqueo #1 hay " + disp_1 + " espacios disponibles");
                    System.out.println("2 = En el parqueo #2 hay " + disp_2 + " espacios disponibles");
                    System.out.println("3 = En el parqueo #3 hay " + disp_3 + " espacios disponibles");
                    int dev = 1;
                    while (dev != 923435) {
                        dev = scan.nextInt();
                        if (dev == 1) {
                            if (Parqueo1.getnDisponibilidad() < 3) {

                                Parqueo1.setnBicicleta(Parqueo1.getnBicicleta() + 1);
                                Parqueo1.setnDisponibilidad(Parqueo1.getnDisponibilidad() + 1);
                                double min = minutos;
                                double seg = segundos / 60.0;
                                double pxh = precioPorHora;
                                precio_sin_IVA = (min + seg) * precioPorHora;
                                IVA = precio_sin_IVA * 0.13;
                                precio_con_IVA = precio_sin_IVA + IVA;
                                totalRecaudado = totalRecaudado + precio_con_IVA; 
                                System.out.println("Son: " + formato.format(precio_sin_IVA) + " colones por el tiempo utilizado");
                                System.out.println("IVA: " + formato.format(IVA) + " colones");
                                System.out.println("Total a pagar: " + formato.format(precio_con_IVA) + " colones.");
                                System.out.println("Digite 1 si realizó la transacción:");
                                        int terminar = scan.nextInt();
                                        if (terminar == 1) {
                                            break;

                                        } else {
                                            System.out.println("Digite una opción valida");
                                        }
                                break;

                            } else {
                                System.out.println("Digite un parqueo con disponibilidad");
                            }
                        } else {
                            if (dev == 2) {
                                if (Parqueo2.getnDisponibilidad() < 4) {

                                    Parqueo2.setnBicicleta(Parqueo2.getnBicicleta() + 1);
                                    Parqueo2.setnDisponibilidad(Parqueo2.getnDisponibilidad() + 1);
                                    double min = minutos;
                                    double seg = segundos / 60.0;
                                    double pxh = precioPorHora;
                                    precio_sin_IVA = (min + seg) * precioPorHora;
                                    IVA = precio_sin_IVA * 0.13;
                                    precio_con_IVA = precio_sin_IVA + IVA;
                                    totalRecaudado = totalRecaudado + precio_con_IVA; 
                                    System.out.println("Son: " + formato.format(precio_sin_IVA) + " colones por el tiempo utilizado");
                                    System.out.println("IVA: " + formato.format(IVA) + " colones");
                                    System.out.println("Total a pagar: " + formato.format(precio_con_IVA) + " colones.");
                                    System.out.println("Digite 1 si realizó la transacción:");
                                        int terminar = scan.nextInt();
                                        if (terminar == 1) {
                                            break;

                                        } else {
                                            System.out.println("Digite una opción valida");
                                        }
                                    break;

                                } else {
                                    System.out.println("Digite un parqueo con disponibilidad");
                                }
                            } else {
                                if (dev == 3) {
                                    if (Parqueo3.getnDisponibilidad() < 5) {

                                        Parqueo3.setnBicicleta(Parqueo3.getnBicicleta() + 1);
                                        Parqueo3.setnDisponibilidad(Parqueo3.getnDisponibilidad() + 1);
                                        double min = minutos;
                                        double seg = segundos / 60.0;
                                        double pxh = precioPorHora;
                                        precio_sin_IVA = (min + seg) * precioPorHora;
                                        IVA = precio_sin_IVA * 0.13;
                                        precio_con_IVA = precio_sin_IVA + IVA;
                                        totalRecaudado = totalRecaudado + precio_con_IVA; 
                                        System.out.println("Son: " + formato.format(precio_sin_IVA) + " colones por el tiempo utilizado");
                                        System.out.println("IVA: " + formato.format(IVA) + " colones");
                                        System.out.println("Total a pagar: " + formato.format(precio_con_IVA) + " colones.");
                                        System.out.println("Digite 1 si realizó la transacción:");
                                        int terminar = scan.nextInt();
                                        if (terminar == 1) {
                                            break;

                                        } else {
                                            System.out.println("Digite una opción valida");
                                        }
                                        break;

                                    } else {
                                        System.out.println("Digite una opción valida");
                                    }
                                }
                            }
                        }
                    }

                } else {
                    System.out.println("Valor inválido.");
                }
            }
        } else {
            System.out.println("No hay disponibilidad de bicicletas en este parqueo.");
        }
    }

    public void alquilar_2(parqueo[] array) {
        DecimalFormat formato = new DecimalFormat("0.00");
        Scanner scan;
        scan = new Scanner(System.in);
        if (Parqueo2.getnDisponibilidad() > 0) {
            Parqueo2.setnDisponibilidad(Parqueo2.getnDisponibilidad() - 1);
            Parqueo2.setnBicicleta(Parqueo2.getnBicicleta() - 1);
            System.out.println("Has alquilado una bicicleta en el parqueo #2");
            System.out.println("Cada hora son " + precioPorHora + " colones + IVA");
            System.out.println("Presiona 1 para iniciar el contador y 0 para detenerlo.");
            Time horaInicioRenta = new Time(System.currentTimeMillis());
            Parqueo2.setnTiempoRenta(horaInicioRenta);
             totalAlquileres++;
            if (scan.nextInt() == 1) {
                Time horaInicioContador = new Time(System.currentTimeMillis());
                System.out.println("Contador iniciado a las " + horaInicioContador.getHours()+":"+ horaInicioContador.getMinutes() + ":" + horaInicioContador.getSeconds());
                if (scan.nextInt() == 0) {
                    Time horaFinContador = new Time(System.currentTimeMillis());
                    long duracionReal = (horaFinContador.getTime() - horaInicioContador.getTime()) / 1000;
                    long minutos = duracionReal / 60;
                    long segundos = duracionReal % 60;
                    System.out.println("La bicicleta fue utilizada por " + minutos + ":" + segundos + " minutos.");

                    Time horaDevolucion = new Time(System.currentTimeMillis());
                    Parqueo3.setnTiempoDevolucion(horaDevolucion);

                    int disp_1 = 3 - Parqueo1.getnDisponibilidad();
                    int disp_2 = 4 - Parqueo2.getnDisponibilidad();
                    int disp_3 = 5 - Parqueo3.getnDisponibilidad();

                    System.out.println("Digite el parqueo en el que va a realizar la devolución: ");
                    System.out.println("1 = En el parqueo #1 hay " + disp_1 + " espacios disponibles");
                    System.out.println("2 = En el parqueo #2 hay " + disp_2 + " espacios disponibles");
                    System.out.println("3 = En el parqueo #3 hay " + disp_3 + " espacios disponibles");
                    int dev = 1;
                    while (dev != 923435) {
                        dev = scan.nextInt();
                        if (dev == 1) {
                            if (Parqueo1.getnDisponibilidad() < 3) {

                                Parqueo1.setnBicicleta(Parqueo1.getnBicicleta() + 1);
                                Parqueo1.setnDisponibilidad(Parqueo1.getnDisponibilidad() + 1);
                                double min = minutos;
                                double seg = segundos / 60.0;
                                double pxh = precioPorHora;
                                precio_sin_IVA = (min + seg) * precioPorHora;
                                IVA = precio_sin_IVA * 0.13;
                                precio_con_IVA = precio_sin_IVA + IVA;
                                totalRecaudado = totalRecaudado + precio_con_IVA; 
                                System.out.println("Son: " + formato.format(precio_sin_IVA) + " colones por el tiempo utilizado");
                                System.out.println("IVA: " + formato.format(IVA) + " colones");
                                System.out.println("Total a pagar: " + formato.format(precio_con_IVA) + " colones.");
                                System.out.println("Digite 1 si realizó la transacción:");
                                        int terminar = scan.nextInt();
                                        if (terminar == 1) {
                                            break;

                                        } else {
                                            System.out.println("Digite una opción valida");
                                        }
                                break;

                            } else {
                                System.out.println("Digite un parqueo con disponibilidad");
                            }
                        } else {
                            if (dev == 2) {
                                if (Parqueo2.getnDisponibilidad() < 4) {

                                    Parqueo2.setnBicicleta(Parqueo2.getnBicicleta() + 1);
                                    Parqueo2.setnDisponibilidad(Parqueo2.getnDisponibilidad() + 1);
                                    double min = minutos;
                                    double seg = segundos / 60.0;
                                    double pxh = precioPorHora;
                                    precio_sin_IVA = (min + seg) * precioPorHora;
                                    IVA = precio_sin_IVA * 0.13;
                                    precio_con_IVA = precio_sin_IVA + IVA;
                                    totalRecaudado = totalRecaudado + precio_con_IVA; 
                                    System.out.println("Son: " + formato.format(precio_sin_IVA) + " colones por el tiempo utilizado");
                                    System.out.println("IVA: " + formato.format(IVA) + " colones");
                                    System.out.println("Total a pagar: " + formato.format(precio_con_IVA) + " colones.");
                                    System.out.println("Digite 1 si realizó la transacción:");
                                        int terminar = scan.nextInt();
                                        if (terminar == 1) {
                                            break;

                                        } else {
                                            System.out.println("Digite una opción valida");
                                        }
                                    break;

                                } else {
                                    System.out.println("Digite un parqueo con disponibilidad");
                                }
                            } else {
                                if (dev == 3) {
                                    if (Parqueo3.getnDisponibilidad() < 5) {

                                        Parqueo3.setnBicicleta(Parqueo3.getnBicicleta() + 1);
                                        Parqueo3.setnDisponibilidad(Parqueo3.getnDisponibilidad() + 1);
                                        double min = minutos;
                                        double seg = segundos / 60.0;
                                        double pxh = precioPorHora;
                                        precio_sin_IVA = (min + seg) * precioPorHora;
                                        IVA = precio_sin_IVA * 0.13;
                                        precio_con_IVA = precio_sin_IVA + IVA;
                                        totalRecaudado = totalRecaudado + precio_con_IVA; 
                                        System.out.println("Son: " + formato.format(precio_sin_IVA) + " colones por el tiempo utilizado");
                                        System.out.println("IVA: " + formato.format(IVA) + " colones");
                                        System.out.println("Total a pagar: " + formato.format(precio_con_IVA) + " colones.");
                                        System.out.println("Digite 1 si realizó la transacción:");
                                        int terminar = scan.nextInt();
                                        if (terminar == 1) {
                                            break;

                                        } else {
                                            System.out.println("Digite una opción valida");
                                        }
                                        break;

                                    } else {
                                        System.out.println("Digite una opción valida");
                                    }
                                }
                            }
                        }
                    }

                } else {
                    System.out.println("Valor inválido.");
                }
            }
        } else {
            System.out.println("No hay disponibilidad de bicicletas en este parqueo.");
        }
    }

    public void alquilar_3(parqueo[] array) {
        DecimalFormat formato = new DecimalFormat("0.00");
        Scanner scan;
        scan = new Scanner(System.in);
        if (Parqueo3.getnDisponibilidad() > 0) {
            Parqueo3.setnDisponibilidad(Parqueo3.getnDisponibilidad() - 1);
            Parqueo3.setnBicicleta(Parqueo3.getnBicicleta() - 1);
            System.out.println("Has alquilado una bicicleta en el parqueo #3");
            System.out.println("Cada hora son " + precioPorHora + " colones + IVA");
            System.out.println("Presiona 1 para iniciar el contador y 0 para detenerlo.");
            Time horaInicioRenta = new Time(System.currentTimeMillis());
            Parqueo3.setnTiempoRenta(horaInicioRenta);
            if (scan.nextInt() == 1) {
                Time horaInicioContador = new Time(System.currentTimeMillis());
                 totalAlquileres++;
                System.out.println("Contador iniciado a las " + horaInicioContador.getHours()+":"+ horaInicioContador.getMinutes() + ":" + horaInicioContador.getSeconds());
                if (scan.nextInt() == 0) {
                    Time horaFinContador = new Time(System.currentTimeMillis());
                    long duracionReal = (horaFinContador.getTime() - horaInicioContador.getTime()) / 1000;
                    long minutos = duracionReal / 60;
                    long segundos = duracionReal % 60;
                    System.out.println("La bicicleta fue utilizada por " + minutos + ":" + segundos + " minutos.");

                    Time horaDevolucion = new Time(System.currentTimeMillis());
                    Parqueo3.setnTiempoDevolucion(horaDevolucion);

                    int disp_1 = 3 - Parqueo1.getnDisponibilidad();
                    int disp_2 = 4 - Parqueo2.getnDisponibilidad();
                    int disp_3 = 5 - Parqueo3.getnDisponibilidad();

                    System.out.println("Digite el parqueo en el que va a realizar la devolución: ");
                    System.out.println("1 = En el parqueo #1 hay " + disp_1 + " espacios disponibles");
                    System.out.println("2 = En el parqueo #2 hay " + disp_2 + " espacios disponibles");
                    System.out.println("3 = En el parqueo #3 hay " + disp_3 + " espacios disponibles");
                    int dev = 1;
                    while (dev != 923435) {
                        dev = scan.nextInt();
                        if (dev == 1) {
                            if (Parqueo1.getnDisponibilidad() < 3) {

                                Parqueo1.setnBicicleta(Parqueo1.getnBicicleta() + 1);
                                Parqueo1.setnDisponibilidad(Parqueo1.getnDisponibilidad() + 1);
                                double min = minutos;
                                double seg = segundos / 60.0;
                                double pxh = precioPorHora;
                                precio_sin_IVA = (min + seg) * precioPorHora;
                                IVA = precio_sin_IVA * 0.13;
                                precio_con_IVA = precio_sin_IVA + IVA;
                                totalRecaudado = totalRecaudado + precio_con_IVA;
                                System.out.println("Son: " + formato.format(precio_sin_IVA) + " colones por el tiempo utilizado");
                                System.out.println("IVA: " + formato.format(IVA) + " colones");
                                System.out.println("Total a pagar: " + formato.format(precio_con_IVA) + " colones.");
                                System.out.println("Digite 1 si realizó la transacción:");
                                        int terminar = scan.nextInt();
                                        if (terminar == 1) {
                                            break;

                                        } else {
                                            System.out.println("Digite una opción valida");
                                        }
                                break;

                            } else {
                                System.out.println("Digite un parqueo con disponibilidad");
                            }
                        } else {
                            if (dev == 2) {
                                if (Parqueo2.getnDisponibilidad() < 4) {

                                    Parqueo2.setnBicicleta(Parqueo2.getnBicicleta() + 1);
                                    Parqueo2.setnDisponibilidad(Parqueo2.getnDisponibilidad() + 1);
                                    double min = minutos;
                                    double seg = segundos / 60.0;
                                    double pxh = precioPorHora;
                                    double precio_sin_IVA = (min + seg) * precioPorHora;
                                    double IVA = precio_sin_IVA * 0.13;
                                    double precio_con_IVA = precio_sin_IVA + IVA;
                                    totalRecaudado = totalRecaudado + precio_con_IVA;
                                    System.out.println("Son: " + formato.format(precio_sin_IVA) + " colones por el tiempo utilizado");
                                    System.out.println("IVA: " + formato.format(IVA) + " colones");
                                    System.out.println("Total a pagar: " + formato.format(precio_con_IVA) + " colones.");
                                    System.out.println("Digite 1 si realizó la transacción:");
                                        int terminar = scan.nextInt();
                                        if (terminar == 1) {
                                            break;

                                        } else {
                                            System.out.println("Digite una opción valida");
                                        }
                                    break;

                                } else {
                                    System.out.println("Digite un parqueo con disponibilidad");
                                }
                            } else {
                                if (dev == 3) {
                                    if (Parqueo3.getnDisponibilidad() < 5) {

                                        Parqueo3.setnBicicleta(Parqueo3.getnBicicleta() + 1);
                                        Parqueo3.setnDisponibilidad(Parqueo3.getnDisponibilidad() + 1);
                                        double min = minutos;
                                        double seg = segundos / 60.0;
                                        double pxh = precioPorHora;
                                        precio_sin_IVA = (min + seg) * precioPorHora;
                                        IVA = precio_sin_IVA * 0.13;
                                        precio_con_IVA = precio_sin_IVA + IVA;
                                        totalRecaudado = totalRecaudado + precio_con_IVA;
                                        System.out.println("Son: " + formato.format(precio_sin_IVA) + " colones por el tiempo utilizado");
                                        System.out.println("IVA: " + formato.format(IVA) + " colones");
                                        System.out.println("Total a pagar: " + formato.format(precio_con_IVA) + " colones.");
                                        System.out.println("Digite 1 si realizó la transacción:");
                                        int terminar = scan.nextInt();
                                        if (terminar == 1) {
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
                    System.out.println("Valor inválido.");
                }
            }
        } else {
            System.out.println("No hay disponibilidad de bicicletas en este parqueo.");
        }
    }

    public void agregarBicicleta(int parqueoSeleccionado) {
        switch (parqueoSeleccionado) {
            case 1:
                if (Parqueo1.getnBicicleta() < Parqueos1.length) {
                    Parqueo1.setnBicicleta(Parqueo1.getnBicicleta() + 1);
                    Parqueo1.setnDisponibilidad(Parqueo1.getnDisponibilidad() + 1);
                    System.out.println("Bicicleta agregada al parqueo #1");
                } else {
                    System.out.println("No hay espacio disponible en el parqueo #1");
                }
                break;
            case 2:
                if (Parqueo2.getnBicicleta() < Parqueos2.length) {
                    Parqueo2.setnBicicleta(Parqueo2.getnBicicleta() + 1);
                    Parqueo2.setnDisponibilidad(Parqueo2.getnDisponibilidad() + 1);
                    System.out.println("Bicicleta agregada al parqueo #2");
                } else {
                    System.out.println("No hay espacio disponible en el parqueo #2");
                }
                break;
            case 3:
                if (Parqueo3.getnBicicleta() < Parqueos3.length) {
                    Parqueo3.setnBicicleta(Parqueo3.getnBicicleta() + 1);
                    Parqueo3.setnDisponibilidad(Parqueo3.getnDisponibilidad() + 1);
                    System.out.println("Bicicleta agregada al parqueo #3");
                } else {
                    System.out.println("No hay espacio disponible en el parqueo #3");
                }
                break;
            default:
                System.out.println("Opción de parqueo inválida");
                break;
        }
    }

    public void cambiarPrecioPorHora(double nuevoPrecio) {
        if (nuevoPrecio >= 0) {
            precioPorHora = nuevoPrecio;
            System.out.println("El nuevo precio por hora es: " + precioPorHora + " colones");
        } else {
            System.out.println("El precio ingresado no es válido. Debe ser un valor positivo.");
        }
    }
      public void mostrarDisponibilidadParqueos() {
    	mostrarDisp_1(Parqueos1);
    	mostrarDisp_2(Parqueos2);
    	mostrarDisp_3(Parqueos3);
      }
      
      public void generarReporte() {
   
    	System.out.println("Reporte de bicicletas alquiladas:");
    	System.out.println("Total de bicicletas alquiladas: " + totalAlquileres);
    	System.out.println("Total recaudado: " + totalRecaudado);
      }


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
}
