package filkom.apps.torseba.util;
import java.util.*;

/**
 * <h1>Default Data Values</h1>
 * 
 * @author Syafa Hadyan Rasendriya
 * @author Dafid Rosydan Hanif
 * @author Davy Sheehan Arisatyo
 * @author Muhammad Fikri Anwar
 * @author Muhammad Raditya Arsyad
 * @author Valentinus Marvel
 */
public class DataStruct
{
    public final int BOX_WIDTH = 200; /* Width of the box */
    public final String DEFAULT_HEADER = "Selamat Datang"; /* Default header */
    public final String DEFAULT_SUB_HEADER = "TORSEBA"; /* Default sub header */
    public HashMap<String,String> userLoginData = new HashMap<>(); /* Email and password  */
    public HashMap<List<String>,List<String>> userData = new HashMap<>(); /* All user data */
    public ArrayList<String> video = new ArrayList<>(); /* Video */
    public ArrayList<String> note = new ArrayList<>(); /* Note */
    public ArrayList<String> tutorList = new ArrayList<>(); /* Tutor list */
    public ArrayList<String> tutorReport = new ArrayList<>(); /* Tutor report */
    public final String[] VALID_USER_ROLE = /* Valid user list */
    {
        "admin",
        "tutor",
        "tutee"
    };
    public final String[] TABLE_HEADER_DATA = /* Table header for displaying user data */
    {
        "Email",
        "Password",
        "Role",
        "Nama",
        "Alamat",
        "Telepon",
        "Jenis Kelamin",
        "Tempat, tanggal lahir"
    };
    public final String[] TUTOR_MAIN_PAGE =
    {
        "Upload video",
        "Upload catatan",
        "Lihat daftar tutor",
        "Lihat laporan",
    };
}