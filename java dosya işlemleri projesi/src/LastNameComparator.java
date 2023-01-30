import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LastNameComparator implements Comparator<Contact> {
    private static ArrayList<Contact> OrderByLastNameArrayList = new ArrayList<>();

    public LastNameComparator() {

    }


    public static ArrayList<Contact> getOrderByLastNameArrayList() {
        return OrderByLastNameArrayList;
    }

    public static void setOrderByLastNameArrayList(ArrayList<Contact> orderByLastNameArrayList) {
        OrderByLastNameArrayList = orderByLastNameArrayList;
    }

    @Override
    //comparator arayüzünü kullanarak soyisimlere göre kıyaslama
    public int compare(Contact o1, Contact o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }

    //contax.txt dosyasını okuyup arraylist üzerinde tutma
    public static void ConstactTxtRead() throws IOException {
        File dosya = new File("contacts.txt");
        Scanner scanner = new Scanner(dosya);
        while (scanner.hasNextLine()) {
            String satir = scanner.nextLine();
            String[] split = satir.split(" ");
            LastNameComparator.OrderByLastNameArrayList.add(new Contact(split[0], split[1], split[2], split[3]));
        }
        contactsArrayListOrderByLastNameTxt(OrderByLastNameArrayList);
        scanner.close();
    }

    // soy isme göre sıralanmışOrderByLastNameArrayList arraylistini contactsArrayListOrderByLastName.txt dosyasına yazan
    //metot
    public static void contactsArrayListOrderByLastNameTxt(ArrayList<Contact> OrderByLastNameArrayList) throws IOException {
        File file = new File("contactsArrayListOrderByLastName.txt");
        if (!file.exists())
            file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter("contactsArrayListOrderByLastName.txt"));
        for (int i = 0; i < OrderByLastNameArrayList.size(); i++) {
            writer.write(OrderByLastNameArrayList.get(i).getSocialSecurityNumber() + " " + OrderByLastNameArrayList.get(i).getFirstName()
                    + " " + OrderByLastNameArrayList.get(i).getLastName() + " " + OrderByLastNameArrayList.get(i).getPhoneNumber());
            writer.newLine();
        }
        writer.close();

    }
}
