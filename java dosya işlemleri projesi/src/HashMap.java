import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashMap {
    private static java.util.HashMap<String,Contact> contactHashMap = new java.util.HashMap<>();//hashmap olustur.

    public static java.util.HashMap<String, Contact> getContactHashMap() {
        return contactHashMap;
    }

    public static void setContactHashMap(java.util.HashMap<String, Contact> contactHashMap) {
        HashMap.contactHashMap = contactHashMap;
    }

    public static void ConstactTxtRead() throws IOException {
        File dosya = new File("contacts.txt");
        Scanner scanner = new Scanner(dosya);

        while (scanner.hasNextLine()) {
            String satir = scanner.nextLine();
            String[] split = satir.split(" ");
           for (Contact i : Contact.getContactArrayList())
               contactHashMap.put(i.getPhoneNumber(),i);//hashmap ekleme
        }
    ContactsHashMapTxt(contactHashMap);//hashmapi yazdıracak metota gönderme
        scanner.close();
    }
    public static void ContactsHashMapTxt(java.util.HashMap<String,Contact> contactHashMap) throws IOException {
        File file = new File("file.txt");
        if (!file.exists())
            file.createNewFile();

        String line ;
        BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt",false));
        Set j = contactHashMap.entrySet();
        Iterator k = j.iterator();
        while (k.hasNext())
        {
            Map.Entry veri = (Map.Entry) k.next();
            line = veri.getValue().toString()+"\n";
            writer.write(line);
        }

        writer.close();

    }
}
