package filkom.apps.torseba;
import filkom.apps.torseba.util.*;
import java.util.*;

/**
 * <h1>Torseba Main App</h1>
 * 
 * @author Syafa Hadyan Rasendriya
 * @author Dafid Rosydan Hanif
 * @author Davy Sheehan Arisatyo
 * @author Muhammad Fikri Anwar
 * @author Muhammad Raditya Arsyad
 * @author Valentinus Marvel
 */
public class Main
{
    static GeneratePage generatePage = new GeneratePage();
    static DataStruct getData = new DataStruct();
    static Tutor tutor = new Tutor();
    static Scanner input = new Scanner(System.in);
    private static void exitApp()
    {
        System.out.println("\n" + "Aplikasi akan ditutup, terima kasih telah menggunakan aplikasi TORSEBA");
        System.exit(0);
    }
    public static void main(String[] args)
    {
        getData.userLoginData.put("admin0@ub.ac.id","default-login-pass");
        getData.userData.put(Arrays.asList("admin0@ub.ac.id","default-login-pass"),Arrays.asList("admin0@ub.ac.id","default-login-pass","admin","Admin UB","Malang","0123456789","Laki-laki","Malang, 0 Januari 0000"));
        String userLogin = "";
        String userPassword = "";
        String userType = "";
        int menuChoose = 0;
        while (true)
        {
            /* Main login page */
            generatePage.defaultWelcomeHeader(getData.DEFAULT_SUB_HEADER);
            generatePage.body("Empty",4);
            generatePage.bodyWithContent(2,"1. Login",false);
            generatePage.bodyWithContent(2,"2. Register",false);
            generatePage.body("Empty",1);
            generatePage.bodyWithContent(2,"3. Keluar",false);
            try
            {
                menuChoose = Integer.parseInt(generatePage.bodyWithContent(2,"Pilihan anda",true));
            }
            catch (NumberFormatException e)
            {
                generatePage.defaultFooterEnd(1);
            }
            generatePage.defaultFooterEnd(1);
            if
            (
                /* If input is valid */
                menuChoose == 1 ||
                menuChoose == 2
            )
            {
                /* Break out of loop then print main menu log in / register */
                boolean validUserLogin = true;
                for (List<String> i : getData.userData.keySet())
                {
                    for (String j : getData.userData.get(i))
                    {
                        System.err.println(j);
                    }
                }
                if (menuChoose == 1)
                {
                    do
                    {
                        if (!validUserLogin)
                        {
                            /* Prompt user to re-enter login credentials */
                            System.out.println("\n" + "Data yang anda masukkan salah, silahkan input kembali");
                        }

                        /* Login page */
                        validUserLogin = false;
                        generatePage.defaultWelcomeHeader(getData.DEFAULT_SUB_HEADER);
                        generatePage.body("Empty",4);
                        userLogin = generatePage.bodyWithContent(2,"Masukkan email",true);
                        userPassword = generatePage.bodyWithContent(2,"Masukkan password",true);
                        generatePage.defaultFooterEnd(4);
                        if (getData.userLoginData.containsKey(userLogin) && getData.userLoginData.get(userLogin).equals(userPassword))
                        {
                            validUserLogin = true;
                            System.err.println("LOG SUCCESSFUL");
                        }
                    }
                    while (!validUserLogin);
                    userType = getData.userData.get(Arrays.asList(userLogin,userPassword)).get(2);
                }
                else if (menuChoose == 2)
                {
                    /* Register page */
                    boolean isRegistered = true;
                    String tempUserEmailRegister = "";
                    String tempUserPasswordRegister = "";
                    String tempUserRole = "";
                    String tempUserFullName = "";
                    String tempUserAddress = "";
                    String tempUserPhoneNumber = "";
                    String tempUserGender = "";
                    String tempPlaceDateOfBirth = "";
                    do
                    {
                        /* Prompt user to enter another email if already registered */
                        if (!(isRegistered))
                        {
                            System.out.println("Email sudah digunakan, silahkan gunakan email lain");
                        }

                        /* Update value to false (will be true when no duplicate found in registered user list) */
                        isRegistered = false;

                        /* Prints default header */
                        generatePage.defaultWelcomeHeader(getData.DEFAULT_SUB_HEADER);
                        generatePage.body("Empty",6);
                        tempUserEmailRegister = generatePage.bodyWithContent(2,"Masukkan email",true);
                        tempUserPasswordRegister = generatePage.bodyWithContent(2,"Masukkan password",true);
                        generatePage.body("Empty",4);
                        generatePage.headerFooter();

                        /* Check if entered email already registered */ 
                        isRegistered = !(getData.userLoginData.containsKey(tempUserEmailRegister));
                    }
                    while (!(isRegistered));
                    /* Put data to valid user and password key value */
                    getData.userLoginData.put(tempUserEmailRegister,tempUserPasswordRegister);
                    userLogin = tempUserEmailRegister;
                    boolean confirmUserDataInput = false;
                    while (!confirmUserDataInput && !(userType.equals("user")))
                    {
                        generatePage.defaultWelcomeHeader(getData.DEFAULT_SUB_HEADER);
                        generatePage.body("Empty",2);
                        generatePage.bodyWithContent(2,"Masukkan data anda",false);
                        tempUserRole = generatePage.bodyWithContent(2,"Role",true).toLowerCase();
                        tempUserFullName = generatePage.bodyWithContent(2,"Nama lengkap",true);
                        tempUserAddress = generatePage.bodyWithContent(2,"Alamat lengkap",true);
                        tempUserPhoneNumber = generatePage.bodyWithContent(2,"Nomor telepon",true);
                        tempUserGender = generatePage.bodyWithContent(2,"Masukkan jenis kelamin",true);
                        tempPlaceDateOfBirth = generatePage.bodyWithContent(2,"Masukkan tempat tanggal lahir",true);
                        generatePage.body("Empty",3);
                        generatePage.headerFooter();
                        generatePage.defaultWelcomeHeader(getData.DEFAULT_SUB_HEADER);
                        generatePage.body("Empty",2);
                        generatePage.bodyWithContent(2,"Konfirmasi data",false);
                        generatePage.bodyWithContent(2,"Role : " + tempUserRole,false);
                        generatePage.bodyWithContent(2,"Nama : " + tempUserFullName,false);
                        generatePage.bodyWithContent(2,"Alamat : "  + tempUserAddress,false);
                        generatePage.bodyWithContent(2,"Nomor telepon : " + tempUserPhoneNumber,false);
                        generatePage.bodyWithContent(2,"Jenis kelamin : " + tempUserGender,false);
                        generatePage.bodyWithContent(2,"Tempat, tanggal lahir : " + tempPlaceDateOfBirth,false);
                        generatePage.body("Empty",2);
                        String tempConfirmInput = generatePage.bodyWithContent(2,"Konfirmasi data? (Enter / 1 (ubah data))",true);
                        generatePage.defaultFooterEnd(2);

                        /* Confirm user data input */
                        confirmUserDataInput = !tempConfirmInput.equalsIgnoreCase("1");

                        /* Check if role is not avaliable in role list, then prompt user to re-enter data */
                        do
                        {
                            confirmUserDataInput = false;
                            for (int i = 0; i < getData.VALID_USER_ROLE.length; i++)
                            {
                                if (getData.VALID_USER_ROLE[i].equals(tempUserRole))
                                {
                                    confirmUserDataInput = true;
                                }
                            }
                            if ((!(tempConfirmInput.equalsIgnoreCase("1"))) && confirmUserDataInput == false)
                            {
                                System.out.println("\n" + "Role yang anda masukkan salah, silahkan masukkan data kembali");
                            }
                        }
                        while (!(confirmUserDataInput));
                    }

                    /* When valid, insert to getData.userData */
                    getData.userLoginData.put(tempUserEmailRegister,tempUserPasswordRegister);
                    getData.userData.put(Arrays.asList(tempUserEmailRegister,tempUserPasswordRegister),Arrays.asList(tempUserEmailRegister,tempUserPasswordRegister,tempUserRole,tempUserFullName,tempUserAddress,tempUserPhoneNumber,tempUserGender,tempPlaceDateOfBirth));
                    userType = tempUserRole;
                }
                if (userType.equals("admin"))
                {
                    System.err.println("ADMIN LOG");
                    System.err.println(userLogin);
                    System.err.println(userType);
                }
                else if (userType.equals("tutor"))
                {
                    System.err.println("TUTOR LOG");
                    System.err.println(userType);
                    System.err.println(userLogin);
                    /*
                     * Upload video
                     * Upload catatan
                     * Liat daftar tutor
                     * Liat laporan
                     * Edit
                     */
                    generatePage.defaultWelcomeHeader(getData.DEFAULT_SUB_HEADER);
                    generatePage.bodyWithContent(2,"Anda login sebagai " + userLogin,false);
                    generatePage.body("generatePage.Body", 2);
                    generatePage.body("Empty",1);
                    for (int i = 0; i < getData.TUTOR_MAIN_PAGE.length; i++)
                    {
                        generatePage.bodyWithContent(2,(i + 1) + ". " + getData.TUTOR_MAIN_PAGE[i],false);
                    }
                    generatePage.body("Empty",1);
                    generatePage.bodyWithContent(2,"6. Keluar aplikasi",false);
                    generatePage.body("Empty",2);
                    try
                    {
                        menuChoose = Integer.parseInt(generatePage.bodyWithContent(2,"Pilihan anda",true));
                    }
                    catch (NumberFormatException e)
                    {
                        generatePage.defaultFooterEnd(3);
                    }
                    generatePage.defaultFooterEnd(3);
                    if (!(tutor.mainPage(menuChoose)))
                    {
                        generatePage.defaultFalseInput();
                    }
                }
                else if (userType.equals("tutee"))
                {
                    System.err.println("TUTEE LOG");
                    System.err.println(userType);
                    System.err.println(userLogin);
                }
            }
            else if (menuChoose == 3)
            {
                exitApp();
            }
        }
    }
}