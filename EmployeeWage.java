package Day9;

import java.util.Random;

public class EmployeeWage {
    private static final int FULL_TIME = 1;
    private static final int PART_TIME = 2;
    private static final int ABSENT = 0;

    private static final int WAGE_PER_HOUR = 20;
    private static final int WORKING_HOURS_PER_MONTH = 100;
    private static final int WORKING_DAYS_PER_MONTH = 20;

    private static final int PART_TIME_HOURS = 8;

    private int wagePerHour;
    private int workingDays;
    private int workingHours;

    public EmployeeWage(int wagePerHour, int workingDays, int workingHours) {
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.workingHours = workingHours;
    }

    public int calculateWage() {
        int totalWage = 0;
        int totalWorkingDays = 0;
        int totalWorkingHours = 0;

        Random random = new Random();
        while (totalWorkingDays < workingDays && totalWorkingHours < workingHours) {
            int randomNumber = random.nextInt(3);
            totalWorkingDays++;
            switch (randomNumber) {
                case FULL_TIME:
                    totalWage += wagePerHour * 8;
                    totalWorkingHours += 8;
                    break;
                case PART_TIME:
                    totalWage += wagePerHour * PART_TIME_HOURS;
                    totalWorkingHours += PART_TIME_HOURS;
                    break;
                case ABSENT:
                    totalWage += 0;
            }
        }
        return totalWage;
    }

    public static void main(String[] args) {
        EmployeeWage company1 = new EmployeeWage(WAGE_PER_HOUR, WORKING_DAYS_PER_MONTH, WORKING_HOURS_PER_MONTH);
        System.out.println("Total wage for company 1: " + company1.calculateWage());

        int company2WagePerHour = 25;
        int company2WorkingDays = 22;
        int company2WorkingHours = 110;
        EmployeeWage company2 = new EmployeeWage(company2WagePerHour, company2WorkingDays, company2WorkingHours);
        System.out.println("Total wage for company 2: " + company2.calculateWage());
    }
}

