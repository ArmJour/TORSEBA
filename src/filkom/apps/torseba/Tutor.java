package filkom.apps.torseba;
import filkom.apps.torseba.util.*;
import java.util.*;

public class Tutor
{
    static DataStruct getData = new DataStruct();
    static Scanner input = new Scanner(System.in);
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
        if (menuChoose == 1)
        {
            getData.video.add(input.nextLine());
        }
        else if (menuChoose == 2)
        {
            getData.note.add(input.nextLine());
        }
        else if (menuChoose == 3)
        {
            getData.tutorList.add(input.nextLine());
        }
        else if (menuChoose == 4)
        {
            getData.tutorReport.add(input.nextLine());
        }
    }
}