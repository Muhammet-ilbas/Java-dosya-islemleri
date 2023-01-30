import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Contact implements Comparable<Contact> {

    private String socialSecurityNumber, firstName, lastName, phoneNumber;


    private static ArrayList<Contact> contactArrayList = new ArrayList<>();

    public Contact(String socialSecurityNumber, String firstName, String lastName, String phoneNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    public Contact()
    {

    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public  String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Contact o) {
        return Integer.parseInt(o.getSocialSecurityNumber());
    }

    public static ArrayList<Contact> getContactArrayList() {
        return contactArrayList;
    }

    public static void setContactArrayList(ArrayList<Contact> contactArrayList) {
        Contact.contactArrayList = contactArrayList;
    }
    @Override
    public String toString() {
        return this.socialSecurityNumber+" "+this.firstName+" "+this.lastName+" "+this.phoneNumber;
    }

    //contacts txt dosyasını okuma ve contactArrayList içerine kaydetme
    public static void ConstactTxtRead() throws IOException {
        File dosya = new File("contacts.txt");
        Scanner scanner = new Scanner(dosya);

        while (scanner.hasNextLine()) {
            String satir = scanner.nextLine();
            String[] split = satir.split(" ");
            Contact.contactArrayList.add(new Contact(split[0], split[1], split[2], split[3]));
        }
        ContactsArraylistTxt(contactArrayList);

        scanner.close();
    }
    //ContactsArraylistTxt metodu contactsArrayList.txt dosyasını oluşturup istenilen verileri bu dosyaya kaydeder.
    public static void ContactsArraylistTxt(ArrayList<Contact> arrayList) throws IOException {
        File file = new File("contactsArrayList.txt");
        if (!file.exists())
            file.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter("contactsArrayList.txt"));
        for (int i = 0; i < arrayList.size(); i++) {
            writer.write(arrayList.get(i).getSocialSecurityNumber() + " " + arrayList.get(i).getFirstName()
                    + " " + arrayList.get(i).getLastName() + " " + arrayList.get(i).getPhoneNumber());
            writer.newLine();
        }
        writer.close();

    }


}
