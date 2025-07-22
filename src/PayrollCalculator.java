public class PayrollCalculator {
    //method to calculate weekly pay based on employee type and hours
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate){
        //calculate the regular pay hours worked * hourly rate
        double regularPay=hoursWorked*hourlyRate;
        switch (employeeType) {
            // Employee types: "FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN"
            // FULL_TIME: Regular pay for 40 hours, overtime (1.5x) for hours > 40
            case "FULL_TIME":

                if (hoursWorked <= 40) {
                    return regularPay;
                } else {
                    double overTimeHours =hoursWorked - 40;
                    double overTimePay = overTimeHours * hourlyRate * 1.5;
                    return overTimePay + (40 * hourlyRate);
                }
                // PART_TIME: Regular pay, no overtime, max 25 hours
            case "PART_TIME":
                if (hoursWorked <= 25) {
                    return regularPay;
                }else{
                    System.out.println("No Over Time Pay.");
                    return regularPay;
                }
            // CONTRACTOR: Flat rate, no overtime rules
            case "CONTRACTOR":
                System.out.println("No Over Time Pay.");
                return hoursWorked * hourlyRate;
            // INTERN: 20% discount from hourly rate, max 20 hours
            case "INTERN":
                double regularPayIntern = regularPay * 0.8; // 1-0.2 the discount rate
                if (hoursWorked <= 20) {
                    return regularPayIntern;
                } else {
                    System.out.println("No Over Time Pay.");
                    return regularPayIntern;
                }
                // Handle invalid employee types and negative values
            default:
                System.out.println("Invalid Information.");
                return 0;

        }
    }
    // Method to calculate tax deduction based on pay brackets
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        // Tax brackets using nested if-else:
        double tax;
        if (grossPay <= 500) {
            // $0-500: 10% tax
            tax = grossPay * 0.1;
        } else if (grossPay <= 1000) {
            // $501-1000: 15% tax
            tax = grossPay * 0.15;
        } else if (grossPay <= 2000) {
            // $1001-2000: 20% tax
            tax = grossPay * 0.2;
        } else {
            // Above $2000: 25% tax
            tax = grossPay * 0.25;
        }
        // If hasHealthInsurance is true, reduce tax by $50
        if (hasHealthInsurance) {
            tax -= 50;
            if(tax<0){
                tax=0;
            }
        }
        // Return total tax amount
        return tax;
    }
    // Method to process multiple employees and find statistics
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        // Calculate pay for each employee
        for (int i=0; i<= names.length;i++){
            double weeklyPay =calculateWeeklyPay(employeeTypes[i],hours[i],rates[i]);
            System.out.println("Pay for"+" "+names[i]+" "+"is"+" "+weeklyPay);
        }
        // Find: highest paid employee, lowest paid employee, average pay
        double max = calculateWeeklyPay(employeeTypes[0], hours[0], rates[0]);
        double min = max;
        String highestPaidEmployee = names[0];
        String lowestPaidEmployee = names[0];
        double sum = max;

        for (int i = 1; i < names.length; i++) {
            double currentPay = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            sum += currentPay;

            if (currentPay > max) {
                max = currentPay;
                highestPaidEmployee = names[i];
            }

            if (currentPay < min) {
                min = currentPay;
                lowestPaidEmployee = names[i];
            }
        }

        double avg = sum / names.length;

        System.out.println("The highest paid employee is"+" "+highestPaidEmployee + " "+max+" "+"OMR");
        System.out.println("The lowest paid employee is"+" "+lowestPaidEmployee + " "+min+" "+"OMR");
        System.out.println("The average weekly pay is"+" "+avg+" "+"OMR");
        // Count how many employees worked overtime (>40 hours)

        // Display results in a formatted table
        // Handle arrays of different lengths gracefully
    }
}