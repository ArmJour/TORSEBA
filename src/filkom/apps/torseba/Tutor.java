package filkom.apps.torseba;
import filkom.apps.torseba.util.*;

public class Tutor
{
    static DataStruct getData = new DataStruct();
    static GeneratePage generatePage = new GeneratePage();
    public boolean mainPage(int menuChoose)
    {
        if (menuChoose >= 1 && menuChoose <= getData.TUTOR_MAIN_PAGE.length)
        {
            menuOperation(menuChoose);
            return true;
        }
        return false;
    }
    private void menuOperation(int menuChoose)
    {
        generatePage.defaultWelcomeHeader("Tambah Data");
        generatePage.body("Empty",2);
        String tempContentAdd = generatePage.bodyWithContent(2,("Masukkan nama" + " " + getData.TUTOR_CONTENT_ADD.get(menuChoose)),true);
        if (menuChoose == 1)
        {
            getData.video.add(tempContentAdd);
        }
        else if (menuChoose == 2)
        {
            getData.note.add(tempContentAdd);
        }
        else if (menuChoose == 3)
        {
            getData.tutorReport.add(tempContentAdd);
        }
        generatePage.defaultFooterEnd(3);
        System.err.println(getData.tutorReport);
        System.err.println(getData.note);
        System.err.println(getData.video);
    }
}