package nieZnanyLekarz;

import org.jdatepicker.JDateComponentFactory;
import org.jdatepicker.JDatePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;

import static javax.swing.JOptionPane.showMessageDialog;

class JDatePanelWrapper {

    private JDatePanel panelGlobal;	            // Panel kalendarza
    private		     JFrame frameGlobal;		// Ramka okna zawierająca panel z kalendarzem
    private volatile boolean isDatePicked;		// Flaga określająca, czy data została już wybrana
     		 String pickedDate;			// Ostateczna data wybrana poprzez podwójne kliknięcie


    String selectDate() {			// Metoda pozwalająca wybrać datę z wyświetlonego kalendarza

        openCalendar();							// Wyświetlanie kalendarza do momentu wybrania daty podwójnym kliknięciem

        while(!isDatePicked) {
            // Pusta pętla wstrzymująca dalsze przetwarzanie do czasu wybrania daty
        }

        return pickedDate;						// Zwrócenie wartości zawierającej wybraną datę
    }


    private void openCalendar() {	// Metoda wyświetlająca kalendarz, zwracająca datę wybraną podwójnym kliknięciem
        isDatePicked = false;		// Resetowanie flagi określającej, czy wybrano już datę


        frameGlobal = new JFrame();                                             // Utworzenie obiektu ramki
        panelGlobal = new JDateComponentFactory().createJDatePanel();           // Utworzenie obiektu panelu kalendarza
        panelGlobal.setShowYearButtons(true);                                   // Włączenie widoczności przycisku do zmiany roku
        frameGlobal.getContentPane().add((JComponent) panelGlobal);             // Powiązanie ramki z panelem
        frameGlobal.setSize(300, 300);                                   // Określenie domyślnych wymiarów ramki z kalendarzem
        frameGlobal.setLocation(800, 300);                               // Określenie domyślnego położenia ramki z kalendarzem

        frameGlobal.addWindowFocusListener(new WindowAdapter() {                // Utworzenie handlera obsługującego zdarzenia skupienia okna
            public void windowClosing(WindowEvent arg0) {     // Metoda uruchamiana przy zamknięciu okna z kalendarzem
                //System.exit(0);                    // Przerwanie programu po zamknięciu okna z kalendarzem
            }
        });


        frameGlobal.setVisible(true);                // Wyświetlenie ramki z kalendarzem

        ActionListener actionHandler = new ActionListener() {                   // Utworzenie handlera do obsługi zdarzeń
            public void actionPerformed(ActionEvent actionEvent) {        // Metoda uruchamiana po wykonaniu akcji kalendarza
                //nieZnanyLekarz.JDatePanelWrapper.displayDate();         // Wyświetlenie wybranej daty
                setPickedDate();		 // Zapisanie wybranej daty
                disposeFrame();          // Zamknięcie okna kalendarza
            }
        };

        panelGlobal.setDoubleClickAction(true);               // Określenie, że do wywołania zdarzenia panelu potrzebne będzie podwójne kliknięcie
        panelGlobal.addActionListener(actionHandler);         // Powiązanie handlera z istniejącym panelem

        //showMessageDialog(null, "Komunikat");
        //System.exit(0);		  		// Przerwanie programu

        //testFrame.setVisible(false);	// Schowanie kalendarza
        //testFrame.dispose();		 	// Zamknięcie kalendarza

    } /// openCalendar - end of method



    public void displayDate() {	 	// Metoda wyświetla w komunikacie aktualnie wskazywaną datę
        String dateLocal = new String();
        dateLocal = getDate(panelGlobal);		// Pobranie daty w formacie RRRMMDD

        showMessageDialog(null, dateLocal);		// Wyświetlanie komunikatu z datą
    }


    private String getDate(JDatePanel iv_panel) {    		// Uzyskanie daty w formacie RRRRMMDD

        String dateString = Integer.toString( iv_panel.getModel().getYear() );	// Pobranie liczby oznaczającej rok

        Integer month = iv_panel.getModel().getMonth();		// Pobieranie liczby oznaczającej miesiąc
        month = month + 1;				 // Zwiększanie liczby miesiąca o 1, bo domyślnie jest on liczony od zera

        if ( month < 10 ) {   			 // Dołożenie wiodącego zera przed liczbą miesiąca, jeśli jest mniejsza, niż 10
            dateString = dateString.concat("0");
        }
        dateString = dateString.concat( Integer.toString(month) );	// Dołożenie liczby miesiąca do roku


        if ( iv_panel.getModel().getDay() < 10 ) {		// Dołożenie wiodącego zera przed liczbą dnia, jeśli jest mniejsza, niż 10
            dateString = dateString.concat("0");
        }
        dateString = dateString.concat( Integer.toString( iv_panel.getModel().getDay() ) );	  // Dołożenie liczby dnia do daty

        return dateString;				// Zwrócenie ciągu znaków z datą w formacie RRRRMMDD
    }


    private void disposeFrame() {		// Zamykanie okna z kalendarzem
        frameGlobal.dispose();
    }

    private void setPickedDate() {	// Metoda zapisująca datę wybraną poprzez podwójne kliknięcie
        pickedDate = getDate(panelGlobal);  // Zapisanie daty w formacie RRRRMMDD
        isDatePicked = true;				// Zaznaczenie flagi informującej o wybraniu daty
    }
}  /// nieZnanyLekarz.JDatePanelWrapper - end of class