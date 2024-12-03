package filkom.apps.torseba;
import filkom.apps.torseba.util.*;
import java.util.*;

public class Tutor
{
    static DataStruct getData = new DataStruct();
    public boolean mainPage(int menuChoose)
    {
        if (menuChoose <= 1 && menuChoose > getData.TUTOR_MAIN_PAGE.length)
        {
            menuOperation(menuChoose);
            return true;
        }
        return false;
    }
    private void menuOperation(int menuChoose)
    {
        /*
         * "Upload video",
         * "Upload catatan",
         * "Lihat daftar tutor",
         * "Lihat laporan",
         * "Edit"
         */
        if (menuChoose == 1)
        {
            //
        }
        else if (menuChoose == 2)
        {
            //
        }
        else if (menuChoose == 3)
        {
            //
        }
        else if (menuChoose == 4)
        {
            //
        }
        else if (menuChoose == 5)
        {
            //
        }
    }
}