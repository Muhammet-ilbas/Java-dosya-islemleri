import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
public class TreeSet {
    private static Set contactSetTreeOrderByLastName = new java.util.TreeSet<>(new LastNameComparator());

    private static  Set contactSetTree = new java.util.TreeSet<>(Comparator.comparing(Contact::getPhoneNumber));


    public static Set<Contact> getContactSetTree() {
        return contactSetTreeOrderByLastName;
    }

    public static void setContactSetTree(Set<Contact> contactSetTree) {
        TreeSet.contactSetTreeOrderByLastName = contactSetTree;
    }

    public static void ConstactTxtRead() throws IOException {
        File dosya = new File("contacts.txt");
        Scanner scanner = new Scanner(dosya);

        while (scanner.hasNextLine()) {
            String satir = scanner.nextLine();
            String[] split = satir.split(" ");
            TreeSet.contactSetTreeOrderByLastName.add(new Contact(split[0], split[1], split[2], split[3]));//treeSetimize değerli aktarma
            TreeSet.contactSetTree.add(new Contact(split[0], split[1], split[2], split[3]));//treeSetimize değerli aktarma
        }
        contactTreeSetTxt(contactSetTreeOrderByLastName,contactSetTree);// treeSetlerimi istenilen dosyaya yazdıran metotu çağırıyoruz.


        scanner.close();
    }

    public static void contactTreeSetTxt(Set<Contact> contactSetTree,Set<Contact> contactTreeSet) throws IOException {
        File file = new File("contactSetTreeOrderByLastName.txt");
        if (!file.exists())
            file.createNewFile();
        String line ;
        BufferedWriter writer = new BufferedWriter(new FileWriter("contactSetTreeOrderByLastName.txt"));
        Iterator<Contact> iterator = contactSetTree.iterator();
        while (iterator.hasNext()) {
            line = String.valueOf(iterator.next());
            writer.write(line);//dosyaya yazdırma
            writer.newLine();
        }
        writer.close();
        File file2 = new File("contactSetTree.txt");
        if (!file2.exists())
            file.createNewFile();
        String line2 ;
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("contactSetTree.txt"));
        Iterator<Contact> iterator2 = contactTreeSet.iterator();
        while (iterator2.hasNext()) {
            line2 = String.valueOf(iterator2.next());
            writer2.write(line2);
            writer2.newLine();
        }
        writer2.close();
    }
}

