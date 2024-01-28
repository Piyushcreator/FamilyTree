package familytreeSrc;

import java.util.HashMap;
import java.util.Map;

class FamilyTree {
    Map<String, Person> personMap;

    public FamilyTree() {
        this.personMap = new HashMap<>();
    }

    public void addPerson(String name) {
        Person person = new Person(name);
        personMap.put(name, person);
    }

    public void connect(String name1, String relationship, String name2) {
        Person person1 = personMap.get(name1);
        Person person2 = personMap.get(name2);

        if (relationship.equals("father")) {
            person2.father = person1;
            person1.children.add(person2);
        } else if (relationship.equals("son") || relationship.equals("daughter")) {
            person2.children.add(person1);
        } else if (relationship.equals("wife") || relationship.equals("husband")) {
            person1.spouses.add(person2);
            person2.spouses.add(person1);
        }
    }

    public String getGender(String name) {
        Person person = personMap.get(name);
        return (person != null) ? person.getGender() : "Not available";
    }

    public int countSons(String name) {
        Person person = personMap.get(name);
        int count = 0;

        for (Person child : person.children) {
            if (child.getGender().equals("Male")) {
                count++;
            }
        }

        return count;
    }

    public int countDaughters(String name) {
        Person person = personMap.get(name);
        int count = 0;

        for (Person child : person.children) {
            if (child.getGender().equals("Female")) {
                count++;
            }
        }

        return count;
    }

    public int countWives(String name) {
        Person person = personMap.get(name);
        int count = 0;

        for (Person spouse : person.spouses) {
            if (spouse.getGender().equals("Female")) {
                count++;
            }
        }

        return count;
    }

    public int countHusbands(String name) {
        Person person = personMap.get(name);
        int count = 0;

        for (Person spouse : person.spouses) {
            if (spouse.getGender().equals("Male")) {
                count++;
            }
        }

        return count;
    }

    public String fatherOf(String name) {
        Person person = personMap.get(name);
        return (person != null && person.father != null) ? person.father.name : "Not available";
    }
}