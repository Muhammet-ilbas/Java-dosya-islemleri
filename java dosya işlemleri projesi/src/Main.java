import java.io.IOException;
import java.util.Collections;


public class Main {
    public static void main(String[] args) throws IOException {
        Contact.ConstactTxtRead();//Contact sınıfından contact.txt dosyasını okuma

       LastNameComparator lastNameComparator = new LastNameComparator();//LastnameComparator nesnesi
        LastNameComparator.ConstactTxtRead();//LastNameComparator sınıfından contact.txt dosyasını okuma

        //soyisme göre sıralamak için kullanılan collections.sort metotu.
        Collections.sort(LastNameComparator.getOrderByLastNameArrayList(), lastNameComparator);
        //sıralanmış arraylisti istenilen dosyaya yazmak için metot
        LastNameComparator.contactsArrayListOrderByLastNameTxt(LastNameComparator.getOrderByLastNameArrayList());

       HashSet.ConstactTxtRead();//kişileri hashset yapısıyla tutma
       TreeSet.ConstactTxtRead();//kişileri treeset yapısıyla tutma
       HashMap.ConstactTxtRead();//kişileri hashmap yapısıyla tutma

    }
}