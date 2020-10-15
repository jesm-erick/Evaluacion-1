import java.util.Scanner;

import data.ItemsData;
import entidades.Items;

public class Main {
    public static void main(String[] args) {
        ItemsData dataitem = new ItemsData();
        Scanner input = new Scanner(System.in);
        int opt = 0;
        do {
            System.out.println("***** CRUD ITEMS *****");
            System.out.println("1 List ");
            System.out.println("2 New ");
            System.out.println("3 Delete ");
            System.out.println("4 Get byID ");
            System.out.println("5 Update ");
            System.out.println("0 Exit ");
            System.out.println("Choice option: ");
            opt = input.nextInt();
            System.out.println("You chosed: " + opt);
            input.nextLine(); 
            switch (opt) {
                case 1:
                    System.out.println("Listado de items ");
                    for (Items u : dataitem.list("")) {
                        System.out.println(u.getId() + "\t" + u.getNombre() + "\t" + u.getCategoria() + "\t" + u.getFamilia() + "\t" + u.getPrecio());
                    }
                    break;
                case 2:
                    System.out.println("Nuevo items ");
                    Items t = new Items();
                    System.out.print("nombre: ");
                    t.setNombre(input.nextLine());
                    System.out.print("categoria: ");
                    t.setCategoria(input.nextLine());
                    System.out.print("familia: ");
                    t.setFamilia(input.nextLine());

                    System.out.print("precio: ");
                    try {
                        t.setPrecio(input.nextInt());
                        dataitem.create(t);
                    } catch (Exception e) {
                        input.nextLine(); // Limpiar el buffer
                        System.out.print("el precio  debe ser entero, no se guardo");
                    }

                    break;
                case 3:
                    System.out.println("Eliminar items ");
                    System.out.print("id: ");
                    dataitem.delete(input.nextInt());
                    break;
                case 4:
                    int b4 = 1;
                    do {
                        System.out.println("get items ");
                        System.out.print("id: ");
                        int id = 0;
                        try {
                            b4 = 0;
                            id = input.nextInt();
                            Items i = dataitem.get(id);
                            if (i != null) {
                                System.out.println("Id: " + i.getId());
                                System.out.println("nombre: " + i.getNombre());
                                System.out.println("categoria: " + i.getCategoria());
                                System.out.println("familia: " + i.getFamilia());
                                System.out.println("precio: " + i.getPrecio());
                            } else {
                                System.out.print("el items no existe");
                            }
                        } catch (Exception e) {
                            input.nextLine(); // Limpiar el buffer
                            System.out.print("id no valido, debe ser un numero");
                            b4 = 1;
                        }

                    } while (b4 != 0);

                    break;
                case 5:
                    System.out.println("update items ");
                    System.out.print("id: ");

                    Items ite = dataitem.get(input.nextInt());

                    if (ite != null) {
                        System.out.println("nombre current: " + ite.getNombre());
                        System.out.println("categoria current: " + ite.getCategoria());
                        System.out.println("familia current: " + ite.getFamilia());
                        System.out.println("precio current: " + ite.getPrecio()) ;


                        input.nextLine(); // Limpiar el buffer
                        System.out.print("new nombre: ");
                        ite.setNombre(input.nextLine());

                        System.out.print("new categoria: ");
                        ite.setCategoria(input.nextLine());

                        System.out.print("new familia: ");
                        ite.setFamilia(input.nextLine());


                        System.out.print("new precio: ");
                        try {
                            ite.setPrecio(input.nextInt());
                            dataitem.update(ite);
                        } catch (Exception e) {
                            // per.setAge(0);
                            input.nextLine(); // Limpiar el buffer
                            System.out.print(" el precio debe ser entero, no se guardo");
                        }

                    } else {
                        System.out.println("NO encontrado");
                    }

                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        } while (opt != 0);
    }
}
