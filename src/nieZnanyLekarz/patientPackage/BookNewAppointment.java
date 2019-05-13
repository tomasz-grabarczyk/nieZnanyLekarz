package nieZnanyLekarz.patientPackage;

import nieZnanyLekarz.generalPackage.CalendarScreen;

class BookNewAppointment {

    void bookNewAppointment() {
        CalendarScreen calendarScreen = new CalendarScreen();
        calendarScreen.selectDate();
    }
}
