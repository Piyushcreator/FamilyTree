package familytreeSrc;

import java.util.Scanner;

public class FamilyTreeApp {
    public static void main(String[] args) {
    		FamilyTree familyTree = new FamilyTree();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter command: ");
                try {
                	 String command = scanner.nextLine();

                     String[] tokens = command.split(" ");
                     String operation = tokens[0];

                     switch (operation) {
                         case "family-tree":
                             processFamilyTreeCommand(familyTree, tokens);
                             break;
                         case "exit":
                             System.out.println("Exiting program.");
                             scanner.close();
                             System.exit(0);
                         default:
                             System.out.println("Invalid command. Try again.");
                     }
                }
                catch(Exception E) {
            		System.out.println("Error Occured. Please Provide Correct Command :" + E.getMessage());
            	}
               
            }       
    }

    private static void processFamilyTreeCommand(FamilyTree familyTree, String[] tokens) {
        if (tokens.length < 3) {
            System.out.println("Invalid command. Try again.");
            return;
        }

        String operation = tokens[1];

        switch (operation) {
            case "add":
                if (tokens.length < 5) {
                    System.out.println("Invalid command. Try again.");
                    return;
                }

                String entityType = tokens[2];
                String name="";
                for(int i=3;i<tokens.length;i++) {
                	name += tokens[i]+" ";
                }
                name= name.trim();
                if (entityType.equals("person")) {
                    familyTree.addPerson(name);
                    System.out.println("Person " + name + " added.");
                } else {
                    System.out.println("Invalid command. Try again.");
                }
                break;

            case "connect":
                if (tokens.length <7) {
                    System.out.println("Invalid command. Try again.");
                    return;
                }
                
                String name1 = "";
                String relationship="";
                String name2 = "";
                int i=2;
                for(;i<tokens.length;i++) {
                	String curr=tokens[i];
                	if(curr.equals("as")) {
                		relationship = tokens[++i];
                		break;
                	}
                	else {
                		name1 += curr + " ";
                	}
                }
                i=i+2;
                for(;i<tokens.length;i++) {
                	name2+=tokens[i] + " ";
                }
                name1= name1.trim();
                name2=name2.trim();
                familyTree.connect(name1, relationship, name2);
                System.out.println("Connected " + name1 + " as " + relationship + " of " + name2 + ".");
                break;

            case "getgender":
                if (tokens.length < 3) {
                    System.out.println("Invalid command. Try again.");
                    return;
                }

                String personName = tokens[2];
                String gender = familyTree.getGender(personName);
                System.out.println("Gender of " + personName + ": " + gender);
                break;

            case "count":
                if (tokens.length < 5) {
                    System.out.println("Invalid command. Try again.");
                    return;
                }

                String countType = tokens[2];
                String countPerson ="";
                for(int j=4;j<tokens.length;j++) {
                	countPerson+= tokens[j] + " ";
                }
                countPerson= countPerson.trim();
                int count;

                switch (countType) {
                    case "sons":
                        count = familyTree.countSons(countPerson);
                        System.out.println("Count of sons of " + countPerson + ": " + count);
                        break;

                    case "daughters":
                        count = familyTree.countDaughters(countPerson);
                        System.out.println("Count of daughters of " + countPerson + ": " + count);
                        break;

                    case "wives":
                        count = familyTree.countWives(countPerson);
                        System.out.println("Count of wives of " + countPerson + ": " + count);
                        break;

                    case "husbands":
                        count = familyTree.countHusbands(countPerson);
                        System.out.println("Count of husbands of " + countPerson + ": " + count);
                        break;

                    default:
                        System.out.println("Invalid command. Try again.");
                        break;
                }
                break;
            case "father" : 
            	if (tokens.length < 4) {
                    System.out.println("Invalid command. Try again.");
                    return;
                }
            	String name4= "";
            	for (int j=3;j<tokens.length;j++) {
            		name4+= tokens[j] + " ";
            	}
            	name4= name4.trim();
            	String result= familyTree.fatherOf(name4);
            	 System.out.println("Father of" + name4 + ": " + result);
            	break;

            default:
                System.out.println("Invalid command. Try again.");
        }
    }
}