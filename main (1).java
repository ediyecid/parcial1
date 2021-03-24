import java.util.ArrayList;
import java.util.Scanner;
public class main {


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int n, opcion; //Definimos las variables
        colores colorSeleccionado;
        String opcionVehiculo;
        String entradasUsuario [] = new String[10]; //Arreglo para almacenar varias entradas del usuario
        ArrayList<Object> garaje = new ArrayList(); // Definimos un arrayList de objetos
                                                    // para almacenar los diferentes objetos (tipos de vehiculos)
        
        
        do{ 
            System.out.println("Deseas agregar un vehiculo\n 1. Sí\n 2. Mostrar garaje\n 3. Salir  ");
            try {   
                opcion = Integer.parseInt(entrada.next());
            } catch (Exception e) {
                System.out.println("Entrada invalida");
                opcion = 0;
            }
            
            switch (opcion) {
                case 1:
                    do{
                        if (garaje.size() >= 10){
                            System.out.println("El garaje esta lleno");
                            break;
                        }
                        System.out.println("Elija una opción: \n A. Avion\n B. Yate\n C. Carro\n D. Salir");
                        opcionVehiculo = entrada.next();

                        switch (opcionVehiculo) {

                            case "A":
                                System.out.println("Ingrese los datos del avion");

                                System.out.println("Ingrese referencia:");
                                entradasUsuario[0] = entrada.next();

                                System.out.println("Ingrese velocidad maxima:");
                                entradasUsuario[1] = entrada.next();

                                System.out.println("Ingrese color");
                                for (colores colorIndice:colores.values()){  //Muestro los valores del ENUM
                                    System.out.println("   " + colorIndice.ordinal()+ ". "+colorIndice.toString()); //Muestro el indice y el nombre
                                }
                                entradasUsuario[2] = entrada.next(); //capturo la entrada del usuario
                                colorSeleccionado = colores.values()[Integer.parseInt(entradasUsuario[2])]; //De los valores de ENUM selecciono
                                                                                                            //el indice que escogio el usuario

                                System.out.println("Ingrese altura maxima");
                                entradasUsuario[3] = entrada.next();

                                garaje.add(new Avion(entradasUsuario[0], Integer.parseInt(entradasUsuario[1]), colorSeleccionado, entradasUsuario[3]));
                                System.out.println("vehiculo Agregado");
                                break;

                            case "B":
                                System.out.println("Ingrese los datos del Yate");

                                System.out.println("Ingrese referencia:");
                                entradasUsuario[0] = entrada.next();

                                System.out.println("Ingrese velocidad maxima:");
                                entradasUsuario[1] = entrada.next();

                                System.out.println("Ingrese color");
                                for (colores colorIndice:colores.values()){
                                    System.out.println("   " + colorIndice.ordinal()+ ". "+colorIndice.toString());
                                }
                                entradasUsuario[2] = entrada.next();
                                colorSeleccionado = colores.values()[Integer.parseInt(entradasUsuario[2])];

                                System.out.println("Ingrese peso maximo");
                                entradasUsuario[3] = entrada.next();

                                garaje.add(new Yate(entradasUsuario[0], Integer.parseInt(entradasUsuario[1]), colorSeleccionado, Integer.parseInt(entradasUsuario[3])));
                                System.out.println("vehiculo agregado");
                                break;
                            case "C":
                                System.out.println("Ingrese los datos del Carro");

                                System.out.println("Ingrese referencia:");
                                entradasUsuario[0] = entrada.next();

                                System.out.println("Ingrese velocidad maxima:");
                                entradasUsuario[1] = entrada.next();

                                System.out.println("Ingrese color");
                                for (colores colorIndice:colores.values()){
                                    System.out.println("   " + colorIndice.ordinal()+ ". "+colorIndice.toString());
                                }
                                entradasUsuario[2] = entrada.next();
                                colorSeleccionado = colores.values()[Integer.parseInt(entradasUsuario[2])];

                                System.out.println("Ingrese numero de puertas");
                                entradasUsuario[3] = entrada.next();

                                garaje.add(new Carro(entradasUsuario[0], Integer.parseInt(entradasUsuario[1]), colorSeleccionado, Integer.parseInt(entradasUsuario[3])));
                                System.out.println("vehiculo agregado");
                                break;
                            case "D":
                                System.out.println("Hasta luego! ");
                                opcionVehiculo = "D";
                                break;
    
                            default:
                                System.out.println("digitaste una opcion incorrecta ");
                        }
                    }while(opcionVehiculo != "D");
                    break;
                case 2:
                    if (garaje.size() == 0){
                        System.out.println("El garaje esta vacio");
                    }else{
                        System.out.println("Los vehiculos en el garaje son: ");
                        for (int i = 0; i < garaje.size(); i++){
                            System.out.println(garaje.get(i).getClass().getName() + garaje.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Digitaste una opcion incorrecta ");
            }
        }while(opcion != 3);
    }
}