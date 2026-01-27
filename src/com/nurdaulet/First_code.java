void main() {
}



public void run(){
  boolean running = true;

  while (running){
    displayMenu;
    System.out.println("Choice: ");

    try{


      int choice = scanner.nextInt();
      scanner.nextLine();

      switch(choice){

        case 1:
          addPet();
          break;
        case 2:
          v
          break;
        case 3:
          a
          break;
        case 4:
          a
          break;
        case 0:
          running = false;
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Invalid choice!");
      }


    } catch(Exception e){
      System.out.println("Error: " + e.getMessage());
      scanner.nextLine();
    }

  }
}

private void addPet(){

  System.out.print("Person ID: ");
  int id = scanner.nextInt();
  scanner.nextLine();

}



