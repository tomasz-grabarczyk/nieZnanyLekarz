package nieZnanyLekarz;

class Patient_BookNewAppointment {

    void patientNewAppointment() {
        Patient_SelectDoctor patient_selectDoctor = new Patient_SelectDoctor();
        patient_selectDoctor.selectDoctor();

        All_CalendarScreen all_calendarScreen = new All_CalendarScreen();
        all_calendarScreen.selectDate();
    }
}
