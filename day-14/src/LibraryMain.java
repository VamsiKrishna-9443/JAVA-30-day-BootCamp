import service.LibraryService;
import ui.LibraryMenu;

public class LibraryMain
{
   public static void main(String[] args) {
        //Create LibraryService object
        LibraryService service  = new LibraryService();

        //Pass LibraryService object too LibraryMenu
        LibraryMenu menu = new LibraryMenu(service);

        menu.start();
    }
}
