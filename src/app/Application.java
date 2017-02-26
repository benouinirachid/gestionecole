/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author vector
 */
public class Application {

    WaitJFrame waitjf;
    MainJFrame mainjf;
    ClassJFrame classjf;
    EmployeeJFrame employeejf;
    ProfessorJFrame professorjf;
    ProfessorSelectorJFrame profSelectorjf;
    StudentJFrame studentjf;
    StudentAbsenceJFrame studentAbsencejf;
    StudentPayJFrame studentPayjf;
    StudentSelectorJFrame studentSelectorjf;

    public Application() {
        waitjf = new WaitJFrame(this);
        waitjf.setVisible(true);
        mainjf = new MainJFrame(this);
        classjf = new ClassJFrame(this);
        employeejf = new EmployeeJFrame(this);
        professorjf = new ProfessorJFrame(this);
        profSelectorjf = new ProfessorSelectorJFrame(this);
        studentjf = new StudentJFrame(this);
        studentAbsencejf=new StudentAbsenceJFrame(this);
        studentPayjf=new StudentPayJFrame(this);
        studentSelectorjf=new StudentSelectorJFrame(this);
        
        waitjf.setVisible(false);
        mainjf.setVisible(true);

    }

}
