import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class HashSet {
    private static java.util.HashSet<Contact> contactHashSet = new java.util.HashSet<>();

    public HashSet() {

    }

    public static java.util.HashSet<Contact> getContactHashSet() {
        return contactHashSet;
    }

    public static void setContactHashSet(java.util.HashSet<Contact> contactHashSet) {
        HashSet.contactHashSet = contactHashSet;
    }

    public static void ConstactTxtRead() throws IOException {
        File dosya = new File("contacts.txt");
        Scanner scanner = new Scanner(dosya);

        while (scanner.hasNextLine()) {
            String satir = scanner.nextLine();
            String[] split = satir.split(" ");
            HashSet.contactHashSet.add(new Contact(split[0],split[1],split[2],split[3]));
        }

        contactHashSetTxt(contactHashSet);

        scanner.close();
    }

    public static void contactHashSetTxt(java.util.HashSet<Contact> contactHashSet) throws IOException {
        File file = new File("contactHashSet.txt");
        if (!file.exists())
            file.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter("contactHashSet.txt"));
        String line ;
        Iterator<Contact> iterator = contactHashSet.iterator();

        while (iterator.hasNext()) {
           line = String.valueOf(iterator.next());
           writer.write(line);

            writer.newLine();
        }

        writer.close();

    }

}

