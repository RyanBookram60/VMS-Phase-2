import java.util.Scanner;

/**
 * Ryan Bookram
 * Software Development (14877)
 * October 10, 2025
 * VMS.java
 * This class operates as a Vehicle Managment System, allowing users to store and manipulate vehicle attributes
 */
public class VMS {

    /**
     * Method: Main
     * Return: None
     * Purpose: Incorporates a menu system to allow users to interact with the managment system
     */
    public static void main(String[] args) {

        VehicleManager vm = new VehicleManager();
        Scanner scnr = new Scanner(System.in);
        String input;
        boolean exit = false;

        System.out.println("\nWelcome to the Vehicle Managment System!");

        while (!exit) {

            System.out.println("\nAvailable Commands (Enter a number):");
            System.out.println("1 - Adds a vehicle to the list based on the format: VIN-Make-Model-Price-Trans-Miles-Color-Drivetrain");
            System.out.println("2 - Adds multiple vehicles from a text file using a file path as input");
            System.out.println("3 - Removes a vehicle using a VIN number");
            System.out.println("4 - Updates a vehicle in the system based off of the VIN number entered");
            System.out.println("5 - Estimates the condition of a vehicle based off of mileage using a VIN number");
            System.out.println("6 - Prints all vehicles in the system");
            System.out.println("7 - Exits the system\n");

            input = scnr.nextLine();

            if(input.equals("1")){

                System.out.println("\nEnter the vehicle to be added. Format: VIN-Make-Model-Price-Trans-Miles-Color-Drivetrain\n");

                input = scnr.nextLine();

                System.out.println("\n" + vm.addVehicle(input) + "\n");
            }
            else if(input.equals("2")){

                System.out.println("\nEnter the file path of the text file you would like to input:\n");

                input = scnr.nextLine();

                System.out.println("\n" + vm.addFromText(input) + "\n");
            }
            else if(input.equals("3")) {

                System.out.println("\nEnter the VIN number of the vehicle you would like to remove:\n");

                input = scnr.nextLine();

                try {
                    System.out.println("\n" + vm.removeVehicle(Integer.parseInt(input)) + "\n");
                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid VIN. Please enter an integer.\n");
                }
            }
            else if(input.equals("4")) {

                System.out.println("\nEnter a full vehicle entry. Ensure the VIN number matches the vehicle to be updated:\n");

                input = scnr.nextLine();

                System.out.println("\n" + vm.updateVehicle(input) + "\n");
            }
            else if(input.equals("5")) {

                System.out.println("\nEnter the VIN number of the vehicle you would like to evaluate:\n");

                input = scnr.nextLine();

                try {
                    System.out.println("\n" + vm.evaluateVehicle(Integer.parseInt(input)) + "\n");
                }
                catch (Exception e) {
                    System.out.println("\nInvalid VIN. Please enter an integer.\n");
                }
            }
            else if(input.equals("6")) {

                System.out.println("\nVIN, Make, Model, Price, Trans, Miles, Color, Drivetrain\n");
                vm.displayVehicles();
                System.out.println();
            }
            else if(input.equals("7")) {

                System.out.println("\nExiting system...\n");
                exit = true;
            }
            else {
                System.out.println("\nInvalid input!\n");
            }
        }
        scnr.close();
    }
}
